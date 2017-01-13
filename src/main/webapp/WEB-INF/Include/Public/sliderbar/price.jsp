<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<div class="price-range"><!--price-range-->
    <h2>Price Range</h2>
    <div class="well text-center">
        <c:choose>
            <c:when test="${typecategorybar == 'shop'}">
                <s:url value="/Public/showProductOfShop" var="searchprice"/>
            </c:when>
            <c:otherwise>
                <s:url value="/Public/searchProducts" var="searchprice"/>
            </c:otherwise>

        </c:choose>
        <form role="form" method="get">
            <input type="hidden" name="searchinput" value="${searchinput}"/>
            <input type="hidden" name="categoryname" value="${categoryname}"/>
            <input type="hidden" name="itemperpage" value="${itemperpage}"/>
            <input type="hidden" name="shopname" value="${shopname}"/>
            <input type="hidden" name="totalvote" value="${totalvote}"/>
            <div class="box-body">
                <div class="form-group">
                    <label >Giá từ</label>
                    <input class="form-control" type="number" name="fromprice" />
                </div>
                <div class="form-group">
                    <label >Đến</label>
                    <input class="form-control" type="number" name="toprice" />
                </div>
                <button  class="btn btn-primary" type="submit" onclick="form.action = '${searchprice}';" >Tìm</button>
            </div>
        </form>

    </div>
</div><!--/price-range-->