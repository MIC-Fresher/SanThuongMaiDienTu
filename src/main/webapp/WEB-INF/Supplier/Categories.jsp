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
        <!--model box-->
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/modalbox.css">
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
                <jsp:include page="/WEB-INF/Include/Public/common/alertmodal/alertmodal.jsp"/>
            <script>

                var modal = document.getElementById('Alert_Modal');
                modal.style.display = "block";
                var span_alert = document.getElementsByClassName("span_close_alert")[0];
                var btn_close_alert = document.getElementsByClassName("btn_close_alert")[0];
                //-----------
                btn_close_alert.onclick = function () {
                    modal.style.display = "none";
                }
                // When the user clicks on <span> (x), close the modal
                span_alert.onclick = function () {
                    modal.style.display = "none";
                }

                // When the user clicks anywhere outside of the modal, close it
                window.onclick = function (event) {
                    if (event.target == modal) {
                        modal.style.display = "none";
                    }
                }

                //alert("");
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
                    <h1>
                        Danh mục hàng hóa</h1>

                    <jsp:include page="/WEB-INF/Include/Supplier/categories/form/searchformforcategories.jsp"></jsp:include>

                        <ol class="breadcrumb">
                            <li><a href="#"><i class="fa fa-dashboard"></i> Level</a></li>
                            <li class="active">Here</li>
                        </ol>
                    </section>

                    <!-- Main content -->
                    <!------------------------------------------------------------------------------------------------------->
                    <section class="content">

                        <div class="row">
                            <div class="col-xs-12">
                                <div class="box">
                                    <div class="box-header">
                                        <h3 class="box-title">
                                        <c:if test="${not empty listSearchCategories}">
                                            <c:choose >
                                                <c:when test="${not empty listSearchCategories}">
                                                    <c:url value="/Supplier/addCategory?page=${requestScope.listSearchCategories.current}&searchinput=${searchinput}" var="addcategories"/>
                                                </c:when>
                                                <c:otherwise>
                                                    <c:url value="/Supplier/addCategory?searchinput=${searchinput}" var="addcategories"/>
                                                </c:otherwise>
                                            </c:choose>

                                            <a href="<c:out value="${addcategories}"/>"  class="btn btn-primary btn-lg" >
                                                Thêm danh mục mới
                                            </a>
                                        </c:if>
                                    </h3>
                                </div>
                                <!-- /.box-header -->
                                <div class="box-body">
                                    <div class="table-responsive">
                                        <c:if test="${listSearchCategories.totalPages==0}">
                                            list is empty
                                        </c:if>
                                        <c:if test="${not empty listSearchCategories.content}">
                                            <jsp:include page="/WEB-INF/Include/Supplier/categories/table/TableSearchCategories.jsp"></jsp:include>
                                            <jsp:include page="/WEB-INF/Include/Supplier/categories/table/PagingSearchCategories.jsp"></jsp:include>
                                        </c:if>
                                    </div>
                                </div>

                                <!-- /.box-body -->
                            </div>

                        </div>
                        <!-- /.col -->
                    </div>
                    <c:if test="${type=='formadd'}">
                        <jsp:include page="/WEB-INF/Include/Supplier/categories/form/addcategories.jsp"></jsp:include>
                    </c:if>
                    <c:if test="${type=='formupdate'}">
                        <jsp:include page="/WEB-INF/Include/Supplier/categories/form/updatecategories.jsp"></jsp:include>
                    </c:if>
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
