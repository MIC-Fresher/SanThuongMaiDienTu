<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<div class="shopper-informations">
    <div class="row">

        <div class="col-sm-5 clearfix">
            <div class="bill-to">
                <p>Thông tin đặt hàng</p>
                <div class="form-one">
                    <s:url value="/User/checkoutOrder" var="checkout"/>
                    <form:form method="POST" commandName="customerForm" action="${checkout}" id="checkout">
                        <form:input required="true"  path="receiverName" type="text" placeholder="Name*"/>
                        <form:input required="true" path="receiverPhone"  placeholder="phone*"/>
                        <form:input required="true"  path="receiverAddress" placeholder="Nơi nhận hàng *"/>
                        <a class="btn btn-primary" href="./index">Hủy</a>
                        <a class="btn btn-primary" href="javascript:{}" onclick="document.getElementById('checkout').submit(); return false;">
                            Đặt hàng 
                        </a>
                    </form:form>
                </div>
                <div class="form-two">
                </div>
            </div>
        </div>

    </div>
</div>