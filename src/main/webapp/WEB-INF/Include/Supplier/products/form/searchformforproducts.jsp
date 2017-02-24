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
<s:url value="/Supplier/searchProducts" var="searchproducts"/>
<form action="${searchproducts}" method="get" class="sidebar-form">
    <div class="input-group">
        <input type="text" name="searchinput" class="form-control" placeholder="Search...">
        
        <span class="input-group-btn">
            <button type="submit" id="search-btn" class="btn btn-flat"><i class="fa fa-search"></i>
            </button>
        </span>
    </div>
</form>
