
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>



<c:url var="firstUrl" value="/Supplier/Orders/Filter?page=1&${parameterUrl.toString()}"/>
<c:url var="lastUrl" value="/Supplier/Orders/Filter?page=${requestScope.listOrders.totalPages}&${parameterUrl.toString()}" />
<c:url var="prevUrl" value="/Supplier/Orders/Filter?page=${requestScope.listOrders.current - 1}&${parameterUrl.toString()}" />
<c:url var="nextUrl" value="/Supplier/Orders/Filter?page=${requestScope.listOrders.current + 1}&${parameterUrl.toString()}" />
<ul class="pagination">
    <c:choose>
        <c:when test="${requestScope.listOrders.current == 1}">
            <li class="disabled"><a href="#">&lt;&lt;</a></li>
            <li class="disabled"><a href="#">&lt; </a></li>
            </c:when>
            <c:otherwise>
            <li><a onclick="pagingAjax('${firstUrl}')" href="javascript:{}">&lt;&lt;</a></li>
            <li><a onclick="pagingAjax('${prevUrl}')" href="javascript:{}">&lt;</a></li>
            </c:otherwise>
        </c:choose>
        <c:forEach var="i" begin="${listOrders.begin}" end="${listOrders.end}">
            <c:url var="pageUrl" value="/Supplier/Orders/Filter?page=${i}&${parameterUrl.toString()}" />
            <c:choose>
                <c:when test="${i == requestScope.listOrders.current}">
                <li class="active"><a onclick="pagingAjax('${pageUrl}')" href="javascript:{}"><c:out value="${i}" /></a></li>
                </c:when>
                <c:otherwise>
                <li><a onclick="pagingAjax('${pageUrl}')"  href="javascript:{}"><c:out value="${i}" /></a></li>
                </c:otherwise>
            </c:choose>
        </c:forEach>
        <c:choose>
            <c:when test="${requestScope.listOrders.current == listOrders.totalPages}">
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

        $('#order_items').html(data);
    }


</script>