<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>home Resto</title>
    </head>
    <body>
        <nav>
            <c:url value="FrontContoleur?section=menu-main" var="url01" />
            <c:import url="${url01}" />
        </nav>
        <div>
            <h1>Big Balds Burgers</h1>
            <p> ici interface serveur/cuisinier/resp caisse </p>
            
            
        </div>
        
    </body>
</html>
