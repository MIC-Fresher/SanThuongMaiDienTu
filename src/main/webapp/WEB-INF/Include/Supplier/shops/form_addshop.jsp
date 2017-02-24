
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>



<div class="col-xs-12">
    <div class="box box-warning">
        <div class="box-header with-border">
            <h3 class="box-title">Thêm cửa hàng mới</h3>
        </div>
        <div class="box-body">
            <form:form method="POST"  commandName="shop"  role="form" >
                <!-- text input -->
                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                <div class="form-group">
                    <label>Tên Shop</label>
                    <form:input required="required"   path="shopName" type="text" class="form-control" placeholder="Enter ..." />
                </div>

                <div class="form-group">
                    <label>SĐT Shop</label>
                    <form:input required="required"  path="shopPhone" class="form-control" placeholder="Enter ..."/>
                </div>

                <div class="form-group">
                    <label>Địa chỉ</label>
                    <form:textarea required="required"  type="text" path="userId.address" class="form-control" rows="3" placeholder="Enter ..." />
                </div>
                <div class="form-group">
                    <label>Username</label> 
                    <form:input required="required"  path="userId.userName"  class="form-control" placeholder="Enter ..."/>
                </div>
                <div class="form-group">
                    <label>Email</label>
                    <form:input required="required" type="email"  path="userId.email" class="form-control" placeholder="Enter ..."/>
                </div>

                <div class="form-group">
                    <label>SĐT cá nhân</label>
                    <form:input path="userId.phone" class="form-control" placeholder="Enter ..."/>
                </div>

                <!------------------------------------------>
                <s:url value="/Supplier/AddShop" var="addShop"/>
                <div class="box-footer clearfix">
                    <button class="btn btn-primary" type="submit" onclick="form.action = '${addShop}';" >Thêm</button>
                </div>
            </form:form>
        </div>
    </div>
</div>