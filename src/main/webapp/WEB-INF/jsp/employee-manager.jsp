<%-- 
    Document   : employee-manager
    Created on : Apr 17, 2018, 6:04:15 PM
    Author     : Thuan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="cp" value="${pageContext.request.servletContext.contextPath}" scope="request" />
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="${cp}/plugin/bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <h1>Employee Manager</h1>

        <div id="div_list_employee">

        </div>
        <button id="btn_add_employee" class="btn btn-primary">Add new Employee</button>
        <script src="${cp}/js/jquery.min.js?ver=2.0" type="text/javascript"></script>
        <script src="${cp}/plugin/bootstrap/js/bootstrap.min.js" type="text/javascript" ></script>
        <script src="${cp}/js_custome/employee-manager.js?ver=1.0" type="text/javascript"></script>
        <script>
            jQuery(document).ready(function () {
                EmployeeManager.init();
            });
        </script>
    </body>
</html>
