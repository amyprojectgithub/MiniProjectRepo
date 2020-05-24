<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    <%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
    <h2 style="color: green; text-align: center">:::::::::Employee Registration Form Page:::::::::</h2>
    <form:form modelAttribute="empCmd">
	<table align="center" border="1" bgcolor="cyan">
	
	
		<tr>
			<td>Employee Name</td>
			<td><form:input path="empName" /></td>
		</tr>
		<tr>
			<td>Designation</td>
			<td><form:input path="job" /></td>
		</tr>

		<tr>
			<td>Salary</td>
			<td><form:input path="salary" /></td>
		</tr>
		<tr>
			<td ><input type="submit" value="register"></td>
			<td ><input type="reset" value="clear"></td>
		</tr>
		
	</table>
</form:form>
