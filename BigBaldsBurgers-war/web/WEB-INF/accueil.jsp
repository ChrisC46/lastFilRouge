<%-- 
    Document   : accueil
    Created on : 6 déc. 2017, 16:23:47
    Author     : cdi313
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Big Balds Burger</title>
    </head>
    <body>
        <h1>Faite votre choix!</h1>
        <nav>
            <c:url value="FrontControlleur?section=carte-menus" var="url01">
                <li><a href="${url01}" >Nos menus</a></li>
            <li>Nos offres</li>
            
        </nav>
        
    </body>
</html>
