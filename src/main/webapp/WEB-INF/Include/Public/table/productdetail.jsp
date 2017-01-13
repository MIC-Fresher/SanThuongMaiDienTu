
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<div class="col-sm-9 padding-right">
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

                    <button  type="reset" onclick="location.href = './addtoCart.html?mathuoc=${thuocControl.thuoc.mathuoc}&url=product-details'" class="btn btn-fefault cart">
                        <i class="fa fa-shopping-cart"></i>
                        Add to cart
                    </button>
                </span>
                ${shopController.p.shopId.shopName}
                <p><b>Số lượng trong kho :</b> 
                    <c:choose>
                        <c:when test="${product.quantity==0}">Hết hàng</c:when>                   
                        <c:otherwise>Còn hàng</c:otherwise>
                    </c:choose>
                </p>
                <p><b>Tình Trạng :</b> Mới nhập</p>
                <p><b>Loại sản phẩm :</b> ${product.categoryId.categoryName}</p>
                <p>
                    <s:url value="/Public/showProductOfShop?shopname=${product.shopId.shopName}" var="productofshop"/>
                    <b>Shop bán:</b> 
                    <a href="${productofshop}"> ${product.shopId.shopName}</a>
                </p>
                <p>

                    <b>Các Shop bán mặt hàng tương tự:</b> 
                    <c:forEach items="${listShopSellProduct}" var="listShopSellProduct">
                        <s:url value="/Public/showProductOfShop?shopname=${listShopSellProduct.shopName}" var="productofshop"/>
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


    <div class="category-tab shop-details-tab"><!--category-tab-->

        <div class="col-sm-12">
            <ul class="nav nav-tabs">
                <li><a href=".details" data-toggle="tab">Thông tin SP</a></li>
                <li><a href=".companyprofile" data-toggle="tab">Sản phẩm cùng loại</a></li>
                <li class="active"><a href="#reviews" data-toggle="tab">Nhận xét đánh giá (5)</a></li>
            </ul>
        </div>

        <!--facebook-->
        <div class="tab-content">							
            <div class="tab-pane fade active in" id="reviews" >
                <div class="col-sm-12">
                    <ul>
                        <li><a href=""><i class="fa fa-user"></i>EUGEN</a></li>
                        <li><a href=""><i class="fa fa-clock-o"></i>12:41 PM</a></li>
                        <li><a href=""><i class="fa fa-calendar-o"></i>31 DEC 2014</a></li>
                    </ul>
                    <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur.</p>
                    <p><b>Write Your Review</b></p>

                    <form action="#">
                        <span>
                            <input type="text" placeholder="Your Name"/>
                            <input type="email" placeholder="Email Address"/>
                        </span>
                        <textarea name="" ></textarea>
                        <b>Rating: </b> <img src="${pageContext.request.contextPath}/images/product-details/rating.png" alt="" />
                        <button type="button" class="btn btn-default pull-right">
                            Submit
                        </button>
                    </form>


                    <div class="response-area">
                        <ul class="media-list">
                            <li class="media">

                                <a class="pull-left" href="#">
                                    <img class="media-object" src="${pageContext.request.contextPath}/images/blog/man-two.jpg" alt="">
                                </a>
                                <div class="media-body">
                                    <ul class="sinlge-post-meta">
                                        <li><i class="fa fa-user"></i>Janis Gallagher</li>
                                        <li><i class="fa fa-clock-o"></i> 1:33 pm</li>
                                        <li><i class="fa fa-calendar"></i> DEC 5, 2013</li>
                                    </ul>
                                    <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.  Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.</p>
                                    <a class="btn btn-primary" href=""><i class="fa fa-reply"></i>Replay</a>
                                </div>
                            </li>
                            <li class="media">

                                <a class="pull-left" href="#">
                                    <img class="media-object" src="${pageContext.request.contextPath}/images/blog/man-two.jpg" alt="">
                                </a>
                                <div class="media-body">
                                    <ul class="sinlge-post-meta">
                                        <li><i class="fa fa-user"></i>Janis Gallagher</li>
                                        <li><i class="fa fa-clock-o"></i> 1:33 pm</li>
                                        <li><i class="fa fa-calendar"></i> DEC 5, 2013</li>
                                    </ul>
                                    <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.  Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.</p>
                                    <a class="btn btn-primary" href=""><i class="fa fa-reply"></i>Replay</a>
                                </div>
                            </li>
                        </ul>
                    </div>
                    <a href="" class="btn btn-primary">xem them</a>
<!--                    <div class="fb-comments" data-href="http://chatvl.tv/v/355659" data-numposts="5"></div>-->


                </div>
            </div>


            <div class="tab-pane fade details" id="reviews" >
                <div class="col-sm-12">
                    <p>
                        ${product.description}
                    </p>
                </div>
            </div>

            <div class="tab-pane fade companyprofile" id="reviews" >
                <div class="col-sm-12">

                </div>
            </div>

        </div>

    </div><!--/category-tab-->


</div>