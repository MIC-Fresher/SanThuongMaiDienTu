<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<table id="example2" class="table table-bordered table-hover">
    <thead>
        <tr>
            <th>Mã ĐH</th>
            <th>Email KH</th>
            <th>Ngày đặt</th>
            <th>SĐT người nhận</th>
            <th>Trạng thái</th>
            <th>Tổng cộng</th>  
            <th style="width: 155px">Tác Vụ</th>
        </tr>
    </thead>
    <tbody>

        <c:forEach var="order" items="${listOrders.content}" varStatus="">
            <tr>
                <td style="width: 100px">
                    ${order.orderId}
                </td>
                <td>
                    ${order.userId.email}
                </td>
                <td>
                    <fmt:formatDate pattern="dd/MM/yyyy" value="${order.orderDate}"/>

                </td>
                <td>
                    ${order.receiverId.receiverPhone}
                </td>
                <td>
                    ${order.statusOrderId.status}
                </td>
                <td>
                    $
                    <fmt:formatNumber type="number" value="${order.totalPrice}"/>
                </td>

                <td>
                    <div class="btn-group">
                        <button type="button" class="btn btn-info">Tác Vụ</button>
                        <button type="button" class="btn btn-info dropdown-toggle" data-toggle="dropdown">
                            <span class="caret"></span>
                            <span class="sr-only">Toggle Dropdown</span>
                        </button>
                        <ul class="dropdown-menu" role="menu">
                            <s:url value="/Supplier/OrderDetail?id=${order.orderId}&page=${requestScope.listOrders.current}&${parameterUrl}" var="update"/>
                            <li><a href="${update}">Xem chi tiết ĐH</a></li>
                           
                            <li class="divider"></li>
                            <li><a href="#">Khác</a></li>
                        </ul>
                    </div>
                </td>
            </tr>
        </c:forEach>
    </tbody>

</table>
<jsp:include page="/WEB-INF/Include/Supplier/order/order_table/order_paging_filter.jsp"></jsp:include>