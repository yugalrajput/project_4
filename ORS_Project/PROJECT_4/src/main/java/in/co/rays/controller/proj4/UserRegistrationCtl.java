package in.co.rays.controller.proj4;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.mchange.v2.codegen.bean.Property;

import in.co.rays.bean.proj4.BaseBean;
import in.co.rays.bean.proj4.RoleBean;
import in.co.rays.bean.proj4.UserBean;
import in.co.rays.exception.proj4.ApplicationException;
import in.co.rays.exception.proj4.DuplicateRecordException;
import in.co.rays.exception.proj4.RecordNotFoundException;
import in.co.rays.model.proj4.UserModel;
import in.co.rays.util.proj4.DataUtility;
import in.co.rays.util.proj4.DataValidator;
import in.co.rays.util.proj4.PropertyReader;
import in.co.rays.util.proj4.ServletUtility;

/**
 * User registration functionality Controller. Performs operation for User
 * Registration
 *
 * 
 * @version 1.0
 * @Copyright 
@author Prashant Jha
 */
@WebServlet(name = "UserRegistrationCtl", urlPatterns = { "/UserRegistrationCtl" })
public class UserRegistrationCtl extends BaseCtl {

	/** The constant OP_SIGN_UP */
	public static final String OP_SIGN_UP = "SignUp";

	/** The log. */
	private static Logger log = Logger.getLogger(UserRegistrationCtl.class);

	@Override
	protected boolean validate(HttpServletRequest request) {

		log.debug("UserRegistrationCtl Method validate Started");

		boolean pass = true;

		String login = request.getParameter("login");
		String dob = request.getParameter("dob");

		if (DataValidator.isNull(request.getParameter("firstName"))) {
			request.setAttribute("firstName", PropertyReader.getValue("error.require", "First Name"));
			pass = false;
		} else if (!DataValidator.isValidName(request.getParameter("firstName"))) {
			request.setAttribute("firstName", PropertyReader.getValue("error.name", "Invalid First"));
			pass = false;
		}

		if (DataValidator.isNull(request.getParameter("lastName"))) {
			request.setAttribute("lastName", PropertyReader.getValue("error.require", "Last Name"));
			pass = false;
		} else if (!DataValidator.isValidName(request.getParameter("lastName"))) {
			request.setAttribute("lastName", PropertyReader.getValue("error.name", "Invlid Last"));
			pass = false;
		}

		if (DataValidator.isNull(login)) {
			request.setAttribute("login", PropertyReader.getValue("error.require", "Login Id"));
			pass = false;
		} else if (!DataValidator.isEmail(login)) {
			request.setAttribute("login", PropertyReader.getValue("error.email", "Invalid "));
			pass = false;
		}

		if (DataValidator.isNull(request.getParameter("mobileNo"))) {
			request.setAttribute("mobileNo", PropertyReader.getValue("error.require", "Mobile No"));
			pass = false;
		} else if (!DataValidator.isMobileNo(request.getParameter("mobileNo"))) {
			request.setAttribute("mobileNo", "Mobile No. contain 10 Digits & Series start with 6-9");
			pass = false;
		}

		if (DataValidator.isNull(request.getParameter("password"))) {
			request.setAttribute("password", PropertyReader.getValue("error.require", "Password"));
			pass = false;
		} else if (!DataValidator.isPassword(request.getParameter("password"))) {
			request.setAttribute("password", "Password contain 8 letters with alpha-numeric & special Character");
			pass = false;
		}
		if (DataValidator.isNull(request.getParameter("confirmPassword"))) {
			request.setAttribute("confirmPassword", PropertyReader.getValue("error.require", "Confirm Password"));
			pass = false;
		}

		if (DataValidator.isNull(request.getParameter("gender"))) {
			request.setAttribute("gender", PropertyReader.getValue("error.require", "Gender"));
			pass = false;
		}

		if (DataValidator.isNull(dob)) {
			request.setAttribute("dob", PropertyReader.getValue("error.require", "Date Of Birth"));
			pass = false;
		} else if (!DataValidator.isvalidateAge(dob)) {
			request.setAttribute("dob", PropertyReader.getValue("error.require", "Minimum Age 18 year"));
			pass = false;
		}

		if (!request.getParameter("password").equals(request.getParameter("confirmPassword"))
				&& !"".equals(request.getParameter("confirmPassword"))) {
			request.setAttribute("confirmPassword",
					PropertyReader.getValue("error.require", "Password and Confirm Password Same"));
			pass = false;
		}
		log.debug("UserRegistrationCtl Method validate Ended");

		return pass;
	}

	@Override
	protected BaseBean populateBean(HttpServletRequest request) {

		log.debug("UserRegistrationCtl Method populatebean Started");

		System.out.println("UserRegistrationCtl Method populateBean 1");

		UserBean bean = new UserBean();

		bean.setRoleId(RoleBean.STUDENT);

		bean.setId(DataUtility.getLong(request.getParameter("id")));
		bean.setFirstName(DataUtility.getString(request.getParameter("firstName")));
		bean.setLastName(DataUtility.getString(request.getParameter("lastName")));
		bean.setLogin(DataUtility.getString(request.getParameter("login")));
		bean.setPassword(DataUtility.getString(request.getParameter("password")));
		bean.setConfirmPassword(DataUtility.getString(request.getParameter("confirmPassword")));
		bean.setGender(DataUtility.getString(request.getParameter("gender")));
		bean.setDob(DataUtility.getDate(request.getParameter("dob")));
		bean.setMobileNo(DataUtility.getString(request.getParameter("mobileNo")));

		populateDTO(bean, request);

		System.out.println("UserRegistrationCtl Method populateBean 2");

		log.debug("UserRegistrationCtl Method populatebean Ended");
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
		log.debug("UserRegistrationCtl Method doGet Started");

		System.out.println("UserRegistrationCtl Method doGet 1");

		ServletUtility.forward(getView(), request, response);

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
		log.debug("UserRegistrationCtl Method doPost Started");

		System.out.println("UserRegistrationCtl Method doPost 1");

		String op = DataUtility.getString(request.getParameter("operation"));

		// get model
		UserModel model = new UserModel();

		if (OP_SIGN_UP.equalsIgnoreCase(op)) {
			UserBean bean = (UserBean) populateBean(request);
			try {
				long pk = model.registerUser(bean);


				ServletUtility.setSuccessMessage("User Successfully Register", request);
				ServletUtility.forward(getView(), request, response);
				return;
			} catch (ApplicationException e) {

				log.error(e);
				ServletUtility.handleException(e, request, response);
				return;
			} catch (DuplicateRecordException e) {
				 log.error(e);
				ServletUtility.setBean(bean, request);
				ServletUtility.setErrorMessage("Login Id Already Exists", request);
				ServletUtility.forward(getView(), request, response);
			} catch (RecordNotFoundException e) {

				e.printStackTrace();
			}

		} else if (OP_RESET.equalsIgnoreCase(op)) {
			ServletUtility.redirect(ORSView.USER_REGISTRATION_CTL, request, response);
		}

		System.out.println("UserRegistrationCtl Method doPost 2");

		log.debug("UserRegistrationCtl Method doPost Ended");
	}

	@Override
	protected String getView() {
		return ORSView.USER_REGISTRATION_VIEW;
	}

}