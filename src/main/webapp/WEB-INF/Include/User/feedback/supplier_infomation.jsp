<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<div class="col-sm-4">
    <div class="contact-info">
        <h2 class="title text-center">Thông tin liên hệ</h2>
        <address>
            <p>${supplierInfomation.companyName} </p>
            <p>${supplierInfomation.companyAddress}</p>
            <p>TP. Đà nẵng , VN</p>
            <p>Mobile: ${supplierInfomation.companyPhone}</p>
            <p>Fax: 1-714-252-0026</p>
            <p>Email: info@e-shopper.com</p>
        </address>
        <div class="social-networks">
            <h2 class="title text-center">Mạng xã hội</h2>
            <ul>
                <li>
                    <a href="#"><i class="fa fa-facebook"></i></a>
                </li>
                <li>
                    <a href="#"><i class="fa fa-twitter"></i></a>
                </li>
                <li>
                    <a href="#"><i class="fa fa-google-plus"></i></a>
                </li>
                <li>
                    <a href="#"><i class="fa fa-youtube"></i></a>
                </li>
            </ul>
        </div>
    </div>
</div>   