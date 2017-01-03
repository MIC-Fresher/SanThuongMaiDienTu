<%-- 
    Document   : aftersignup
    Created on : Dec 29, 2016, 8:53:43 AM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <c:if test="${not empty messeger}">
            <script>
                alert("${messeger}");
            </script>
        </c:if>
        <h1>Hello World!</h1>
    </body>
</html>
