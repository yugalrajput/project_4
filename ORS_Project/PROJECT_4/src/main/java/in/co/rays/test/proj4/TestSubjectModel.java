package in.co.rays.test.proj4;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import in.co.rays.bean.proj4.SubjectBean;
import in.co.rays.exception.proj4.ApplicationException;
import in.co.rays.exception.proj4.DuplicateRecordException;
import in.co.rays.model.proj4.CollegeModel;
import in.co.rays.model.proj4.SubjectModel;

/**
 * @author Prashant Jha
 *
 */
public class TestSubjectModel {
	
    public static SubjectModel model = new SubjectModel();

	public static void main(String[] args) throws Exception {
		testAdd();
//		testdelete();
//		testUpdate();
//		testFindByPK();
//		testFindByName();
//		 testsearch();
//		 testList();

	}

	public static void testAdd() throws Exception {
		try {
			SubjectBean bean = new SubjectBean();
//			bean.setId(1);
			bean.setSubjectName("biology");
			bean.setDuration("24");
			bean.setDescription("chemist");
			bean.setCourseId(2);
			bean.setCourseName("LLB");
			bean.setCreatedBy("min");
			bean.setModifiedBy("min");
			bean.setCreatedDatetime(new Timestamp(new Date().getTime()));
			bean.setModifiedDatetime(new Timestamp(new Date().getTime()));
			long pk = model.add(bean);
			System.out.println("Test add success");
//			SubjectBean addedBean = model.findByPK(pk);
//			if (addedBean == null) {
//				System.out.println("Test add fail");
//			}
		} catch (ApplicationException e) {
			e.printStackTrace();
		}
	}

	public static void testdelete() throws Exception {
		try {
			SubjectBean bean = new SubjectBean();
			bean.setId(2);
			model.delete(bean);
			System.out.println("Test delete succ");
//				SubjectBean addedBean = model.findByPK(1L);
//				if (addedBean == null) {
//					System.out.println("Test delete fail");
//				}
		} catch (ApplicationException e) {
			e.printStackTrace();
		}
	}

	public static void testUpdate() {

		try {
			SubjectBean bean = model.findByPk(1L);

			bean.setSubjectName("Java");
            bean.setCourseId(2L);
            bean.setDescription("page");
			model.update(bean);

			SubjectBean updatedbean = model.findByPk(2L);
			System.out.println("subject updated");
			/*
			 * if (!"c++".equals(updatedbean.getSubjectName())) {
			 * System.out.println("Test Update fail"); }
			 */
		} catch (ApplicationException e) {
			e.printStackTrace();
		} catch (DuplicateRecordException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Tests find a Student by PK.
	 */
	public static void testFindByPK() {
		try {
			SubjectBean bean = new SubjectBean();
			long pk = 2L;
			bean = model.findByPk(pk);
			if (bean == null) {
				System.out.println("Test Find By PK fail");
			}
			System.out.println(bean.getId());
			System.out.println(bean.getCourseId());
			System.out.println(bean.getCourseName());
			System.out.println(bean.getDescription());
			System.out.println(bean.getCreatedBy());
			System.out.println(bean.getSubjectName());
			System.out.println(bean.getModifiedBy());
		} catch (ApplicationException e) {
			e.printStackTrace();
		}

	}

	/**
	 * Test find by name.
	 * 
	 * @throws ApplicationException
	 */
	public static void testFindByName() throws ApplicationException {

		SubjectBean bean = model.findByName("java");
		if (bean == null) {
			System.out.println("Test Find By name fail");
		}

		System.out.println(bean.getId());
		System.out.println(bean.getCourseId());
		System.out.println(bean.getCourseName());
		System.out.println(bean.getDescription());
		System.out.println(bean.getCreatedBy());
		System.out.println(bean.getSubjectName());
		System.out.println(bean.getModifiedBy());

	}

	/**
	 * Tests get Search.
	 */

	public static void testSearch() {

		try {
			SubjectBean bean = new SubjectBean();
			List list = new ArrayList();
			bean.setSubjectName("Java");
			list = model.search(bean, 1, 10);
			if (list.size() < 0) {
				System.out.println("Test Serach fail");
			}
			Iterator it = list.iterator();
			while (it.hasNext()) {
				bean = (SubjectBean) it.next();
				System.out.println(bean.getId());
				System.out.println(bean.getSubjectName());
				System.out.println(bean.getCourseId());
				System.out.println(bean.getCourseName());
				System.out.println(bean.getDescription());
			}

		} catch (ApplicationException e) {
			e.printStackTrace();
		}

	}

	private static void testsearch() {
		try {
			SubjectBean bean = new SubjectBean();
			List list = new ArrayList();
			bean.setSubjectName("Java");
			list = model.search(bean, 0, 0);
			if (list.size() < 0) {
				System.out.println("Test Search fail");
			}
			Iterator it = list.iterator();
			while (it.hasNext()) {
				bean = (SubjectBean) it.next();
				System.out.println(bean.getId());
				System.out.println(bean.getSubjectName());
				System.out.println(bean.getCourseName());
				System.out.println(bean.getCourseId());
				System.out.println(bean.getCreatedBy());
				System.out.println(bean.getModifiedBy());
				System.out.println(bean.getCreatedDatetime());
				System.out.println(bean.getModifiedDatetime());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void testList() {
		try {
			SubjectBean bean = new SubjectBean();
			List list = new ArrayList();
			list = model.list(1, 6);
			if (list.size() < 0) {
				System.out.println("Test List fail");
			}
			Iterator it = list.iterator();
			while (it.hasNext()) {
				bean = (SubjectBean) it.next();
				System.out.println(bean.getId());
				System.out.println(bean.getSubjectName());
				System.out.println(bean.getCourseName());
				System.out.println(bean.getCourseId());
				System.out.println(bean.getCreatedBy());
				System.out.println(bean.getCreatedDatetime());
				System.out.println(bean.getModifiedBy());
				System.out.println(bean.getModifiedDatetime());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
