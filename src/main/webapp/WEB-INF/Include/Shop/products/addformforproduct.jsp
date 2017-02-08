
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>



<div class="col-xs-12">
    <div class="box box-warning">
        <div class="box-header with-border">
            <h3 class="box-title">Thêm Sản phẩm mới</h3>
        </div>
        <div class="box-body">
            <form:form method="POST" commandName="product"  role="form"  enctype="multipart/form-data">
                <!-- text input -->
                 <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                <div class="form-group">
                    <label>Tên Sản phẩm</label>
                    <form:input  path="productName" id="name" type="text" class="form-control" placeholder="Enter ..." />
                </div>

                <div class="form-group">
                    <label>Danh mục</label>
                    <form:select  path="categoryId.categoryId">
                        <c:forEach items="${listCategoriesOfShop}" var="category">
                            <form:option  value="${category.categoryId}">${category.categoryName}</form:option>
                        </c:forEach>

                    </form:select>
                </div>
                <!-- textarea -->


                <div class="form-group">
                    <label>Giá Sản phẩm</label>
                    <form:input path="unitPrice" id="thanhphan"   class="form-control" placeholder="Enter ..."/>
                </div>

                <div class="form-group">
                    <label>Mô tả</label>
                    <form:textarea type="text" path="description" id="noidung" class="form-control" rows="3" placeholder="Enter ..." />
                </div>
            

                <div class="form-group">
                    <label>Hình ảnh</label>
                    
                    <input type="file" name="file" />
                </div>

                <div class="form-group">
                    <label>Kích cỡ (Size)</label>
                    <form:select  path="productdetail.sizeId.sizeId">
                        <c:forEach items="${listSizes}" var="size">
                            <form:option  value="${size.sizeId}">${size.size}</form:option>
                        </c:forEach>

                    </form:select>
                </div>

                <div class="form-group">
                    <label>Màu sắc</label>
                    <form:select  path="productdetail.colorId.colorId">
                        <c:forEach items="${listColors}" var="color">
                            <form:option  value="${color.colorId}">${color.colorName}</form:option>
                        </c:forEach>

                    </form:select>
                </div>
                <div class="form-group">
                    <label>Trạng thái</label>
                    <form:select  path="isActive">
                        <form:option  value="1">được bán</form:option>
                        <form:option  value="0">tạm dừng bán</form:option>
                    </form:select>
                </div>
                <!------------------------------------------>
                <div class="form-group">
                    <label>Số lương nhập kho</label>
                    <form:input path="quantity" type="Number" id="kieu"   class="form-control" placeholder="Enter ..."/>
                </div>



                <input type="hidden" value="${requestScope.listSearchProducts.current}" name="page"/>
                <input type="hidden" value="${searchinput}" name="searchinput"/>
                <s:url value="/Shop/addProduct" var="addproduct"/>
                <div class="box-footer clearfix">


                    <button class="btn btn-primary" type="submit" onclick="form.action = '${addproduct}';" >Thêm</button>
                </div>
            </form:form>
        </div>
    </div>
</div>