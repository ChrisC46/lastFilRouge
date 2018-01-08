<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>


<!DOCTYPE html>



<html>
    <head>

        <style type='text/css'>
            td {cursor:hand;}
            .up {	border: outset 10 px red;
                  height:50px;
                  width:50px;
                  font-family:verdana;
                  text-align:center;
            }

            .down {border: inset 10 px red;
                   height:50px;
                   width:50px;
                   font-family:verdana;
                   text-align:center;
            }
        </style>

        <script type='text/javascript'>
            var activeinput

            function populateTd() {
                var tdcollection = document.getElementsByTagName('table')[0].getElementsByTagName('td')
                for (i = 0; i < tdcollection.length; i++) {
                    tdcollection[i].className = 'up'
                    tdcollection[i].onmousedown = function () {
                        this.className = 'down'
                    }
                    tdcollection[i].onmouseup = function () {
                        this.className = 'up'
                    }
                    tdcollection[i].onclick = function () {
                        if (!!activeinput) {
                            activeinput.value += this.innerHTML
                        }
                    }
                }
            }


        </script>

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
                <ul>

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

                        <table border="2" solid blue>
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
                                <td colspan=3>0</td>
                            </tr>

                        </table>
                        <a class="btn btn-primary"><input type="reset" name="clear" style="    margin: 0;
    padding: 0;
    line-height: 100%; /* Si ça fonctionne pas mets 0 */
    border: 0;
    background: none; /* ou transparent je sais plus... */
    font: /* Définis le même font qu'un lien traditionnel */
    
    text-decoration: underline;color:white; /* Normalement */"/></a>
                        
                        <label for="code">Code secteur : </label><input type="password"  autofocus="activeinput = this" onfocus="activeinput = this"  name="login" maxlength="4" value="${loginERR}" required/>
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

                </ul>
            </nav>


        </div>
        <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.3/umd/popper.min.js" integrity="sha384-vFJXuSJphROIrBnz7yo7oB41mKfc8JzQZiCq4NCceLEaO4IHwicKwpJf9c9IpFgh" crossorigin="anonymous"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/js/bootstrap.min.js" integrity="sha384-h0AbiXch4ZDo7tp9hKZ4TsHbi047NrKGLO3SEJAg45jXxnGIfYzk4Si90RDIqNm1" crossorigin="anonymous"></script>


    </body>
</html>
