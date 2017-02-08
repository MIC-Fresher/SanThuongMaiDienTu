
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>



<div class="col-xs-12">
    <div class="box box-warning">
        <div class="box-header with-border">
            <h3 class="box-title">Thông tin người đặt hàng</h3>
        </div>
        <div class="box-body">
     
                <!-- text input -->
                
                <form:input path="userId.userId" type="hidden" />
                <div class="form-group">
                    <label>User name</label>
                    <form:input readonly="true" path="userId.userName"    class="form-control" placeholder="Enter ..."/>
                </div>
                <div class="form-group">
                    <label>Email </label>
                    <form:input readonly="true" path="userId.email"  type="text" class="form-control" placeholder="Enter ..." />
                </div>
                <div class="form-group">
                    <label>Phone </label>
                    <form:input readonly="true" path="userId.phone"  type="text" class="form-control" placeholder="Enter ..." />
                </div>
                <div class="form-group">
                    <label>Address </label>
                    <form:input readonly="true" path="userId.address" type="text" class="form-control" placeholder="Enter ..." />
                </div>

                <!-- textarea -->

       
        </div>
    </div>
</div>