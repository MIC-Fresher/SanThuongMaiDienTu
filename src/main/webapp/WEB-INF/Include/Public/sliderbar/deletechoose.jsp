<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<div class="checkout-options">
    <ul class="nav">

        <li>
            <c:if test="${not empty categoryname }">




                <c:choose>
                    <c:when test="${typecategorybar == 'shop'}">

                        <s:url value="/Public/showProductOfShop?categoryname=&${parameterUrl}" var="deletecatagory"/>
                    </c:when>
                    <c:otherwise>
                        <s:url value="/Public/searchProducts?categoryname=&${parameterUrl}" var="deletecatagory"/>
                    </c:otherwise>

                </c:choose>

                <a href="${deletecatagory}">deletecata</a>
            </c:if>
        </li> 

        <li>
            <c:if test="${not empty totalvote}">

                <c:choose>
                    <c:when test="${typecategorybar == 'shop'}">
                        <s:url value="/Public/showProductOfShop?totalvote=&${parameterUrl}" var="deletevote"/>
                    </c:when>
                    <c:otherwise>
                        <s:url value="/Public/searchProducts?totalvote=&${parameterUrl}" var="deletevote"/>
                    </c:otherwise>

                </c:choose>



                <a href="${deletevote}">delete vote</a>
            </c:if>
        </li>
        <li><c:if test="${not empty fromprice and not empty toprice}">

                <c:choose>
                    <c:when test="${typecategorybar == 'shop'}">

                        <s:url value="/Public/showProductOfShop?fromprice=&toprice=&${parameterUrl}" var="deleteprice"/>


                    </c:when>
                    <c:otherwise>


                        <s:url value="/Public/searchProducts?fromprice=&toprice=&${parameterUrl}" var="deleteprice"/>

                    </c:otherwise>

                </c:choose>



                <a href="${deleteprice}">delete price</a>
            </c:if>
        </li>
        <li>
            <c:if test="${not empty shopname and typecategorybar != 'shop'}">

                <s:url value="/Public/searchProducts?shopname=&${parameterUrl}" var="deleteshopname"/>


                <a href="${deleteshopname}">deleteshopname</a>
            </c:if>
        </li>
        <li>
            <c:if test="${not empty searchinput}">
                <c:choose>
                    <c:when test="${typecategorybar == 'shop'}">
                        <s:url value="/Public/showProductOfShop?searchinput=&${parameterUrl}" var="deletesearchinput"/>

                    </c:when>
                    <c:otherwise>


                        <s:url value="/Public/searchProducts?searchinput=&${parameterUrl}" var="deletesearchinput"/>

                    </c:otherwise>

                </c:choose>


                <a href="${deletesearchinput}">searchinput</a>
            </c:if>
        </li>
    </ul>
</div>