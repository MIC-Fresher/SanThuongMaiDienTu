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
                <section id="cart_items">
                    <div class="container">
                        <jsp:include page="/WEB-INF/Include/Public/sections/breadcrumbs/breadcrumbs.jsp"/>
                        <c:if test="${empty cartForm or empty cartForm.cartLines}">
                            <h2>Không có món hàng nào trong giỏ hàng</h2>
                            <s:url value="/setupIndex" var="index"/>
                            <a href="${index}">về lại trang chủ</a>

                        </c:if>
                        <c:if test="${not empty cartForm and not empty cartForm.cartLines }">
                            <jsp:include page="/WEB-INF/Include/Public/common/cart/cartitems.jsp"/>
                        </c:if>
                    </div>
                </section>
                <section id="do_action">
                    <div class="container">
                        <div class="row">
                            <c:if test="${not empty cartForm and not empty cartForm.cartLines }">
                                <jsp:include page="/WEB-INF/Include/Public/common/cart/cartaction.jsp"/>
                            </c:if>
                        </div>
                    </div>
                </section><!--/#do_action-->
            </div>
            <!--footer-->
            <jsp:include page="/WEB-INF/Include/Public/sections/header_footer/footer.jsp"/>
        </div>
    </body>
</html>