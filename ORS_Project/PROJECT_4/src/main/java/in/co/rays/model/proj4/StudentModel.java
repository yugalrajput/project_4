package in.co.rays.model.proj4;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import in.co.rays.bean.proj4.CollegeBean;
import in.co.rays.bean.proj4.StudentBean;
import in.co.rays.exception.proj4.ApplicationException;
import in.co.rays.exception.proj4.DatabaseException;
import in.co.rays.exception.proj4.DuplicateRecordException;
import in.co.rays.util.proj4.JDBCDataSource;

/**
 * @author Prashant Jha
 *
 */
public class StudentModel {

	private static Logger log = Logger.getLogger(StudentModel.class);

	public Integer nextPK() throws DatabaseException {
		log.debug("Model nextPK Started");
		Connection conn = null;
		int pk = 0;
		try {
			conn = JDBCDataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement("select max(id) from st_student");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				pk = rs.getInt(1);
			}
			rs.close();
		} catch (Exception e) {
			log.error("Database Exception..", e);
			throw new DatabaseException("Exception : Exception in getting PK");

		} finally {
			JDBCDataSource.closeConnection(conn);
		}
		log.debug("Model nextPK End");
		return pk + 1;
	}

	public long add(StudentBean bean) throws ApplicationException, DuplicateRecordException {
		log.debug("model add started");
		Connection conn = null;

		CollegeModel cModel = new CollegeModel();
		CollegeBean collegeBean = cModel.findByPK(bean.getCollegeId());
		bean.setCollegeName(collegeBean.getName());
		int pk = 0;
		StudentBean duplicateName = findByEmailId(bean.getEmail());

		try {
			conn = JDBCDataSource.getConnection();
			pk = nextPK();
			System.out.println(pk + "in modelJDBC");
			conn.setAutoCommit(false);
			PreparedStatement ps = conn.prepareStatement("insert into st_student values(?,?,?,?,?,?,?,?,?,?,?,?)");
			ps.setInt(1, pk);
			ps.setLong(2, bean.getCollegeId());
			ps.setString(3, bean.getCollegeName());
			ps.setString(4, bean.getFirstName());
			ps.setString(5, bean.getLastName());
			ps.setDate(6, new java.sql.Date(bean.getDob().getTime()));
			ps.setString(7, bean.getMobileNo());
			ps.setString(8, bean.getEmail());
			ps.setString(9, bean.getCreatedBy());
			ps.setString(10, bean.getModifiedBy());
			ps.setTimestamp(11, bean.getCreatedDatetime());
			ps.setTimestamp(12, bean.getModifiedDatetime());
			ps.executeUpdate();
			conn.commit();
			ps.close();
		} catch (Exception e) {
			log.error("database..", e);
			try {
				conn.rollback();
			} catch (Exception ex) {
				throw new ApplicationException("Exception:add rollback exception" + ex.getMessage());

			}
			throw new ApplicationException("exception:Exception in add Student");

		} finally {
			JDBCDataSource.closeConnection(conn);
		}
		log.debug("model add end");
		return pk;
	}

	public void delete(StudentBean bean) throws ApplicationException, DuplicateRecordException {
		log.debug("model delete started");
		Connection conn = null;
		try {
			conn = JDBCDataSource.getConnection();
			conn.setAutoCommit(false);
			PreparedStatement ps = conn.prepareStatement("delete from st_student where id=?");
			ps.setLong(1, bean.getId());
			ps.executeUpdate();
			conn.commit();
			conn.close();

		} catch (Exception e) {
			log.debug("model delete ended");
			e.printStackTrace();
		}
	}

	public StudentBean findByEmailId(String email) throws ApplicationException {
		log.debug("model find by name started");
		StringBuffer sql = new StringBuffer("select * from st_student where EMAIL=?");
		StudentBean bean = null;
		Connection conn = null;
		try {
			conn = JDBCDataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql.toString());
			ps.setString(1, email);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				bean = new StudentBean();
				bean.setId(rs.getLong(1));
				bean.setCollegeId(rs.getLong(2));
				bean.setCollegeName(rs.getString(3));
				bean.setFirstName(rs.getString(4));
				bean.setLastName(rs.getString(5));
				bean.setMobileNo(rs.getString(6));
				bean.setEmail(rs.getString(7));
				bean.setDob(rs.getDate(8));
				bean.setCreatedBy(rs.getString(9));
				bean.setModifiedBy(rs.getString(10));
				bean.setCreatedDatetime(rs.getTimestamp(11));
				bean.setModifiedDatetime(rs.getTimestamp(12));

			}
			rs.close();
		} catch (Exception e) {
			log.error("database exception..." + e);
			throw new ApplicationException("Exception:exception in getting User by email");

		} finally {
			JDBCDataSource.closeConnection(conn);
		}
		log.debug("model findBy email end");

		return bean;
	}

	public StudentBean findByPk(long pk) throws ApplicationException {
		log.debug("Model find By PK Started");
		StringBuffer sql = new StringBuffer("select * from st_student where id=?");
		StudentBean bean = null;
		Connection conn = null;
		try {
			conn = JDBCDataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql.toString());
			ps.setLong(1, pk);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				bean = new StudentBean();
				bean.setId(rs.getLong(1));
				bean.setCollegeId(rs.getLong(2));
				bean.setCollegeName(rs.getString(3));
				bean.setFirstName(rs.getString(4));
				bean.setLastName(rs.getString(5));
				bean.setMobileNo(rs.getString(6));
				bean.setEmail(rs.getString(7));
				bean.setDob(rs.getDate(8));
				bean.setCreatedBy(rs.getString(9));
				bean.setModifiedBy(rs.getString(10));
				bean.setCreatedDatetime(rs.getTimestamp(11));
				bean.setModifiedDatetime(rs.getTimestamp(12));
			}
			rs.close();
		} catch (Exception e) {
			log.error("Database Exception", e);
		} finally {
			JDBCDataSource.closeConnection(conn);
		}
		log.debug("Model find By PK End");
		return bean;
	}

	public void update(StudentBean bean) throws ApplicationException, DuplicateRecordException {
		log.debug("model update started");
		Connection conn = null;
		StudentBean beanExist = findByEmailId(bean.getEmail());

		if (beanExist != null && beanExist.getId() != bean.getId()) {
			throw new DuplicateRecordException("Email Id is Already Exist");
		}
		CollegeModel cModel = new CollegeModel();
		CollegeBean collegeBean = cModel.findByPK(bean.getId());
		bean.setCollegeName(collegeBean.getName());
		try {
			conn = JDBCDataSource.getConnection();
			conn.setAutoCommit(false);
			PreparedStatement ps = conn.prepareStatement(
					"UPDATE ST_STUDENT SET COLLEGE_ID=?,COLLEGE_NAME=?,FIRST_NAME=?,LAST_NAME=?,DATE_OF_BIRTH=?,MOBILE_NO=?,EMAIL=?,CREATED_BY=?,MODIFIED_BY=?,CREATED_DATETIME=?,MODIFIED_DATETIME=? WHERE ID=? ");

			ps.setLong(1, bean.getCollegeId());
			ps.setString(2, bean.getCollegeName());
			ps.setString(3, bean.getFirstName());
			ps.setString(4, bean.getLastName());
			ps.setString(5, bean.getMobileNo());
			ps.setString(6, bean.getEmail());
			ps.setDate(7, new java.sql.Date(bean.getDob().getTime()));
			ps.setString(8, bean.getCreatedBy());
			ps.setString(9, bean.getModifiedBy());
			ps.setTimestamp(10, bean.getCreatedDatetime());
			ps.setTimestamp(11, bean.getCreatedDatetime());

			ps.setLong(12, bean.getId());
			ps.executeUpdate();
			conn.commit();
			ps.close();
		} catch (Exception e) {
			e.printStackTrace();
			log.error("Database Exception..", e);
			try {
				conn.rollback();
			} catch (Exception ex) {
				throw new ApplicationException("Exception : Delete rollback exception" + ex.getMessage());
			}
			throw new ApplicationException("Exception in updating Student ");
		} finally {
			JDBCDataSource.closeConnection(conn);
		}
		log.debug("Model update End");
	}

	public List search(StudentBean bean) throws ApplicationException {
		return search(bean, 0, 0);
	}

	public List search(StudentBean bean, int pageNo, int pageSize) throws ApplicationException {
		log.debug("Model search Started");
		StringBuffer sql = new StringBuffer("SELECT * FROM ST_STUDENT WHERE 1=1");

		if (bean != null) {
			if (bean.getId() > 0) {
				sql.append(" AND id = " + bean.getId());
			}
			if (bean.getFirstName() != null && bean.getFirstName().length() > 0) {
				sql.append(" AND FIRST_NAME like '" + bean.getFirstName() + "%'");
			}
			if (bean.getLastName() != null && bean.getLastName().length() > 0) {
				sql.append(" AND LAST_NAME like '" + bean.getLastName() + "%'");
			}
			if (bean.getDob() != null && bean.getDob().getDate() > 0) {
				sql.append(" AND DOB = " + bean.getDob());
			}
			if (bean.getMobileNo() != null && bean.getMobileNo().length() > 0) {
				sql.append(" AND MOBILE_NO like '" + bean.getMobileNo() + "%'");
			}
			if (bean.getEmail() != null && bean.getEmail().length() > 0) {
				sql.append(" AND EMAIL like '" + bean.getEmail() + "%'");
			}
			if (bean.getCollegeName() != null && bean.getCollegeName().length() > 0) {
				sql.append(" AND COLLEGE_NAME = " + bean.getCollegeName());
			}

		}

		if (pageSize > 0) {
			pageNo = (pageNo - 1) * pageSize;

			sql.append(" Limit " + pageNo + ", " + pageSize);
		}
		ArrayList list = new ArrayList();
		Connection conn = null;
		try {
			conn = JDBCDataSource.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql.toString());
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				bean = new StudentBean();
				bean.setId(rs.getLong(1));
				bean.setCollegeId(rs.getLong(2));
				bean.setCollegeName(rs.getString(3));
				bean.setFirstName(rs.getString(4));
				bean.setLastName(rs.getString(5));
				bean.setDob(rs.getDate(6));
				bean.setMobileNo(rs.getString(7));
				bean.setEmail(rs.getString(8));
				bean.setCreatedBy(rs.getString(9));
				bean.setModifiedBy(rs.getString(10));
				bean.setCreatedDatetime(rs.getTimestamp(11));
				bean.setModifiedDatetime(rs.getTimestamp(12));
				list.add(bean);
			}
			rs.close();
		} catch (Exception e) {
			log.error("Database Exception..", e);
			throw new ApplicationException("Exception : Exception in search Student");
		} finally {
			JDBCDataSource.closeConnection(conn);
		}

		log.debug("Model search End");
		return list;
	}
	 public List list() throws ApplicationException {
	        return list(0, 0);
	    }

	    public List list(int pageNo, int pageSize) throws ApplicationException {
	        log.debug("Model list Started");
	        ArrayList list = new ArrayList();
	        StringBuffer sql = new StringBuffer("select * from ST_STUDENT");

	        if (pageSize > 0) {
	        
	            pageNo = (pageNo - 1) * pageSize;
	            sql.append(" limit " + pageNo + "," + pageSize);
	        }

	        Connection conn = null;

	        try {
	            conn = JDBCDataSource.getConnection();
	            PreparedStatement pstmt = conn.prepareStatement(sql.toString());
	            ResultSet rs = pstmt.executeQuery();
	            while (rs.next()) {
	                StudentBean bean = new StudentBean();
	                bean.setId(rs.getLong(1));
	                bean.setCollegeId(rs.getLong(2));
	                bean.setCollegeName(rs.getString(3));
	                bean.setFirstName(rs.getString(4));
	                bean.setLastName(rs.getString(5));
	                bean.setDob(rs.getDate(6));
	                bean.setMobileNo(rs.getString(7));
	                bean.setEmail(rs.getString(8));
	                bean.setCreatedBy(rs.getString(9));
	                bean.setModifiedBy(rs.getString(10));
	                bean.setCreatedDatetime(rs.getTimestamp(11));
	                bean.setModifiedDatetime(rs.getTimestamp(12));
	                list.add(bean);
	            }
	            rs.close();
	        } catch (Exception e) {
	            log.error("Database Exception..", e);
	            throw new ApplicationException(
	                    "Exception : Exception in getting list of Student");
	        } finally {
	            JDBCDataSource.closeConnection(conn);
	        }

	        log.debug("Model list End");
	        return list;
	    }
	    }
