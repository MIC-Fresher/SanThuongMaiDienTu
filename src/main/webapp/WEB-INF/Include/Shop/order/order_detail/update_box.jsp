
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<div class="box-header">
    <h3 class="box-title">

        <a class="btn btn-primary btn-lg" href="javascript:{}" onclick="document.getElementById('order_form').submit(); return false;">
            Cập nhật thay đổi 
        </a> 
    </h3>
    <h3 class="box-title">
        <a class="btn btn-primary btn-lg" href="javascript:{}" onclick="document.getElementById('order_form').reset(); return false;">
            Reset 
        </a> 
    </h3>
    <h3 class="box-title">
        <s:url value="/Shop/deleteOrder?id=${order.orderId}" var="delete"/>
        <a class="btn btn-primary btn-lg" href="javascript:{}" onclick="deleteOrder('${delete}')" >
            Xóa đơn hàng 
        </a> 
    </h3>

</div>









