<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<div class="row">
    <div class="col-xs-12">
        <div class="box box-warning">
            <div class="box-header with-border">
                <h3 class="box-title">Phân quyền cho cửa hàng</h3>
            </div>
            <!-- /.box-header -->

            <div class="box-body">
                <form:form method="POST" commandName="categories"  role="form"  >

                    <!-- text input -->
                    <div class="form-group">
                        <label>Tên danh mục</label>
                        <form:input  path="categoryName" id="name" type="text" class="form-control" placeholder="Enter ..." />
                    </div

                    <div class="form-group">
                        <label>Trạng thái </label>
                        <form:select  path="isActive"> 
                            <form:option value="0">deactive</form:option>
                            <form:option value="1">active</form:option>
                        </form:select>
                    </div>
                    <c:if test="${not empty listCategories}">
                        <input type="hidden" value="${requestScope.listCategories.current}" name="page"/>
                    </c:if>
                    <c:url value="/Suplier/addCategory" var="addcategories"/>
                <button class="btn btn-primary" type="submit" onclick="form.action = '<c:out value="${addcategories}"/>';" >Thêm</button>
            </form:form>
        </div>
        <!-- /.box-body -->
    </div>
</div>
</div>