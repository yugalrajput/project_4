package in.co.rays.test.proj4;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import in.co.rays.bean.proj4.RoleBean;
import in.co.rays.exception.proj4.ApplicationException;
import in.co.rays.exception.proj4.DuplicateRecordException;
import in.co.rays.model.proj4.RoleModel;

/**
 * @author Prashant Jha
 *
 */
public class TestRoleModel {

	public static void main(String[] args) throws Exception {

//		testAdd();
//		 testDelete();
//		testUpdate();
//		 testFindByPK();
//		 testFindByName();
//		 testSearch();
		testList();
	}

	public static void testAdd() throws Exception {
		try {
			RoleBean bean = new RoleBean();
			RoleModel model = new RoleModel();

			bean.setName("navneet");
			bean.setDescription("student");
			bean.setCreatedBy("min");
			bean.setModifiedBy("min");
			bean.setCreatedDatetime(new Timestamp(new Date().getTime()));
			bean.setModifiedDatetime(new Timestamp(new Date().getTime()));

			long pk = model.add(bean);
			System.out.println("Model Add success");

			RoleBean addedbean = model.findByPK(pk);
			if (addedbean == null) {
				System.out.println("Test add fail");
			}
		} catch (ApplicationException e) {
			e.printStackTrace();
		} catch (DuplicateRecordException e) {
			e.printStackTrace();
		}
	}

	public static void testDelete() {

		try {
			RoleBean bean = new RoleBean();
			RoleModel model = new RoleModel();
			long pk = 1L;
			bean.setId(pk);
			model.delete(bean);
			RoleBean deletedbean = model.findByPK(1);
			System.out.println("model delete success");

			if (deletedbean != null) {
				System.out.println("Test Delete fail");
			}
		} catch (ApplicationException e) {
			e.printStackTrace();
		}
	}

	public static void testUpdate() {

		try {
			RoleModel model = new RoleModel();
			RoleBean bean = model.findByPK(1);
			bean.setName("anshu");
			bean.setDescription("damage");

			model.update(bean);

			RoleBean updatedbean = model.findByPK(1L);

			if (!"12".equals(updatedbean.getName())) {
				System.out.println("Test Update success");
			}
		} catch (ApplicationException e) {
			e.printStackTrace();
		} catch (DuplicateRecordException e) {
			e.printStackTrace();
		}
	}

	public static void testFindByPK() {
		try {
			RoleBean bean = new RoleBean();
			RoleModel model = new RoleModel();
			long pk = 1L;
			bean = model.findByPK(pk);
			if (bean == null) {
				System.out.println("Test Find By PK fail");
			}
			System.out.println(bean.getId());
			System.out.println(bean.getName());
			System.out.println(bean.getDescription());
		} catch (ApplicationException e) {
			e.printStackTrace();
		}
	}

	public static void testFindByName() {
		try {
			RoleBean bean = new RoleBean();
			RoleModel model = new RoleModel();

			bean = model.findByName("navneet");
			if (bean == null) {
				System.out.println("Test Find By PK fail");
			}
			System.out.println(bean.getId());
			System.out.println(bean.getName());
			System.out.println(bean.getDescription());
		} catch (ApplicationException e) {
			e.printStackTrace();
		}
	}

	public static void testSearch() {

		try {
			RoleModel model = new RoleModel();

			RoleBean bean = new RoleBean();
			List list = new ArrayList();
			bean.setName("anshu");
			list = model.search(bean, 0, 0);
			if (list.size() < 0) {
				System.out.println("Test Serach fail");
			}
			Iterator it = list.iterator();
			while (it.hasNext()) {
				bean = (RoleBean) it.next();
				System.out.println(bean.getId());
				System.out.println(bean.getName());
				System.out.println(bean.getDescription());
			}

		} catch (ApplicationException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Tests get List.
	 */
	public static void testList() {

		try {
			RoleModel model = new RoleModel();
			RoleBean bean = new RoleBean();
			List list = new ArrayList();
			list = model.list(1, 10);
			if (list.size() < 0) {
				System.out.println("Test list fail");
			}
			Iterator it = list.iterator();
			while (it.hasNext()) {
				bean = (RoleBean) it.next();
				System.out.println(bean.getId());
				System.out.println(bean.getName());
				System.out.println(bean.getDescription());
			}

		} catch (ApplicationException e) {
			e.printStackTrace();
		}
	}
}
