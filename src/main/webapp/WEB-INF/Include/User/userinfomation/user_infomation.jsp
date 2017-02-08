<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<div class="contact-form">
    <h2 class="title text-center">Thông tin</h2>
    <div class="status alert alert-success" style="display: none"></div>
    <s:url value="/User/InformationAccount" var="updateinfo"/>
    <form:form action="${updateinfo}" commandName="userInformation" id="main-contact-form" class="contact-form row" name="contact-form" method="post">
        <form:hidden path="userId" value="${userInformation.userId}"/>

        
        <div class="form-group col-md-12">
            Tên	:	
        </div>
        <div class="form-group col-md-12">
            <form:input path="userName" type="text" name="Username" class="form-control"  placeholder="Username"/>
        </div>
        <div class="form-group col-md-12">
            Email :		
        </div>
        <div class="form-group col-md-12">
            <form:input readonly="true" type="email"  path="email" name="Email" class="form-control"  placeholder="Email"/>
        </div>
        <div class="form-group col-md-12">
            Password :		
        </div>
        <div class="form-group col-md-12">
            <form:input  path="passWord" type="text" name="password" class="form-control"  placeholder="password"/>
        </div>
        <div class="form-group col-md-12">
            Phone :		
        </div>
        <div class="form-group col-md-12">
            <form:input path="phone" type="text"  name="Phone" class="form-control"  placeholder="Phone"/>
        </div>
        <div class="form-group col-md-12">
            Địa chỉ :		
        </div>
        <div class="form-group col-md-12">
            <form:textarea path="address" id="message"  class="form-control" rows="8" placeholder="Địa chỉ"/>
        </div>                        
        <div class="form-group col-md-12">
            <input type="submit" name="submit" class="btn btn-primary pull-right" value="Sửa">
        </form:form>

    </div>

</div>