<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<div class="table-responsive cart_info">
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
                    <td class="cart_description">
                        <h4>
                            <a href="">${order.productId.productName}</a>
                        </h4>
                        <h4>
                            <a href="">
                                ngày đặt : 
                                <fmt:formatDate pattern="dd/MM/yyyy" value="${order.orderId.orderDate}"/>

                            </a>
                        </h4>
                        <h4>
                            <a href="">
                                giá : 
                                $
                                <fmt:formatNumber type="number" value="${order.productId.unitPrice}"/>

                            </a>
                        </h4>
                        <h4>
                            <a href="">
                                Cung cấp bởi:
                                ${order.productId.shopId.shopName}

                            </a>
                        </h4>
                    </td>

                    <td class="cart_quantity">
                        <div class="cart_quantity_button">

                            <input readonly="readonly" class="cart_quantity_input" type="text" name="quantity" value="${order.quantity}" autocomplete="off" size="2">

                        </div>
                    </td>
                    <td class="cart_total">
                        <fmt:formatNumber type="number" value="${order.totalUnitPrice}"/>

                    </td>
                    <td class="cart_total">
                        ${order.orderId.statusOrderId.status}
                    </td>

                </tr>

            </c:forEach>
        </tbody>
    </table>
</div>