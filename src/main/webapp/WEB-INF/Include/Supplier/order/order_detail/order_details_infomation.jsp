
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>



<div class="col-xs-12">
    <div class="box box-warning">
        <div class="box-header with-border">
            <h3 class="box-title">Chi tiết đơn hàng</h3>
        </div>
        <div class="box-body">
            <div class="table-responsive cart_info">
                <table class="table table-condensed">
                    <thead>
                        <tr class="cart_menu">
                            <td class="image">Sản phẩm</td>
                            <td class="description">Thông tin</td>
                            <td class="price">Giá</td>
                            <td class="quantity">Số lượng</td>
                            <td class="quantity"></td>
                            <td></td>
                        </tr>
                    </thead>
                    <tbody>

                        <c:forEach var="order" items="${order.orderdetailList}" varStatus="status">
                            <tr id="${order.orderDetailId}">

                                <td class="cart_product">
                                    <a href="">
                                        <c:choose >
                                            <c:when test="${order.productId.productdetail.producimageList[0].url!=null}">
                                                <img style="height: 110px ; width: 110px" src="${pageContext.request.contextPath}/images/product-details/<c:out value="${order.productId.productdetail.producimageList.get(0).url}"/>" class="img-circle" alt="User Image">
                                            </c:when>
                                            <c:otherwise>
                                                <img style="height: 110px ; width: 110px" src="${pageContext.request.contextPath}/images/product-details/imgnotfound.png" class="img-circle" alt="User Image">
                                            </c:otherwise>
                                        </c:choose>

                                    </a>

                                </td>
                                <td class="cart_description">
                                    <h4>ID:
                                        <a href="">
                                            ${order.productId.productId}
                                        </a>
                                    </h4>
                                    <h4>
                                        <a href="">
                                            ${order.productId.productName}
                                        </a>
                                    </h4>
                                    <h4>
                                        <a href="">ngày đặt : 
                                            <fmt:formatDate pattern="dd/MM/yyyy" value="${order.orderId.orderDate}"/>
                                        </a>
                                    </h4>
                                    <h4>
                                        <a href="">Cung cấp bởi:
                                            ${order.productId.shopId.shopName}
                                        </a>
                                    </h4>

                                </td>
                                <td class="cart_price"> 
                                    <p>
                                        <fmt:formatNumber type="number" value="${order.productId.unitPrice}"/>

                                    </p>
                                </td>
                                <td class="cart_quantity">
                                    <div class="cart_quantity_button">
                                        ${order.quantity}

                                    </div>
                                </td>
                              

                                <s:url value="/Public/shoppingCartRemoveProduct?id={cartLineInfo.product.productId}" var="deletecart"/>
                                <!--                                <td  class="cart_delete">
                              <a class="cart_quantity_delete" onclick="deleteDetail('{order.orderDetailId}')"  href="javascript:{}">
                                  <i class="fa fa-times"></i>
                              </a>
                          </td>-->
                            </tr>

                        </c:forEach>

                    </tbody>
                </table>

            </div>

        </div>
    </div>
</div>
<!--<script lang="javascript">
    function deleteDetail(input) {
        $("#" + input).remove();
    }


</script>-->