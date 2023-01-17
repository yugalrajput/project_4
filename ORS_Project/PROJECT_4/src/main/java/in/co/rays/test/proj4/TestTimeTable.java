package in.co.rays.test.proj4;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.mail.internet.ParseException;

import in.co.rays.bean.proj4.TimeTableBean;
import in.co.rays.exception.proj4.ApplicationException;
import in.co.rays.exception.proj4.DuplicateRecordException;
import in.co.rays.model.proj4.TimeTableModel;

/**
 * The Class TimeTableModelTest.
 * 
 * @author Prashant Jha
 *
 */
public class TestTimeTable {

	/** The model. */
	public static TimeTableModel model = new TimeTableModel();

	/**
	 * The main method.
	 *
	 * @param args
	 *            the arguments
	 * @throws java.text.ParseException 
	 * @throws ParseException
	 *             the parse exception
	 * @throws ApplicationException
	 * @throws java.text.ParseException 
	 * @throws DuplicateRecordException 
	 * @throws java.text.ParseException 
	 *  
	 */
public static void main(String[] args) throws ParseException, DuplicateRecordException, java.text.ParseException, ApplicationException {
	

//	testAdd();
		 testDelete();
//		 testFindByPK();
//		 testSearch();
//		 testList();
//		 testUpdate();

	}

	/**
	 * Test add.
	 *
	 * @throws ParseException
	 *             the parse exception
	 * @throws java.text.ParseException 
	 * @throws DuplicateRecordException 
	 * @throws java.text.ParseException 
	 */
	public static void testAdd() throws ParseException, ParseException, DuplicateRecordException, java.text.ParseException {
		try {
			TimeTableBean bean = new TimeTableBean();
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

//			bean.setCourseId(1L);
			bean.setSubjectId(3L);
			bean.setSubjectName("physics");
			bean.setCourseId(6);
			bean.setCourseName("B TECH");
			bean.setExamDate(sdf.parse("01/05/2018"));
			bean.setExamTime("07:00 AM to 10:00 AM");
			bean.setSemester("1st");
			bean.setSubjectName("RDBMS");
			bean.setCreatedBy("Admin");
			bean.setModifiedBy("Admin");
			bean.setCreatedDatetime(new Timestamp(new Date().getTime()));
			bean.setModifiedDatetime(new Timestamp(new Date().getTime()));
			long pk = model.add(bean);
			TimeTableBean addedbean = model.findByPk(pk);
			if (addedbean == null) {
				System.out.println("Test add fail");
			}
		} catch (ApplicationException e) {
			e.printStackTrace();
		} catch (DuplicateRecordException e) {
			e.printStackTrace();
		}

	}

	

	/**
	 * Test find by PK.
	 */
	public static void testFindByPK() {
		try {
			TimeTableBean bean = new TimeTableBean();
			long pk = 1;
			bean = model.findByPk(pk);
			if (bean == null) {
				System.out.println("Test Find By PK fail");
			}
			System.out.println(bean.getId());
			System.out.println(bean.getCourseId());
			System.out.println(bean.getCourseName());
			System.out.println(bean.getExamTime());
			System.out.println(bean.getSemester());
			System.out.println(bean.getSubjectId());
			System.out.println(bean.getSubjectName());
			System.out.println(bean.getExamDate());

			System.out.println(bean.getCreatedBy());
			System.out.println(bean.getModifiedBy());
		} catch (ApplicationException e) {
			e.printStackTrace();
		}

	}

	/**
	 * Test search.
	 */
	public static void testSearch() {

		try {
			TimeTableBean bean = new TimeTableBean();
			List list = new ArrayList();
			bean.setSubjectName("RDBMS");
			list = model.search(bean, 0, 0);
			if (list.size() < 0) {
				System.out.println("Test Serach fail");
			}
			Iterator it = list.iterator();
			while (it.hasNext()) {
				bean = (TimeTableBean) it.next();
				System.out.println(bean.getId());
				System.out.println(bean.getCourseId());
				System.out.println(bean.getCourseName());
				System.out.println(bean.getExamTime());
				System.out.println(bean.getSemester());
				System.out.println(bean.getSubjectId());
				System.out.println(bean.getSubjectName());
				System.out.println(bean.getExamDate());
			}

		} catch (ApplicationException e) {
			e.printStackTrace();
		}

	}

	/**
	 * Test list.
	 */
	public static void testList() {

		try {
			TimeTableBean bean = new TimeTableBean();
			List list = new ArrayList();
			list = model.list(1, 12);
			if (list.size() < 0) {
				System.out.println("Test list fail");
			}
			Iterator it = list.iterator();
			while (it.hasNext()) {
				bean = (TimeTableBean) it.next();
				System.out.println(bean.getId());
				System.out.println(bean.getCourseId());
				System.out.println(bean.getCourseName());
				System.out.println(bean.getExamTime());
				System.out.println(bean.getSemester());
				System.out.println(bean.getSubjectId());
				System.out.println(bean.getSubjectName());
				System.out.println(bean.getExamDate());
				System.out.println(bean.getCreatedBy());
				System.out.println(bean.getCreatedDatetime());
				System.out.println(bean.getModifiedBy());
				System.out.println(bean.getModifiedDatetime());
			}

		} catch (ApplicationException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Test update.
	 */
	public static void testUpdate() {

		try {
			TimeTableBean bean = model.findByPk(1);
			bean.setSubjectId(1L);
			 bean.setSubjectName("Material Technology");
			model.update(bean);
			System.out.println("timetble update succesfully");

//			TimeTableBean updatedbean = model.findByPk(1L);
			/*
			 * if (!"Material Technology".equals(updatedbean.getSubjectName()))
			 * { System.out.println("Test Update fail"); }else{
			 * System.out.println("Test Update Successfully"); }
			 */

		} catch (ApplicationException e) {
			e.printStackTrace();
		} catch (DuplicateRecordException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Test delete.
	 */
	public static void testDelete() {

		try {
			TimeTableBean bean = new TimeTableBean();
			long pk = 1L;
			bean.setId(pk);
			model.delete(bean);
System.out.println("delete succ");
			TimeTableBean deletedBean = model.findByPk(pk);
			if (deletedBean != null) {

				System.out.println("Test Delete fail");

			}
		} catch (ApplicationException e) {
			e.printStackTrace();
		}
	}

	}

