
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<div class="box-header">
    <h3 class="box-title">
        <s:url value="#" var="addproduct"/>
        <a href="${addproduct}"  class="btn btn-primary btn-lg" >
            Thêm đơn hàng
        </a>
    </h3>
    

</div>