<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>ERROR 404</title>
        <link rel="stylesheet" href="${path}/static/css/emp-style.css">
        <link rel="stylesheet" href="${path}/static/css/homepage-css.css">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
              integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <title>Manage Road Page</title>
    </head>
    <body>
        <%@include file="../../misc/navbars/newjsp.jsp" %>
        <section class="main-container">
            <div class="content">
                <div class="form sign-in">
                    <c:choose>
                        <c:when test="${road.id != null}">
                            <h1 class="text-center">Update Road</h1>
                        </c:when>
                        <c:otherwise>
                            <h1 class="text-center">Add Road</h1>
                        </c:otherwise>
                    </c:choose>

                    <form:form 
                        action="${pageContext.request.contextPath}/admin/manage-road/create" 
                        method="POST"
                        modelAttribute="road">
                        <form:hidden path="id"/>
                        <label for="roadName">Station Name</label>
                        <form:input path="roadName" class="form-control" placeholder="Road Name"/>
                        <form:errors path="roadName" cssClass="error"/>
                        <br/>
                        <button type="submit" class="submit submit-button">Submit</button>
                    </form:form>
                    <br/>
                    <p  class="text-center">
                      <a href ="${pageContext.request.contextPath}/admin/manage-road/list">Return to list</a>  
                    </p>
                    
                </div>
            </div>
            <div class="sub-content">
                <div class="side-shadow">
                    <div class="img-text">
                        <h2>ATC</h2>
                        <p>Awesome Toll Company</p>
                    </div>
                </div>
            </div>
        </section>
        <footer>
            footer
        </footer>
    </body>
</html>
