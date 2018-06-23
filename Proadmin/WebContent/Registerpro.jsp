<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Admin Registration</title>
</head>
<body>
<form method="post" action="Registerform">
<p>Employee ID :<input name ="empID" type="text"/></p>
<p>empName :<input name ="empName" type="text"/></p>
<p>deptCode :<input name ="deptCode" type="text"/></p>
<p>DOJ :<input name ="DOJ" type="date"/></p>
<p>Password :<input name ="Password" type="password"/></p>
<p>ConfirmPassword :<input name ="ConfirmPassword" type="password"/></p>
<p><input type="submit" value="AddUser"/></p>
</form>
</body>
</html>