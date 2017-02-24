<%-- 
    Document   : PagingAllCategories
    Created on : Jan 2, 2017, 9:10:41 PM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<c:url var="firstUrl" value="/Supplier/setupShowAllFeedbacks?page=1" />
<c:url var="lastUrl" value="/Supplier/setupShowAllFeedbacks?page=${requestScope.listFeedbacks.totalPages}" />
<c:url var="prevUrl" value="/Supplier/setupShowAllFeedbacks?page=${requestScope.listFeedbacks.current - 1}" />
<c:url var="nextUrl" value="/Supplier/setupShowAllFeedbacks?page=${requestScope.listFeedbacks.current + 1}" />
<ul class="pagination">
    <c:choose>
        <c:when test="${requestScope.listFeedbacks.current == 1}">
            <li class="disabled"><a href="#">&lt;&lt;</a></li>
            <li class="disabled"><a href="#">&lt; </a></li>
        </c:when>
        <c:otherwise>
            <li><a href="${firstUrl}">&lt;&lt;</a></li>
            <li><a href="${prevUrl}">&lt;</a></li>
        </c:otherwise>
    </c:choose>
    <c:forEach var="i" begin="${listFeedbacks.begin}" end="${listFeedbacks.end}">
        <c:url var="pageUrl" value="/Supplier/setupShowAllFeedbacks?page=${i}" />
        <c:choose>
            <c:when test="${i == requestScope.listFeedbacks.current}">
                <li class="active"><a href="${pageUrl}"><c:out value="${i}" /></a></li>
            </c:when>
            <c:otherwise>
                <li><a href="${pageUrl}"><c:out value="${i}" /></a></li>
            </c:otherwise>
        </c:choose>
    </c:forEach>
    <c:choose>
        <c:when test="${requestScope.listFeedbacks.current == requestScope.listFeedbacks.totalPages}">
            <li class="disabled"><a href="#">&gt;</a></li>
            <li class="disabled"><a href="#">&gt;&gt;</a></li>
        </c:when>
        <c:otherwise>
            <li><a href="${nextUrl}">&gt;</a></li>
            <li><a href="${lastUrl}">&gt;&gt;</a></li>
        </c:otherwise>
    </c:choose>
</ul>