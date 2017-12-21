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
                    <li><a href="${url00}">creerJeuDeTest</a><a><p class="${dClasse}">${msg}</p></a></li>
                            <c:url value="FrontControleur?section=accueil" var="url01" />
                    <form action="${url01}" method="POST">
                        <label class="erreur">${erreur}</label>
                        <div>
                            <select>
                                <option value="serveur">Serveur</option>
                                <option value="client">Client</option>
                                <option value="cuisinier">Cuisinier</option>
                                <option value="caissier">Caissier</option>
                            </select>
                            <p><input type="radio" name="choixAccueil" value="serveur" >
                                <img src="images/serveurHome.png"/>
                                <br>
                                <input type="radio" name="choixAccueil" value="client">
                                <img src="images/clientHome.png"/>
                                <br>
                                <input type="radio" name="choixAccueil" value="cuisinier">
                                <img src="images/cuisineHome.png"/>
                                <br>
                                <input type="radio" name="choixAccueil" value="caissier">
                                <img src="images/caisseHome.png"/>
                                <br>      
                            </p>
                        </div>
                        <label for="code">Code secteur : </label><input type="password" name="login" maxlength="4" value="${loginERR}" required/>
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
