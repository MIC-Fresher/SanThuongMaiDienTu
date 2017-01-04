<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>




<div class="row">
    <div class="col-xs-12">
        <div class="box">
            <div class="box-header">
                <h3 class="box-title">
                    Thông tin cửa hàng

                </h3>
            </div>
            <!-- /.box-header -->
            <div class="box-body">
                <table id="example2" class="table table-bordered table-hover">
                    <tbody>
                        <tr>
                            <td >
                                ShopID
                            </td>
                            <td>
                                ${shopDetail.shopId}
                            </td>
                        </tr>
                        <tr>
                            <td >
                                shopName
                            </td>
                            <td >
                                ${shopDetail.shopName}
                            </td>
                        </tr>
                        <tr>
                            <td >
                                shopPhone
                            </td>
                            <td >
                                ${shopDetail.shopPhone}
                            </td>
                        </tr>
                        <tr>
                            <td>dateCreated</td>
                            <td>
                                <fmt:formatDate value="${shopDetail.dateCreated}" type="both" 
                                                pattern="dd-MM-yyyy" />
                            </td>
                        </tr>
                    </tbody>
                </table>
            </div>
            <!-- /.box-body -->
        </div>

    </div>
    <!-- /.col -->
</div>