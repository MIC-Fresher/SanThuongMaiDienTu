<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<table id="example2" class="table table-bordered table-hover">
    <thead>
        <tr>
            <th>Mã SP</th>
            <th>Tên SP</th>
            <th>IMG</th>
            <th>Giá</th>
            <th>Số lượng</th>
            <th>Trạng thái</th>  
            <th style="width: 155px">Tác Vụ</th>
        </tr>
    </thead>
    <tbody>
      

        <c:forEach var="listProducts" items="${listSearchProducts.content}" varStatus="">
            <tr>
                <td style="width: 100px">
                    ${listProducts.productId}
                </td>
                <td>
                    ${listProducts.productName}
                </td>
                <td>

                    ${listProducts.productName}
                </td>
                <td>
                    ${listProducts.unitPrice}
                </td>
                <td>
                    ${listProducts.quantity}
                </td>
                <td>
                    <c:choose>
                        <c:when test="${listProducts.isActive==1}">
                            <font style="color: blue"> active</font>
                        </c:when>
                        <c:otherwise>
                            <font style="color: red"> deactive</font>
                        </c:otherwise>
                    </c:choose>
                </td>

                <td>
                    <div class="btn-group">
                        <button type="button" class="btn btn-info">Tác vụ</button>
                        <button type="button" class="btn btn-info dropdown-toggle" data-toggle="dropdown">
                            <span class="caret"></span>
                            <span class="sr-only">Toggle Dropdown</span>
                        </button>
                        <ul class="dropdown-menu" role="menu">

                            <li>
                                <s:url value="/Supplier/DetailProduct?id=${listProducts.productId}" var="detailproduct"/>
                                <a href="${detailproduct}">Xem chi tiết</a>
                            </li>

                            <li class="divider"></li>
                            <li><a href="#">Khác</a></li>
                        </ul>
                    </div>
                </td>
            </tr>
        </c:forEach>
    </tbody>

</table>