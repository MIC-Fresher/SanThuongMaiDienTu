<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<div class="row">

    <div class="col-md-3">
        <div class="box box-warning box-solid">
            <div class="box-header with-border">
                <h3 class="box-title">Đơn hàng</h3>

                <div class="box-tools pull-right">
                    <button type="button" class="btn btn-box-tool" data-widget="collapse"><i class="fa fa-minus"></i>
                    </button>
                </div>
                <!-- /.box-tools -->
            </div>
            <!-- /.box-header -->
            <div class="box-body" style="display: block;">
                ${totalOrder}
            </div>
            <!-- /.box-body -->
        </div>
        <!-- /.box -->
    </div>
    <div class="col-md-3">
        <div class="box box-warning box-solid">
            <div class="box-header with-border">
                <h3 class="box-title">Sản phẩm hoạt động</h3>

                <div class="box-tools pull-right">
                    <button type="button" class="btn btn-box-tool" data-widget="collapse"><i class="fa fa-minus"></i>
                    </button>
                </div>
                <!-- /.box-tools -->
            </div>
            <!-- /.box-header -->
            <div class="box-body" style="display: block;">
                ${totalProductsActive}
            </div>
            <!-- /.box-body -->
        </div>
        <!-- /.box -->
    </div>
    <div class="col-md-3">
        <div class="box box-warning box-solid">
            <div class="box-header with-border">
                <h3 class="box-title">Sản phẩm hết hàng</h3>

                <div class="box-tools pull-right">
                    <button type="button" class="btn btn-box-tool" data-widget="collapse"><i class="fa fa-minus"></i>
                    </button>
                </div>
                <!-- /.box-tools -->
            </div>
            <!-- /.box-header -->
            <div class="box-body" style="display: block;">
                ${totalProductsOld}
            </div>
            <!-- /.box-body -->
        </div>
        <!-- /.box -->
    </div>
    <div class="col-md-3">
        <div class="box box-warning box-solid">
            <div class="box-header with-border">
                <h3 class="box-title">Sản phẩm đã bán</h3>

                <div class="box-tools pull-right">
                    <button type="button" class="btn btn-box-tool" data-widget="collapse"><i class="fa fa-minus"></i>
                    </button>
                </div>
                <!-- /.box-tools -->
            </div>
            <!-- /.box-header -->
            <div class="box-body" style="display: block;">
                The body of the box
            </div>
            <!-- /.box-body -->
        </div>
        <!-- /.box -->
    </div>
</div>

<div class="row">

    <div class="col-md-3">
        <div class="box box-warning box-solid">
            <div class="box-header with-border">
                <h3 class="box-title">Danh mục đang hoạt động</h3>

                <div class="box-tools pull-right">
                    <button type="button" class="btn btn-box-tool" data-widget="collapse"><i class="fa fa-minus"></i>
                    </button>
                </div>
                <!-- /.box-tools -->
            </div>
            <!-- /.box-header -->
            <div class="box-body" style="display: block;">
                ${ShopCategories}
            </div>
            <!-- /.box-body -->
        </div>
        <!-- /.box -->
    </div>
    
</div>