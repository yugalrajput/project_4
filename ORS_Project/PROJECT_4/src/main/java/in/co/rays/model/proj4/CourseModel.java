package in.co.rays.model.proj4;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import in.co.rays.bean.proj4.CourseBean;
import in.co.rays.exception.proj4.ApplicationException;
import in.co.rays.exception.proj4.DatabaseException;
import in.co.rays.exception.proj4.DuplicateRecordException;
import in.co.rays.util.proj4.JDBCDataSource;


/**
 * @author Prashant Jha
 *
 */
public class CourseModel {
	/**
	 * Find next Primary  key of College
	 *
	 */
	public long nextPK() throws DatabaseException {

		Connection conn = null;
		int pk = 0;
		try {
			conn = JDBCDataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement("SELECT MAX(ID) FROM ST_COURSE");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				pk = rs.getInt(1);
			}
			rs.close();
		} catch (Exception e) {
			e.printStackTrace();

			throw new DatabaseException("Exception : Exception in getting Pk");
		} finally {
			JDBCDataSource.closeConnection(conn);
		}
		return pk + 1;
	}
	/**
	 * Add a Course
	 *
	 */
	public long add(CourseBean bean) throws ApplicationException, DuplicateRecordException {

		Connection conn = null;
		int pk = 0;

		CourseBean duplicateCourseName = findByName(bean.getName());
		if (duplicateCourseName != null) {
			throw new DuplicateRecordException("Course Name already Exist");
		}

		try {
			conn = JDBCDataSource.getConnection();

			conn.setAutoCommit(false);
			PreparedStatement ps = conn.prepareStatement("INSERT INTO ST_COURSE VALUES(?,?,?,?,?,?,?,?)");
			ps.setLong(1, nextPK());
			ps.setString(2, bean.getName());
			ps.setString(3, bean.getDescription());
			ps.setString(4, bean.getDuration());
			ps.setString(5, bean.getCreatedBy());
			ps.setString(6, bean.getModifiedBy());
			ps.setTimestamp(7, bean.getCreatedDatetime());
			ps.setTimestamp(8, bean.getModifiedDatetime());

			ps.executeUpdate();

			conn.commit();
			ps.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
			try {
				conn.rollback();
			} catch (Exception ex) {
				throw new ApplicationException("Exception : add Rollback Exception.." + ex.getMessage());
			}
			throw new ApplicationException("Exception in Course Add method");
		} finally {
			JDBCDataSource.closeConnection(conn);
		}
		return pk;
	}
	/**
	 * Delete a Course
	 *
	 */
	public void delete(CourseBean bean) throws ApplicationException {

		Connection conn = null;
		try {
			conn = JDBCDataSource.getConnection();
			conn.setAutoCommit(false);
			PreparedStatement ps = conn.prepareStatement("DELETE FROM ST_COURSE WHERE ID=?");
			ps.setLong(1, bean.getId());
			ps.executeUpdate();
			conn.commit();
			ps.close();
		} catch (Exception e) {
			e.printStackTrace();

			try {
				conn.rollback();
			} catch (Exception ex) {
				throw new ApplicationException("Exception : Exception in Rollback Method" + ex.getMessage());
			}
			throw new ApplicationException("Exception in Delete Method");
		} finally {
			JDBCDataSource.closeConnection(conn);
		}
	}
	/**
	 * Update a Course
	 *
	 */
	public void update(CourseBean bean) throws ApplicationException, DuplicateRecordException {
		Connection conn = null;

		CourseBean beanExist = findByName(bean.getName());
		if (beanExist != null && beanExist.getId() != bean.getId()) {
			throw new DuplicateRecordException("Course Already Exist");
		}
		try {
			conn = JDBCDataSource.getConnection();
			conn.setAutoCommit(false);
			PreparedStatement ps = conn.prepareStatement(
					"UPDATE ST_COURSE SET NAME=?,DESCRIPTION=?,DURATION=?,CREATED_BY=?,MODIFIED_BY=?,CREATED_DATETIME=?,MODIFIED_DATETIME=? WHERE ID=?");
			ps.setString(1, bean.getName());
			ps.setString(2, bean.getDescription());
			ps.setString(3, bean.getDuration());
			ps.setString(4, bean.getCreatedBy());
			ps.setString(5, bean.getModifiedBy());
			ps.setTimestamp(6, bean.getCreatedDatetime());
			ps.setTimestamp(7, bean.getModifiedDatetime());
			ps.setLong(8, bean.getId());

			ps.executeUpdate();
			conn.commit();
			ps.close();

		} catch (Exception e) {
			e.printStackTrace();
			try {
				conn.rollback();
			} catch (Exception ex) {
				ex.printStackTrace();
				throw new ApplicationException("Exception : Exception in Rollback.." + ex.getMessage());
			}
			throw new ApplicationException("Exception in Updating the Course Model");
		} finally {
			JDBCDataSource.closeConnection(conn);
		}
	}
	/**
	 * Find by name of a Course
	 *
	 */
	public CourseBean findByName(String name) throws ApplicationException {

		StringBuffer sql = new StringBuffer("SELECT * FROM ST_COURSE WHERE NAME=?");
		CourseBean bean = null;
		Connection conn = null;
		try {
			conn = JDBCDataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql.toString());
			ps.setString(1, name);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				bean = new CourseBean();
				bean.setId(rs.getLong(1));
				bean.setName(rs.getString(2));
				bean.setDescription(rs.getString(3));
				bean.setDuration(rs.getString(4));
				bean.setCreatedBy(rs.getString(5));
				bean.setModifiedBy(rs.getString(6));
				bean.setCreatedDatetime(rs.getTimestamp(7));
				bean.setModifiedDatetime(rs.getTimestamp(8));

			}
			rs.close();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCDataSource.closeConnection(conn);
		}

		return bean;
	}
	/**
	 * Find by primary key of a College
	 *
	 */
	public CourseBean findByPk(long pk) throws ApplicationException {

		StringBuffer sql = new StringBuffer("SELECT * FROM ST_COURSE WHERE ID=?");
		CourseBean bean = null;
		Connection conn = null;

		try {
			conn = JDBCDataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql.toString());
			ps.setLong(1, pk);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				bean = new CourseBean();
				bean.setId(rs.getLong(1));
				bean.setName(rs.getString(2));
				bean.setDescription(rs.getString(3));
				bean.setDuration(rs.getString(4));
				bean.setCreatedBy(rs.getString(5));
				bean.setModifiedBy(rs.getString(6));
				bean.setCreatedDatetime(rs.getTimestamp(7));
				bean.setModifiedDatetime(rs.getTimestamp(8));
			}
			rs.close();
		} catch (Exception e) {
			e.printStackTrace();

			throw new ApplicationException("Exception : Exception in the findbyPk method");
		} finally {
			JDBCDataSource.closeConnection(conn);
		}

		return bean;
	}

	public List search(CourseBean bean) throws ApplicationException {
		return search(bean, 0, 0);
	}
	/**
	 * Search of a College
	 *
	 */
	public List search(CourseBean bean, int pageNo, int pageSize) throws ApplicationException {

		StringBuffer sql = new StringBuffer("SELECT * FROM ST_COURSE WHERE 1=1");
		if (bean != null) {
			if (bean.getId() > 0) {
				sql.append(" AND id = " + bean.getId());
			}
			if(bean.getName()!=null && bean.getName().length()>0) {
				sql.append(" AND NAME like '" + bean.getName() + "%'");
			}
		}
		if (pageSize > 0) {
			pageNo = (pageNo - 1) * pageSize;
			sql.append(" limit " + pageNo + "," + pageSize);
		}
		ArrayList list = new ArrayList();
		Connection conn = null;
		try {
			conn = JDBCDataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql.toString());
			System.out.println(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				bean = new CourseBean();
				bean.setId(rs.getLong(1));
				bean.setName(rs.getString(2));
				bean.setDescription(rs.getString(3));
				bean.setDuration(rs.getString(4));
				bean.setCreatedBy(rs.getString(5));
				bean.setModifiedBy(rs.getString(6));
				bean.setCreatedDatetime(rs.getTimestamp(7));
				bean.setModifiedDatetime(rs.getTimestamp(8));
				list.add(bean);

			}
			rs.close();
		} catch (Exception e) {
			e.printStackTrace();

			throw new ApplicationException("Exception in the Search Method" + e.getMessage());

		} finally {
			JDBCDataSource.closeConnection(conn);
		}

		return list;
	}
	/**
	 * Find list of a Course
	 *
	 */
	public List list() throws ApplicationException {
		return list(0, 0);
	}

	public List list(int pageNo, int pageSize) throws ApplicationException {

		StringBuffer sql = new StringBuffer("SELECT * FROM ST_COURSE ");

		if (pageSize > 0) {
			pageNo = (pageNo - 1) * pageSize;
			sql.append(" limit " + pageNo + " , " + pageSize);
		}

		ArrayList list = new ArrayList();
		Connection conn = null;

		try {
			conn = JDBCDataSource.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql.toString());
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				CourseBean bean = new CourseBean();
				bean.setId(rs.getLong(1));
				bean.setName(rs.getString(2));
				bean.setDescription(rs.getString(3));
				bean.setDuration(rs.getString(4));
				bean.setCreatedBy(rs.getString(5));
				bean.setModifiedBy(rs.getString(6));
				bean.setCreatedDatetime(rs.getTimestamp(7));
				bean.setModifiedDatetime(rs.getTimestamp(8));
				list.add(bean);
			}
			rs.close();
		} catch (Exception e) {
			e.printStackTrace();

			throw new ApplicationException("Exception : Exception in CourseModel List method " + e.getMessage());
		} finally {
			JDBCDataSource.closeConnection(conn);
		}

		return list;
	}
}

