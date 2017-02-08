<%-- 
    Document   : main
    Created on : May 22, 2016, 6:14:14 PM
    Author     : Asus
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
    <head>
        <title>ADMIN MANAGER</title>
        <link rel="stylesheet" href="webjars/bootstrap/3.3.7/css/bootstrap.min.css" />
        <spring:url value="/css/bootstrap.css" var="bootstrap" />
        <link href="${bootstrap}" rel="stylesheet" />
<!--        <link href="${pageContext.request.contextPath}/css/bootstrap.css" type="text/css" rel="stylesheet" media="all">-->
        <link href="${pageContext.request.contextPath}/css/style.css" type="text/css" rel="stylesheet" media="all">
        <link href="${pageContext.request.contextPath}/css/loginGG.css" type="text/css" rel="stylesheet" media="all">
        <link href="${pageContext.request.contextPath}/css/AdminLTE.min.css" type="text/css" rel="stylesheet" media="all">
        <!--web-font-->
        <link href='http://fonts.googleapis.com/css?family=Neuton:200,300,400,700,800,400italic' rel='stylesheet' type='text/css'>
        <!--//web-font-->
        <!-- Custom Theme files -->
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <meta name="keywords" content="Pabulum Responsive web template, Bootstrap Web Templates, Flat Web Templates, Andriod Compatible web template, 
              Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyErricsson, Motorola web design" />
        <script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
        <script src="http://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
        <!-- //Custom Theme files -->
        <!-- js -->
        <script src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/modernizr.custom.js"></script>
        <!-- //js -->	
        <!-- start-smoth-scrolling-->
        <script type="text/javascript" src="${pageContext.request.contextPath}/js/move-top.js"></script>
        <script type="text/javascript" src="${pageContext.request.contextPath}/js/loginGG.js"></script>
        <script type="text/javascript" src="${pageContext.request.contextPath}/js/easing.js"></script>	
        <script type="text/javascript" src="${pageContext.request.contextPath}/js/modernizr.custom.53451.js"></script>
        <script type="text/javascript">
            jQuery(document).ready(function ($) {
                $(".scroll").click(function (event) {
                    event.preventDefault();
                    $('html,body').animate({scrollTop: $(this.hash).offset().top}, 1000);
                });
            });
        </script>
        <script>
            $(document).ready(function () {
                size_li = $("#myList li").size();
                x = 1;
                $('#myList li:lt(' + x + ')').show();
                $('#loadMore').click(function () {
                    x = (x + 1 <= size_li) ? x + 1 : size_li;
                    $('#myList li:lt(' + x + ')').show();
                });
                $('#showLess').click(function () {
                    x = (x - 1 < 0) ? 1 : x - 1;
                    $('#myList li').not(':lt(' + x + ')').hide();
                });
            });
        </script>
        <script src="https://apis.google.com/js/client:platform.js?onload=renderButton" async defer></script>

        <!--//end-smoth-scrolling-->
    </head>
    <body class="hold-transition login-page">
        <div class="login-box">
            <div class="login-logo">
                <a href="../../index2.html"><b>ADMIN</b>LTE</a>
            </div>
            <!-- /.login-logo -->
            <div class="login-box-body">
                <p class="login-box-msg">Sign in to start your session</p>

                <form:form method="POST"  id="contact" >
                    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                    <div class="form-group has-feedback">
                        <input name="user" required="true"   id="name" type="text" class="form-control" placeholder="Tên" />
                        
                    </div>
                    <div class="form-group has-feedback">
                        <input name="pass" required="true" id="pass" type="password" class="form-control" placeholder="Password" />
                        
                    </div>
                    <div class="row">
                        <div class="col-xs-8">
                            <div class="checkbox icheck">
                                <label>
                                    <input  type="checkbox"> Remember Me
                                </label>
                            </div>
                        </div>
                        <!-- /.col -->
                        <div class="col-xs-4">
                            
                            <button id="add" class="btn btn-primary btn-block btn-flat" onclick="form.action='Supplier/j_spring_security_check';" > Đăng nhập </button>
                        </div>
                        <!-- /.col -->
                    </div>
                </form:form>
                 <c:if test="${not empty SPRING_SECURITY_LAST_EXCEPTION}">
                <p style=" color: red">
                    ban dang nhap sai roi 
                    <c:out value="${SPRING_SECURITY_LAST_EXCEPTION}"/>
                </p>
                
            </c:if>
               
                <!-- /.social-auth-links -->

                <a href="#">I forgot my password</a><br>
                <a href="register.html" class="text-center">Register a new membership</a>

            </div>
            <!-- /.login-box-body -->
        </div>
        <!-- /.login-box -->

        <!-- jQuery 2.2.0 -->
        <script src="../../plugins/jQuery/jQuery-2.2.0.min.js"></script>
        <!-- Bootstrap 3.3.6 -->
        <script src="../../bootstrap/js/bootstrap.min.js"></script>
        <!-- iCheck -->
        <script src="../../plugins/iCheck/icheck.min.js"></script>
        <script>
            $(function () {
                $('input').iCheck({
                    checkboxClass: 'icheckbox_square-blue',
                    radioClass: 'iradio_square-blue',
                    increaseArea: '20%' // optional
                });
            });
        </script>
    </body>
</html>
