<%@page import="in.co.rays.controller.proj4.RoleCtl"%>
<%@page import="in.co.rays.util.proj4.DataUtility"%>
<%@page import="in.co.rays.util.proj4.ServletUtility"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Role</title>
</head>
<body>
	<form action="<%=ORSView.ROLE_CTL%>" method="post">
		<%@ include file="Header.jsp"%>

		<jsp:useBean id="bean" class="in.co.rays.bean.proj4.RoleBean"
			scope="request"></jsp:useBean>

		<center>
			<h1>
				<%
					if (bean != null && bean.getId() > 0) {
				%>
				<tr>
					<th>Update Role</th>
				</tr>
				<%
					} else {
				%>
				<tr>
					<th>Add Role</th>
				</tr>
				<%
					}
				%>
			</h1>
			<div>
				<h3>
					<font style="color: green"><%=ServletUtility.getSuccessMessage(request)%>
					</font>
				</h3>

				<h3>
					<font style="color: red"><%=ServletUtility.getErrorMessage(request)%>
					</font>
				</h3>
			</div>

			<input type="hidden" name="id" value="<%=bean.getId()%>"> <input
				type="hidden" name="createdBy" value="<%=bean.getCreatedBy()%>">
			<input type="hidden" name="modifiedBy"
				value="<%=bean.getModifiedBy()%>"> <input type="hidden"
				name="createdDatetime"
				value="<%=DataUtility.getTimestamp(bean.getCreatedDatetime())%>">
			<input type="hidden" name="modifiedDatetime"
				value="<%=DataUtility.getTimestamp(bean.getModifiedDatetime())%>">


			<table>
				<tr>
					<th align="left">Name<span style="color: red">*</span> :
					</th>
					<td><input type="text" name="name"
						placeholder="Enter Role Name"
						value="<%=DataUtility.getStringData(bean.getName())%>"></td>
					<td style="position: fixed;"><font color="red"><%=ServletUtility.getErrorMessage("name", request)%></font>
					</td>

				</tr>
				<tr>
					<th style="padding: 3px"></th>
					<td></td>
				</tr>
				
				<tr>
					<th align="left">Description<span style="color: red">*</span>
						:
					</th>
					<td><input type="text" name="description"
						placeholder="Enter Description"
						value="<%=DataUtility.getStringData(bean.getDescription())%>"></td>
					<td style="position: fixed;"><font color="red"><%=ServletUtility.getErrorMessage("description", request)%></font>
					</td>

				</tr>
				<tr><th style="padding: 3px"></th><td></td></tr>
				<tr>
					<th></th>
					<%
						if (bean.getId() > 0) {
					%>
					<td>&nbsp; &emsp; <input type="submit" name="operation"
						value="<%=RoleCtl.OP_UPDATE%>"> &nbsp; &nbsp; <input
						type="submit" name="operation" value="<%=RoleCtl.OP_CANCEL%>">
					</td>
					<%
						} else {
					%>

					<td>&nbsp; &emsp; <input type="submit" name="operation"
						value="<%=RoleCtl.OP_SAVE%>"> &nbsp; &nbsp; <input
						type="submit" name="operation" value="<%= RoleCtl.OP_RESET%>">
					</td>
					<%
						}
					%>

				</tr>
			</table>
	</form>
	</center>
	<%@ include file="Footer.jsp"%>
</body>
</html>>