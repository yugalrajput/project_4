<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="in.co.rays.bean.proj4.RoleBean" %>
    <%@page import="in.co.rays.bean.proj4.UserBean" %>
    <%@page import="in.co.rays.controller.proj4.ORSView" %>


<!DOCTYPE html>
<head>
<meta charset="ISO-8859-1">
<title>Welcome</title>
</head>
<body>
<form action="<%=ORSView.WELCOME_CTL%>">
<%@include file="Header.jsp" %>
<h1 align="center">
<font size="10px" color="red">Welcome To ORS</font>
</h1>

<%
UserBean beanUserBean= (UserBean) session.getAttribute("user");
if(beanUserBean!=null){
	if(beanUserBean.getRoleId()== RoleBean.STUDENT){
%>
<h2 align="center">
<a href="<%=ORSView.GET_MARKSHEET_CTL%>">Click Here to see your Marksheet</a>
</h2>
<%

}
}
%>
</form>
<%@include file="Footer.jsp" %>
</body>
