<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c"  %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>LIST OF REGISTERED MEMBERS</title>
</head>
<body>
<form>

<p> LIST OF REGISTERED MEMBERS</p>


<c:forEach items="${listofpro}" var="prouserlist">
${prouserlist.empID}
${prouserlist.empName }
${prouserlist.deptCode }
${prouserlist.DOJ }
</c:forEach>


</form>

</body>
</html>
