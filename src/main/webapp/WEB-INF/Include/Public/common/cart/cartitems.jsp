
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<div class="table-responsive cart_info">
    <s:url value="/Public/shoppingCart" var="updatecart"/>
    <form:form id="cartform" method="POST"  commandName="cartForm" action="${updatecart}">
        <table class="table table-condensed">
            <thead>
                <tr class="cart_menu">
                    <td class="image">Item</td>
                    <td class="description"></td>
                    <td class="price">Price</td>
                    <td class="quantity">Quantity</td>
                    <td></td>
                </tr>
            </thead>

            <tbody>

                <c:forEach var="cartLineInfo" items="${cartForm.cartLines}" varStatus="status">
                    <tr>
                        <form:hidden
                            path="cartLines[${status.index}].product.productId" />
                        <td class="cart_product">
                            <a href="">
                                <c:choose >
                                    <c:when test="${cartLineInfo.product.productdetail.producimageList[0].url!=null}">
                                        <img style="height: 110px ; width: 110px" src="${pageContext.request.contextPath}/images/product-details/<c:out value="${cartLineInfo.product.productdetail.producimageList.get(0).url}"/>" alt="User Image">
                                    </c:when>
                                    <c:otherwise>
                                        <img style="height: 110px ; width: 110px"  src="${pageContext.request.contextPath}/images/product-details/imgnotfound.png" alt="User Image">
                                    </c:otherwise>
                                </c:choose>

                            </a>
                        </td>
                        <td class="cart_description">
                            <h4>
                                <a href="">${cartLineInfo.product.productName}</a>
                            </h4>
                        </td>
                        <td class="cart_price">  
                            <p>
                                <fmt:formatNumber type="number" value="${cartLineInfo.product.unitPrice}"/>

                            </p>
                        </td>

                        <td class="cart_quantity">
                            <div class="cart_quantity_button">
                                <form:select path="cartLines[${status.index}].quantity">
                                    <c:forEach begin="1" end="${cartLineInfo.getNumberCanOrder()}" var="i">
                                        <form:option value="${i}">${i}</form:option>
                                    </c:forEach>
                                </form:select>
                            </div>
                        </td>

                        <td  class="cart_delete">
                            <s:url value="/Public/shoppingCartRemoveProduct?id=${cartLineInfo.product.productId}" var="deletecart"/>
                            <a class="cart_quantity_delete" href="${deletecart}">
                                <i class="fa fa-times"></i>
                            </a>
                        </td>
                    </tr>

                </c:forEach>

            </tbody>
        </table>
    </form:form>
</div>