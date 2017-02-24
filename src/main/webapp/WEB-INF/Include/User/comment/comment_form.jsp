<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<div class="media commnets">
    <p><b>Bình luận</b></p>
    <s:url value="/User/Comment" var="comment"/>
    <form:form id="form_comment" commandName="commentForm" action="${comment}">
        <form:hidden path="productId" value="${product.productId}"/>

        <form:textarea required="true" path="commentContent" />

        <c:choose>
            <c:when test="${checklogin!='login'}">
                <s:url value="/User/index" var="loginuser"/>
                <input class="btn btn-primary pull-right" type="button" value="Đăng nhập để bình luận" onclick="window.location = '${loginuser}';" />  

            </c:when>
            <c:otherwise>
                <input onclick="CommentProduct()"  value="Gửi" type="button" class="btn btn-primary pull-right"/>
            </c:otherwise>
        </c:choose>



    </form:form>

</div>
<script lang="javascript">
    function CommentProduct() {

        $.ajax({
            type: $('#form_comment').attr('method'),
            url: $('#form_comment').attr('action'),
            data: $('#form_comment').serialize(),
            timeout: 100000,
            success: function (data) {
                console.log("SUCCESS: ", data);

                displaycomment(data);

            },
            error: function (e) {
                console.log("ERROR: ", e);
                //
            }
        });
    }
    function displaycomment(data) {

        $('#comment_return').html("");
        alert('Bình luận của bạn sẽ được đăng sau khi kiểm duyệt');
    }


</script>