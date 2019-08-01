<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<h2>welcome <%= request.getSession().getAttribute("username")%></h2>
	<form action = "/logout" method="post">
		<input type="submit" value="Logout">
	</form>
	<form action="/addEmployee" method="post">
		<br><br>EmployeeCode: <input type="text" name="employeeCode" required/>
		<br><br>EmployeeName: <input type="text" name="employeeName" maxlength="100" required />
		<br><br>EmployeeLocation: <input type="textarea" name="employeeLoc" maxlength="500" required/>
		<br><br>EmployeeEmail: <input type="email" name="employeeEmail" required/>
		<br><br>EmployeeDOB: <input type="Date" name="employeeDOB" required/>
		<br><br><input type="submit"/>
	</form>
	
	<form action="home" method="post">
		<br><br>
		<input type="submit" value="Cancel"/>
	</form>
	

</body>
</html>