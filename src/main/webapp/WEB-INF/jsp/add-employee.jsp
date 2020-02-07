<%-- 
    Document   : add-employee
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
        <title>Add Employee</title>
        <link href="${cp}/plugin/bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <h1>Add New Employee</h1>

        <div class="row">
            <div class="col-md-12">
                <form id="frm_faq" class="form-horizontal">
                    <div class="form-body">
                        <div class="row">
                            <div class="col-md-12">
                                <div class="form-group">
                                    <label class="control-label col-md-2">Name</label>
                                    <div class="col-md-6">
                                        <input type="text" class="form-control input-sm" name="txt_name" id="txt_name" autocomplete="off">
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-md-12">
                                <div class="form-group">
                                    <label class="control-label col-md-2">Age</label>
                                    <div class="col-md-6">
                                        <input type="text" class="form-control input-sm" name="txt_age" id="txt_age" autocomplete="off">
                                    </div>
                                </div>
                            </div>

                        </div>
                        <div class="row">
                            <div class="col-md-6">
                                <div class="form-group">
                                    <label class="control-label col-md-4">Dept</label>
                                    <div class="col-md-8 number-select">
                                        <input type="text" class="form-control input-sm" name="txt_dept" id="txt_dept" autocomplete="off">
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-md-6">
                                <div class="form-group">
                                    <label class="control-label col-md-4">Salary</label>
                                    <div class="col-md-8 number-select">
                                        <input type="text" class="form-control input-sm" name="txt_salary" id="txt_salary" autocomplete="off">
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="form-actions">
                        <div class="row">
                            <div class="col-md-offset-2 col-md-10">
                                <button type="submit" id="btn_save" class="btn yellow-casablanca btn-outline"><i class='fa fa-save'></i>Save</button>
                                <button type="submit" id="btn_save_continues" class="btn yellow-casablanca btn-outline"><i class='fa fa-save'></i>Save & Continues</button>
                            </div>
                        </div>
                    </div>
                </form>
            </div>
        </div>
        <script src="${cp}/js/jquery.min.js?ver=2.0" type="text/javascript"></script>
        <script src="${cp}/plugin/bootstrap/js/bootstrap.min.js" type="text/javascript" ></script>
        <script src="${cp}/plugin/jquery-validation/dist/jquery.validate.min.js" type="text/javascript" ></script>
        <script src="${cp}/js_custome/new-employee.js?ver=1.0" type="text/javascript"></script>
        <script>
            jQuery(document).ready(function () {
                NewEmployee.init();
            });
        </script>
    </body>
</html>
