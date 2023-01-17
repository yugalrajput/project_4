package in.co.rays.controller.proj4;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import in.co.rays.bean.proj4.BaseBean;
import in.co.rays.bean.proj4.CourseBean;
import in.co.rays.exception.proj4.ApplicationException;
import in.co.rays.exception.proj4.DuplicateRecordException;
import in.co.rays.model.proj4.CourseModel;
import in.co.rays.util.proj4.DataUtility;
import in.co.rays.util.proj4.DataValidator;
import in.co.rays.util.proj4.PropertyReader;
import in.co.rays.util.proj4.ServletUtility;

/**
 * Servlet implementation class CourseCtl.
 */
/**
 * @author Prashant Jha
 *
 */
@WebServlet(name="CourseCtl", urlPatterns={"/ctl/CourseCtl"})
public class CourseCtl extends BaseCtl {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	

	/** The log. */
	private static Logger log = Logger.getLogger(CourseCtl.class);

	
	@Override
	protected boolean validate(HttpServletRequest request) {
		log.debug("CourseCtl validate started");
		boolean pass = true;

		if (DataValidator.isNull(request.getParameter("name"))) {
			request.setAttribute("name", PropertyReader.getValue("error.require", "Course Name"));
			 pass = false ;
		}else if (!DataValidator.isName(request.getParameter("name"))) {
			request.setAttribute("name", PropertyReader.getValue("error.name", "Invalid Course"));
			 pass = false ;
		}
		if (DataValidator.isNull(request.getParameter("duration"))) {
			request.setAttribute("duration", PropertyReader.getValue("error.require", "Duration"));
			pass = false ;
		}
		if (DataValidator.isNull(request.getParameter("description"))) {
			request.setAttribute("description", PropertyReader.getValue("error.require", "Description"));
			pass = false ;
		}

		log.debug("CourseCtl validate End");
		return pass;
	}

	
	@Override
	protected BaseBean populateBean(HttpServletRequest request){
		log.debug("CourseCtl PopulatedBean started");
		CourseBean bean = new CourseBean();
		
		bean.setId(DataUtility.getLong(request.getParameter("id")));
		bean.setName(DataUtility.getString(request.getParameter("name")));
		//System.out.println("duration "+request.getParameter("duration"));
		//bean.setDuration(DataUtility.getString(request.getParameter("duration")));
		bean.setDescription(DataUtility.getString(request.getParameter("description")));
	
		populateDTO(bean, request);
		log.debug("CourseCtl PopulatedBean End");
		return bean;
	}
	
	
	/**
	 * Contain Display Logics.
	 *
	 * @param request the request
	 * @param response the response
	 * @throws ServletException the servlet exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		log.debug("Do get method od courseCtl started");
		String op = DataUtility.getString(request.getParameter("operation"));
		
		// get Model
		CourseModel model = new CourseModel();
		long id = DataUtility.getLong(request.getParameter("id"));
		
		if(id>0){
			CourseBean bean;
			try{
			bean = model.findByPk(id);
			ServletUtility.setBean(bean, request);
			
			}catch(ApplicationException e){
				//log.error(e);
				ServletUtility.handleException(e, request, response);
				return;
			}
		}
		ServletUtility.forward(getView(), request, response);
	}
    
	
	/**
	 * Contain submit Logics.
	 *
	 * @param request the request
	 * @param response the response
	 * @throws ServletException the servlet exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		log.debug("Do Post method of CourseCtl started ");
		String op = DataUtility.getString(request.getParameter("operation"));
		
		// Get Model
		CourseModel model = new CourseModel();
		long id = DataUtility.getLong(request.getParameter("id"));
	
		if(OP_SAVE.equalsIgnoreCase(op) || OP_UPDATE.equalsIgnoreCase(op)){
			CourseBean bean =(CourseBean) populateBean(request);
		try{
			if(id>0){		
				//System.out.println("in course update.......");
					model.update(bean);
					ServletUtility.setBean(bean, request);
					ServletUtility.setSuccessMessage("Course is Successfully Updated", request);
				
			}else{
				//System.out.println("in course addd.......");
				 long pk = model.add(bean);
				 ServletUtility.setBean(bean, request);
					ServletUtility.setSuccessMessage("Course is Successfully Added", request);
				

			}
				ServletUtility.setBean(bean, request);
		
		
		}catch(ApplicationException e ){
			e.printStackTrace();
			log.error(e);
			ServletUtility.handleException(e, request, response);
			return;
		} catch (DuplicateRecordException e) {
			ServletUtility.setBean(bean, request);
			ServletUtility.setErrorMessage("Course Name Already Exist", request);
			
		}		
		}
		else if (OP_CANCEL.equalsIgnoreCase(op)) {
			ServletUtility.redirect(ORSView.COURSE_LIST_CTL, request, response);
			return;
		}
		else if (OP_RESET.equalsIgnoreCase(op)) {
			ServletUtility.redirect(ORSView.COURSE_CTL, request, response);
			return;
		}
		ServletUtility.forward(getView(), request, response);
		log.debug("Do Post method CourseCtl Ended");
	
	}

	
	@Override
	protected String getView() {
		return ORSView.COURSE_VIEW;
	}

}
