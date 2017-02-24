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
            <jsp:include page="/WEB-INF/Include/Shop/header_footer/header.jsp"/>
            <!-- Left side column. contains the logo and sidebar -->
            <jsp:include page="/WEB-INF/Include/Shop/sliderbar/sliderbar.jsp"/>
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

                    <jsp:include page="/WEB-INF/Include/Shop/products/searchformforproducts.jsp"></jsp:include>
                    </section>
                    <!--modalbox-->
                    <div id="Product_Modal" class="modal">
                        <div class="modal-dialog">
                            <div class="modal-content">
                                <div class="modal-header">
                                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                        <span aria-hidden="true">&times;</span></button>
                                    <h4 class="modal-title">Thông báo</h4>
                                </div>
                                <div class="modal-body">
                                    <p id="body_modal">

                                    </p>
                                </div>
                                <div class="modal-footer">
                                    <button type="button" class="btn btn-primary pull-left close2" data-dismiss="modal">Close</button>
                                    <a id="delete_href" type="button" class="btn btn-primary">Đồng ý</a>
                                </div>
                            </div>
                            <!-- /.modal-content -->
                        </div>
                    </div>
                    <!-- Main content -->
                    <!------------------------------------------------------------------------------------------------------->
                    <section class="content">
                        <div class="row">
                            <div class="col-xs-12">
                                <div class="box">
                                <jsp:include page="/WEB-INF/Include/Shop/sliderbar/boxheader.jsp"></jsp:include>

                                    <!-- /.box-header -->
                                    <div class="box-body">

                                    <c:if test="${not empty listSearchProducts.content}">
                                        <jsp:include page="/WEB-INF/Include/Shop/products/table/TableSearchProducts.jsp"></jsp:include>
                                        <jsp:include page="/WEB-INF/Include/Shop/products/table/PagingSearchProducts.jsp"></jsp:include>
                                    </c:if>
                                    <c:if test="${ empty listSearchProducts.content}">
                                        Không có sản phẩm nào
                                    </c:if>


                                </div>
                                <!-- /.box-body -->
                            </div>

                        </div>

                        <!-- /.col -->
                    </div>
                    <!-- /.row -->




                </section>
                <!------------------------------------------------------------------------------------------------->
                <!-- /.content -->
            </div>
            <!-- /.content-wrapper -->

            <!-- Main Footer -->
            <jsp:include page="/WEB-INF/Include/Shop/header_footer/footer.jsp"/> 

            <!-- Control Sidebar -->
            <jsp:include page="/WEB-INF/Include/Shop/sliderbar/controlslidebar.jsp"/>
            <!-- /.control-sidebar -->
            <!-- Add the sidebar's background. This div must be placed
                 immediately after the control sidebar -->
            <div class="control-sidebar-bg"></div>
        </div>
        <!-- ./wrapper -->
        <script>
            function deleteProduct(input) {

                // Get the modal
                var modal = document.getElementById('Product_Modal');
                modal.style.display = "block";
                document.getElementById("body_modal").innerHTML = "Bạn  muốn xóa SP này ?";
                document.getElementById("delete_href").href = input;

                // Get the <span> element that closes the modal
                var span = document.getElementsByClassName("close")[0];
                var btnclose = document.getElementsByClassName("close2")[0];

                //-----------
                btnclose.onclick = function () {
                    modal.style.display = "none";
                }
                // When the user clicks on <span> (x), close the modal
                span.onclick = function () {
                    modal.style.display = "none";
                }

                // When the user clicks anywhere outside of the modal, close it
                window.onclick = function (event) {
                    if (event.target == modal) {
                        modal.style.display = "none";
                    }
                }

            }


        </script>

    </body>
</html>
