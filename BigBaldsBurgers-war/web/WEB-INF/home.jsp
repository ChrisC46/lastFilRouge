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
                    <c:url value="FrontControleur?section=creerJeuDeTest" var="url00" />
                    <li><a href="${url00}">creerJeuDeTest</a></li>
                    <c:url value="FrontControleur?section=serveur" var="url01" />
                    <li><a href="${url01}">Serveur</a></li>
                    <c:url value="FrontControleur?section=client" var="url02" />
                    <li><a href="${url03}">Client</a></li>
                    <c:url value="FrontControleur?section=cuisinier" var="url03" />
                    <li><a href="${url03}">Cuisinier</a></li>
                    <c:url value="FrontControleur?section=caisse" var="url04" />
                    <li><a href="${url04}">Caisse</a></li>
                </ul>
            </nav>
            
                    <p class="${dClasse}">${msg}</p>
        </div>
        
    </body>
</html>
