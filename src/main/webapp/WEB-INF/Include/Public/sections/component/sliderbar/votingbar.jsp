<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<div class="brands_products"><!--brands_products-->
    <h2>Đánh giá</h2>
    <div class="brands-name">
        <ul class="nav nav-pills nav-stacked">
            <c:forEach var="step"  begin="1" end="5" varStatus="status" >
                <s:url value="/Public/searchProducts?totalvote=${status.index}&${parameterUrl.toStringVote()}" var="searchbyvote"/>

                <li>
                    <a href="${searchbyvote}">
                        <c:forEach begin="1" end="${status.index}">
                            <span style="color:yellow" class="glyphicon glyphicon-star"></span>
                        </c:forEach>
                        ${status.index}
                    </a>
                </li>
            </c:forEach>
        </ul>
    </div>
</div><!--/brands_products-->