
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>


<div class="col-xs-12">
    <div class="box box-warning">
        <div class="box-header with-border">
            <h3 class="box-title">Thông tin người nhận hàng</h3>
        </div>
        <div class="box-body">
      
              
                
                <div class="form-group">
                    <label>ID</label>
                    <form:input readonly="true" path="receiverId.receiverId" id="thanhphan"   class="form-control" placeholder="Enter ..."/>
                </div>
                <div class="form-group">
                    <label>Tên người nhận</label>
                    <form:input path="receiverId.receiverName" id="thanhphan"   class="form-control" placeholder="Enter ..."/>
                </div>
            
                <div class="form-group">
                    <label>Phone người nhận </label>
                    <form:input  path="receiverId.receiverPhone" id="name" type="text" class="form-control" placeholder="Enter ..." />
                </div>
                <div class="form-group">
                    <label>Địa chỉ người nhận </label>
                    <form:input  path="receiverId.receiverAddress" id="name" type="text" class="form-control" placeholder="Enter ..." />
                </div>

          
        </div>
    </div>
</div>