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
            <nav>
                <ul>
                    <c:url value="FrontControleur?section=creerJeuDeTest" var="url00" />
                    <li><a href="${url00}">creerJeuDeTest</a></li><p class="${dClasse}">${msg}</p>
                    <c:url value="FrontControleur?section=accueil" var="url01" />
                    <form action="${url01}" method="POST">
                        <label class="erreur">${erreur}</label>
                        <div>
                            <p>
                                <input type="radio" name="choixAccueil" value="serveur" >
                                <img src="images/serveurHome.png"/>
                                <br>
                                <input type="radio" name="choixAccueil" value="client">
                                <img src="images/clientHome.png" class="img-responsive img-rounded" onclick=""/>
                                <br>
                                <input type="radio" name="choixAccueil" value="cuisinier">
                                <img src="images/cuisineHome.png"/>
                                <br>
                                <input type="radio" name="choixAccueil" value="caissier">
                                <img src="images/caisseHome.png"/>
                                <br>      
                           </p>
                        </div>
                        <label for="code">Code secteur : </label><input type="passwor" name="login" maxlength="4" value="${loginERR}" required/>
                        <label class="erreur">${loginErr}</label>
                        <input type="submit" name="code" value="valider"/>
                    </form>
                    <c:url value="FrontControleur?section=categorieCatalogue" var="url03" />
                    <li><a href="${url03}"> Categorie Catalogue</a></li>
                </ul>
            </nav>
            
                   
        </div>
        
    </body>
</html>
