<%-- 
    Document   : PagingAllCategories
    Created on : Jan 2, 2017, 9:10:41 PM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<c:choose>
    <c:when test="${typecategorybar == 'shop'}">
        <s:url value="/Public/showProductOfShop?categoryname=${category.categoryName}&${parameterUrl}" var="searchbycategory"/>
    </c:when>
    <c:otherwise>
        <s:url value="/Public/searchProducts?categoryname=${category.categoryName}&${parameterUrl}" var="searchbycategory"/>
    </c:otherwise>

</c:choose>
<c:choose>
    <c:when test="${typesearch =='all'}">
        <c:url var="firstUrl" value="/Public/searchAllProducts?page=1&${parameterUrl}"/>
        <c:url var="lastUrl" value="/Public/searchAllProducts?page=${requestScope.listSearchProducts.totalPages}&${parameterUrl}" />
        <c:url var="prevUrl" value="/Public/searchAllProducts?page=${requestScope.listSearchProducts.current - 1}&${parameterUrl}" />
        <c:url var="nextUrl" value="/Public/searchAllProducts?page=${requestScope.listSearchProducts.current + 1}&${parameterUrl}" />
    </c:when>
    <c:when test="${typecategorybar == 'shop'}">
        <c:url var="firstUrl" value="/Public/showProductOfShop?page=1&${parameterUrl}"/>
        <c:url var="lastUrl" value="/Public/showProductOfShop?page=${requestScope.listSearchProducts.totalPages}&${parameterUrl}" />
        <c:url var="prevUrl" value="/Public/showProductOfShop?page=${requestScope.listSearchProducts.current - 1}&${parameterUrl}" />
        <c:url var="nextUrl" value="/Public/showProductOfShop?page=${requestScope.listSearchProducts.current + 1}&${parameterUrl}" />
    </c:when>
    <c:otherwise>
        <c:url var="firstUrl" value="/Public/searchProducts?page=1&${parameterUrl}"/>
        <c:url var="lastUrl" value="/Public/searchProducts?page=${requestScope.listSearchProducts.totalPages}&${parameterUrl}" />
        <c:url var="prevUrl" value="/Public/searchProducts?page=${requestScope.listSearchProducts.current - 1}&${parameterUrl}" />
        <c:url var="nextUrl" value="/Public/searchProducts?page=${requestScope.listSearchProducts.current + 1}&${parameterUrl}" />
    </c:otherwise>
</c:choose>
<ul class="pagination">
    <c:choose>
        <c:when test="${requestScope.listSearchProducts.current == 1}">
            <li class="disabled"><a href="#">&lt;&lt;</a></li>
            <li class="disabled"><a href="#">&lt; </a></li>
            </c:when>
            <c:otherwise>
            <li><a href="${firstUrl}">&lt;&lt;</a></li>
            <li><a href="${prevUrl}">&lt;</a></li>
            </c:otherwise>
        </c:choose>

    <c:forEach var="i" begin="${listSearchProducts.begin}" end="${listSearchProducts.end}">
        <c:choose>
            <c:when test="${typesearch=='all'}">
                <c:url var="pageUrl" value="/Public/searchAllProducts?page=${i}&${parameterUrl}" />
            </c:when>
            <c:when test="${typecategorybar == 'shop'}">
                <c:url var="pageUrl" value="/Public/showProductOfShop?page=${i}&${parameterUrl}" />
            </c:when>
            <c:otherwise>
                <c:url var="pageUrl" value="/Public/searchProducts?page=${i}&${parameterUrl}" />
            </c:otherwise>
        </c:choose>
        <c:choose>
            <c:when test="${i == requestScope.listSearchProducts.current}">
                <li class="active"><a href="${pageUrl}"><c:out value="${i}" /></a></li>
                </c:when>
                <c:otherwise>
                <li><a href="${pageUrl}"><c:out value="${i}" /></a></li>
                </c:otherwise>
            </c:choose>
        </c:forEach>
        <c:choose>
            <c:when test="${requestScope.listSearchProducts.current == requestScope.listSearchProducts.totalPages}">
            <li class="disabled"><a href="#">&gt;</a></li>
            <li class="disabled"><a href="#">&gt;&gt;</a></li>
            </c:when>
            <c:otherwise>
            <li><a href="${nextUrl}">&gt;</a></li>
            <li><a href="${lastUrl}">&gt;&gt;</a></li>
            </c:otherwise>
        </c:choose>
</ul>