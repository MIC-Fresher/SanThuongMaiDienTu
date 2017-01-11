<%-- 
    Document   : starter
    Created on : May 22, 2016, 10:18:07 PM
    Author     : Asus
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <title>AdminLTE 2 | Starter</title>
        <!-- Tell the browser to be responsive to screen width -->
        <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
        <!-- Bootstrap 3.3.6 -->
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css">
        <!-- Font Awesome -->
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/font-awesome.min.css">
        <!-- Ionicons -->
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/ionicons.min.css">
        <!-- Theme style -->
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/AdminLTE.min.css">
        <!-- AdminLTE Skins. We have chosen the skin-blue for this starter
              page. However, you can choose any other skin. Make sure you
              apply the skin class to the body tag so the changes take effect.
        -->
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/skin-blue.min.css">

        <script src="${pageContext.request.contextPath}/js/jQuery-2.2.0.min.js"></script>
        <!-- Bootstrap 3.3.6 -->
        <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
        <!-- AdminLTE App -->
        <script src="${pageContext.request.contextPath}/js/app.min.js"></script>
    </head>
    <!--
    
    -->
    <body class="hold-transition skin-blue sidebar-mini">
        <c:if test="${not empty messeger}">
            <script>
                alert("${messeger}");
            </script>
        </c:if>
        <div class="wrapper">

            <!-- Main Header -->
            <jsp:include page="/WEB-INF/Include/Supplier/header_footer/header.jsp"/>
            <!-- Left side column. contains the logo and sidebar -->
            <jsp:include page="/WEB-INF/Include/Supplier/sliderbar/sliderbar.jsp"/>
            <!-- Content Wrapper. Contains page content -->
            <div class="content-wrapper">
                <!-- Content Header (Page header) -->
                <section class="content-header">

                    <ol class="breadcrumb">
                        <li><a href="#"><i class="fa fa-dashboard"></i> Level</a></li>
                        <li class="active">Here</li>
                    </ol>
                </section>
                <section class="content-header">

                    <jsp:include page="/WEB-INF/Include/Supplier/form/searchformforshops.jsp"></jsp:include>
                    </section>

                    <!-- Main content -->
                    <!------------------------------------------------------------------------------------------------------->
                    <section class="content">
                        <div class="row">
                            <div class="col-xs-12">
                                <div class="box">
                                <jsp:include page="/WEB-INF/Include/Supplier/sliderbar/boxheader.jsp"></jsp:include>

                                    <!-- /.box-header -->
                                    <div class="box-body">
                                    

                                    <c:if test="${not empty listSearchShops.content}">
                                        <jsp:include page="/WEB-INF/Include/Supplier/table/TableSearchShops.jsp"></jsp:include>
                                        <jsp:include page="/WEB-INF/Include/Supplier/table/PagingSearchShops.jsp"></jsp:include>
                                    </c:if>

                                </div>
                                <!-- /.box-body -->
                            </div>

                        </div>
                        <c:if test="${not empty shopDetail}">

                            <jsp:include page="/WEB-INF/Include/Supplier/table/TableDetailShop.jsp"></jsp:include>
                            <jsp:include page="/WEB-INF/Include/Supplier/table/TableCategoriesOfShop.jsp"></jsp:include>
                            <jsp:include page="/WEB-INF/Include/Supplier/form/setroleshop.jsp"></jsp:include>

                        </c:if>

                        <!-- /.col -->
                    </div>
                    <!-- /.row -->




                </section>
                <!------------------------------------------------------------------------------------------------->
                <!-- /.content -->
            </div>
            <!-- /.content-wrapper -->

            <!-- Main Footer -->
            <jsp:include page="/WEB-INF/Include/Supplier/header_footer/footer.jsp"/> 

            <!-- Control Sidebar -->
            <jsp:include page="/WEB-INF/Include/Supplier/sliderbar/controlslidebar.jsp"/>
            <!-- /.control-sidebar -->
            <!-- Add the sidebar's background. This div must be placed
                 immediately after the control sidebar -->
            <div class="control-sidebar-bg"></div>
        </div>
        <!-- ./wrapper -->


    </body>
</html>
