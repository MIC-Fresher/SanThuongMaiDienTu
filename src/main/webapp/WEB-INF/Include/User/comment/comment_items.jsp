
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<div id="comment_items" class="response-area">
    <ul class="media-list">
        <li class="media">
            <div class="rating-area">
                <ul class="ratings">
                    <li class="rate-this">Rate this item:</li>
                    <li>
                        <i class="fa fa-star color"></i>
                        <i class="fa fa-star color"></i>
                        <i class="fa fa-star color"></i>
                        <i class="fa fa-star"></i>
                        <i class="fa fa-star"></i>
                    </li>
                    <li class="color">(6 votes)</li>
                </ul>
            </div><!--/rating-area-->
            <a class="pull-left" href="#">
                <img class="media-object" src="${pageContext.request.contextPath}/images/blog/man-two.jpg" alt="">
            </a>
            <div class="media-body">
                <ul class="sinlge-post-meta">
                    <li><i class="fa fa-user"></i>Janis Gallagher</li>
                    <li><i class="fa fa-clock-o"></i> 1:33 pm</li>
                    <li><i class="fa fa-calendar"></i> DEC 5, 2013</li>
                </ul>
                <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.  Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.</p>

            </div>

        </li>

    </ul>
    <a href="" class="btn btn-primary pull-right">xem them</a>
</div>
