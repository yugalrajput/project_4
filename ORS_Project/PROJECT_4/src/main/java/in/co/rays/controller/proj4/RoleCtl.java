package in.co.rays.controller.proj4;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import in.co.rays.bean.proj4.BaseBean;
import in.co.rays.bean.proj4.RoleBean;
import in.co.rays.exception.proj4.ApplicationException;
import in.co.rays.exception.proj4.DuplicateRecordException;
import in.co.rays.model.proj4.RoleModel;
import in.co.rays.util.proj4.DataUtility;
import in.co.rays.util.proj4.DataValidator;
import in.co.rays.util.proj4.PropertyReader;
import in.co.rays.util.proj4.ServletUtility;

/**
 * @author Prashant Jha
 *
 */
@WebServlet(name = "RoleCtl", urlPatterns = { "/ctl/RoleCtl" })
public class RoleCtl extends BaseCtl {

	
	/**
	 * The Log.
	 */
	private static Logger log = Logger.getLogger(RoleCtl.class);

	@Override
	protected boolean validate(HttpServletRequest request) {

		log.debug("RoleCtl Method validate Started");

		boolean pass = true;

		if (DataValidator.isNull(request.getParameter("name"))) {
			request.setAttribute("name", PropertyReader.getValue("error.require", "Name"));
			pass = false;
		} else if (!DataValidator.isValidName(request.getParameter("name"))) {
			request.setAttribute("name", PropertyReader.getValue("error.name", "Invalid"));
			pass = false;
		}

		if (DataValidator.isNull(request.getParameter("description"))) {
			request.setAttribute("description", PropertyReader.getValue("error.require", "Description"));
			pass = false;
		}

		log.debug("RoleCtl Method validate Ended");

		return pass;
	}

	@Override
	protected BaseBean populateBean(HttpServletRequest request) {

		log.debug("RoleCtl method populateBean started");

		RoleBean bean = new RoleBean();
		bean.setId(DataUtility.getLong(request.getParameter("id")));
		bean.setName(DataUtility.getString(request.getParameter("name")));
		bean.setDescription(DataUtility.getString(request.getParameter("description")));

		populateDTO(bean, request);
		log.debug("RoleCtl method populateBean Ended");

		return bean;
	}

	/**
	 * Contain Display Logics.
	 *
	 * @param request
	 *            the request
	 * @param response
	 *            the response
	 * @throws ServletException
	 *             the servlet exception
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// System.out.println("in do get");

		String op = DataUtility.getString(request.getParameter("operation"));

		// get model
		RoleModel model = new RoleModel();

		long id = DataUtility.getLong(request.getParameter("id"));
		if (id > 0 || op != null) {
			RoleBean bean;
			try {
				bean = model.findByPK(id);
//				ServletUtility.setBean(bean, request);
			} catch (ApplicationException e) {
				log.error(e);
				ServletUtility.handleException(e, request, response);
				return;
			}
		}

		ServletUtility.forward(getView(), request, response);
		log.debug("RoleCtl method doGet Ended");
	}

	/**
	 * Contain Submit Logics.
	 *
	 * @param request
	 *            the request
	 * @param response
	 *            the response
	 * @throws ServletException
	 *             the servlet exception
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		log.debug("RoleCtl method doPost Started");
		 System.out.println("in do post");

		String op = DataUtility.getString(request.getParameter("operation"));

		// get model
		RoleModel model = new RoleModel();
		RoleBean bean = (RoleBean) populateBean(request);
		long id = DataUtility.getLong(request.getParameter("id"));

		if (OP_SAVE.equalsIgnoreCase(op) || OP_UPDATE.equalsIgnoreCase(op)) {
			try {
				if (id > 0) {
					model.update(bean);
					ServletUtility.setBean(bean, request);
					ServletUtility.setSuccessMessage("Role is Successfully Updated ", request);

				} else {
					try {
						long pk = model.add(bean);
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					ServletUtility.setBean(bean, request);
					ServletUtility.setSuccessMessage("Role is Successfully Added ", request);

				}

			} catch (ApplicationException e) {
				log.error(e);
				e.printStackTrace();
				ServletUtility.handleException(e, request, response);
				return;
			} catch (DuplicateRecordException e) {
//				ServletUtility.setBean(bean, request);
				ServletUtility.setErrorMessage("Role already exists", request);
			}

		} else if (OP_RESET.equalsIgnoreCase(op)) {

			ServletUtility.redirect(ORSView.ROLE_CTL, request, response);
			return;
		} else if (OP_CANCEL.equalsIgnoreCase(op)) {

			ServletUtility.redirect(ORSView.ROLE_LIST_CTL, request, response);
			return;
		}
//		ServletUtility.setBean(bean, request);
		ServletUtility.forward(getView(), request, response);
		log.debug("RoleCtl method doPost Ended");
	}

	@Override
	protected String getView() {

		return ORSView.ROLE_VIEW;
	}
}
