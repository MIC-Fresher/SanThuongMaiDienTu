<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>


<div class="left-sidebar">
    <h2>Chức năng</h2>
    <div class="panel-group category-products" id="accordian"><!--category-productsr-->


        <div class="panel panel-default">
            <div class="panel-heading">
                <s:url value="/User/InformationAccount" var="informationpage"/>
                <h4 class="panel-title"><a href="${informationpage}">Quản lý account</a></h4>
            </div>
        </div>

        <div class="panel panel-default">
            <div class="panel-heading">
                <s:url value="/User/Order" var="orderpage"/>
                <h4 class="panel-title"><a href="${orderpage}">Lịch sử đặt hàng</a></h4>
            </div>
        </div>



    </div><!--/category-products-->
    <div class="shipping text-center"><!--shipping-->
        <img src="${pageContext.request.contextPath}/images/home/shipping.jpg" alt="" />
    </div><!--/shipping-->
</div>
