<%-- 
    Document   : header
    Created on : Jan 2, 2017, 6:25:17 PM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!--include header-->
<div class="agileits-modal modal fade" id="myModal88" tabindex="-1" role="dialog" aria-labelledby="myModal88"
     aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4 class="modal-title" id="myModalLabel"><i class="fa fa-map-marker" aria-hidden="true"></i> Location</h4>
            </div>
            <div class="modal-body modal-body-sub"> 
                <h5>Vị trí của bạn</h5>  
                <select class="form-control bfh-states" data-country="US" data-state="CA">
                    <option value="">Thành phố</option>
                    <option value="AL">Alabama</option>
                    <option value="AK">Alaska</option>
                    <option value="AS">American Samoa</option>
                    <option value="AZ">Arizona</option>
                    <option value="AR">Arkansas</option>
                </select>
                <h5>Chọn cửa hàng gần bạn</h5>
                <select class="form-control bfh-states" data-country="US" data-state="CA">
                    <option value="">Cửa hàng</option>
                    <option value="AL">Alabama</option>
                    <option value="AK">Alaska</option>
                    <option value="AS">American Samoa</option>
                    <option value="AZ">Arizona</option>
                    <option value="AR">Arkansas</option>
                </select>
                <button type="button" class="close2" data-dismiss="modal" aria-hidden="true" style="margin-top: 20px;">Bắt đầu mua săm</button>
            </div>
        </div>
    </div>
</div>
<script>
    $('#myModal88').modal('show');
