<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<div class="col-sm-8">
    <div class="contact-form">
        <h2 class="title text-center">Chi tiết phản hồi</h2>
        <div class="status alert alert-success" style="display: none"></div>
        <s:url value="/User/FeedBack" var="submitFeedBack" />
        <sec:authentication property="principal" var="userlogin" />
        <form:form commandName="feedBackForm" action="${submitFeedBack}" id="main-contact-form" class="contact-form row" name="contact-form" method="post">
            <div class="form-group col-md-6">
                <input value="${userlogin.username}"  readonly="true"  type="text" name="name" class="form-control"  placeholder="Name"/>
            </div>
            
            <div class="form-group col-md-12">
                <form:input path="title" type="text" name="subject" class="form-control" required="required" placeholder="Subject"/>
            </div>
            <div class="form-group col-md-12">
                <form:textarea path="content" name="message" id="message" required="required" class="form-control" rows="8" placeholder="Your Message Here"/>
            </div>                 


            <div class="form-group col-md-12">
                <input type="submit" name="submit" class="btn btn-primary pull-right" value="Gửi">
            </div>

        </form:form>
    </div>
</div>