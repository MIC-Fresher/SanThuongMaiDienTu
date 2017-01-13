<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<div class="price-range"><!--brands_products-->
    <h2>Shops</h2>
    <div class="brands-name">
        <ul class="nav nav-pills nav-stacked">
            <c:forEach items="${listShops}" var="shop">
                <s:url value="/Public/searchProducts?shopname=${shop.shopName}&${parameterUrl}" var="searchbyshop"/>
                <li>

                    <a href="${searchbyshop}" >
                        <span class="pull-right">(${shop.productList.size()})</span>
                        ${shop.shopName}
                    </a>

                </li>
            </c:forEach>
        </ul>
    </div>
</div><!--/brands_products-->