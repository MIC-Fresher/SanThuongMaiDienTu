<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>


<h2>Category</h2>
<div class="panel-group category-products" id="accordian"><!--category-productsr-->
    <c:forEach items="${listGroupcategories}" var="Groupcategories" varStatus="status">
        <div class="panel panel-default">

            <div class="panel-heading">
                <h4 class="panel-title">
                    <a data-toggle="collapse" data-parent="#accordian" href="#${Groupcategories.groupCategoriesId}">
                        <span class="badge pull-right"><i class="fa fa-plus"></i></span>

                        ${Groupcategories.groupCategoriesName}
                    </a>
                </h4>
            </div>
            <div id="${Groupcategories.groupCategoriesId}" class="panel-collapse collapse">
                <div class="panel-body">
                    <ul>
                        <c:forEach items="${Groupcategories.categoryList}" var="category"  varStatus="status">
                            <s:url value="/Public/setupSearchProducts?categoryname=${category.categoryName}&${parameterUrl.toStringCategory()}" var="searchbycategory"/>
                            <li>
                                <a href="${searchbycategory}">${category.categoryName}</a>
                            </li>
                        </c:forEach>
                    </ul>
                </div>
            </div>
        </div>
    </c:forEach>


</div><!--/category-products-->



