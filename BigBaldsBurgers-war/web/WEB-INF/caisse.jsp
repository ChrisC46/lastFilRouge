<%-- 
    Document   : caisse
    Created on : 18 déc. 2017, 16:44:57
    Author     : Tofi
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello caissier!</h1>

        <c:forEach items="${lTable}" var="t">
            <div>
                <select>
                    <option value="${t.numero}">table</option>
                </select>
                <a>${t.numero}</a>
            </div>
        </c:forEach>


    </body>
</html>
