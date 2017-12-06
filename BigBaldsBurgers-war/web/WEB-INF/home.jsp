<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Big Balds Burgers</title>
    </head>
    <body>
    
        <div>
            <h1>Big Balds Burgers</h1>
            <p> ici interface serveur/cuisinier/resp caisse </p>
            <nav>
                <ul>
                    <c:url value="FrontControlleur?section=serveur" var="url01" />
                    <li><a href="${url01}">Serveur</a></li>
                    <li>Cuisinier</li>
                    <li>Caisse</li>
                </ul>
            </nav>
            
            
        </div>
        
    </body>
</html>
