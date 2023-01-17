package in.co.rays.test.proj4;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import in.co.rays.bean.proj4.UserBean;
import in.co.rays.exception.proj4.ApplicationException;
import in.co.rays.exception.proj4.DuplicateRecordException;
import in.co.rays.exception.proj4.RecordNotFoundException;
import in.co.rays.model.proj4.UserModel;

/**
 * @author Prashant Jha
 *
 */
public class TestUserModel {

	private static UserModel model = new UserModel();

	public static void main(String[] args)
			throws ParseException, DuplicateRecordException, RecordNotFoundException, ApplicationException {
//		testAdd();
//		testDelete();
//		 testFindByLogin();
//	testFindByPK();
//   testUpdate();
//	testSearch();
//		testList();
//		testAuthenticate();
//		testChangePassword();
		testRegisterUser();
//		testresetPassword();
//		testforgetPassword();
//		testGetRoles();
	}

	public static void testAdd() throws ParseException, DuplicateRecordException, RecordNotFoundException {
		try {
			UserBean bean = new UserBean();
			SimpleDateFormat sdf = new SimpleDateFormat("MM-DD-yyyy");

		   bean.setId(5234L);
			bean.setFirstName("ankit");
			bean.setLastName("tiwari");
			bean.setLogin("Ankit@gmail.com");
			bean.setPassword("Ab@123");
			bean.setDob(sdf.parse("05-10-2020"));
			bean.setRoleId(1);
			bean.setUnSuccessfulLogin(2);
			bean.setGender("male");
			bean.setMobileNo("8256939225");
			bean.setLastLogin(new Timestamp(new Date().getTime()));
			bean.setLock("knock");
			bean.setConfirmPassword("Ankit@123");
			long pk = model.add(bean);
			UserBean addedbean = model.findByPK(pk);
			System.out.println("Test add succesfuly");
			if (addedbean == null) {
				System.out.println("Test add fail");
			}
		} catch (ApplicationException e) {
			e.printStackTrace();
		}
	}

	public static void testDelete() throws ApplicationException {

		try {
			UserBean bean = new UserBean();
			bean.setId(3);
			model.delete(bean);
			System.out.println("model delete succ");
		} catch (Exception e) {
			System.out.println("delete succ");
			e.printStackTrace();
		}
	}

