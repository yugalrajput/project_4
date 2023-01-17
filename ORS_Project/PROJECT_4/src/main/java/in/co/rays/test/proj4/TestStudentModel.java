package in.co.rays.test.proj4;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import in.co.rays.bean.proj4.StudentBean;
import in.co.rays.exception.proj4.ApplicationException;
import in.co.rays.exception.proj4.DuplicateRecordException;
import in.co.rays.model.proj4.StudentModel;

/**
 * @author Prashant Jha
 *
 */
public class TestStudentModel {

	public static StudentModel model = new StudentModel();

	public static void main(String[] args) throws ParseException, DuplicateRecordException, ApplicationException {
		testAdd();
//		testDelete();
//	testFindByEmailId();
//		  testFindByPK();
//		testUpdate();
//		testSearch();
//		testList();
	}

	public static void testAdd() throws ParseException {

		try {
			StudentBean bean = new StudentBean();

			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

			bean.setId(1);
			bean.setCollegeId(4L);
			bean.setCollegeName("A.P.J.abdul kalaam college");
			bean.setFirstName("aswin");
			bean.setLastName("chaudhary");
			bean.setDob(sdf.parse("4/02/1999"));
			bean.setMobileNo("9165254357");
			bean.setEmail("aswin@gmail.com");

			bean.setCreatedBy("Admin");
			bean.setModifiedBy("Admin");
			bean.setCreatedDatetime(new Timestamp(new Date().getTime()));
			bean.setModifiedDatetime(new Timestamp(new Date().getTime()));
			long pk = model.add(bean);
			
	            StudentBean addedbean = model.findByPk(pk);
	            if (addedbean == null) {
	                System.out.println("Test add fail");
	            }
		} catch (ApplicationException e) {
			e.printStackTrace();
			System.out.println("model delete success");

		} catch (DuplicateRecordException e) {
			e.printStackTrace();
		}
	}

	public static void testDelete() throws DuplicateRecordException {
		try {
			long pk = 2L;
			StudentBean bean = new StudentBean();
			bean.setId(pk);
			model.delete(bean);
	            StudentBean deletedbean = model.findByPk(pk);
	            if (deletedbean != null) {
	                System.out.println("Test Delete fail");
	            }
		} catch (ApplicationException e) {
			e.printStackTrace();
		}
	}

	public static void testFindByEmailId() throws ApplicationException {
		try {
			StudentBean bean = model.findByEmailId("vipin@gmail.com");
			if (bean != null) {

				System.out.println(bean.getId());
				System.out.println(bean.getCollegeId());
				System.out.println(bean.getCollegeName());
				System.out.println(bean.getFirstName());
				System.out.println(bean.getLastName());
				System.out.println(bean.getDob());
				System.out.println(bean.getMobileNo());
			}
		} catch (ApplicationException e) {
			e.printStackTrace();
		}
	}

	public static void testFindByPK() {
		try {
			StudentBean bean = new StudentBean();
			long pk = 1;
			bean = model.findByPk(pk);
			if (bean == null) {
				System.out.println("Test Find By PK fail");
			}
			System.out.println(bean.getId());
			System.out.println(bean.getFirstName());
			System.out.println(bean.getLastName());
			System.out.println(bean.getDob());
			System.out.println(bean.getMobileNo());
			System.out.println(bean.getEmail());
			System.out.println(bean.getCollegeId());
		} catch (ApplicationException e) {
			e.printStackTrace();
		}

	}

	private static void testUpdate() throws ApplicationException {
		try {
			StudentBean bean = model.findByPk(2);

//		            bean.setCollegeId(1L);
			bean.setCollegeName("Sage University");
			bean.setFirstName("Ankit");
			bean.setLastName("Sharma");
			bean.setDob(new Date());
			model.update(bean);
			System.out.println("test update succ");
		            StudentBean updatedbean = model.findByPk(3L);
		            if (!"rr".equals(updatedbean.getFirstName())) {
		                System.out.println("Test Update fail");
		            }
		} catch (ApplicationException e) {

			e.printStackTrace();
		} catch (DuplicateRecordException e) {
			e.printStackTrace();
		}
	}

	private static void testSearch() {
		// TODO Auto-generated method stub
		try {
			StudentBean bean = new StudentBean();
			List list = new ArrayList();
//          bean.setLastName("Sharma");
			bean.setFirstName("Ankit");
//                    bean.setId(1);
//          bean.setCollegeId(2);
			list = model.search(bean, 0, 0);
			if (list.size() < 0) {
				System.out.println("Test Serach fail");

			}
			Iterator it = list.iterator();
			while (it.hasNext()) {
				bean = (StudentBean) it.next();
				System.out.println(bean.getId());
				System.out.println(bean.getFirstName());
				System.out.println(bean.getLastName());
				System.out.println(bean.getDob());
				System.out.println(bean.getMobileNo());
				System.out.println(bean.getEmail());
				System.out.println(bean.getCollegeId());
			}

		} catch (ApplicationException e) {
			e.printStackTrace();
		}
	}
	  public static void testList() {

	        try {
	            StudentBean bean = new StudentBean();
	            List list = new ArrayList();
	            list = model.list(1, 10);
	            if (list.size() < 0) {
	                System.out.println("Test list fail");
	            }
	            Iterator it = list.iterator();
	            while (it.hasNext()) {
	                bean = (StudentBean) it.next();
	                System.out.println(bean.getId());
	                System.out.println(bean.getFirstName());
	                System.out.println(bean.getLastName());
	                System.out.println(bean.getDob());
	                System.out.println(bean.getMobileNo());
	                System.out.println(bean.getEmail());
	                System.out.println(bean.getCollegeId());
	                System.out.println(bean.getCreatedBy());
	                System.out.println(bean.getCreatedDatetime());
	                System.out.println(bean.getModifiedBy());
	                System.out.println(bean.getModifiedDatetime());
	            }

	        } catch (ApplicationException e) {
	            e.printStackTrace();
	        }
	    }

	
}