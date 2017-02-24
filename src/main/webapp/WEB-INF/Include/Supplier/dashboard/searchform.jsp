<%-- 
    Document   : searchform
    Created on : Jan 6, 2017, 9:54:37 AM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<s:url value="/Supplier/DashBoard/Search" var="search"/>

<form:form action="${search}" commandName="dashBoard" method="post" >
    <div class="form-group">
        <label>Từ ngày:</label>

        <div class="input-group date">
            <div class="input-group-addon">
                <i class="fa fa-calendar"></i>
            </div>
            <form:input path="fromDate" required="required" type="date" class="form-control pull-right" />
        </div>
        <!-- /.input group -->
    </div>
    <div class="form-group">
        <label>Đến ngày:</label>

        <div class="input-group date">
            <div class="input-group-addon">
                <i class="fa fa-calendar"></i>
            </div>
            <form:input path="toDate" required="required" type="date" class="form-control pull-right" />
        </div>
        <!-- /.input group -->
    </div>

    <input type="submit" value="submit" name="submit" />
</form:form>