	private static void testFindByLogin() throws ApplicationException {
		try {
			UserBean bean = new UserBean();

			bean = model.findByLogin("Ankit@gmail.com");
			if (bean == null) {
				System.out.println("test find by pk fail");
			}
			System.out.println(bean.getId());
			System.out.println(bean.getFirstName());
			System.out.println(bean.getLastName());
			System.out.println(bean.getLogin());
			System.out.println(bean.getPassword());
			System.out.println(bean.getDob());
			System.out.println(bean.getRoleId());
			System.out.println(bean.getUnSuccessfulLogin());
			System.out.println(bean.getGender());
			System.out.println(bean.getLastLogin());
			System.out.println(bean.getLock());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void testFindByPK() {

		try {
			UserBean bean = new UserBean();
			long pk = 1L;
			bean = model.findByPK(pk);
			if (bean == null) {
				System.out.println("test findByPk fail");

			}
			System.out.println(bean.getId());
			System.out.println(bean.getFirstName());
			System.out.println(bean.getLastName());
			System.out.println(bean.getLogin());
			System.out.println(bean.getPassword());
			System.out.println(bean.getDob());
			System.out.println(bean.getRoleId());
			System.out.println(bean.getUnSuccessfulLogin());
			System.out.println(bean.getGender());
			System.out.println(bean.getLastLogin());
			System.out.println(bean.getLock());
		} catch (ApplicationException e) {
			e.printStackTrace();
		}
	}

	private static void testUpdate() throws RecordNotFoundException {
		try {
			
			UserBean bean = model.findByPK(1);
			SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
			bean.setFirstName("chetan");
			bean.setLastName("bhagat");
			bean.setLogin("bhagat@gmail.com");
			
			 bean.setPassword("chetan@123");
			bean.setMobileNo("7534566455");
			bean.setConfirmPassword("chetan@4321");
			bean.setRoleId(1);
			bean.setCreatedBy("admin");
			bean.setModifiedBy("admin");
			bean.setCreatedDatetime(new Timestamp(new Date().getTime()));
			bean.setModifiedDatetime(new Timestamp(new Date().getTime()));

			model.update(bean);
			System.out.println("user update successfully");

			UserBean updatedbean = model.findByPK(52);
			
		} catch (ApplicationException e) {
			e.printStackTrace();
		} catch (DuplicateRecordException e) {
			e.printStackTrace();
		}
	}
	/**
	 * Test search.
	 */
	public static void testSearch() {

		try {
			UserBean bean = new UserBean();
			List list = new ArrayList();
			bean.setLogin("bhagat@gmail.com");
			list = model.search(bean);
			if (list.size() < 0) {
				System.out.println("Test Serach fail");
			}
			Iterator it = list.iterator();
			while (it.hasNext()) {
				bean = (UserBean) it.next();
				System.out.println(bean.getId());
				System.out.println(bean.getFirstName());
				System.out.println(bean.getLastName());
				System.out.println(bean.getLogin());
				System.out.println(bean.getPassword());
				System.out.println(bean.getDob());
				System.out.println(bean.getRoleId());
				System.out.println(bean.getUnSuccessfulLogin());
				System.out.println(bean.getGender());
				System.out.println(bean.getLastLogin());
				System.out.println(bean.getLock());
			}

		} catch (ApplicationException e) {
			e.printStackTrace();
		}}

	public static void testList() throws ApplicationException {
		UserBean bean = new UserBean();
		ArrayList list=new ArrayList();
		list = (ArrayList) model.list();
		
		Iterator it=list.iterator();
		while(it.hasNext()) {
			bean=(UserBean)it.next();
			System.out.println(bean.getId());
			System.out.println(bean.getFirstName());
			System.out.println(bean.getLastName());
			System.out.println(bean.getLogin());
			System.out.println(bean.getPassword());
			System.out.println(bean.getDob());
			System.out.println(bean.getRoleId());
			System.out.println(bean.getUnSuccessfulLogin());
			System.out.println(bean.getGender());
			System.out.println(bean.getLastLoginIP());
			System.out.println(bean.getLock());
		}
	}
	public static void testAuthenticate() throws ApplicationException {
		UserBean bean = new UserBean();
		bean.setLogin("Ankit@gmail.com");
		bean.setPassword("Ab@123");
		bean = model.authenticate(bean.getLogin(), bean.getPassword());
		if (bean != null) {
			System.out.println("Successful login");
		} else {
			System.out.println("login id is wrong ");
		}
	}
	 public static void testChangePassword() {

	        try {
	            UserBean bean = model.findByLogin("bhagat@gmail.com");
	            String oldPassword = bean.getPassword();
	            bean.setId(1);
	            bean.setPassword("786");
	            bean.setConfirmPassword("786");
	            String newPassword = bean.getPassword();
	            try {
                    model.changePassword(1L, oldPassword, newPassword);	            
	                System.out.println("password has been change successfully");
	            } catch (RecordNotFoundException e) {
	                e.printStackTrace();
	            }

	        } catch (ApplicationException e) {
	            e.printStackTrace();
	        }
	 }
	 public static void testRegisterUser() throws ParseException, RecordNotFoundException {
	        try {
	            UserBean bean = new UserBean();
	            SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");

	            // bean.setId(8L);
	            bean.setFirstName("vipin");
	            bean.setLastName("kumawat");
	            bean.setLogin("rranjitch11ou1dhay@gmail.com");
	            bean.setPassword("rr");
	            bean.setConfirmPassword("4444");
	            bean.setDob(sdf.parse("11/20/2015"));
	            bean.setGender("Male");
	            bean.setRoleId(2);
	            long pk = model.registerUser(bean);
	            System.out.println("Successfully register");
	            System.out.println(bean.getFirstName());
	            System.out.println(bean.getLogin());
	            System.out.println(bean.getLastName());
	            System.out.println(bean.getDob());
	            UserBean registerbean = model.findByPK(pk);
	            if (registerbean != null) {
	                System.out.println("Test registation fail");
	            }
	        } catch (ApplicationException e) {
	            e.printStackTrace();
	        } catch (DuplicateRecordException e) {
	            e.printStackTrace();
	        }
	    }
	   public static void testforgetPassword() {
	        try {
	            boolean b = model.forgetPassword("Radhe@gmail.com");

	            System.out.println("Suucess : Test Forget Password Success");

	        } catch (RecordNotFoundException e) {
	            e.printStackTrace();
	        } catch (ApplicationException e) {
	            e.printStackTrace();
	        }
	    }

	    
	    /**
	     * Tests resetPassword
	     * @throws RecordNotFoundException 
	     *
	     * @throws ParseException
	     */
	    public static void testresetPassword() throws RecordNotFoundException {
	        UserBean bean = new UserBean();
	        try {
	            bean = model.findByLogin("Radhe@gmail.com");
	            if (bean != null) {
	                boolean pass = model.resetPassword(bean);
	                if (pass = false) {
	                    System.out.println("Test Update fail");
	                }
	            }

	        } catch (ApplicationException e) {
	            e.printStackTrace();
	        }

	    }
	    private static void testGetRoles() throws ApplicationException {

			UserBean bean = new UserBean();
			List list = new ArrayList();
			bean.setRoleId(3);
			list = model.getRoles(bean);

			Iterator it = list.iterator();
			while (it.hasNext()) {
				bean = (UserBean) it.next();
				System.out.println(bean.getId());
				System.out.println(bean.getFirstName());
				System.out.println(bean.getLastName());
				System.out.println(bean.getLogin());
				System.out.println(bean.getPassword());
				System.out.println(bean.getDob());
				System.out.println(bean.getRoleId());
				System.out.println(bean.getUnSuccessfulLogin());
				System.out.println(bean.getGender());
				System.out.println(bean.getLastLogin());
				System.out.println(bean.getLock());
			}
		}
	 
	 }
	     
	    	  