</script> 
<!-- header -->
<div class="header">
    <div class="w3ls-header"><!--header-one--> 
        <div class="w3ls-header-left">
            <p><a href="#">THỜI TRANG CHO CẢ NHÀ | MUA THỎA THÍCH </a></p>
        </div>
        <div class="w3ls-header-right">
            <ul>
                <li class="dropdown head-dpdn">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown"><i class="fa fa-user" aria-hidden="true"></i> Cá nhân<span class="caret"></span></a>
                    <ul class="dropdown-menu">
                        <li><a href="login.html">Đăng nhập </a></li> 
                        <li><a href="signup.html">Đăng ký</a></li> 
                        <li><a href="login.html">Đơn hàng của tôi</a></li> 
                    </ul> 
                </li> 
                <li class="dropdown head-dpdn">
                    <a href="contact.html" class="dropdown-toggle"><i class="fa fa-map-marker" aria-hidden="true"></i> Cửa hàng</a>
                </li> 
                <li class="dropdown head-dpdn">
                    <a href="help.html" class="dropdown-toggle"><i class="fa fa-question-circle" aria-hidden="true"></i> Trợ giúp</a>
                </li>
            </ul>
        </div>
        <div class="clearfix"> </div> 
    </div>
    <div class="header-two"><!-- header-two -->
        <div class="container">
            <div class="header-logo">
                <h1><a href="index.html"><span>S</span>pring</a></h1>
                <h6>Thời trang của gia đình bạn</h6> 
            </div>	
            <div class="header-search">
                <form action="#" method="post">
                    <input type="search" name="Search" placeholder="Tìm kiếm sản phẩm" required="">
                    <button type="submit" class="btn btn-default" aria-label="Left Align">
                        <i class="fa fa-search" aria-hidden="true"> </i>
                    </button>
                </form>
            </div>
            <div class="header-cart"> 
                <div class="my-account">
                    <a href="contact.html"><i class="fa fa-map-marker" aria-hidden="true"></i> CONTACT US</a>						
                </div>
                <div class="cart"> 
                    <form action="#" method="post" class="last"> 
                        <input type="hidden" name="cmd" value="_cart" />
                        <input type="hidden" name="display" value="1" />
                        <button class="w3view-cart" type="submit" name="submit" value=""><i class="fa fa-cart-arrow-down" aria-hidden="true"></i></button>
                    </form>  
                </div>
                <div class="clearfix"> </div> 
            </div> 
            <div class="clearfix"> </div>
        </div>		
    </div><!-- //header-two -->
    <div class="header-three"><!-- header-three -->
        <div class="container">
            <div class="menu">
                <div class="cd-dropdown-wrapper">
                    <a class="cd-dropdown-trigger" href="#0" style="font-family: 'tahoma', bold, cursive;">Danh mục sản phẩm</a>
                    <nav class="cd-dropdown"> 
                        <a href="#0" class="cd-close">Close</a>
                        <ul class="cd-dropdown-content"> 
                            <li class="has-children">
                                <a href="#">Thời trang cho bé</a> 
                                <ul class="cd-secondary-dropdown is-hidden">
                                    <li class="go-back"><a href="#">Menu</a></li>
                                    <li class="see-all"><a href="products1.html">All Fashion Stores</a></li>
                                    <li class="has-children">
                                        <a href="#">Bé gái</a> 
                                        <ul class="is-hidden">  
                                            <li class="go-back"><a href="#">All Fashion Stores</a></li>
                                            <li><a href="products1.html">Danh muc 1</a></li>
                                            <li><a href="products1.html">Danh muc 1</a></li>
                                            <li><a href="products1.html">Danh muc 1</a></li>
                                            <li><a href="products1.html">Danh muc 1</a></li>
                                            <li><a href="products1.html">Danh muc 1</a></li>
                                            <li><a href="products1.html">Danh muc 1</a></li>
                                        </ul>
                                    </li> 
                                    <li class="has-children">
                                        <a href="#">Bé trai</a> 
                                        <ul class="is-hidden">  
                                            <li class="go-back"><a href="#">All Fashion Stores</a></li>
                                            <li><a href="products1.html">Danh muc 1</a></li>  
                                            <li><a href="products1.html">Danh muc 1</a></li> 
                                            <li><a href="products1.html">Danh muc 1</a></li> 
                                            <li><a href="products1.html">Danh muc 1</a></li> 
                                            <li><a href="products1.html">Danh muc 1</a></li> 
                                        </ul>
                                    </li> 
                                    <li class="has-children">
                                        <a href="products1.html">Phụ kiện</a> 
                                        <ul class="is-hidden"> 
                                            <li class="go-back"><a href="#">All Fashion Stores</a></li>
                                            <li><a href="products1.html">Danh muc 1</a></li>
                                            <li><a href="products1.html">Danh muc 1</a></li>
                                            <li><a href="products1.html">Danh muc 1</a></li>
                                            <li><a href="products1.html">Danh muc 1</a></li>
                                            <li><a href="products1.html">Danh muc 1</a></li>   
                                        </ul>
                                    </li>
                                </ul> <!-- .cd-secondary-dropdown --> 
                            </li> <!-- .has-children -->
                            <li class="has-children">
                                <a href="products2.html">Thời trang nữ</a> 
                                <ul class="cd-secondary-dropdown is-hidden">
                                    <li class="go-back"><a href="#">Menu</a></li>
                                    <li class="see-all"><a href="products1.html">All Fashion Stores</a></li>
                                    <li class="has-children">
                                        <a href="#">Thời trang nữ</a> 
                                        <ul class="is-hidden">  
                                            <li class="go-back"><a href="#">All Fashion Stores</a></li>
                                            <li><a href="products1.html">Danh muc 1</a></li>
                                            <li><a href="products1.html">Danh muc 1</a></li>
                                            <li><a href="products1.html">Danh muc 1</a></li>
                                            <li><a href="products1.html">Danh muc 1</a></li>
                                            <li><a href="products1.html">Danh muc 1</a></li>
                                            <li><a href="products1.html">Danh muc 1</a></li>
                                        </ul>
                                    </li> 
                                    <li class="has-children">
                                        <a href="#">Phụ kiện</a> 
                                        <ul class="is-hidden">  
                                            <li class="go-back"><a href="#">All Fashion Stores</a></li>
                                            <li><a href="products1.html">Danh muc 1</a></li>  
                                            <li><a href="products1.html">Danh muc 1</a></li> 
                                            <li><a href="products1.html">Danh muc 1</a></li> 
                                            <li><a href="products1.html">Danh muc 1</a></li> 
                                            <li><a href="products1.html">Danh muc 1</a></li> 
                                        </ul>
                                    </li> 
                                </ul><!-- .cd-secondary-dropdown --> 
                            </li> <!-- .has-children --> 
                            <li class="has-children">
                                <a href="#">Thời trang nam</a> 
                                <ul class="cd-secondary-dropdown is-hidden">
                                    <li class="go-back"><a href="#">Menu</a></li>
                                    <li class="see-all"><a href="products1.html">All Fashion Stores</a></li>
                                    <li class="has-children">
                                        <a href="#">Thời trang nam</a> 
                                        <ul class="is-hidden">  
                                            <li class="go-back"><a href="#">All Fashion Stores</a></li>
                                            <li><a href="products1.html">Danh muc 1</a></li>
                                            <li><a href="products1.html">Danh muc 1</a></li>
                                            <li><a href="products1.html">Danh muc 1</a></li>
                                            <li><a href="products1.html">Danh muc 1</a></li>
                                            <li><a href="products1.html">Danh muc 1</a></li>
                                            <li><a href="products1.html">Danh muc 1</a></li>
                                        </ul>
                                    </li> 
                                    <li class="has-children">
                                        <a href="#">Phụ kiện</a> 
                                        <ul class="is-hidden">  
                                            <li class="go-back"><a href="#">All Fashion Stores</a></li>
                                            <li><a href="products1.html">Danh muc 1</a></li>  
                                            <li><a href="products1.html">Danh muc 1</a></li> 
                                            <li><a href="products1.html">Danh muc 1</a></li> 
                                            <li><a href="products1.html">Danh muc 1</a></li> 
                                            <li><a href="products1.html">Danh muc 1</a></li> 
                                        </ul>
                                    </li> 
                                </ul><!-- .cd-secondary-dropdown --> 
                            </li> <!-- .has-children -->
                            <li><a href="sitemap.html">Tất cả sản phẩm</a></li>  
                        </ul> <!-- .cd-dropdown-content -->
                    </nav> <!-- .cd-dropdown -->
                </div> <!-- .cd-dropdown-wrapper -->	 
            </div>
            <div class="move-text">
                <div class="marquee"><a href="#0">Nhiều sản phẩm mới <span>Khuyến mãi tưng bừng </span><span>Hệ thống cửa hàng lớn</span> </a></div>
                <script type="text/javascript" src="../js/jquery.marquee.min.js"></script>
                <script>
    $('.marquee').marquee({pauseOnHover: true});
