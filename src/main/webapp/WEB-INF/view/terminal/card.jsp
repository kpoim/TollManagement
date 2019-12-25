<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <c:choose>
            <c:when test="${history == null}">
                <h2>Welcome to the highway!!</h2>
            </c:when>
            <c:otherwise>
                <h2>Hope you enjoyed!!</h2>
            </c:otherwise>
        </c:choose>
        
    </body>
</html>
