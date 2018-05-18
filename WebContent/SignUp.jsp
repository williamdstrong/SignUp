<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="css/Styles.css">

<title>${title}</title>
</head>
<body>

    <form id="form" method="post" action="" novalidate>
        <c:set var="s" value="liferayID"/>
        <c:forEach items="${list}" var="item">
        	<c:if  test="${ item.getName() ne 'liferayID' }">
        		<c:if test="${ item.getName() eq 'yearsAtCollege' }">
        			<label for="${item.getName()}">
        				<span>${item.getLabel()}</span>
	    				<input id="${item.getName()}" name="${item.getName()}" type="${item.getOptions()}" type="text" required min="0">
	    				<p class="${item.getName()} error"></p>
	    			</label>
	    		</c:if>
	    		<c:if test="${ item.getName() ne 'yearsAtCollege' }">
	            	<label for="${item.getName()}">
	            		<span>${item.getLabel()}</span>
			    		<input id="${item.getName()}" name="${item.getName()}" type="${item.getOptions()}" type="text" required>
		    			<p class="${item.getName()} error"></p>
	    			</label>
	    		</c:if>
	    	</c:if>
        </c:forEach>
        <input type="reset">
    	<input type="submit">
    </form>

	<script type="text/javascript" src="js/validation.js"></script>

</body>
</html>
