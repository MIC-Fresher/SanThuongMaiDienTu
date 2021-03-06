<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<div class="checkout-options">
    <ul class="nav">

        <li>
            <c:if test="${not empty parameterUrl.categoryname }">
                <s:url value="/Public/setupSearchProducts?${parameterUrl.toStringCategory()}" var="deletecatagory"/>
                <a href="${deletecatagory}">deletecata</a>
            </c:if>
        </li> 

        <li>
            <c:if test="${not empty parameterUrl.totalvote}">
                <s:url value="/Public/setupSearchProducts?${parameterUrl.toStringVote()}" var="deletevote"/>
                <a href="${deletevote}">delete vote</a>
            </c:if>
        </li>
        <li><c:if test="${not empty parameterUrl.fromprice and not empty parameterUrl.toprice}">



                <s:url value="/Public/setupSearchProducts?${parameterUrl.toStringPrice()}" var="deleteprice"/>


                <a href="${deleteprice}">delete price</a>
            </c:if>
        </li>
   
        <li>
            <c:if test="${not empty parameterUrl.searchinput}">
                <s:url value="/Public/setupSearchProducts?${parameterUrl.toStringSearchInput()}" var="deletesearchinput"/>
                <a href="${deletesearchinput}">searchinput</a>
            </c:if>
        </li>
    </ul>
</div>