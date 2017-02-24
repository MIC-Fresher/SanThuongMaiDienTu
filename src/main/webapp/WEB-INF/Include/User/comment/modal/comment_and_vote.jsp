
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<div  id="Comment_Modal" class="modal">
    <div  class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close span_close_comment" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title">  ${messeger}</h4>
            </div>
            <div id="body_modal_comment" class="modal-body">
                <c:if test="${not empty products}">
                    <div class="table-responsive">
                        <table class="table table-condensed">

                            <tbody>
                                <c:forEach var="product" items="${products}" varStatus="status">
                                    <tr>

                                        <td class="cart_product">
                                            <a href="">
                                                <c:choose >
                                                    <c:when test="${product.productdetail.producimageList[0].url!=null}">
                                                        <s:url var="productdetail" value="/Public/setupShowDetailProduct?id=${product.productId}"/>
                                                        <a href="${productdetail}">   <img style="height: 110px ; width: 110px"  src="${pageContext.request.contextPath}/images/product-details/<c:out value="${product.productdetail.producimageList.get(0).url}"/>" alt="User Image">
                                                        </a>
                                                    </c:when>
                                                    <c:otherwise>
                                                        <img style="height: 110px ; width: 110px"  src="${pageContext.request.contextPath}/images/product-details/imgnotfound.png" alt="User Image">
                                                    </c:otherwise>
                                                </c:choose>

                                            </a>
                                        </td>
                                        <td>
                                            <div class="col-sm-12">

                                                <c:set var="product" value="${product}" scope="request"/>
                                                <jsp:include page="/WEB-INF/Include/User/comment/vote/vote_form.jsp">
                                                    <jsp:param name="status" value="${status.index}" />   
                                                </jsp:include>

                                            </div>
                                        </td>

                                    </tr>

                                </c:forEach>
                            </tbody>
                        </table>
                    </div>

                </c:if>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-primary pull-left btn_close_comment" data-dismiss="modal">Close</button>
            </div>
        </div>
        <!-- /.modal-content -->
    </div>
</div>
<script>
    var modal = document.getElementById('Comment_Modal');
     modal.style.display = "block";
    var span_alert = document.getElementsByClassName("span_close_comment")[0];
    var btn_close_alert = document.getElementsByClassName("btn_close_comment")[0];
    //-----------
    btn_close_alert.onclick = function () {
        modal.style.display = "none";
    }
    // When the user clicks on <span> (x), close the modal
    span_alert.onclick = function () {
        modal.style.display = "none";
    }

    // When the user clicks anywhere outside of the modal, close it
    window.onclick = function (event) {
        if (event.target == modal) {
            modal.style.display = "none";
        }
    }

</script>