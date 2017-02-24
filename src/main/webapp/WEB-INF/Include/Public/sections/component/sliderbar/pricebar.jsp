<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>



<div class="price-range"><!--price-range-->
    <h2>Mức giá</h2>
    <div class="well text-center">
        <s:url  value="/Public/searchProducts" var="searchprice"/>
        <form  role="form" method="get">
            <c:if test="${not empty parameterUrl.searchinput}">
                <input id="searchinput" type="hidden" name="searchinput" value="${parameterUrl.searchinput}"/>
            </c:if>
            <c:if test="${not empty parameterUrl.categoryname}">
                <input id="categoryname" type="hidden" name="categoryname" value="${parameterUrl.categoryname}"/>
            </c:if>
            <c:if test="${not empty parameterUrl.itemperpage}">
                <input id="itemperpage" type="hidden" name="itemperpage" value="${parameterUrl.itemperpage}"/>
            </c:if>
            <c:if test="${not empty parameterUrl.shopname}">
                <input  id="shopname" type="hidden" name="shopname" value="${parameterUrl.shopname}"/>
            </c:if>
            <c:if test="${not empty parameterUrl.totalvote}">

                <input id="totalvote" type="hidden" name="totalvote" value="${parameterUrl.totalvote}"/>
            </c:if>


            <div class="box-body">
                <div class="form-group">
                    <label >Giá từ</label>
                    <input required="required" class="form-control" type="number" name="fromprice" />
                </div>
                <div class="form-group">
                    <label >Đến</label>
                    <input required="required" class="form-control" type="number" name="toprice" />
                </div>
                <button id="price"  class="btn btn-primary" type="submit" onclick="form.action = '${searchprice}';" >Tìm</button>
            </div>
        </form>

    </div>
</div><!--/price-range-->

