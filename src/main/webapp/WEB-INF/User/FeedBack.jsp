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
        <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.js"></script>
        <script src="${pageContext.request.contextPath}/js/jQuery-2.2.0.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/jquery.scrollUp.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/price-range.js"></script>
        <script src="${pageContext.request.contextPath}/js/jquery.prettyPhoto.js"></script>
        <script src="${pageContext.request.contextPath}/js/main.js"></script>

    </head><!--/head-->

    <body>

        <div class="wrapper">
            <c:if test="${not empty messeger}">
                <script>
                    alert("${messeger}");
                </script>
            </c:if>
            <!--header-->
            <jsp:include page="/WEB-INF/Include/Public/sections/header_footer/header.jsp"/>

            <!--slider-->
            <div id="contact-page" class="container">
                <div class="bg">
                    <div class="row">    		
                        <div class="col-sm-12">    			   			
                            <h2 class="title text-center">Liên hệ <strong>chúng tôi</strong></h2>    			    				    				
                            <div  class="contact-map">
                                <iframe src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d3833.9588979385185!2d108.23031465012637!3d16.067622543695006!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x3142182bedf8aab7%3A0xc38028d0c4697fd3!2zQ-G7rWEgSMOgbmcgVGh14buRYyBUw6J5IDU4NQ!5e0!3m2!1sen!2sus!4v1479453604672"  frameborder="0" style="border:0 ;width: 100%;height: 385px" allowfullscreen></iframe>
                            </div>
                        </div>			 		
                    </div>    	
                    <div class="row">  	
                        <jsp:include page="/WEB-INF/Include/User/feedback/feedback_form.jsp"/>
                        <jsp:include page="/WEB-INF/Include/User/feedback/supplier_infomation.jsp"/> 			
                    </div>  
                </div>	
            </div><!--/#contact-page-->
            <!--footer-->
            <jsp:include page="/WEB-INF/Include/Public/sections/header_footer/footer.jsp"/>



        </div>





    </body>
</html>