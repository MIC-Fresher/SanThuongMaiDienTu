
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<div id="test" style="display: block"   class="modal">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close span_close_comment" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title">  ${messeger}</h4>
            </div>
            <div id="body_modal_comment" class="modal-body">
                <c:if test="${not empty listOrder}">
                    <div class="table-responsive">
                        <table class="table table-condensed">

                            <tbody>
                                <c:forEach var="order" items="${listOrder.content}" varStatus="status">
                                    <tr>

                                        <td class="cart_product">
                                            <a href="">
                                                <c:choose >
                                                    <c:when test="${order.productId.productdetail.producimageList[0].url!=null}">
                                                        <s:url var="productdetail" value="/Public/setupShowDetailProduct?id=${order.productId.productId}"/>
                                                        <a href="${productdetail}">   <img style="height: 110px ; width: 110px"  src="${pageContext.request.contextPath}/images/product-details/<c:out value="${order.productId.productdetail.producimageList.get(0).url}"/>" alt="User Image">
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

                                                <c:set  value="${order}" var="order" scope="request"/>
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
