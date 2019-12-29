<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Access Denied</title>
    </head>
    <body>
        <h1>This page is forbidden</h1>
        <h3>This is Spring Security baby!!!</h3>
        <a href="${pageContext.request.contextPath}/">Home Page</a>
    </body>
</html>
