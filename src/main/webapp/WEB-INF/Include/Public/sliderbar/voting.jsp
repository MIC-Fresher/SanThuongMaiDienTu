<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<div class="brands_products"><!--brands_products-->
    <h2>Vote number</h2>
    <div class="brands-name">
        <ul class="nav nav-pills nav-stacked">
            <c:forEach begin="1" end="5" varStatus="status" >

                <c:choose>
                    <c:when test="${typecategorybar == 'shop'}">
                        <s:url value="/Public/showProductOfShop?totalvote=${status.index}&${parameterUrl}" var="searchbyshop"/>

                    </c:when>
                    <c:otherwise>
                        <s:url value="/Public/searchProducts?totalvote=${status.index}&${parameterUrl}" var="searchbyshop"/>

                    </c:otherwise>

                </c:choose>


                <li>
                    <a href="${searchbyshop}" >

                        ${status.index}
                    </a>
                </li>
            </c:forEach>
        </ul>
    </div>
</div><!--/brands_products-->