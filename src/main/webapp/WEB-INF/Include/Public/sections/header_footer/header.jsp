

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<header id="header"><!--header-->
    <div class="header_top"><!--header_top-->
        <div class="container">
            <div class="row">
                <div class="col-sm-6">
                    <div class="contactinfo">
                        <ul class="nav nav-pills">
                            <li><a href="#"><i class="fa fa-phone"></i> +2 95 01 88 821</a></li>
                            <li><a href="#"><i class="fa fa-envelope"></i> info@domain.com</a></li>
                        </ul>
                    </div>
                </div>
                <div class="col-sm-6">
                    <div class="social-icons pull-right">
                        <ul class="nav navbar-nav">
                            <li><a href="#"><i class="fa fa-facebook"></i></a></li>
                            <li><a href="#"><i class="fa fa-twitter"></i></a></li>
                            <li><a href="#"><i class="fa fa-linkedin"></i></a></li>
                            <li><a href="#"><i class="fa fa-dribbble"></i></a></li>
                            <li><a href="#"><i class="fa fa-google-plus"></i></a></li>
                        </ul>
                    </div>
                </div>
            </div>
        </div>
    </div><!--/header_top-->

    <div class="header-middle"><!--header-middle-->
        <div class="container">
            <div class="row">
                <div class="col-sm-7">
                    <s:url value="/setupIndex" var="index"/>
                    <div class="logo pull-left">
                        <a href="${index}"><img src="${pageContext.request.contextPath}/images/shop/logo1.png" alt="" /></a>
                    </div>

                </div>
                <div class="col-sm-5">
                    <div class="shop-menu pull-right">
                        <ul class="nav navbar-nav">

                            <li>

                                <s:url value="/Public/shoppingCart" var="cartshop"/>
                                <a href="${cartshop}">
                                    <i class="fa fa-shopping-cart"></i> 
                                    Giỏ hàng 

                                    (<label id="cart_status">
                                        <c:if test="${sessionScope.myCart!=null}">
                                            ${sessionScope.myCart.cartLines.size()}
                                        </c:if>
                                    </label>)
                                </a>

                            </li>

                            <sec:authentication property="principal" var="userlogin" scope="request"/>

                            <sec:authorize access="hasAnyRole('ROLE_USER,ROLE_SHOP')">
                                <c:set value="login" var="checklogin" scope="request"/>
                            </sec:authorize>
                            
                            
                            <c:choose>
                                <c:when test="${checklogin!='login'}">
                                    <li>
                                        <s:url value="/User/index" var="loginuser"/>
                                        <a href="${loginuser}"><i class="fa fa-lock"></i> Đăng nhập</a>
                                    </li>
                                </c:when>
                                <c:otherwise>
                                    <li>
                                        <s:url value="/User/InformationAccount" var="infomationpage"/>
                                        <a href="${infomationpage}"><i class="fa fa-user"></i> ${userlogin.username}</a>
                                    </li>
                                    <li>
                                        <s:url value="/User/logout" var="logoutuser"/>
                                        <a href="${logoutuser}"><i class="fa fa-lock"></i> Đăng xuất</a>
                                    </li>
                                </c:otherwise>
                            </c:choose>

                        </ul>
                    </div>
                </div>
            </div>
        </div>
    </div><!--/header-middle-->

    <div class="header-bottom"><!--header-bottom-->
        <div class="container">
            <div class="row">
                <div class="col-sm-9">
                    <div class="navbar-header">
                        <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                            <span class="sr-only">Toggle navigation</span>
                            <span class="icon-bar"></span>
                            <span class="icon-bar"></span>
                            <span class="icon-bar"></span>
                        </button>
                    </div>
                    <div class="mainmenu pull-left">
                        <ul class="nav navbar-nav collapse navbar-collapse">

                            <li><a href="${index}" class="active">Trang chủ</a></li>

                            <li class="dropdown"><a href="#">Cửa hàng<i class="fa fa-angle-down"></i></a>
                                <ul role="menu" class="sub-menu">
                                    <li><a href="#">Products</a></li>
                                    <li><a href="#">Product Details</a></li> 
                                    <li><a href="${cartshop}">Giỏ hàng</a></li> 

                                </ul>
                            </li> 
                            <li class="dropdown"><a href="#">Blog<i class="fa fa-angle-down"></i></a>
                                <ul role="menu" class="sub-menu">
                                    <li><a href="#">Blog List</a></li>
                                    <li><a href="#">Blog Single</a></li>
                                </ul>
                            </li> 
                            <li>
                                <s:url value="/User/FeedBack" var="feedback"/>
                                <a href="${feedback}">Liên hệ & Phản hồi</a>
                            </li>
                        </ul>
                    </div>
                </div>
                <div class="col-sm-3">
                    <div class="search_box pull-right">
                        <s:url value="/Public/searchAllProducts" var="searchform"/>
                        <form action="${searchform}" method="get" >

                            <input name="searchinput" type="text"   placeholder="Search...">

                        </form>

                    </div>

                </div>
            </div>
        </div>
    </div><!--/header-bottom-->
</header><!--/header-->
