
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<div class="col-sm-6">
    <div class="total_area">
        <ul>
            <li>Cart Sub Total 
                <span>$
                    <fmt:formatNumber type="number" value="${cartForm.totalPrice}"/>
                </span>
            </li>
            <li>Eco Tax <span>$0</span></li>
            <li>Shipping Cost <span>Free</span></li>
            <li>Total 
                <span>$
                    <fmt:formatNumber type="number" value="${cartForm.totalPrice}"/>
                </span>
            </li>
        </ul>

        <a class="btn btn-default update" href="javascript:{}" onclick="document.getElementById('cartform').submit(); return false;">
            Update  
        </a> 

        <s:url value="/User/checkoutOrder" var="checkoutorder"/>
        <a class="btn btn-default check_out" href="${checkoutorder}">Check Out</a>


    </div>
</div>
