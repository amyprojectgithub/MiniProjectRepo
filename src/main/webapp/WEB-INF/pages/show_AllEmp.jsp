<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<style>
table {
  border-collapse: collapse;
  color: white;
}

table, td, th {
  border: 1px solid black;
}
</style>
<h2 style="color:green;text-align: center">  ${msg }  </h2>
<c:choose>
<c:when test="${!empty listDTO}">
<table align="center" border="1"  bgcolor="#40587C">
<tr bgcolor="#4052AB">
<th>Sr. No.</th>
<th>Emp No.</th>
<th>Emp Name</th>
<th>Job</th>
<th>Salary</th>
<th colspan="2">Operations</th>
</tr>
<c:forEach var="dto" items="${listDTO}">
<tr>
<td>${dto.srNo }</td>
<td>${dto.empNo }</td>
<td>${dto.empName }</td>
<td>${dto.job }</td>
<td>${dto.salary }</td>
<td><a href="edit.htm?eno=${dto.empNo}"><img src="images/empEdit.png" width="30" height="30"/></a></td>
<td><a href="delete.htm?eno=${dto.empNo}" onclick="confirm('Do you really want to delete?')"><img src="images/empDelete.png" width="30" height="30"/></a></td>
</tr>
</c:forEach>
</table>

</c:when>
<c:otherwise>
<h2 style="color: red;text-align: center">Employees Not Found</h2>
</c:otherwise>
</c:choose>
<br><br>
<div align="center">
<a href="welcome.htm"><img  src="images/home.jpg" width="30" height="30" ></a>
&nbsp;&nbsp;&nbsp;&nbsp;
<a href="register.htm"><img src="images/empAdd.png" width="30" height="30"/></a>
</div>