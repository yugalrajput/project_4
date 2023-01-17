<%@page import="in.co.rays.util.proj4.DataUtility"%>
<%@page import="in.co.rays.util.proj4.ServletUtility"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>

</head>
<body>

	<form action="<%=ORSView.LOGIN_CTL%>" method="post">
		<%@ include file="Header.jsp"%>

		<jsp:useBean id="bean" class="in.co.rays.bean.proj4.UserBean"
			scope="request"></jsp:useBean>

		<center>
			<h1>Login</h1>

			<H2>
				<font color="red"> <%=ServletUtility.getErrorMessage(request)%></font>
				<font color="green"><%=ServletUtility.getSuccessMessage(request)%></font>
			</H2>

			<h1>
				<font color="red"> <%=ServletUtility.getErrorMessage("message", request)%></font>
			</h1>


			<input type="hidden" name="id" value="<%=bean.getId()%>">
			 <input type="hidden" name="createdBy" value="<%=bean.getCreatedBy()%>">
			<input type="hidden" name="modifiedBy" value="<%=bean.getModifiedBy()%>"> 
			<input type="hidden" name="createdDatetime" value="<%=DataUtility.getTimestamp(bean.getCreatedDatetime())%>">
			<input type="hidden" name="modifiedDatetime" value="<%=DataUtility.getTimestamp(bean.getModifiedDatetime())%>">

			<table>
				<tr>
					<th align="left">Login Id <span style="color: red">*</span> :
					</th>
					<td><input type="text" name="login" size=25 placeholder="Enter Email Id" value="<%=DataUtility.getStringData(bean.getLogin())%>"></td>
						
					<td style="position: fixed;">
					<font color="red"> <%=ServletUtility.getErrorMessage("login", request)%></font></td>
				</tr>

				<tr>
					<th style="padding: 3px"></th>
					<td></td>
				</tr>
				<tr>
					<th align="left">Password<span style="color: red">*</span> :
					</th>
					<td>
					<input type="password" name="password" size=25 placeholder="Enter Password" value="<%=DataUtility.getStringData(bean.getPassword())%>">
					</td>
					
					<td style="position: fixed;">
					<font color="red"> <%=ServletUtility.getErrorMessage("password", request)%></font>
					</td>

				</tr>
				<tr>
					<th style="padding: 3px"></th>
					<td></td>
				</tr>
				<tr>
					<th></th>
					<td colspan="2"><input type="submit" name="operation" value="<%=LoginCtl.OP_SIGN_IN%>"> 
					&nbsp;
					
						 <input type="submit" name="operation" value="<%=LoginCtl.OP_SIGN_UP%>">
						  &nbsp;
						  
						  </td>
				</tr>
				<tr>
					<th></th>
					<td><a href="<%=ORSView.FORGET_PASSWORD_CTL%>"><b>Forget my password</b></a></td>
				</tr>
			</table>
		</center>
		<%@ include file="Footer.jsp"%>
	</form>

</body>
</html>