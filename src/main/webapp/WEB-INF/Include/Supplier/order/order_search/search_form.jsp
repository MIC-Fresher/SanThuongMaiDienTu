<%-- 
    Document   : searchform
    Created on : Jan 6, 2017, 9:54:37 AM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>

<form  id="form_order"  method="get" class="sidebar-form">
    <div class="input-group">
        <input type="text" name="searchinput" class="form-control" placeholder="Search...">

        <span class="input-group-btn">
            <span class="input-group-btn">
                <button id="search-btn" class="btn btn-flat"><i class="fa fa-search"></i>
                </button>
            </span>
        </span>
    </div>
</form>
<script type="text/javascript">
    <s:url value="/Supplier/Orders/Search" var="searchorder"/>
   
    var frm = $('#form_order');
    frm.submit(function (ev) {
        $.ajax({
            type: frm.attr('method'),
            url: ${searchorder},
            data: frm.serialize(),
            timeout: 100000,
            success: function (data) {
                console.log("SUCCESS: ", data);

                displayOrder_items(data);

            },
            error: function (e) {
                console.log("ERROR: ", e);
                //
            }
        });

        ev.preventDefault();
    });


    function displayOrder_items(data) {

        $('#order_items').html(data);

    }

</script>
