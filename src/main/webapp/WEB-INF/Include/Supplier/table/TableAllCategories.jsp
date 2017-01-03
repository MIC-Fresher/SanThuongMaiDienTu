<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<table id="example2" class="table table-bordered table-hover">
    <thead>
        <tr>
            <th>Mã danh mục</th>
            <th>Tên danh mục</th>
            <th>Sản phẩm</th>
            <th>Trạng thái</th>  
            <th style="width: 155px">Tác Vụ</th>
        </tr>
    </thead>
    <tbody>
 
        <c:forEach var="categories" items="${listCategories.content}" varStatus="">
            <tr>
                <td style="width: 100px">
                    ${categories.categoryId}
                </td>
                <td>
                    ${categories.categoryName}
                </td>
                <td>
                    ${categories.productList.size()}
                </td>
                <td>
                    <c:choose>
                        <c:when test="${categories.isActive==1}">
                            <font style="color: blue"> active</font>
                        </c:when>
                        <c:otherwise>
                            <font style="color: red"> deactive</font>
                        </c:otherwise>
                    </c:choose>
                </td>

                <td>
                    <div class="btn-group">
                        <button type="button" class="btn btn-info">Action</button>
                        <button type="button" class="btn btn-info dropdown-toggle" data-toggle="dropdown">
                            <span class="caret"></span>
                            <span class="sr-only">Toggle Dropdown</span>
                        </button>
                        <ul class="dropdown-menu" role="menu">
                            <c:url value="/Suplier/deactiveCategory?id=${categories.categoryId}" var="deactive"/>
                            <li><a href="<c:out value="${deactive}"/>">Khóa danh mục</a></li>
                            <c:url value="/Suplier/activeCategory?id=${categories.categoryId}&page=${requestScope.listCategories.current}" var="deactive"/>
                            <li><a href="<c:out value="${deactive}"/>">Mở khóa danh mục</a></li>
                            <li><a href="">Xem chi tiết</a></li>

                            <li class="divider"></li>
                            <li><a href="#">Khác</a></li>
                        </ul>
                    </div>
                </td>
            </tr>
        </c:forEach>
    </tbody>

</table>