<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>${title}</title>
</head>
<body>

    <form method="post" action="">
        <c:set var="s" value="liferayID"/>
        <c:forEach items="${list}" var="item">
        	<p>${ item.getFirstName() } ${ item.getLastName() } ${ item.getEmail() }</p>
        	<a href="/SignUp/EditUser/${ item.getEmail() }">Edit</a>
        </c:forEach>
    </form>

</body>
</html>