//@ sourceURL=pen.js
                </script>
            </div>
        </div>
    </div>
</div>
<!-- //header -->
<!-- cart-js -->
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
<!-- countdown.js -->	
<script src="${pageContext.request.contextPath}/js/jquery.knob.js"></script>
<script src="${pageContext.request.contextPath}/js/jquery.throttle.js"></script>
<script src="${pageContext.request.contextPath}/js/jquery.classycountdown.js"></script>
<script>
    $(document).ready(function () {
        $('#countdown1').ClassyCountdown({
            end: '1388268325',
            now: '1387999995',
            labels: true,
            style: {
                element: "",
                textResponsive: .5,
                days: {
                    gauge: {
                        thickness: .10,
                        bgColor: "rgba(0,0,0,0)",
                        fgColor: "#1abc9c",
                        lineCap: 'round'
                    },
                    textCSS: 'font-weight:300; color:#fff;'
                },
                hours: {
                    gauge: {
                        thickness: .10,
                        bgColor: "rgba(0,0,0,0)",
                        fgColor: "#05BEF6",
                        lineCap: 'round'
                    },
                    textCSS: ' font-weight:300; color:#fff;'
                },
                minutes: {
                    gauge: {
                        thickness: .10,
                        bgColor: "rgba(0,0,0,0)",
                        fgColor: "#8e44ad",
                        lineCap: 'round'
                    },
                    textCSS: ' font-weight:300; color:#fff;'
                },
                seconds: {
                    gauge: {
                        thickness: .10,
                        bgColor: "rgba(0,0,0,0)",
                        fgColor: "#f39c12",
                        lineCap: 'round'
                    },
                    textCSS: ' font-weight:300; color:#fff;'
                }

            },
            onEndCallback: function () {
                console.log("Time out!");
            }
        });
    });
</script>
<!-- //countdown.js -->
<!-- menu js aim -->
<script src="${pageContext.request.contextPath}/js/jquery.menu-aim.js"></script>
<script src="${pageContext.request.contextPath}/js/main.js"></script> <!-- Resource jQuery -->
<!-- //menu js aim --> 

<!--include header-->