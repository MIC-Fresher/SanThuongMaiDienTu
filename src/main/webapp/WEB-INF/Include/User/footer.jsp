<%-- 
    Document   : footer
    Created on : Jan 2, 2017, 6:28:19 PM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
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
        <link href='//fonts.googleapis.com/css?family=Roboto+Condensed:400,300,300italic,400italic,700,700italic' rel='stylesheet' type='text/css'>
        <link href='//fonts.googleapis.com/css?family=Lovers+Quarrel' rel='stylesheet' type='text/css'>
        <link href='//fonts.googleapis.com/css?family=Offside' rel='stylesheet' type='text/css'> 
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
        <div class="footer">
		<div class="container">
			<div class="footer-info w3-agileits-info">
				<div class="col-md-4 address-left agileinfo">
					<div class="footer-logo header-logo">
						<h2><a href="index.html"><span>S</span>pringShop</a></h2>
					</div>
					<ul>
						<li><i class="fa fa-map-marker"></i> 123 Quang Trung, Tp. Đà Nẵng</li>
						<li><i class="fa fa-mobile"></i> 333 222 3333 </li>
						<li><i class="fa fa-phone"></i> +222 11 4444 </li>
						<li><i class="fa fa-envelope-o"></i> <a href="mailto:example@mail.com"> mail@example.com</a></li>
					</ul> 
				</div>
				<div class="col-md-8 address-right">
					<div class="col-md-4 footer-grids">
						<h3>Spring Việt Nam</h3>
						<ul>
							<li><a href="about.html">Thông tin về chúng tôi</a></li>
							<li><a href="marketplace.html">Marketplace</a></li>  
							<li><a href="values.html">Core Values</a></li>  
							<li><a href="privacy.html">Điều khoản</a></li>
						</ul>
					</div>
					<div class="col-md-4 footer-grids">
						<h3>Services</h3>
						<ul>
							<li><a href="contact.html">Liên hệ với chúng tôi</a></li>
							<li><a href="login.html">Returns</a></li> 
							<li><a href="faq.html">FAQ</a></li>
							<li><a href="sitemap.html">Site Map</a></li>
							<li><a href="login.html">Trạng thái đơn hàng</a></li>
						</ul> 
					</div>
					<div class="col-md-4 footer-grids">
						<h3>Phương thức thanh toán</h3>
						<ul>
							<li><i class="fa fa-laptop" aria-hidden="true"></i> Net Banking</li>
							<li><i class="fa fa-money" aria-hidden="true"></i> Cash On Delivery</li>
							<li><i class="fa fa-pie-chart" aria-hidden="true"></i>EMI Conversion</li>
							<li><i class="fa fa-gift" aria-hidden="true"></i> E-Gift Voucher</li>
							<li><i class="fa fa-credit-card" aria-hidden="true"></i> Debit/Credit Card</li>
						</ul>  
					</div> -->
					<div class="clearfix"></div>
				</div>
				<div class="clearfix"></div>
			</div>
		</div>
	</div>
	<!-- //footer -->		
	<div class="copy-right"> 
		<div class="container">
			<p>© 2016 Spring shop . All rights reserved | Design by <a href="http://w3layouts.com"> W3layouts.</a></p>
		</div>
	</div>
    </body>
</html>
