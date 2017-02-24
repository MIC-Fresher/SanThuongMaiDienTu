
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>



<div class="col-xs-12">
    <div class="box box-warning">
        <div class="box-header with-border">
            <h3 class="box-title">Thông tin sản phẩm</h3>
        </div>
        <div class="box-body">
            <form:form method="POST" commandName="product"  role="form"  >
                <!-- text input -->
                <form:hidden path="productId"/>
                <div class="form-group">
                    <label>Tên Sản phẩm</label>
                    <form:input readonly="true"  path="productName" id="name" type="text" class="form-control" placeholder="Enter ..." />
                </div>

                <div class="form-group">
                    <label>Danh mục</label>
                    <form:input path="categoryId.categoryName" readonly="true" type="text" class="form-control"/>
                </div>
                <!-- textarea -->


                <div class="form-group">
                    <label>Giá Sản phẩm</label>
                    <form:input readonly="true" path="unitPrice" id="thanhphan"   class="form-control" placeholder="Enter ..."/>
                </div>

                <div class="form-group">
                    <label>Mô tả</label>
                    <form:textarea readonly="true" type="text" path="description" id="noidung" class="form-control" rows="3" placeholder="Enter ..." />
                </div>


                <div class="form-group">

                    <label>Hình ảnh</label>
                    <c:choose >
                        <c:when test="${product.productdetail.producimageList[0].url!=null}">
                            <img  src="${pageContext.request.contextPath}/images/product-details/<c:out value="${product.productdetail.producimageList.get(0).url}"/>" class="img-circle" alt="User Image">
                        </c:when>
                        <c:otherwise>
                            <img style="width: 60px;" src="${pageContext.request.contextPath}/images/product-details/imgnotfound.png" class="img-circle" alt="User Image">
                        </c:otherwise>
                    </c:choose>

                </div>

                <div class="form-group">
                    <label>Kích cỡ (Size)</label>
                    <form:input path="productdetail.sizeId.size" readonly="true" type="text" id="kieu"   class="form-control" />
                   
                </div>

                <div class="form-group">
                    <label>Màu sắc</label>
                    <form:input path="productdetail.colorId.colorName" readonly="true" type="text" id="kieu"   class="form-control" />
                    
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
                    <form:input readonly="true" path="quantity" type="Number" id="kieu"   class="form-control" placeholder="Enter ..."/>
                </div>
                <div class="form-group">
                    <label>Số lượng còn trong kho</label>
                    <c:choose>
                        <c:when test="${product.stock>0}">

                            <input readonly="true" value="${product.stock}" type="Number" id="kieu"   class="form-control"/>
                        </c:when>
                        <c:otherwise>

                            <input readonly="true" value=" hết hàng" type="text" id="kieu"   class="form-control" placeholder="Enter ..."/>
                        </c:otherwise>
                    </c:choose>
                </div>

            </form:form>
        </div>
    </div>
</div>