/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.55
 * Generated at: 2023-01-07 11:42:20 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.JSP;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import in.co.rays.controller.proj4.TimeTableCtl;
import java.util.LinkedHashMap;
import in.co.rays.util.proj4.HTMLUtility;
import in.co.rays.util.proj4.ServletUtility;
import in.co.rays.util.proj4.DataUtility;
import in.co.rays.bean.proj4.TimeTableBean;
import java.util.List;
import in.co.rays.controller.proj4.LoginCtl;
import in.co.rays.bean.proj4.RoleBean;
import in.co.rays.controller.proj4.ORSView;
import in.co.rays.bean.proj4.RoleBean;
import in.co.rays.controller.proj4.LoginCtl;
import in.co.rays.bean.proj4.UserBean;
import in.co.rays.controller.proj4.ORSView;

public final class TimeTableView_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(2);
    _jspx_dependants.put("/JSP/Header.jsp", Long.valueOf(1673038452691L));
    _jspx_dependants.put("/JSP/Footer.jsp", Long.valueOf(1672052472982L));
  }

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = new java.util.HashSet<>();
    _jspx_imports_classes.add("java.util.LinkedHashMap");
    _jspx_imports_classes.add("in.co.rays.bean.proj4.UserBean");
    _jspx_imports_classes.add("in.co.rays.util.proj4.ServletUtility");
    _jspx_imports_classes.add("java.util.List");
    _jspx_imports_classes.add("in.co.rays.bean.proj4.TimeTableBean");
    _jspx_imports_classes.add("in.co.rays.controller.proj4.LoginCtl");
    _jspx_imports_classes.add("in.co.rays.controller.proj4.ORSView");
    _jspx_imports_classes.add("in.co.rays.util.proj4.HTMLUtility");
    _jspx_imports_classes.add("in.co.rays.util.proj4.DataUtility");
    _jspx_imports_classes.add("in.co.rays.controller.proj4.TimeTableCtl");
    _jspx_imports_classes.add("in.co.rays.bean.proj4.RoleBean");
  }

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
      throws java.io.IOException, javax.servlet.ServletException {

    if (!javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      final java.lang.String _jspx_method = request.getMethod();
      if ("OPTIONS".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        return;
      }
      if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSPs only permit GET, POST or HEAD. Jasper also permits OPTIONS");
        return;
      }
    }

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=ISO-8859-1");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=ISO-8859-1\">\r\n");
      out.write("<title>TimeTable</title>\r\n");
      out.write("\r\n");
      out.write("<script\r\n");
      out.write("	src=\"https://ajax.googleapis.com/ajax/libs/jquery/1.6/jquery.min.js\"\r\n");
      out.write("	type=\"text/javascript\"></script>\r\n");
      out.write("<script\r\n");
      out.write("	src=\"https://ajax.googleapis.com/ajax/libs/jqueryui/1.8/jquery-ui.min.js\"\r\n");
      out.write("	type=\"text/javascript\"></script>\r\n");
      out.write("<link\r\n");
      out.write("	href=\"https://ajax.googleapis.com/ajax/libs/jqueryui/1.8/themes/base/jquery-ui.css\"\r\n");
      out.write("	rel=\"Stylesheet\" type=\"text/css\" />\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<script>\r\n");
      out.write("	$(function() {\r\n");
      out.write("		$(\"#datepicker\").datepicker({\r\n");
      out.write("			changeMonth : true,\r\n");
      out.write("			changeYear : true,\r\n");
      out.write("			minDate : +1,\r\n");
      out.write("			maxDate : \"+1Y\",\r\n");
      out.write("		/* 	dateFormat : \"dd-mm-yy\", */\r\n");
      out.write("		});\r\n");
      out.write("	});\r\n");
      out.write("</script>\r\n");
      out.write("\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("	");
      in.co.rays.bean.proj4.TimeTableBean bean = null;
      bean = (in.co.rays.bean.proj4.TimeTableBean) _jspx_page_context.getAttribute("bean", javax.servlet.jsp.PageContext.REQUEST_SCOPE);
      if (bean == null){
        bean = new in.co.rays.bean.proj4.TimeTableBean();
        _jspx_page_context.setAttribute("bean", bean, javax.servlet.jsp.PageContext.REQUEST_SCOPE);
      }
      out.write("\r\n");
      out.write("\r\n");
      out.write("	<form action=\"");
      out.print(ORSView.TIMETABLE_CTL);
      out.write("\" method=\"post\">\r\n");
      out.write("\r\n");
      out.write("		");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta charset=\"ISO-8859-1\">\r\n");
      out.write("<title>Project-4</title>\r\n");
      out.write("</head>\r\n");
      out.write("<body >\r\n");
      out.write("	");

		UserBean userBean = (UserBean) session.getAttribute("user");

		boolean userLoggedIn = userBean != null;

		String welcomeMsg = "Hi, ";
		if (userLoggedIn) {
			String role = (String) session.getAttribute("role");
			welcomeMsg += userBean.getFirstName()+ "(" + role + ")";

		} else {
			welcomeMsg += "Guest";
		}
	
      out.write("\r\n");
      out.write("	<table style=\"background-color: white; width: 100%\">\r\n");
      out.write("		<tr>\r\n");
      out.write("			<td><b><a href=\"");
      out.print(ORSView.WELCOME_CTL);
      out.write("\">Welcome</a> </b>| ");

 	if (userLoggedIn) {
 
      out.write("<b><a\r\n");
      out.write("					href=\"");
      out.print(ORSView.LOGIN_CTL);
      out.write("?operation=");
      out.print(LoginCtl.OP_LOG_OUT);
      out.write("\">Logout</a></b>\r\n");
      out.write("\r\n");
      out.write("				");

					} else {
				
      out.write(" <b><a href=\"");
      out.print(ORSView.LOGIN_CTL);
      out.write("\">Login</a></b> ");

 	}
 
      out.write("</td>\r\n");
      out.write("\r\n");
      out.write("			<td rowspan=\"2\">\r\n");
      out.write("				<h1 align=\"right\">\r\n");
      out.write("					<img src=\"");
      out.print(ORSView.APP_CONTEXT);
      out.write("/img/logo.png\" width=\"250\"\r\n");
      out.write("						height=\"75\" >\r\n");
      out.write("				</h1>\r\n");
      out.write("			</td>\r\n");
      out.write("		</tr>\r\n");
      out.write("		<tr>\r\n");
      out.write("			<td>\r\n");
      out.write("				<h3>\r\n");
      out.write("					");
      out.print(welcomeMsg);
      out.write("</h3>\r\n");
      out.write("			</td>\r\n");
      out.write("		</tr>\r\n");
      out.write("\r\n");
      out.write("		");

			if (userLoggedIn) {
		
      out.write("\r\n");
      out.write("\r\n");
      out.write("		<tr >\r\n");
      out.write("			<td colspan=\"3\"><font style=\"font-size: 17px\"> <b><a\r\n");
      out.write("						href=\"");
      out.print(ORSView.MY_PROFILE_CTL);
      out.write("\">MyProfile</a></b>| <b><a\r\n");
      out.write("						href=\"");
      out.print(ORSView.CHANGE_PASSWORD_CTL);
      out.write("\">Change Password</a></b> | <b><a\r\n");
      out.write("						href=\"");
      out.print(ORSView.GET_MARKSHEET_CTL);
      out.write("\">Get Marksheet</a></b> | <b><a\r\n");
      out.write("						href=\"");
      out.print(ORSView.MARKSHEET_MERIT_LIST_CTL);
      out.write("\">Marksheet\r\n");
      out.write("							MeritList</a></b> | ");

 	if (userBean.getRoleId() == RoleBean.ADMIN) {
      out.write(" <b><a \r\n");
      out.write("                        href=\"");
      out.print(ORSView.MARKSHEET_CTL);
      out.write("\">Add Marksheet</a></b> |<b><a\r\n");
      out.write("						href=\"");
      out.print(ORSView.MARKSHEET_LIST_CTL);
      out.write("\">Marksheet List</a></b> |<b><a\r\n");
      out.write("						href=\"");
      out.print(ORSView.USER_CTL);
      out.write("\">Add User</a></b> | <b><a\r\n");
      out.write("						href=\"");
      out.print(ORSView.USER_LIST_CTL);
      out.write("\">User List</a></b> |<b><a\r\n");
      out.write("						href=\"");
      out.print(ORSView.COLLEGE_CTL);
      out.write("\">Add College</a></b> | <b><a\r\n");
      out.write("						href=\"");
      out.print(ORSView.COLLEGE_LIST_CTL);
      out.write("\">College List</a></b> |<b><a\r\n");
      out.write("						href=\"");
      out.print(ORSView.ROLE_CTL);
      out.write("\">Add Role</a></b> | <b><a\r\n");
      out.write("						href=\"");
      out.print(ORSView.ROLE_LIST_CTL);
      out.write("\">Role List</a></b> |<br> <b>\r\n");
      out.write("						<a href=\"");
      out.print(ORSView.STUDENT_CTL);
      out.write("\">Add Student</a>\r\n");
      out.write("				</b> | <b><a href=\"");
      out.print(ORSView.STUDENT_LIST_CTL);
      out.write("\">Student List</a></b> |<b>\r\n");
      out.write("						<a href=\"");
      out.print(ORSView.COURSE_CTL);
      out.write("\">Add Course</a>\r\n");
      out.write("				</b> | <b><a href=\"");
      out.print(ORSView.COURSE_LIST_CTL);
      out.write("\">Course List</a></b> |<b>\r\n");
      out.write("						<a href=\"");
      out.print(ORSView.SUBJECT_CTL);
      out.write("\">Add Subject</a>\r\n");
      out.write("				</b> | <b><a href=\"");
      out.print(ORSView.SUBJECT_LIST_CTL);
      out.write("\">Subject List</a></b> |<b>\r\n");
      out.write("						<a href=\"");
      out.print(ORSView.FACULTY_CTL);
      out.write("\">Add Faculty</a>\r\n");
      out.write("				</b> | <b><a href=\"");
      out.print(ORSView.FACULTY_LIST_CTL);
      out.write("\">Faculty List</a></b> |<b>\r\n");
      out.write("						<a href=\"");
      out.print(ORSView.TIMETABLE_CTL);
      out.write("\">Add TimeTable</a>\r\n");
      out.write("				</b> |<b> <a href=\"");
      out.print(ORSView.TIMETABLE_LIST_CTL);
      out.write("\">TimeTable\r\n");
      out.write("							List</a></b> |<b> <a target=\"blank\" href=\"");
      out.print(ORSView.JAVA_DOC_VIEW);
      out.write("\">Java\r\n");
      out.write("							Doc</a>\r\n");
      out.write("				</b> | ");

					}
				
      out.write(' ');

 	if (userBean.getRoleId() == RoleBean.STUDENT) {
 
      out.write(" <b><a href=\"");
      out.print(ORSView.COLLEGE_LIST_CTL);
      out.write("\">College List</a></b> |<b>\r\n");
      out.write("						<a href=\"");
      out.print(ORSView.STUDENT_LIST_CTL);
      out.write("\">Student List</a>\r\n");
      out.write("				</b> | <b><a href=\"");
      out.print(ORSView.COURSE_LIST_CTL);
      out.write("\">Course List</a></b> |<b>\r\n");
      out.write("						<a href=\"");
      out.print(ORSView.SUBJECT_LIST_CTL);
      out.write("\">Subject List</a>\r\n");
      out.write("				</b> |<b> <a href=\"");
      out.print(ORSView.FACULTY_LIST_CTL);
      out.write("\">Faculty List</a></b> |<b>\r\n");
      out.write("						<a href=\"");
      out.print(ORSView.TIMETABLE_LIST_CTL);
      out.write("\">TimeTable List</a>\r\n");
      out.write("				</b> | ");

					}
				
      out.write(' ');

 	if (userBean.getRoleId() == RoleBean.KIOSK) {
 
      out.write(" <b><a href=\"");
      out.print(ORSView.COLLEGE_LIST_CTL);
      out.write("\">College List</a></b> |<b>\r\n");
      out.write("						<a href=\"");
      out.print(ORSView.TIMETABLE_LIST_CTL);
      out.write("\">TimeTable List</a>\r\n");
      out.write("				</b> |<b> <a href=\"");
      out.print(ORSView.COURSE_LIST_CTL);
      out.write("\">Course List</a>\r\n");
      out.write("				</b>| ");

					}
				
      out.write(' ');

 	if (userBean.getRoleId() == RoleBean.FACULTY) {
 
      out.write(" <b><a href=\"");
      out.print(ORSView.MARKSHEET_CTL);
      out.write("\">Add Marksheet</a></b> |<b>\r\n");
      out.write("						<a href=\"");
      out.print(ORSView.MARKSHEET_LIST_CTL);
      out.write("\">Marksheet List</a></b> |\r\n");
      out.write("						<b> <a href=\"");
      out.print(ORSView.COLLEGE_LIST_CTL);
      out.write("\">College List</a></b> |\r\n");
      out.write("				<b><a href=\"");
      out.print(ORSView.STUDENT_CTL);
      out.write("\">Add Student</a></b> |\r\n");
      out.write("				 <b><a href=\"");
      out.print(ORSView.STUDENT_LIST_CTL);
      out.write("\">Student List</a></b> |\r\n");
      out.write("					<b><a href=\"");
      out.print(ORSView.COURSE_LIST_CTL);
      out.write("\">Course List</a></b> |\r\n");
      out.write("					 <b><a	href=\"");
      out.print(ORSView.SUBJECT_CTL);
      out.write("\">Add Subject</a></b> |\r\n");
      out.write("					  <b> <a href=\"");
      out.print(ORSView.SUBJECT_LIST_CTL);
      out.write("\">Subject List</a></b> |\r\n");
      out.write("					   <b><a href=\"");
      out.print(ORSView.TIMETABLE_CTL);
      out.write("\">Add TimeTable</a></b> |\r\n");
      out.write("					    <b><a href=\"");
      out.print(ORSView.TIMETABLE_LIST_CTL);
      out.write("\">TimeTable List</a></b> | ");
}
 
      out.write(' ');

 	if (userBean.getRoleId() == RoleBean.COLLEGE_SCHOOL) { 
      out.write(" <b><a\r\n");
      out.write("                         href=\"");
      out.print(ORSView.MARKSHEET_CTL);
      out.write("\">Add Marksheet</a></b> | <b><a\r\n");
      out.write("						href=\"");
      out.print(ORSView.MARKSHEET_LIST_CTL);
      out.write("\">Marksheet List</a></b> |<b>\r\n");
      out.write("						<a href=\"");
      out.print(ORSView.STUDENT_CTL);
      out.write("\">Add Student</a>\r\n");
      out.write("				</b> | <b><a href=\"");
      out.print(ORSView.STUDENT_LIST_CTL);
      out.write("\">Student List</a></b> |\r\n");
      out.write("					<b><a href=\"");
      out.print(ORSView.FACULTY_LIST_CTL);
      out.write("\">Faculty List</a></b> |<b>\r\n");
      out.write("						<a href=\"");
      out.print(ORSView.TIMETABLE_LIST_CTL);
      out.write("\">TimeTable List</a>\r\n");
      out.write("				</b> |<b> <a href=\"");
      out.print(ORSView.COURSE_LIST_CTL);
      out.write("\">Course List</a></b> | ");

 	}
 
      out.write("\r\n");
      out.write("			</font></td>\r\n");
      out.write("\r\n");
      out.write("		</tr>\r\n");
      out.write("		");

			}
		
      out.write("\r\n");
      out.write("		<tr>\r\n");
      out.write("			<td colspan=\"3\"><hr></td>\r\n");
      out.write("		</tr>\r\n");
      out.write("	</table>\r\n");
      out.write("\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
      out.write("\r\n");
      out.write("\r\n");
      out.write("		<center>\r\n");
      out.write("			");

				List<TimeTableBean> courseList = (List<TimeTableBean>) request.getAttribute("CourseList");
				List<TimeTableBean> subjectList = (List<TimeTableBean>) request.getAttribute("SubjectList");
			
      out.write("\r\n");
      out.write("\r\n");
      out.write("			<input type=\"hidden\" name=\"id\" value=\"");
      out.print(bean.getId());
      out.write("\"> <input\r\n");
      out.write("				type=\"hidden\" name=\"createdby\" value=\"");
      out.print(bean.getCreatedBy());
      out.write("\">\r\n");
      out.write("			<input type=\"hidden\" name=\"modifiedby\"\r\n");
      out.write("				value=\"");
      out.print(bean.getModifiedBy());
      out.write("\"> <input type=\"hidden\"\r\n");
      out.write("				name=\"createddatetime\"\r\n");
      out.write("				value=\"");
      out.print(DataUtility.getTimestamp(bean.getCreatedDatetime()));
      out.write("\">\r\n");
      out.write("			<input type=\"hidden\" name=\"modifiedby\"\r\n");
      out.write("				value=\"");
      out.print(DataUtility.getTimestamp(bean.getModifiedDatetime()));
      out.write("\">\r\n");
      out.write("\r\n");
      out.write("			<div align=\"center\">\r\n");
      out.write("				<h1>\r\n");
      out.write("					");

						if (bean != null && bean.getId() > 0) {
					
      out.write("\r\n");
      out.write("\r\n");
      out.write("					<tr>\r\n");
      out.write("						<th>Update TimeTable</th>\r\n");
      out.write("					</tr>\r\n");
      out.write("\r\n");
      out.write("					");

						} else {
					
      out.write("\r\n");
      out.write("\r\n");
      out.write("					<tr>\r\n");
      out.write("						<th>Add TimeTable</th>\r\n");
      out.write("					</tr>\r\n");
      out.write("					");

						}
					
      out.write("\r\n");
      out.write("				</h1>\r\n");
      out.write("\r\n");
      out.write("				<h3 align=\"center\">\r\n");
      out.write("					<font style=\"color: red\">");
      out.print(ServletUtility.getErrorMessage(request));
      out.write("</font>\r\n");
      out.write("				</h3>\r\n");
      out.write("				<h3 align=\"center\">\r\n");
      out.write("					<font style=\"color: green\">");
      out.print(ServletUtility.getSuccessMessage(request));
      out.write("</font>\r\n");
      out.write("				</h3>\r\n");
      out.write("			</div>\r\n");
      out.write("\r\n");
      out.write("			<table>\r\n");
      out.write("				<tr>\r\n");
      out.write("					<th align=\"left\">Course <span style=\"color: red\">*</span> :\r\n");
      out.write("					</th>\r\n");
      out.write("					<td>");
      out.print(HTMLUtility.getList("courseId", String.valueOf(bean.getCourseId()), courseList));
      out.write("</td>\r\n");
      out.write("					<td style=\"position: fixed;\"><font color=\"red\">");
      out.print(ServletUtility.getErrorMessage("courseId", request));
      out.write("</font>\r\n");
      out.write("					</td>\r\n");
      out.write("				</tr>\r\n");
      out.write("\r\n");
      out.write("				<tr>\r\n");
      out.write("					<th style=\"padding: 3px\"></th>\r\n");
      out.write("				</tr>\r\n");
      out.write("\r\n");
      out.write("				<tr>\r\n");
      out.write("					<th align=\"left\">Subject <span style=\"color: red\">*</span> :\r\n");
      out.write("					</th>\r\n");
      out.write("					<td>");
      out.print(HTMLUtility.getList("subjectId", String.valueOf(bean.getSubjectId()), subjectList));
      out.write("</td>\r\n");
      out.write("					<td style=\"position: fixed;\"><font color=\"red\">");
      out.print(ServletUtility.getErrorMessage("subjectId", request));
      out.write("</font>\r\n");
      out.write("					</td>\r\n");
      out.write("				</tr>\r\n");
      out.write("\r\n");
      out.write("				<tr>\r\n");
      out.write("					<th style=\"padding: 3px\"></th>\r\n");
      out.write("				</tr>\r\n");
      out.write("\r\n");
      out.write("				<tr>\r\n");
      out.write("					<th align=\"left\">Semester<span style=\"color: red\">*</span> :\r\n");
      out.write("					</th>\r\n");
      out.write("					<td>\r\n");
      out.write("						");

							LinkedHashMap<String, String> map = new LinkedHashMap<String, String>();
							map.put("1st", "1st");
							map.put("2nd", "2nd");
							map.put("3rd", "3rd");
							map.put("4th", "4th");
							map.put("5th", "5th");
							map.put("6th", "6th");
							map.put("7th", "7th");
							map.put("8th", "8th");

							String htmlList = HTMLUtility.getList("semester", bean.getSemester(), map);
						
      out.write(' ');
      out.print(htmlList);
      out.write("\r\n");
      out.write("					</td>\r\n");
      out.write("					<td style=\"position: fixed;\"><font color=\"red\">");
      out.print(ServletUtility.getErrorMessage("semester", request));
      out.write("</font>\r\n");
      out.write("					</td>\r\n");
      out.write("				</tr>\r\n");
      out.write("\r\n");
      out.write("				<tr>\r\n");
      out.write("					<th style=\"padding: 3px\"></th>\r\n");
      out.write("				</tr>\r\n");
      out.write("\r\n");
      out.write("				<tr>\r\n");
      out.write("					<th align=\"left\">Exam Date <span style=\"color: red\">*</span> :\r\n");
      out.write("					</th>\r\n");
      out.write("					<td><input type=\"text\" readonly=\"readonly\" id=\"datepicker\"\r\n");
      out.write("						style=\"width: 170px\" placeholder=\"Select Date\" name=\"ExDate\"\r\n");
      out.write("						value=\"");
      out.print(DataUtility.getDateString(bean.getExamDate()));
      out.write("\">\r\n");
      out.write("					<td style=\"position: fixed;\"><font color=\"red\">");
      out.print(ServletUtility.getErrorMessage("ExDate", request));
      out.write("</font>\r\n");
      out.write("					</td>\r\n");
      out.write("				</tr>\r\n");
      out.write("\r\n");
      out.write("				<tr>\r\n");
      out.write("					<th style=\"padding: 3px\"></th>\r\n");
      out.write("				</tr>\r\n");
      out.write("\r\n");
      out.write("				<tr>\r\n");
      out.write("					<th align=\"left\">Exam Time <span style=\"color: red\">*</span> :\r\n");
      out.write("					</th>\r\n");
      out.write("					<td>\r\n");
      out.write("						");

							LinkedHashMap<String, String> map1 = new LinkedHashMap<String, String>();
							map1.put("08:00 AM to 11:00 AM", "08:00 AM to 11:00 AM");
							map1.put("12:00 PM to 03:00 PM", "12:00 PM to 03:00 PM");
							map1.put("04:00 PM to 07:00 PM", "04:00 PM to 07:00 PM");

							String htmlList1 = HTMLUtility.getList("ExTime", bean.getExamTime(), map1);
						
      out.write(' ');
      out.print(htmlList1);
      out.write("\r\n");
      out.write("					</td>\r\n");
      out.write("					<td style=\"position: fixed;\"><font color=\"red\">");
      out.print(ServletUtility.getErrorMessage("ExTime", request));
      out.write("</font>\r\n");
      out.write("					</td>\r\n");
      out.write("				</tr>\r\n");
      out.write("\r\n");
      out.write("				");
      out.write("\r\n");
      out.write("\r\n");
      out.write("				<tr>\r\n");
      out.write("					<th style=\"padding: 3px\"></th>\r\n");
      out.write("					<td></td>\r\n");
      out.write("				</tr>\r\n");
      out.write("\r\n");
      out.write("				<tr>\r\n");
      out.write("					<th></th>\r\n");
      out.write("					<td></td>\r\n");
      out.write("				</tr>\r\n");
      out.write("\r\n");
      out.write("				<tr align=\"center\">\r\n");
      out.write("					");

						if (bean != null && bean.getId() > 0) {
					
      out.write("\r\n");
      out.write("					<td colspan=\"3\">&emsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;\r\n");
      out.write("						&nbsp; <input type=\"submit\" name=\"operation\"\r\n");
      out.write("						value=\"");
      out.print(TimeTableCtl.OP_UPDATE);
      out.write("\"> &nbsp; <input\r\n");
      out.write("						type=\"submit\" name=\"operation\" value=\"");
      out.print(TimeTableCtl.OP_CANCEL);
      out.write("\">\r\n");
      out.write("					</td>\r\n");
      out.write("					");

						} else {
					
      out.write("\r\n");
      out.write("\r\n");
      out.write("					<td colspan=\"3\">&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;\r\n");
      out.write("						&nbsp; <input type=\"submit\" name=\"operation\"\r\n");
      out.write("						value=\"");
      out.print(TimeTableCtl.OP_SAVE);
      out.write("\"> &nbsp; <input\r\n");
      out.write("						type=\"submit\" name=\"operation\" value=\"");
      out.print(TimeTableCtl.OP_RESET);
      out.write("\">\r\n");
      out.write("					</td>\r\n");
      out.write("					");

						}
					
      out.write("\r\n");
      out.write("				</tr>\r\n");
      out.write("			</table>\r\n");
      out.write("	</form>\r\n");
      out.write("	</center>\r\n");
      out.write("\r\n");
      out.write("	");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<style type=\"text/css\">\r\n");
      out.write(".footer{\r\n");
      out.write("position: fixed;\r\n");
      out.write("left: 0;\r\n");
      out.write("bottom: 0;\r\n");
      out.write("width: 100%;\r\n");
      out.write("background-color: white;\r\n");
      out.write("color: black;\r\n");
      out.write("text-align: center; \r\n");
      out.write("}\r\n");
      out.write("</style>\r\n");
      out.write("<meta http-equiv=\"Content-type\" content=\"text/html\"; charset=\"ISO-8859-1\">\r\n");
      out.write("<title>Footer</title>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\r\n");
      out.write("<div class=\"footer\">\r\n");
      out.write("<hr>\r\n");
      out.write("<CENTER>\r\n");
      out.write("<h2>&copy; copyrights RAYS Technologies</h2>\r\n");
      out.write("</CENTER>\r\n");
      out.write("</div>\r\n");
      out.write("\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
      out.write("\r\n");
      out.write("</body>\r\n");
      out.write("\r\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
