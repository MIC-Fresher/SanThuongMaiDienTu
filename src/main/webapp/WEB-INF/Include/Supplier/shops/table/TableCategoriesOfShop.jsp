<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>


<div class="col-xs-12">
    <div class="box">

        <div class="box-header">
            <h3 class="box-title">
                <s:url value="/Supplier/addCatogoryToShop?idshop=${shopDetail.shopId}" var="addcategorytoshop"/>
                <a href="${addcategorytoshop}"  class="btn btn-primary btn-lg" >
                    Thêm danh mục cho cửa hàng
                </a>
            </h3>
        </div>
        <div class="box-header">
            <h3 class="box-title">
                Danh mục sản phẩm mà cửa hàng được phép bán
            </h3>
        </div>
        <!-- /.box-header -->
        <div class="box-body">
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

                    <c:forEach var="categories" items="${listCategories}" varStatus="">
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
                                        <font style="color: blue"> Hoạt động</font>
                                    </c:when>
                                    <c:otherwise>
                                        <font style="color: red"> Bị khóa</font>
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
                                        <s:url value="/Supplier/deleteCategoriesOfShop?idcategory=${categories.categoryId}&idshop=${shopDetail.shopId}" var="delete"/>
                                        <li><a href="${delete}">Xóa danh mục</a></li>
                                    </ul>
                                </div>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>

            </table>
        </div>
        <div class="box-body">
            <c:if test="${not empty shopCategory}">
                <jsp:include page="/WEB-INF/Include/Supplier/shops/form/addcategorytoshop.jsp"></jsp:include>
            </c:if>

        </div>
        <!-- /.box-body -->
    </div>

</div>
