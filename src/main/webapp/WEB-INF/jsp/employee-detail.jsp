<%-- 
    Document   : index
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
        <h1>Employee Detail</h1>

        <div>
            <div class="form-body">
                <div class="row">
                    <div class="col-md-12">
                        <div class="form-group">
                            <label class="control-label col-md-2">Name</label>
                            <div class="col-md-6">
                                <label id="txt_name"></label>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col-md-12">
                        <div class="form-group">
                            <label class="control-label col-md-2">Age</label>
                            <div class="col-md-6">
                                <label id="txt_age"></label>
                            </div>
                        </div>
                    </div>

                </div>
                <div class="row">
                    <div class="col-md-6">
                        <div class="form-group">
                            <label class="control-label col-md-4">Dept</label>
                            <div class="col-md-6">
                                <label id="txt_dept"></label>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col-md-6">
                        <div class="form-group">
                            <label class="control-label col-md-4">Salary</label>
                            <div class="col-md-6">
                                <label id="txt_salary"></label>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <script src="${cp}/js/jquery.min.js?ver=2.0" type="text/javascript"></script>
        <script src="${cp}/plugin/bootstrap/js/bootstrap.min.js" type="text/javascript" ></script>
        <script src="${cp}/js_custome/employee-detail.js?ver=1.0" type="text/javascript"></script>
        <script>
            jQuery(document).ready(function () {
                EmployeeDetail.init();
            });
        </script>
    </body>
</html>
