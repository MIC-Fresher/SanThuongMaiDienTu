
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>



<div class="col-xs-12">
    <div class="box box-warning">
        <div class="box-header with-border">
            <h3 class="box-title">Thông tin đơn hàng</h3>
        </div>
        <div class="box-body">
     

                <div class="form-group">
                    <label>Mã đơn hàng</label>
                    <form:input readonly="true"  path="orderId" id="name" type="text" class="form-control" placeholder="Enter ..." />
                </div>
                <div class="form-group">
                    <label>Ngày đặt hàng</label>
                    <form:input readonly="true"  path="orderDate" id="name" type="date" class="form-control" placeholder="Enter ..." />
                </div>
                <div class="form-group">
                    <label>Ngày hoàn thành đơn hàng</label>
                    <form:input   path="updateDate" id="name" type="date" class="form-control" placeholder="Enter ..." />
                </div>
                <div class="form-group">
                    <label>Tổng giá trị đơn hàng</label>
                    <form:input readonly="true"  path="totalPrice" id="name" type="number" class="form-control" placeholder="Enter ..." />
                </div>
                    
                <div class="form-group">
                    <label>Trạng thái đơn hàng</label>
                    <form:select  path="statusOrderId.statusOrderId">
                        <c:forEach items="${statusOrders}" var="statusOrders">
                            <form:option  value="${statusOrders.statusOrderId}">${statusOrders.status}</form:option>
                        </c:forEach>

                    </form:select>
                </div>
            
       
        </div>
    </div>
</div>