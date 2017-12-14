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
            <p> ici interface serveur/Client/cuisinier/resp caisse </p>
            <nav>
                <ul>
                    <c:url value="FrontControleur?section=creerJeuDeTest" var="url00" />
                    <li><a href="${url00}">creerJeuDeTest</a></li>
                    <c:url value="FrontControleur?section=accueil" var="url01" />
                    <form action="${url01}" method="POST">
                        <div>
                            <p><input type="radio" name="choixAccueil" value="serveur" CHECKED>
                                Serveur
                                <br>
                                <input type="radio" name="choixAccueil" value="client">
                                Client
                                <br>
                                <input type="radio" name="choixAccueil" value="cuisine">
                                Cuisine
                                <br>
                                <input type="radio" name="choixAccueil" value="caisse">
                                Caisse
                                <br>      
                           </p>
                        </div>
                        <label for="code">Code secteur : </label><input type="text" maxlength="4" />
                        <input type="submit" name="c"/>
                    </form>
                    <c:url value="FrontControleur?section=categorieCatalogue" var="url03" />
                    <li><a href="${url03}"> Categorie Catalogue</a></li>
                </ul>
            </nav>
            
                    <p class="${dClasse}">${msg}</p>
        </div>
        
    </body>
</html>
