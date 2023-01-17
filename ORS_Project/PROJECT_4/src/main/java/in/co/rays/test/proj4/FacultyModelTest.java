package in.co.rays.test.proj4;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import in.co.rays.bean.proj4.FacultyBean;
import in.co.rays.exception.proj4.ApplicationException;
import in.co.rays.exception.proj4.DuplicateRecordException;
import in.co.rays.model.proj4.FacultyModel;

//TODO: Auto-generated Javadoc

/**
 * @author Prashant Jha
 *
 */
public class FacultyModelTest {

	
	public static FacultyModel model = new FacultyModel();

	public static void main(String[] args) throws DuplicateRecordException, ParseException {
		testAdd();
//		 testDelete();
//		 testUpdate();
//		 testFindByEmailId();
//		 testFindByPK();
//		testSearch();
//		 testList();

	}

	
	public static void testAdd() throws DuplicateRecordException, ParseException {

		try {
			FacultyBean bean = new FacultyBean();

			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

			bean.setCollegeId(2L);
			bean.setCourseId(2L);
			bean.setSubjectId(2L);
			bean.setFirstName("kartikay");
			bean.setLastName("rai");
			bean.setGender("male");
		bean.setDob(sdf.parse("6/07/1998"));
			bean.setEmailId("kartikey@1234");
			bean.setMobileNo("8765576878");

			bean.setCreatedBy("cat");
			bean.setModifiedBy("cat");
			bean.setCreatedDatetime(new Timestamp(new Date().getTime()));
			bean.setModifiedDatetime(new Timestamp(new Date().getTime()));
			long pk = model.add(bean);
			System.out.println("Test add succ");

		} catch (ApplicationException e) {
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void testDelete() {

		try {
			FacultyBean bean = new FacultyBean();
			long pk = 2L;
			bean.setId(pk);
			model.delete(bean);
			System.out.println("Test Delete successfully");

			FacultyBean deletedBean = model.findByPk(pk);
			if (deletedBean != null) {

				System.out.println("Test Delete fail");

			}
		} catch (ApplicationException e) {
			e.printStackTrace();
		}
	}

	
	public static void testUpdate() {

		try {
			FacultyBean bean = model.findByPk(2L);
			bean.setCollegeId(1);
			bean.setFirstName("Sheekha");
			bean.setLastName("Dave");
			bean.setGender("female");
			model.update(bean);

			FacultyBean updatedbean = model.findByPk(2L);
			if (!"Sheekha".equals(updatedbean.getFirstName())) {
				System.out.println("Test Update fail");
			} else {
				System.out.println("Test Update Successfully");
			}
		} catch (ApplicationException e) {
			e.printStackTrace();
		} catch (DuplicateRecordException e) {
			e.printStackTrace();
		}
	}

	public static void testFindByPK() {
		try {
			FacultyBean bean = new FacultyBean();
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
			System.out.println(bean.getEmailId());
			System.out.println(bean.getCollegeId());
			System.out.println(bean.getCourseId());

			System.out.println(bean.getSubjectId());

		} catch (ApplicationException e) {
			e.printStackTrace();
		}

	}


	public static void testSearch() {
		try {
			FacultyBean bean = new FacultyBean();
			List list = new ArrayList();

			 //bean.setCollegeName("narmada mahavidhyalay");
			bean.setCourseName("BE");
			list = model.search(bean, 1, 10);
			if (list.size() < 0) {
				System.out.println("Test Search fail");
			}
			Iterator it = list.iterator();
			while (it.hasNext()) {
				bean = (FacultyBean) it.next();
				System.out.println(bean.getId());
				System.out.println(bean.getFirstName());
				System.out.println(bean.getLastName());
				System.out.println(bean.getEmailId());
				System.out.println(bean.getMobileNo());
				System.out.println(bean.getCreatedBy());
				System.out.println(bean.getCreatedDatetime());
				System.out.println(bean.getModifiedBy());
				System.out.println(bean.getModifiedDatetime());
			}
		} catch (ApplicationException e) {
			e.printStackTrace();
		}
	}

	
	public static void testList() {

		try {
			FacultyBean bean = new FacultyBean();
			List list = new ArrayList();
			list = model.list(1, 18);
			if (list.size() < 0) {
				System.out.println("Test list fail");
			}
			Iterator it = list.iterator();
			while (it.hasNext()) {
				bean = (FacultyBean) it.next();
				System.out.println(bean.getId());
				System.out.println(bean.getFirstName());
				System.out.println(bean.getLastName());
				System.out.println(bean.getDob());
				System.out.println(bean.getMobileNo());
				System.out.println(bean.getEmailId());
				System.out.println(bean.getCollegeId());
				System.out.println(bean.getCourseId());
				System.out.println(bean.getSubjectId());
				System.out.println(bean.getCollegeName());
				System.out.println(bean.getCourseName());
				System.out.println(bean.getSubjectName());
				System.out.println(bean.getCreatedBy());
				System.out.println(bean.getCreatedDatetime());
				System.out.println(bean.getModifiedBy());
				System.out.println(bean.getModifiedDatetime());
			}

		} catch (ApplicationException e) {
			e.printStackTrace();
		}
	}

	public static void testFindByEmailId() {
		try {
			FacultyBean bean = new FacultyBean();
			bean = model.findByEmail("amit@1234");
			if (bean != null) {
				System.out.println("Test Find By EmailId fail");
			}
			System.out.println(bean.getId());
			System.out.println(bean.getFirstName());
			System.out.println(bean.getLastName());
			System.out.println(bean.getDob());
			System.out.println(bean.getMobileNo());
			System.out.println(bean.getEmailId());
			System.out.println(bean.getCollegeId());
			System.out.println(bean.getCourseId());
			System.out.println(bean.getSubjectId());
		} catch (ApplicationException e) {
			e.printStackTrace();
		}
	}

}
