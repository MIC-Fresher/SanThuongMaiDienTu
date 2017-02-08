<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="description" content="">
        <meta name="author" content="">
        <title>Home | E-Shopper</title>
        <!--        <link rel="stylesheet" href="webjars/bootstrap/3.3.7/css/bootstrap.min.css" />-->
        <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">
        <link href="${pageContext.request.contextPath}/css/font-awesome.min.css" rel="stylesheet">
        <link href="${pageContext.request.contextPath}/css/prettyPhoto.css" rel="stylesheet">
        <link href="${pageContext.request.contextPath}/css/price-range.css" rel="stylesheet">
        <link href="${pageContext.request.contextPath}/css/animate.css" rel="stylesheet">
        <link href="${pageContext.request.contextPath}/css/main.css" rel="stylesheet">
        <link href="${pageContext.request.contextPath}/css/responsive.css" rel="stylesheet">
        <link href="${pageContext.request.contextPath}/css/style.css" rel="stylesheet">
        <!--[if lt IE 9]>
        <script src="js/html5shiv.js"></script>
        <script src="js/respond.min.js"></script>
        <![endif]-->       
        <link rel="shortcut icon" href="${pageContext.request.contextPath}/images/ico/favicon.ico">
        <link rel="apple-touch-icon-precomposed" sizes="144x144" href="${pageContext.request.contextPath}/images/ico/apple-touch-icon-144-precomposed.png">
        <link rel="apple-touch-icon-precomposed" sizes="114x114" href="${pageContext.request.contextPath}/images/ico/apple-touch-icon-114-precomposed.png">
        <link rel="apple-touch-icon-precomposed" sizes="72x72" href="${pageContext.request.contextPath}/images/ico/apple-touch-icon-72-precomposed.png">
        <link rel="apple-touch-icon-precomposed" href="${pageContext.request.contextPath}/images/ico/apple-touch-icon-57-precomposed.png">

    </head><!--/head-->

    <body>
        <script src="${pageContext.request.contextPath}/js/jquery.js"></script>
        <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/jquery.scrollUp.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/price-range.js"></script>
        <script src="${pageContext.request.contextPath}/js/jquery.prettyPhoto.js"></script>
        <script src="${pageContext.request.contextPath}/js/main.js"></script>
        <div class="wrapper">
            <c:if test="${not empty messeger}">
                <script>
                    alert("${messeger}");
                </script>
            </c:if>
            <!--header-->
            <jsp:include page="/WEB-INF/Include/Public/sections/header_footer/header.jsp"/>

            <!--slider-->
            <div class="content-wrapper">
                <!--content-->
                <section>
                    <div class="container">
                        <div class="row">
                            <div class="col-sm-3">
                                <div class="left-sidebar">
                                    <jsp:include page="/WEB-INF/Include/Public/sections/component/sliderbar/categoriesbar.jsp"/>
                                    <c:if test="${not empty listShops}">
                                        <jsp:include page="/WEB-INF/Include/Public/sections/component/sliderbar/listshopbar.jsp"/>

                                    </c:if>
                                    <jsp:include page="/WEB-INF/Include/Public/sections/component/sliderbar/pricebar.jsp"/>
                                    <jsp:include page="/WEB-INF/Include/Public/sections/component/sliderbar/votingbar.jsp"/>
                                    <div class="shipping text-center"><!--shipping-->
                                        <img src="${pageContext.request.contextPath}/images/home/shipping.jpg" alt="" />
                                    </div><!--/shipping-->
                                </div>
                            </div>
                            <div class="col-sm-9 padding-right">
                                <jsp:include page="/WEB-INF/Include/Public/common/product/productdetail.jsp"/>
                                <div id="response_comment" class="category-tab shop-details-tab"><!--category-tab-->
                                    <div class="col-sm-12">
                                        <ul class="nav nav-tabs">
                                            <li>
                                                <a href="#details" data-toggle="tab">Thông tin SP</a>
                                            </li>
                                            <li>
                                                <a href="#companyprofile" data-toggle="tab">Sản phẩm cùng loại</a>
                                            </li>
                                            <li class="active">
                                                <a href="#reviews" data-toggle="tab">Bình luận về sản phẩm (5)</a>
                                            </li>
                                        </ul>
                                    </div>
                                    
                                    <div class="tab-content">							
                                        <div class="tab-pane fade active in" id="reviews" >
                                            <div class="col-sm-12">
                                               
                                                <jsp:include page="/WEB-INF/Include/User/vote/vote_form.jsp"/>
                                                <jsp:include page="/WEB-INF/Include/User/comment/comment_form.jsp"/>
                                                <jsp:include page="/WEB-INF/Include/User/comment/comment_items.jsp"/>

                                            </div>


                                            <!--                    <div class="fb-comments" data-href="http://chatvl.tv/v/355659" data-numposts="5"></div>-->
                                        </div>
                                        <div class="tab-pane fade" id="details">
                                            <div class="col-sm-12">
                                                <p>
                                                    ${product.description}
                                                </p>
                                            </div>
                                        </div>

                                        <div class="tab-pane fade companyprofile"  id="companyprofile">
                                            <div class="col-sm-12">

                                            </div>
                                        </div>
                                    </div>
                              
                                </div>
                            </div>
                        </div>
                    </div>
                </section>
            </div>
            <!--footer-->
            <jsp:include page="/WEB-INF/Include/Public/sections/header_footer/footer.jsp"/>
        </div>
    </body>
</html>