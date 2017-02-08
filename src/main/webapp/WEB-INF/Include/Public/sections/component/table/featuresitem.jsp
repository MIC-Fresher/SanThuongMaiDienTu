
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<jsp:include page="/WEB-INF/Include/Public/sections/component/table/pagingfeaturesitem.jsp"/>
<div  class="features_items"><!--features_items-->
    <h2 class="title text-center">Danh mục SP</h2>

    <c:forEach var="listProducts" items="${listSearchProducts.content}" varStatus="status">

        <div class="col-sm-4">
            <div class="product-image-wrapper">
                <div class="single-products">
                    <div class="productinfo text-center">
                        <a href=""> 

                            <c:choose >
                                <c:when test="${listProducts.productdetail.producimageList[0].url!=null}">
                                    <s:url var="productdetail" value="/Public/setupShowDetailProduct?id=${listProducts.productId}"/>
                                    <a href="${productdetail}"> <img style="height: 373px" src="${pageContext.request.contextPath}/images/product-details/<c:out value="${listProducts.productdetail.producimageList.get(0).url}"/>" alt="User Image">
                                    </a>
                                </c:when>
                                <c:otherwise>
                                    <img style="height: 373px"  src="${pageContext.request.contextPath}/images/product-details/imgnotfound.png" alt="User Image">
                                </c:otherwise>
                            </c:choose>
                        </a>
                        <h2>
                            <fmt:formatNumber type="number" value="${listProducts.unitPrice}"/>
                            
                        </h2>
                        <p>${listProducts.productName}</p>

                        <s:url value="/Public/addProduct?id=${listProducts.productId}" var="addtocart"/>
                        <a class="btn btn-default add-to-cart" onclick="addCart('${addtocart}')" href="javascript:{}">
                            <i class="fa fa-shopping-cart"></i>Add to cart
                        </a>


                        <p>shop ${listProducts.shopId.shopName}</p>
                        <p>vote ${listProducts.totalVote}</p>
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

    <script lang="javascript">
        function addCart(input) {

            $.ajax({
                type: "GET",
                url: input,
                timeout: 100000,
                success: function (data) {
                    console.log("SUCCESS: ", data);
                    displayadd(data);

                },
                error: function (e) {
                    console.log("ERROR: ", e);
                    display(e);
                }
            });
        }
        function displayadd(data) {
            alert("thêm vào giỏ thành công");
            $('#cart_status').html(data);
        }


    </script>

</div><!--features_items-->
