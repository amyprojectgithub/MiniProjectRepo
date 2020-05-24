<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<style> 
table {
	border-collapse: collapse;
}

table, td, th {
	border: 1px solid black;
}
</style>

<h2 style="color: green; text-align: center">:::::::::Update	Employee Form Page:::::::::</h2>
<form:form modelAttribute="empCmd">
	<table align="center" border="1" bgcolor="cyan">
		<tr>
			<td>Employee No.</td>
			<td><form:input path="empNo" readonly="true" /></td>
		</tr>
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
			<td colspan="2"><input type="submit" value="update"></td>
		</tr>
		
	</table>
</form:form>