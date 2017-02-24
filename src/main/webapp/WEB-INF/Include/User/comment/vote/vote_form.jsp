<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<div >
    <p>Xin vui lòng chia sẻ đánh giá của bạn về sản phẩm này 
    </p>

    <s:url value="/User/Vote" var="voting"/>
    <form:form id="form_voting${param.status}" commandName="voteForm" action="${voting}" method="POST">
        <form:hidden path="productId" value="${product.productId}"/>
        <div id="rating${param.status}" class="form-group">
            <fieldset class="rating">

                <input type="radio" id="star5${param.status}" name="rating" value="5" /><label class = "full" for="star5" title="Awesome - 5 stars"></label>

                <input type="radio" id="star4${param.status}" name="rating" value="4" /><label class = "full" for="star4" title="Pretty good - 4 stars"></label>


                <input type="radio" id="star3${param.status}" name="rating" value="3" /><label class = "full" for="star3" title="Meh - 3 stars"></label>


                <input type="radio" id="star2${param.status}" name="rating" value="2" /><label class = "full" for="star2" title="Kinda bad - 2 stars"></label>


                <input type="radio" id="star1${param.status}" name="rating" value="1" /><label class = "full" for="star1" title="Sucks big time - 1 star"></label>

            </fieldset>
            <form:select path="markVote">
                <c:forEach begin="1" end="5" var="i">
                    <form:option value="${i}">${i}</form:option>
                </c:forEach>
            </form:select>
        </div>
        <div class="form-group">
            <input type="button" value="Đánh giá" onclick="addVote()" class="btn btn-primary pull-right"/>
        </div>
    </form:form>

</div>
<script lang="javascript">
    function addVote() {

        $.ajax({
            type: $('#form_voting${param.status}').attr('method'),
            url: $('#form_voting${param.status}').attr('action'),
            data: $('#form_voting${param.status}').serialize(),
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

        $('#Vote_Return').html(data);
        document.getElementById("Comment_Modal").style.display = "block";
    }


</script>