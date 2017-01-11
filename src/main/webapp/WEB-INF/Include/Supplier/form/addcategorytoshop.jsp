<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<div class="row">
    <div class="col-xs-12">
        <div class="box box-warning">
            <div class="box-header with-border">
                <h3 class="box-title">Thêm danh mục</h3>
            </div>
            <!-- /.box-header -->

            <div class="box-body">
                <form:form method="POST" commandName="shopCategory"  role="form"  >

                    <!-- text input -->
                    ${supplierController.listcata.categoryId}

                    <div class="form-group">
                        <label>Tên danh mục </label>
                        <form:select  path="categoryId"> 
                            <c:forEach items="${listAllCategories}" var="category">
                                <form:option label="${category.categoryName}" value="${category.categoryId}"></form:option>
                            </c:forEach>


                        </form:select>
                    </div>
                    <input type="hidden" value="${shopDetail.shopId}" name="idshop"/>
                    <s:url value="/Supplier/addCatogoryToShop" var="addcategorytoshop"/>
                    <div class="box-footer clearfix">
                        <button class="btn btn-primary" type="submit" onclick="form.action = '${addcategorytoshop}';" >Thêm</button>
                    </div>
                </form:form>
            </div>
            <!-- /.box-body -->
        </div>
    </div>
</div>