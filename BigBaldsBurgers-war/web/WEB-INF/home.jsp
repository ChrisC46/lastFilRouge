<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>


<!DOCTYPE html>



<html>
    <head>
        <link rel="stylesheet" href="css/radioButtonHidden.css" />


        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Big Balds Burgers</title>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css" type="text/css">
        <link rel="stylesheet" href="https://v40.pingendo.com/assets/bootstrap/bootstrap-4.0.0-beta.1.css" type="text/css"> 
    </head>
    <body onload='populateTd()'>
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
                <div>

                    <c:url value="FrontControleur?section=accueil" var="url01" />
                    <form action="${url01}" method="POST">
                        <%--<label class="erreur">${erreur}</label>--%>
                        <div class="btn-group">
                            <label class="btn btn-outline-primary"><img src="images/serveurHome.png"/><input  class="opacity" type="radio" name="choixAccueil" value="serveur"></label>
                            <label class="btn btn-outline-primary"><img src="images/clientHome.png"/><input  class="opacity" type="radio" name="choixAccueil" value="client" ></label>
                            <label class="btn btn-outline-primary"><img src="images/cuisineHome.png"/><input class="opacity" type="radio" name="choixAccueil" value="cuisinier" ></label>
                            <label class="btn btn-outline-primary"><img src="images/caisseHome.png"/><input class="opacity" type="radio" name="choixAccueil" value="caissier" ></label>

                        </div>

                        <table border="2">
                            <tr>
                                <td>7</td>
                                <td>8</td>
                                <td>9</td>
                            </tr>
                            <tr>
                                <td>4</td>
                                <td>5</td>
                                <td>6</td>
                            </tr>
                            <tr>
                                <td>1</td>
                                <td>2</td>
                                <td>3</td>
                            </tr>
                            <tr>
                                <td colspan=1>0</td>
                                <td colspan=2><a class="btn btn-primary"><input type="reset" name="clear" style="    margin: 0;
                                                                                padding: 0;
                                                                                line-height: 100%; /* Si ça fonctionne pas mets 0 */
                                                                                border: 0;
                                                                                background: none; /* ou transparent je sais plus... */
                                                                                font: /* Définis le même font qu'un lien traditionnel */

                                                                                text-decoration: underline;color:white; /* Normalement */"/></a></td>
                            </tr>

                        </table>

                        <br>
                        <label for="code">Code secteur : </label><input type="password" name="login" maxlength="4" value="${loginERR}" required  autofocus="activeinput = this" onfocus="activeinput = this"  />
                        <label class="erreur">${loginErr}</label>
                        <a class="btn btn-primary"><input type="submit" name="code"  value="valider" style="    margin: 0;
                                                          padding: 0;
                                                          line-height: 100%; /* Si ça fonctionne pas mets 0 */
                                                          border: 0;
                                                          background: none; /* ou transparent je sais plus... *
                                                          font: /* Définis le même font qu'un lien traditionnel */
                                                          color: /* La même couleur... */
                                                          text-decoration: underline;color:white; /* Normalement */"/></a>
                    </form>

                </div>
            </nav>


        </div>

        <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.3/umd/popper.min.js" integrity="sha384-vFJXuSJphROIrBnz7yo7oB41mKfc8JzQZiCq4NCceLEaO4IHwicKwpJf9c9IpFgh" crossorigin="anonymous"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/js/bootstrap.min.js" integrity="sha384-h0AbiXch4ZDo7tp9hKZ4TsHbi047NrKGLO3SEJAg45jXxnGIfYzk4Si90RDIqNm1" crossorigin="anonymous"></script>

        <script src="/BigBaldsBurgers-war/js/paveNumerique.js" type='text/javascript' ></script> 
    </body>
</html>
