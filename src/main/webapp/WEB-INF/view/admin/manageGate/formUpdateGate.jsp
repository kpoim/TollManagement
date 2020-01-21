<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

        <title>ERROR 404</title>
        <link rel="stylesheet" href="${path}/static/css/emp-style.css">
        <link rel="stylesheet" href="${path}/static/css/homepage-css.css">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
              integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        
        <title>Update Gate Page</title>
    </head>
    <body>
        <%@include file="../../misc/navbars/nav-admin.jsp" %>
        <section class="main-container">
            <div class="content">
                <div class="form sign-in">
                        <h1 class="text-center">Update Gate</h1>
                        <form:form 
                            action="${pageContext.request.contextPath}/admin/manage-gate/update" 
                            method="POST"
                            modelAttribute="gate">
                            <label for="gateid">Gate ID</label>
                            <form:input path="id" class="form-control" readonly="true" />
                            <br/>
                            <label for="gateNo">Gate Number</label>
                            <form:input path="gateNo" class="form-control" placeholder="Gate number"/>
                            <form:errors path="gateNo" cssClass="error"/>
                            <br/>
                            <label for="stationid">Station ID</label>
                            <form:select path="station.id">
                            <c:forEach items="${listOfStation}" var="s">
                                <form:option value="${s.id}">${s.id} - ${s.stationName}</form:option>
                            </c:forEach>
                        </form:select>
                            <br/>
                            <label for="isEntry">Entry/Exit</label>
                            <form:input path="isEntry" class="form-control"/>
                            <form:errors path="isEntry" cssClass="error"/>
                            <br/>
                            <button type="submit" class="submit submit-button">Update</button>
                        </form:form>
                        <p class="text-center">
                            <a href ="${pageContext.request.contextPath}/admin/manage-gate/list">Return to list</a>
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
