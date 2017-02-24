
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<div class="box-header">
    <h3 class="box-title">
        <s:url value="/Supplier/Orders/Filter?statusOrder=2" var="filtercomplete"/>
        <a class="btn btn-primary btn-xs" onclick="pagingAjax('${filtercomplete}')" href="javascript:{}"   >
            Đơn hàng đã giao
        </a> 
    </h3>
    <h3 class="box-title">
        <s:url value="/Supplier/Orders/Filter?statusOrder=3" var="filtercanceled"/>
        <a class="btn btn-primary btn-xs" onclick="pagingAjax('${filtercanceled}')" href="javascript:{}"   >
            Đơn hàng bị từ chối
        </a> 
    </h3>

</div>

<script lang="javascript">
    function filter(input) {

        $.ajax({
            type: "GET",
            url: input,
            timeout: 100000,
            success: function (data) {
                console.log("SUCCESS: ", data);
                display(data);

            },
            error: function (e) {
                console.log("ERROR: ", e);
                display(e);
            }
        });
    }
    function display(data) {

        $('#order_items').html(data);
    }


</script>







