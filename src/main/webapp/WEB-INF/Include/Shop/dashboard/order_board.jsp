<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<div class="row">
    <div class="col-md-8">
        <div class="box box-info">
            <div class="box-header with-border">
                <h3 class="box-title">Đơn hàng mới nhất</h3>

                <div class="box-tools pull-right">
                    <button type="button" class="btn btn-box-tool" data-widget="collapse"><i class="fa fa-minus"></i>
                    </button>
                    <button type="button" class="btn btn-box-tool" data-widget="remove"><i class="fa fa-times"></i></button>
                </div>
            </div>
            <!-- /.box-header -->
            <div class="box-body" style="display: block;">
                <div class="table-responsive">
                    <table class="table no-margin">
                        <thead>
                            <tr>
                                <th>ID</th>
                                <th>Khách hàng</th>
                                <th>Trạng thái</th>
                                <th>Ngày đặt hàng</th>
                                <th>Giá trị</th>
                                
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach var="order" items="${listOrders.content}" varStatus="status">
                                <tr>
                                    <td><a href="#">${order.orderId}</a></td>
                                    <td>${order.userId.email}</td>
                                    <td>
                                        <c:choose>
                                            <c:when test="${order.statusOrderId.status=='Đã giao'}">
                                             
                                                <c:set value="label label-success" var="statusorder"/>
                                            </c:when>
                                            <c:when test="${order.statusOrderId.status=='Đang giao hàng'}">
                                             
                                                <c:set value="label label-warning" var="statusorder"/>
                                            </c:when>
                                            <c:when test="${order.statusOrderId.status=='Bị khóa'}">
                                             
                                                <c:set value="label label-danger" var="statusorder"/>
                                            </c:when>
                                            <c:otherwise>
                                                <c:set value="label label-info" var="statusorder"/>
                                                
                                            </c:otherwise>
                                        </c:choose>

                                        <span class="${statusorder}">${order.statusOrderId.status}</span>


                                    </td>
                                    <td>
                                        <fmt:formatDate pattern="dd/MM/yyyy" value="${order.orderDate}"/>
                                    </td>
                                    <td>
                                        $
                                        <fmt:formatNumber type="number" value="${order.totalPrice}"/>
                                    </td>
                                </tr>
                            </c:forEach>
                        

                        </tbody>
                    </table>
                </div>
                <!-- /.table-responsive -->
            </div>
            <!-- /.box-body -->
            <div class="box-footer clearfix" style="display: block;">
                <s:url value="/Shop/Orders" var="orders"/>
                <a href="${orders}" class="btn btn-sm btn-default btn-flat pull-right">View All Orders</a>
            </div>
            <!-- /.box-footer -->
        </div>
    </div>
</div>