
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<div id="Feedback_Modal" class="modal">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close span_close_feedback" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title">Thông báo</h4>
            </div>
            <div class="modal-body">
                <p id="body_modal">

                </p>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-primary pull-left btn_close_feedback" data-dismiss="modal">Close</button>
                <a id="delete_href" href="javascript:{}" type="button" class="btn btn-primary">Đồng ý</a>
            </div>
        </div>
        <!-- /.modal-content -->
    </div>
</div>