<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<div class="col-xs-12">
    <div class="box box-warning">
        <div class="box-header with-border">
            <h3 class="box-title">Role của cửa hàng</h3>
        </div>
        <!-- /.box-header -->

        <div class="box-body">
            <table id="example2" class="table table-bordered table-hover">
                <thead>
                    <tr>
                        <th>Id</th>
                        <th>Tên Role</th>
                        <th style="width: 155px">Tác Vụ</th>
                    </tr>
                </thead>
                <tbody>

                    <c:forEach var="listrole" items="${listRoleofShop}" varStatus="">
                        <tr>
                            <td style="width: 100px">
                                ${listrole.roleId}
                            </td>
                            <td>
                                ${listrole.roleName}
                            </td>


                            <td>
                                <div class="btn-group">
                                    <button type="button" class="btn btn-info">Action</button>
                                    <button type="button" class="btn btn-info dropdown-toggle" data-toggle="dropdown">
                                        <span class="caret"></span>
                                        <span class="sr-only">Toggle Dropdown</span>
                                    </button>
                                    <ul class="dropdown-menu" role="menu">
                                        <s:url value="/Supplier/deleteRoleShop?idrole=${listrole.roleId}&idshop=${shopDetail.shopId}" var="deleterole"/>
                                        <li><a href="${deleterole}">Xóa Role</a></li>
                                        <li class="divider"></li>
                                        <li><a href="#">Khác</a></li>
                                    </ul>
                                </div>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>

            </table>

        </div>
        <div class="box-header with-border">
            <h3 class="box-title">Cấp quyền cho cửa hàng</h3>
        </div>
        <div class="box-body">
            <form:form method="POST" commandName="role" role="form"  >
                <div class="form-group">
                    <label>Cập nhật role </label>
                    <form:select path="roleId">
                        <option value="0" label="-----select-----"/>
                        <c:forEach items="${listRole}" var="role">
                            <form:option label="${role.roleName}" 
                                         value="${role.roleId}"/>
                        </c:forEach>
                    </form:select>
                </div>
                <input type="hidden" value="${shopDetail.shopId}" name="idshop"/>
                <div class="box-footer clearfix">
                    <s:url value="/Supplier/addRoleForShop" var="addrole"/>
                    <button class="btn btn-primary" type="submit" onclick="form.action = '${addrole}';" >Cập nhật Role</button>
                </div>

            </form:form>
        </div>
        <!-- /.box-body -->
    </div>
</div>