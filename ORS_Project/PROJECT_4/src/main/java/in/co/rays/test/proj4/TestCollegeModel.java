package in.co.rays.test.proj4;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import in.co.rays.bean.proj4.CollegeBean;
import in.co.rays.exception.proj4.ApplicationException;
import in.co.rays.exception.proj4.DuplicateRecordException;
import in.co.rays.model.proj4.CollegeModel;

/**
 * @author Prashant Jha
 *
 */
public class TestCollegeModel {

    public static CollegeModel model = new CollegeModel();

	public static void main(String[] args) throws DuplicateRecordException, ApplicationException {
//        testAdd();
		//  testDelete();
//   	testFindByName();
 	  // testUpdate();
    // testFindByName();
//         testFindByPK();
//        testSearch();
testList();

	}

public static void testAdd() throws DuplicateRecordException{
	 CollegeBean bean= new CollegeBean();
		bean.setName("saurabh");
		bean.setAddress("cihor road");
		bean.setState("mp");
		bean.setCity("becsul");
		bean.setPhoneNo("9654656687");
		bean.setCreatedBy("cs");
		bean.setModifiedBy("cs");
		bean.setCreatedDatetime(new Timestamp(new Date().getTime()));
		bean.setModifiedDatetime(new Timestamp(new Date().getTime()));
	 
	try { 
	 
	long pk= model.add(bean);
	System.out.println("Test add pass");
	CollegeBean addedBean = model.findByPK(pk);
    if (addedBean == null) {
        System.out.println("Test add fail");
    }
} catch (ApplicationException e) {
    e.printStackTrace();
    }
	
  }

public static void testDelete() throws ApplicationException {
	  try {
          CollegeBean bean = new CollegeBean();
         // bean.setId(1);
          long pk = 1;
          bean.setId(pk);
          model.delete(bean);
          System.out.println("Test Delete succ");
          CollegeBean deletedBean = model.findByPK(pk);
          if (deletedBean != null) {
              System.out.println("Test Delete fail");
          }
      } catch (ApplicationException e) {
          e.printStackTrace();
      }
}
   public static void testFindByName() {
	 try {
         CollegeBean bean = model.findByName("MLB College");
         bean.setName("");
         if (bean == null) {
             System.out.println("Test Find By Name fail");
         }
         System.out.println(bean.getId());
         System.out.println(bean.getName());
         System.out.println(bean.getAddress());
         System.out.println(bean.getState());
         System.out.println(bean.getCity());
         System.out.println(bean.getPhoneNo());
         System.out.println(bean.getCreatedBy());
         System.out.println(bean.getModifiedBy());
         System.out.println(bean.getCreatedDatetime());
         System.out.println(bean.getModifiedDatetime());
     } catch (ApplicationException e) {
         e.printStackTrace();
     }
 }
  
 public static void testUpdate() throws ApplicationException {
       try {
           CollegeBean bean =model.findByPK(1);

           bean.setName("Lnct");
           bean.setAddress("gwalior");
           model.update(bean);
           System.out.println("Test Update succ");
//           CollegeBean updateBean = model.findByPK(2L);
//           if (!"oit".equals(updateBean.getName())) {
//               System.out.println("Test Update fail");
//           }
       } catch (ApplicationException e) {
           e.printStackTrace();
       } catch (DuplicateRecordException e) {
           e.printStackTrace();
       }

   }
   public static void testFindByPK() throws ApplicationException {
       try { CollegeBean bean = new CollegeBean();
    long pk = 1;
           bean = model.findByPK(pk);
           
           if (bean == null) {
               System.out.println("Test Find By PK fail");
           }
        //.out.println(bean.getId());
           System.out.println(bean.getName());
           System.out.println(bean.getAddress());
           System.out.println(bean.getState());
           System.out.println(bean.getCity());
           System.out.println(bean.getPhoneNo());
           System.out.println(bean.getCreatedBy());
           System.out.println(bean.getCreatedDatetime());
           System.out.println(bean.getModifiedBy());
           System.out.println(bean.getModifiedDatetime());
       } catch (ApplicationException e) {
           e.printStackTrace();
       }

   }

   public static void testSearch() throws ApplicationException {
       try {
           CollegeBean bean = new CollegeBean();
           List list = new ArrayList();
           bean.setName("abhishek verma");
           // bean.setAddress("borawan");
           list = model.search(bean, 1, 10);
           if (list.size() < 0) {
               System.out.println("Test Search fail");
           }
           Iterator it = list.iterator();
           while (it.hasNext()) {
               bean = (CollegeBean) it.next();
               System.out.println(bean.getId());
               System.out.println(bean.getName());
               System.out.println(bean.getAddress());
               System.out.println(bean.getState());
               System.out.println(bean.getCity());
               System.out.println(bean.getPhoneNo());
               System.out.println(bean.getCreatedBy());
               System.out.println(bean.getCreatedDatetime());
               System.out.println(bean.getModifiedBy());
               System.out.println(bean.getModifiedDatetime());
          }
       } catch (ApplicationException e) {
           e.printStackTrace();} }
   public static void testList() throws ApplicationException {
         try {
           CollegeBean bean = new CollegeBean();
           List list = new ArrayList();
           list = model.list(1, 10);
           if (list.size() < 0) {
               System.out.println("Test list fail");
           }
           Iterator it = list.iterator();
           while (it.hasNext()) {
               bean = (CollegeBean) it.next();
               System.out.println(bean.getId());
               System.out.println(bean.getName());
               System.out.println(bean.getAddress());
               System.out.println(bean.getState());
               System.out.println(bean.getCity());
               System.out.println(bean.getPhoneNo());
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
	
	
