
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<div class="col-sm-9 padding-right">
    <jsp:include page="/WEB-INF/Include/Public/table/pagingfeaturesitem.jsp"/>
    <div class="features_items"><!--features_items-->
        <h2 class="title text-center">Danh mục thuốc</h2>

        <c:forEach var="listProducts" items="${listSearchProducts.content}" varStatus="status">

            <div class="col-sm-4">
                <div class="product-image-wrapper">
                    <div class="single-products">
                        <div class="productinfo text-center">
                            <a href=""> 

                                <c:choose >
                                    <c:when test="${listProducts.productdetail.producimageList[0].url!=null}">
                                        <img src="${pageContext.request.contextPath}/images/product-details/<c:out value="${listProducts.productdetail.producimageList.get(0).url}"/>" alt="User Image">
                                    </c:when>
                                    <c:otherwise>
                                        <img  src="${pageContext.request.contextPath}/images/product-details/imgnotfound.png" alt="User Image">
                                    </c:otherwise>
                                </c:choose>


                            </a>

                            <h2>
                                <fmt:formatNumber type="number" value="${listProducts.unitPrice}"/>
                                ${shopController.p.productId}
                            </h2>
                            <p>${listProducts.productName}</p>
                            <form:form method="get" action="addtoCart.html" id="contact${status.index+1}">
                                <input type="hidden" name="mathuoc" value="${listProducts.productId}" />
                                <input type="hidden" name="url" value="index" />
                                <a href="javascript:{}" onclick="document.getElementById('contact${status.index+1}').submit();
                                        return false;"  class="btn btn-default add-to-cart"><i class="fa fa-shopping-cart"></i>Add to cart</a>

                            </form:form>
                        </div>
                        <div class="product-overlay">
                            <div class="overlay-content">
                                <h2>$56</h2>
                                <p>Easy Polo Black Edition</p>
                                <a href="#" class="btn btn-default add-to-cart"><i class="fa fa-shopping-cart"></i>Add to cart</a>
                            </div>
                        </div>

                    </div>
                    <div class="choose">
                        <ul class="nav nav-pills nav-justified">
                            <li><a href="#"><i class="fa fa-plus-square"></i>Add to wishlist</a></li>
                            <li><a href="#"><i class="fa fa-plus-square"></i>Add to compare</a></li>
                        </ul>
                    </div>
                </div>
            </div>

        </c:forEach>
        <!--paging-->


    </div><!--features_items-->


</div>