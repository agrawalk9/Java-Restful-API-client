
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
	<style type="text/css">
		.class1{
			margin-left:600px;
			display:inline-block;
		}
	</style>
</head>
<body>

<div class="class1">Welcome <%= request.getSession().getAttribute("username")%>
	<form action = "logout" method="post">
		<input type="submit" value="Logout">
	</form>
</div>

<form action = "/addEmployee" method="get" style=" margin-left:800px">
	<input type="submit" value="Upload Employee Details">
</form>

<br><br>
<table>
		<thead>
			<td>SR.No</td>
			<td>EmployeeCode</td>
			<td>EmployeeName</td>
			<td>EmployeeLocation</td>
			<td>EmployeeEmail</td>
			<td>EmployeeDOB</td>
			<td>Action</td>
		</thead>
		<tbody>
			<c:forEach var="employee" items="${employeeList}" varStatus="counter">
			<tr>
				<td><c:out value="${counter.count}"></c:out></td>
				<td><c:out value="${employee.employeeCode}"></c:out></td>
				<td><c:out value="${employee.employeeName}"></c:out></td>
				<td><c:out value="${employee.employeeLoc}"></c:out></td>
				<td><c:out value="${employee.employeeEmail}"></c:out></td>
				<td><c:out value="${employee.employeeDOB}"></c:out></td>
				<td>
				<form action="/updateEmployee">
					<input type="hidden" name="employeeCode" value="<c:out value="${employee.employeeCode}"/>" />
					<input type="hidden" name="employeeName" value="<c:out value="${employee.employeeName}"/>" />
					<input type="hidden" name="employeeEmail" value="<c:out value="${employee.employeeEmail}"/>" />
					<input type="hidden" name="employeeLoc" value="<c:out value="${employee.employeeLoc}"/>" />
					<input type="hidden" name="employeeDOB" value="<c:out value="${employee.employeeDOB}"/>" />
					<input type="submit" value="edit"/>
				</form>
				</td>		
			</tr>
			</c:forEach>
		</tbody>
	</table>

</body>
</html>