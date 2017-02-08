
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>



<c:url var="firstUrl" value="/Public/pagingProducts?page=1&${parameterUrl.toString()}"/>
<c:url var="lastUrl" value="/Public/pagingProducts?page=${requestScope.listSearchProducts.totalPages}&${parameterUrl.toString()}" />
<c:url var="prevUrl" value="/Public/pagingProducts?page=${requestScope.listSearchProducts.current - 1}&${parameterUrl.toString()}" />
<c:url var="nextUrl" value="/Public/pagingProducts?page=${requestScope.listSearchProducts.current + 1}&${parameterUrl.toString()}" />
<ul class="pagination">
    <c:choose>
        <c:when test="${requestScope.listSearchProducts.current == 1}">
            <li class="disabled"><a href="#">&lt;&lt;</a></li>
            <li class="disabled"><a href="#">&lt; </a></li>
            </c:when>
            <c:otherwise>
            <li><a onclick="pagingAjax('${firstUrl}')" href="javascript:{}">&lt;&lt;</a></li>
            <li><a onclick="pagingAjax('${prevUrl}')" href="javascript:{}">&lt;</a></li>
            </c:otherwise>
        </c:choose>
        <c:forEach var="i" begin="${listSearchProducts.begin}" end="${listSearchProducts.end}">
            <c:url var="pageUrl" value="/Public/pagingProducts?page=${i}&${parameterUrl.toString()}" />
            <c:choose>
                <c:when test="${i == requestScope.listSearchProducts.current}">
                <li class="active"><a onclick="pagingAjax('${pageUrl}')" href="javascript:{}"><c:out value="${i}" /></a></li>
                </c:when>
                <c:otherwise>
                <li><a onclick="pagingAjax('${pageUrl}')"  href="javascript:{}"><c:out value="${i}" /></a></li>
                </c:otherwise>
            </c:choose>
        </c:forEach>
        <c:choose>
            <c:when test="${requestScope.listSearchProducts.current == listSearchProducts.totalPages}">
            <li class="disabled"><a href="#">&gt;</a></li>
            <li class="disabled"><a href="#">&gt;&gt;</a></li>
            </c:when>
            <c:otherwise>
            <li><a onclick="pagingAjax('${nextUrl}')"  href="javascript:{}">&gt;</a></li>
            <li><a onclick="pagingAjax('${lastUrl}')"  href="javascript:{}">&gt;&gt;</a></li>
            </c:otherwise>
        </c:choose>
</ul>


<script lang="javascript">
            function pagingAjax(input) {

                $.ajax({
                    type: "GET",
                    url: input,
                    timeout: 100000,
                    success: function (data) {
                        console.log("SUCCESS: ", data);
                        display(data);

                    },
                    error: function (e) {
                        console.log("ERROR: ", e);
                        display(e);
                    }
                });
            }
            function display(data) {

                $('#featuresitem').html(data);
            }


        </script>