
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!-- Left side column. contains the logo and sidebar -->
<aside class="main-sidebar">

    <!-- sidebar: style can be found in sidebar.less -->
    <section class="sidebar">

        <!-- Sidebar user panel (optional) -->
        <div class="user-panel">
            <div class="pull-left image">
                <img src="${pageContext.request.contextPath}/img/user2-160x160.jpg" class="img-circle" alt="User Image">
            </div>
            <div class="pull-left info">
                <p>${admin.user}</p>
                <!-- Status -->
                <a href="#"><i class="fa fa-circle text-success"></i> Online</a>
            </div>
        </div>

        <!-- search form (Optional) -->
        <form action="#" method="get" class="sidebar-form">
            <div class="input-group">
                <input type="text" name="q" class="form-control" placeholder="Search...">
                <span class="input-group-btn">
                    <button type="submit" name="search" id="search-btn" class="btn btn-flat"><i class="fa fa-search"></i>
                    </button>
                </span>
            </div>
        </form>
        <!-- /.search form -->

        <!-- Sidebar Menu --------------------------------------------------------------------------------------------------->
        <ul class="sidebar-menu">
            <li class="header">Quản lý</li>
            <!-- Optionally, you can add icons to the links -->
            <li class="treeview">
                <a href="#"><i class="fa fa-link"></i> <span>Quản lý  Sản phẩm</span> <i class="fa fa-angle-left pull-right"></i></a>
                <ul class="treeview-menu">
                    <s:url value="/Shop/searchProducts" var="showallproducts"/>
                    <li><a href="${showallproducts}">Danh sách sản phẩm</a></li>
                </ul>
            </li>
            <li class="treeview">


                <a href="#"><i class="fa fa-link"></i> <span>Quản lý  phản hồi</span> <i class="fa fa-angle-left pull-right"></i></a>
                <ul class="treeview-menu">
                    <li><a href="">Danh sách phản hồi</a></li>
                    <li><a href="#">Link in level 2</a></li>
                </ul>
            </li>
            <li class="treeview">
                <a href="#"><i class="fa fa-link"></i> <span>Quản lý cửa hàng</span> <i class="fa fa-angle-left pull-right"></i></a>
                <ul class="treeview-menu">
                    <c:url value="" var="shops"/>
                    <li><a href="<c:out value="${shops}"/>">Danh sách cửa hàng</a></li>
                    <li><a href="#">Link in level 2</a></li>
                </ul>
            </li>
        </ul>
        <!-- /.sidebar-menu -->
    </section>
    <!-- /.sidebar ------------------------------------------------------------------------------------------->
</aside>