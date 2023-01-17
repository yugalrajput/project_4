package in.co.rays.test.proj4;


import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import in.co.rays.bean.proj4.CourseBean;
import in.co.rays.model.proj4.CourseModel;

/**
 * @author Prashant Jha
 *
 */
public class TestCourseModel {
	
    public static CourseBean model = new CourseBean();
    public static void main(String[] args) {
		testAdd();
//		testdelete();
//		testUpdate();
//		testsearch();
//		testlist();
	}
	

	private static void testAdd() {
		try {
			CourseBean bean = new CourseBean();
			CourseModel model = new CourseModel();

			bean.setName("B.com");
			bean.setDescription("commerce_Expertization");
			bean.setDuration("sixth");
			bean.setCreatedBy("grow");
			bean.setModifiedBy("grow");
			bean.setCreatedDatetime(new Timestamp(new Date().getTime()));
			bean.setModifiedDatetime(new Timestamp(new Date().getTime()));

			long pk = model.add(bean);

			System.out.println("Test Add Success");

			CourseBean bean1 = model.findByPk(1);
			if (bean1 == null) {
				System.out.println("Test Add fail");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static void testdelete () {
			try {
				
				CourseModel model = new CourseModel();
				CourseBean bean = new CourseBean();
				bean.setId(5L);
				model.delete(bean);
				System.out.println("Test delete Success");
				CourseBean bean1= model.findByPk(1);
				if (bean1 == null) {
					System.out.println("Test delete fail");
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
	}

	public static void testUpdate() {
		try {
			
			CourseModel model = new CourseModel();
			CourseBean bean = model.findByPk(1);
			bean.setName("BE");
			bean.setDescription("Hindi");
			bean.setDuration("sdsad");
			bean.setCreatedBy("Admin");
			bean.setModifiedBy("Admin");
			bean.setCreatedDatetime(new Timestamp(new Date().getTime()));
			bean.setModifiedDatetime(new Timestamp(new Date().getTime()));

			model.update(bean);

			System.out.println("Test update Success");

			CourseBean bean1 = model.findByPk(1);

			if (bean1 == null) {
				System.out.println("Test update fail");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	
	}
	public static void testsearch() {
		try {
			CourseBean bean = new CourseBean();
			CourseModel model = new CourseModel();
			List list = new ArrayList();
            bean.setName("BE");
            list = model.search(bean, 1, 10);
            if (list.size() < 0) {
                System.out.println("Test Search fail");
            }
            Iterator it = list.iterator();
            while (it.hasNext()) {
                bean = (CourseBean) it.next();
                System.out.println(bean.getId());
	            System.out.println(bean.getName());
	            System.out.println(bean.getDescription());
	            System.out.println(bean.getCreatedBy());
	            System.out.println(bean.getModifiedBy());
	            System.out.println(bean.getCreatedDatetime());
	            System.out.println(bean.getModifiedDatetime());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
		
	}

	public static void testlist() {

		try {
			CourseBean bean = new CourseBean();
			CourseModel model = new CourseModel();
            List list = new ArrayList();
            list = model.list(1, 6);
            if (list.size() < 0) {
                System.out.println("Test List fail");
            }
            Iterator it = list.iterator();
            while (it.hasNext()) {
                bean = (CourseBean) it.next();
                System.out.println(bean.getId());
                System.out.println(bean.getName());
	            System.out.println(bean.getDescription());
                System.out.println(bean.getDuration());
                System.out.println(bean.getCreatedDatetime());
                System.out.println(bean.getModifiedBy());
                System.out.println(bean.getModifiedDatetime());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }	
	}	
}