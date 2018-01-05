<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>


<!DOCTYPE html>
<%--
<html>

<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css" type="text/css">
  <link rel="stylesheet" href="https://v40.pingendo.com/assets/bootstrap/bootstrap-4.0.0-beta.1.css" type="text/css"> 
</head>

<body>
  <div class="py-5">
    <div class="container">
      <div class="row">
        <div class="col-md-12">
            <c:url value="FrontControleur?section=creerJeuDeTest" var="url00" />
          <a href="${url00}" class="btn btn-outline-primary">Création Jeu de Test</a>
          <a><p class="${dClasse}">${msg}</p></a>
        </div>
      </div>
    </div>
  </div>
  <div class="py-5">
    <div class="container">
      <div class="row">
        <div class="col-md-12">
            <c:url value="FrontControleur?section=categorieCatalogue" var="url03" />
          <a href="${url03}" class="btn btn-outline-primary">Categorie Catalogue</a>
        </div>
      </div>
    </div>
  </div>
  <div class="mx-auto text-center">
    <div class="container">
      <div class="row">
        <div class="col-md-12 text-uppercase justify-content-center w-100">
            <c:url value="FrontControleur?section=accueil" var="url01" />
                    <form action="${url01}" method="POST">
          <div class="btn-group">
            <c:url value="FrontControleur?section=accueil&choixAccueil=serveur" var="url04" />  
            <a href="${url04}" id="serveur" class="btn btn-primary btn-lg">SERVEUR</a>
            <a href="#" class="btn btn-primary btn-lg">CLIENT</a>
            <a href="#" class="btn btn-primary btn-lg">CUISINE</a>
             <c:url value="FrontControleur?section=accueil&choixAccueil=caissier" var="url07" />
             <a href="${url07}" id="caissier" class="btn btn-primary btn-lg">CAISSE</a>
            <input type="password" name="login" class="form-control" placeholder="Entrer code">
            <button type="submit" class="btn btn-primary text-center">Valider</button>
            
          
        </div>
          </form>
      </div>
    </div>
  </div>
  <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.3/umd/popper.min.js" integrity="sha384-vFJXuSJphROIrBnz7yo7oB41mKfc8JzQZiCq4NCceLEaO4IHwicKwpJf9c9IpFgh" crossorigin="anonymous"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/js/bootstrap.min.js" integrity="sha384-h0AbiXch4ZDo7tp9hKZ4TsHbi047NrKGLO3SEJAg45jXxnGIfYzk4Si90RDIqNm1" crossorigin="anonymous"></script>
</body>

</html>
--%>


<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Big Balds Burgers</title>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css" type="text/css">
        <link rel="stylesheet" href="https://v40.pingendo.com/assets/bootstrap/bootstrap-4.0.0-beta.1.css" type="text/css"> 
    </head>
    <body>
<div class="py-5">
    <div class="container">
      <div class="row">
        <div class="col-md-12">
            <c:url value="FrontControleur?section=creerJeuDeTest" var="url00" />
          <a href="${url00}" class="btn btn-outline-primary">Création Jeu de Test</a>
          <a><p class="${dClasse}">${msg}</p></a>
        </div>
      </div>
    </div>
  </div>
        <div>
            <h1>Big Balds Burgers</h1>
            <nav>
                <ul>
                    <%--
                    <c:url value="FrontControleur?section=creerJeuDeTest" var="url00" />
                    <li><a href="${url00}">creerJeuDeTest</a><a><p class="${dClasse}">${msg}</p></a></li>
                    --%>
                    <c:url value="FrontControleur?section=accueil" var="url01" />
                    <form action="${url01}" method="POST">
                        <label class="erreur">${erreur}</label>
                        <div>
                            

                            <p><label class="radio-inline"><img src="images/serveurHome.png"/><input type="radio" name="choixAccueil" value="serveur" ></label>
                               <label class="radio-inline"><img src="images/clientHome.png"/><input type="radio" name="choixAccueil" value="client"></label>
                               <label class="radio-inline"><img src="images/cuisineHome.png"/><input type="radio" name="choixAccueil" value="cuisinier"></label>
                               <label class="radio-inline"><img src="images/caisseHome.png"/><input type="radio" name="choixAccueil" value="caissier"></label>
                            </p>
                        </div>
                        <label for="code">Code secteur : </label><input type="password" name="login" maxlength="4" value="${loginERR}" required/>
                        <label class="erreur">${loginErr}</label>
                        <input type="submit" name="code" value="valider"/>
                    </form>
                        <%--
                    <c:url value="FrontControleur?section=categorieCatalogue" var="url03" />
                    <li><a href="${url03}"> Categorie Catalogue</a></li>
                        --%>
                </ul>
            </nav>


        </div>
        <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.3/umd/popper.min.js" integrity="sha384-vFJXuSJphROIrBnz7yo7oB41mKfc8JzQZiCq4NCceLEaO4IHwicKwpJf9c9IpFgh" crossorigin="anonymous"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/js/bootstrap.min.js" integrity="sha384-h0AbiXch4ZDo7tp9hKZ4TsHbi047NrKGLO3SEJAg45jXxnGIfYzk4Si90RDIqNm1" crossorigin="anonymous"></script>
    </body>
</html>
