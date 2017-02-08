

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<!DOCTYPE html>
<html lang="en">

    <head>
        <title>Thương mại điện tử</title>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <meta name="keywords" content="Smart Bazaar Responsive web template, Bootstrap Web Templates, Flat Web Templates, Android Compatible web template, 
              SmartPhone Compatible web template, free WebDesigns for Nokia, Samsung, LG, SonyEricsson, Motorola web design" />
        <script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false);
            function hideURLbar(){ window.scrollTo(0,1); } </script>
        <!-- Custom Theme files -->
        <link href="${pageContext.request.contextPath}/css/bootstrap.css" rel="stylesheet" type="text/css" media="all" />
        <link href="${pageContext.request.contextPath}/css/style.css" rel="stylesheet" type="text/css" media="all" /> 
        <link href="${pageContext.request.contextPath}/css/animate.min.css" rel="stylesheet" type="text/css" media="all" /><!-- animation -->
        <link href="${pageContext.request.contextPath}/css/menu.css" rel="stylesheet" type="text/css" media="all" /> <!-- menu style -->  
        <!-- //Custom Theme files -->
        <!-- font-awesome icons -->
        <link href="${pageContext.request.contextPath}/css/font-awesome.css" rel="stylesheet"> 
        <!-- //font-awesome icons -->
        <!-- js -->
        <script src="${pageContext.request.contextPath}/js/jquery-2.2.3.min.js"></script> 
        <script src="${pageContext.request.contextPath}/js/jquery-scrolltofixed-min.js" type="text/javascript"></script><!-- fixed nav js -->
        <script src="${pageContext.request.contextPath}/js/jquery.menu-aim.js"></script>
        <script src="${pageContext.request.contextPath}/js/main.js"></script> <!-- Resource jQuery -->
        <!-- //menu js aim --> 
        <!-- Bootstrap core JavaScript
    ================================================== -->
        <!-- Placed at the end of the document so the pages load faster -->
        <script src="${pageContext.request.contextPath}/js/bootstrap.js"></script>


        <script>
            $(document).ready(function () {

                // Dock the header to the top of the window when scrolled past the banner. This is the default behaviour.

                $('.header-two').scrollToFixed();
                // previous summary up the page.

                var summaries = $('.summary');
                summaries.each(function (i) {
                    var summary = $(summaries[i]);
                    var next = summaries[i + 1];

                    summary.scrollToFixed({
                        marginTop: $('.header-two').outerHeight(true) + 10,
                        zIndex: 999
                    });
                });
            });
        </script>
        <!-- //js --> 
        <!-- web-fonts -->
        <!--        <link href='//fonts.googleapis.com/css?family=Roboto+Condensed:400,300,300italic,400italic,700,700italic' rel='stylesheet' type='text/css'>
                <link href='//fonts.googleapis.com/css?family=Lovers+Quarrel' rel='stylesheet' type='text/css'>
                <link href='//fonts.googleapis.com/css?family=Offside' rel='stylesheet' type='text/css'> -->
        <!-- web-fonts -->  
        <!-- start-smooth-scrolling -->
        <script type="text/javascript" src="${pageContext.request.contextPath}/js/move-top.js"></script>
        <script type="text/javascript" src="${pageContext.request.contextPath}/js/easing.js"></script>	
        <script type="text/javascript">
            jQuery(document).ready(function ($) {
                $(".scroll").click(function (event) {
                    event.preventDefault();
                    $('html,body').animate({scrollTop: $(this.hash).offset().top}, 1000);
                });
            });
        </script>
        <!-- //end-smooth-scrolling -->
        <!-- smooth-scrolling-of-move-up -->
        <script type="text/javascript">
            $(document).ready(function () {

                var defaults = {
                    containerID: 'toTop', // fading element id
                    containerHoverID: 'toTopHover', // fading element hover id
                    scrollSpeed: 1200,
                    easingType: 'linear'
                };

                $().UItoTop({easingType: 'easeOutQuart'});

            });
        </script>
        <!-- //smooth-scrolling-of-move-up -->
    </head><!--/head-->

    <body>


        <c:if test="${not empty messeger}">
            <script>
                alert("${messeger}");
            </script>
        </c:if>



        <!-- login-page -->
        <div class="login-page">
            <div class="container"> 
                <h3 class="w3ls-title w3ls-title1">Login to your account</h3>  
                <div class="login-body">
                    <form:form method="POST"  id="contact">
                        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>

                        <input name="user" class="lock" required="true"  id="name" type="text"  placeholder="email" />
                        <input name="pass" class="user" required="true" id="pass" type="password"  placeholder="Password" />


                        <input onclick="form.action = 'User/j_spring_security_check';"  type="submit" value="Login">
                        <div class="forgot-grid">
                            <label class="checkbox"><input type="checkbox" name="checkbox"><i></i>Remember me</label>
                            <div class="forgot">
                                <a href="#">Forgot Password?</a>
                            </div>
                            <div class="clearfix"> </div>
                        </div>
                    </form:form>
                </div>  
                <c:if test="${not empty SPRING_SECURITY_LAST_EXCEPTION}">
                    <p style=" color: red">
                        ban dang nhap sai roi 
                        <c:out value="${SPRING_SECURITY_LAST_EXCEPTION}"/>
                    </p>

                </c:if>
                <h6> Not a Member? <a href="Public/setupSignUp">Sign Up Now »</a> </h6> 
                <div class="login-page-bottom social-icons">
                    <h5>Recover your social account</h5>
                    <ul>
                        <li><a href="#" class="fa fa-facebook icon facebook"> </a></li>
                        <li><a href="#" class="fa fa-twitter icon twitter"> </a></li>
                        <li><a href="#" class="fa fa-google-plus icon googleplus"> </a></li>
                        <li><a href="#" class="fa fa-dribbble icon dribbble"> </a></li>
                        <li><a href="#" class="fa fa-rss icon rss"> </a></li> 
                    </ul> 
                </div>
            </div>
        </div>
        <!-- //login-page --> 



        <script src="${pageContext.request.contextPath}/js/minicart.js"></script>
        <script>
                            w3ls.render();

                            w3ls.cart.on('w3sb_checkout', function (evt) {
                                var items, len, i;

                                if (this.subtotal() > 0) {
                                    items = this.items();

                                    for (i = 0, len = items.length; i < len; i++) {
                                        items[i].set('shipping', 0);
                                        items[i].set('shipping2', 0);
                                    }
                                }
                            });
        </script>  
        <!-- //cart-js --> 	 
        <!-- menu js aim -->




    </body>
</html>