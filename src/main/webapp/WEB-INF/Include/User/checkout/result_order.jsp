<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>


<div class="table-responsive cart_info">
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

                            <input readonly="true" class="cart_quantity_input" type="text" name="quantity" value="${cartLineInfo.quantity}" autocomplete="off" size="2">
                            <input type="hidden" name="url" value="cart" />
                        </div>
                    </td>

                </tr>

            </c:forEach>

            <tr>
                <td colspan="4">&nbsp;</td>
                <td colspan="2">
                    <table class="table table-condensed total-result">
                        <tr>
                            <td>Cart Sub Total</td>
                            <td>$
                                <fmt:formatNumber type="number" value="${cartForm.totalPrice}"/>
                            </td>
                        </tr>
                        <tr>
                            <td>Exo Tax</td>
                            <td>$0</td>
                        </tr>
                        <tr class="shipping-cost">
                            <td>Shipping Cost</td>
                            <td>Free</td>										
                        </tr>
                        <tr>
                            <td>Total</td>
                            <td><span>$ <fmt:formatNumber type="number" value="${cartForm.totalPrice}"/></span></td>
                        </tr>
                    </table>
                </td>
            </tr>
        </tbody>
    </table>
</div>