<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<div class="col-xs-12">
    <div class="box box-warning">
        <div class="box-header with-border">
            <h3 class="box-title">Chi tiết phản hồi</h3>
        </div>
        <div class="box-body">
            <s:url value="/Supplier/FeedBackDetail" var="updateFeedback"/>
            <!-- text input -->
            <form:form action="${updateFeedback}" method="POST" commandName="feedBackForm">
                
                <form:input path="userId" type="hidden" />
                <div class="form-group">
                    <label>Tên người gửi</label>
                    <form:input readonly="true" path="userId.userName"    class="form-control" placeholder="Enter ..."/>
                </div>
                <div class="form-group">
                    <label>Email người gửi </label>
                    <form:input readonly="true" path="userId.email"  type="text" class="form-control" placeholder="Enter ..." />
                </div>
                <div class="form-group">
                    <label>Tiêu đề </label>
                    <form:input readonly="true" path="title"  type="text" class="form-control" placeholder="Enter ..." />
                </div>
                <div class="form-group">
                    <label>Nội dung </label>
                    <form:textarea cols="4" readonly="true" path="content" type="text" class="form-control" placeholder="Enter ..." />
                </div>
                
                <!-- textarea -->

            </form:form>
        </div>
    </div>
</div>