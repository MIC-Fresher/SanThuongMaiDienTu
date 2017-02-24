
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:if test="${not empty productcomments.content}">
    <c:url var="nextUrl" value="/Public/pagingComments?page=${requestScope.productcomments.current + 1}&id=${product.productId}" />
    <c:url var="prevUrl" value="/Public/pagingComments?page=${requestScope.productcomments.current - 1}&id=${product.productId}" />
    <div id="comment_items" class="response-area">
        <c:forEach var="productcomment" items="${productcomments.content}" >
            <ul class="media-list">
                <li class="media">

                    <a class="pull-left" href="#">
                        <img class="media-object" src="${pageContext.request.contextPath}/images/blog/man-two.jpg" alt="">
                    </a>
                    <div class="media-body">
                        <ul class="sinlge-post-meta">
                            <li>
                                <i class="fa fa-user"></i>${productcomment.userId.userName}
                            </li>
                            <li>
                                <i class="fa fa-clock-o"></i>       <fmt:formatDate pattern="dd/MM/yyyy" value="${productcomment.dateCreated}"/>

                            </li>

                        </ul>
                        ${productcomment.content}
                    </div>

                </li>

            </ul>
        </c:forEach>
        <ul class="pagination">

            <c:choose>
                <c:when test="${requestScope.productcomments.current == 1}">

                    <!--<li class="btn btn-primary pull-right disabled"><a href="#">Quay lại</a></li>-->
                </c:when>
                <c:otherwise>

                    <li><a class="btn btn-primary pull-right" onclick="pagingAjax('${prevUrl}')" href="javascript:{}">Quay lại</a></li>
                    </c:otherwise>
                </c:choose>
                <c:choose>
                    <c:when test="${requestScope.productcomments.current == productcomments.totalPages}">
                    <!--<li class="btn btn-primary pull-right disabled"><a href="#">Xem thêm</a></li>-->

                </c:when>
                <c:otherwise>
                    <li><a class="btn btn-primary pull-right" onclick="pagingAjax('${nextUrl}')"  href="javascript:{}">Xem thêm</a></li>

                </c:otherwise>
            </c:choose>
        </ul>
    </div>
</c:if>
<script lang="javascript">
    function pagingAjax(input) {

        $.ajax({
            type: "GET",
            url: input,
            timeout: 100000,
            success: function (data) {
                console.log("SUCCESS: ", data);
                displaypaging(data);

            },
            error: function (e) {
                console.log("ERROR: ", e);
                //display(e);
            }
        });
    }
    function displaypaging(data) {

        $('#comment_items_return').html(data);
    }


</script>