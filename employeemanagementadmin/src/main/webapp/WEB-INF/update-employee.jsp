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
	
	<form action = "logout" method="post">
		<input type="submit" value="Logout">
	</form>
	
	<form action="/updateEmployee" method="post">
		<br>Code:<input type="text" name="employeeCode" readOnly="readonly" value="<%=request.getParameter("employeeCode")%>"/>
		<br>Name <input type="text" name="employeeName" value="<%=request.getParameter("employeeName")%>" maxlength="100" required />
		<br>Location: <input type="text" name="employeeLoc" value="<%=request.getParameter("employeeLoc")%>" maxlength="500" required/>
		<br>Email: <input type="email" name="employeeEmail" value="<%=request.getParameter("employeeEmail")%>" required/>
		<br>DOB: <input type="Date" name="employeeDOB" value="<%=request.getParameter("employeeDOB")%>" required/>
		<br><input type="submit" value="Update"/>
	</form>

	

</body>
</html>