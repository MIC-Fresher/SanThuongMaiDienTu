<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<table id="example2" class="table table-bordered table-hover">
    <thead>
        <tr>
            <th>ID</th>
            <th>Email người gửi</th>
            <th>Tiêu đề</th>
            <th>Nội dung</th>  
            <th>Trạng thái</th> 
            <th>Ngày gửi</th>  
            <th style="width: 155px">Tác Vụ</th>
        </tr>
    </thead>
    <tbody>
        
        <c:forEach var="feedback" items="${listFeedbacks.content}" varStatus="">
            <tr>
                <td style="width: 100px">
                    ${feedback.feedbackId}
                </td>
                <td>
                    ${feedback.userId.email}
                </td>
                <td>
                    ${feedback.title}
                </td>
                <td>
                    ${feedback.content}
                </td>
                <td>
                    ${feedback.statusFeedbackId.status}
                </td>
                <td>
                    <fmt:formatDate value="${feedback.createDate}" pattern="dd-MM-yyyy" type="both"/>
                </td>


                <td>
                    <div class="btn-group">
                        <button type="button" class="btn btn-info">Tác vụ</button>
                        <button type="button" class="btn btn-info dropdown-toggle" data-toggle="dropdown">
                            <span class="caret"></span>
                            <span class="sr-only">Toggle Dropdown</span>
                        </button>
                        <ul class="dropdown-menu" role="menu">
                            
                            <li>
                                <s:url value="/Supplier/FeedBackDetail?id=${feedback.feedbackId}" var="feedbackdetail"/>
                                <a href="${feedbackdetail}">Xem chi tiết</a>
                            </li>
                            <li>
                                <s:url value="/Supplier/deleteFeedBack?id=${feedback.feedbackId}&page=${requestScope.listFeedbacks.current}" var="delete"/>
                                <a href="javascript:{}" onclick="deleteFeedback('${delete}')">Xóa</a>
                            </li>
                            <li class="divider"></li>
                            <li><a href="#">Khác</a></li>
                        </ul>
                    </div>
                </td>
            </tr>
        </c:forEach>
    </tbody>

</table>