
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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

    <div class="product-details"><!--product-details-->
        <div class="col-sm-5">
            <div class="view-product"> 
                <!--hinh anh pro-->
                <c:choose >
                    <c:when test="${product.productdetail.producimageList[0].url!=null}">
                        <img style="height: 380px ; width: 329px " src="${pageContext.request.contextPath}/images/product-details/<c:out value="${product.productdetail.producimageList.get(0).url}"/>" alt="User Image">
                    </c:when>
                    <c:otherwise>
                        <img style="height: 380px ; width: 329px "  src="${pageContext.request.contextPath}/images/product-details/imgnotfound.png" alt="User Image">
                    </c:otherwise>
                </c:choose>

            </div>
        </div>
        <div class="col-sm-7">
            <!--thong tin sp 1-->
            <div class="product-information"><!--/product-information-->
                <img src="${pageContext.request.contextPath}/images/product-details/new.jpg" class="newarrival" alt="" />
                <h2>${product.productName}</h2>

                <img style="margin-right: 100px" src="${pageContext.request.contextPath}/images/product-details/rating.png" alt="" />
                total vote ${product.totalVote}
                <span>
                    <span>
                        <fmt:formatNumber type="number" value="${product.unitPrice}"/>
                    </span>


                    <s:url value="/Public/addProduct?id=${product.productId}" var="addtocart"/>

                    <button  type="reset" onclick="addCart('${addtocart}')" class="btn btn-fefault cart">
                        <i class="fa fa-shopping-cart"></i>
                        Add to cart
                    </button>
                </span>
          
                <p><b>Số lượng trong kho :</b> 
                    <c:choose>
                        <c:when test="${product.quantity==0}">Hết hàng</c:when>                   
                        <c:otherwise>Còn hàng</c:otherwise>
                    </c:choose>
                </p>
                <p><b>Tình Trạng :</b> Mới nhập</p>
                <p><b>Loại sản phẩm :</b> ${product.categoryId.categoryName}</p>
                <p>
                    <s:url value="/Public/${product.shopId.shopName}/" var="productofshop"/>
                    <b>Shop bán:</b> 
                    <a href="${productofshop}"> ${product.shopId.shopName}</a>
                </p>
                <p>

                    <b>Các Shop bán mặt hàng tương tự:</b> 
                    <c:forEach items="${listShopSellProduct}" var="listShopSellProduct">
                        <s:url value="/Public/${listShopSellProduct.shopName}/" var="productofshop"/>
                        <c:if test="${listShopSellProduct.shopName != product.shopId.shopName}">
                            <a href="${productofshop}"> ${listShopSellProduct.shopName},</a>
                        </c:if>

                    </c:forEach>
                </p>
                <div id="fb-root"></div>
                <script>(function (d, s, id) {
                        var js, fjs = d.getElementsByTagName(s)[0];
                        if (d.getElementById(id))
                            return;
                        js = d.createElement(s);
                        js.id = id;
                        js.src = "//connect.facebook.net/vi_VN/sdk.js#xfbml=1&version=v2.8";
                        fjs.parentNode.insertBefore(js, fjs);
                    }(document, 'script', 'facebook-jssdk'));</script>



                <div class="fb-like" data-href="http://daynhauhoc.com/" data-layout="standard" data-action="like" data-show-faces="true" data-share="true"></div>

            </div><!--/product-information-->
        </div>
    </div><!--/product-details-->
    <!--thong tin sp 2-->




