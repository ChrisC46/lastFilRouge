<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>

    <head>
        <%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
        <%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
        <link rel="stylesheet" href="css/radioButtonHidden.css" />
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css" type="text/css">
        <link rel="stylesheet" href="https://v40.pingendo.com/assets/bootstrap/bootstrap-4.0.0-beta.1.css" type="text/css"> 
    </head>
    <body onload='populateTd()' class="text-center text-uppercase" >
        <div class="py-5 my-5">
            <div class="container">
                <div class="row">
                    <div class="col-md-2">
                        <ul class="nav nav-pills flex-column">
                            <li class="nav-item">
                                <c:url value="FrontControleur?section=PaiementCtrl" var="url21" />  
                                <a href="${url21}" class="active nav-link"><i class=""></i>voir les tables à encaisser</a>
                            </li>
                            <c:forEach items="${lTable}" var="t">
                                <li class="nav-item">
                                    <c:url value="FrontControleur?section=DetailPaiementCtrl&numTable=${t.numero}" var="url22" />
                                    <a class="nav-link" href="${url22}">table ${t.numero}</a>
                                </li>
                            </c:forEach>
                        </ul>
                    </div>
                    <div class="col-md-6">
                        <table class="table">

                            <thead>
                                <tr>
                                    <th>Qte</th>
                                    <th>Produit</th>
                                    <th>Prix HT</th>
                                    <th>Prix TTC</th>
                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach var="d" items="${lDetail}">

                                    <tr>
                                        <td>${d.qteCommande}</td>
                                        <td>${d.formule.nom}${d.produit.nom}</td>
                                        <td>${d.prixLigneDeCo} €</td>
                                        <fmt:setLocale value="fr_FR" scope="session" />
                                        <td><fmt:formatNumber value="${d.formule.getPrixTTC()*d.qteCommande}${d.produit.getPrixTTC()*d.qteCommande}" type="currency" /></td>


                                    </tr>
                                </c:forEach>


                            </tbody>
                        </table>
                    </div>

                    <div class="col-md-4">
                        <tbody onload='populateTd()'>
                            <c:url value="FrontControleur?section=DetailPaiementCtrl" var="url30" />
                        <form action="${url30}" method="POST">
                            <div class="btn-group">
                                <label class="btn btn-outline-primary"><input class="visiblity" type="radio" name="choixPaiement" value="cb">CB</label>
                                <label class="btn btn-outline-primary"><input class="visiblity" type="radio" name="choixPaiement" value="especes" >ESPECES</label>
                                <label class="btn btn-outline-primary"><input class="visiblity" type="radio" name="choixPaiement" value="cheque" >CHEQUE</label>
                                <label class="btn btn-outline-primary"><input class="visiblity" type="radio" name="choixPaiement" value="tResto" >T RESTO</label>

                            </div>

                            <table  border="2">

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
                                    <td colspan=2><input type="reset" name="clear" style="    margin: 0;
                                                         padding: 0;
                                                         line-height: 100%; /* Si ça fonctionne pas mets 0 */
                                                         border: 0;
                                                         background: none; /* ou transparent je sais plus... */
                                                         font: /* Définis le même font qu'un lien traditionnel */

                                                         //text-decoration: underline;color:white; /* Normalement */"/></td>
                                </tr>

                            </table>
                            <br>
                            <label for="code">Montant : </label><input type="text" name="montantPaye" maxlength="4" required  autofocus="activeinput = this" onfocus="activeinput = this"  />
                            <label class="erreur">${loginErr}</label>
                            <a class="btn btn-primary"><input type="submit" name=""  value="valider" style="    margin: 0;
                                                              padding: 0;
                                                              line-height: 100%; /* Si ça fonctionne pas mets 0 */
                                                              border: 0;
                                                              background: none; /* ou transparent je sais plus... *
                                                              font: /* Définis le même font qu'un lien traditionnel */
                                                              color: /* La même couleur... */
                                                              //text-decoration: underline;color:white; /* Normalement */"/></a>

                        </form>
                        </tbody>
                    </div>

                </div>

            </div>
        </div>

        <div class="py-5">
            <div class="container">
                <div class="row">
                    <div class="col-md-12">
                        <table class="table">
                            <tbody>
                                <tr>
                                    <td>Montant HT :</td><td>${totalHT} €</td>
                                </tr>
                                <c:forEach   var="t" items="${lTva}">
                                    <tr>
                                        <td>${t.nom} ${t.taux} %:</td><td>€</td>
                                    </tr>
                                </c:forEach>
                                <tr>
                                    <td>Montant TTC :</td><td>${totalTTC} €</td>
                                </tr>
                                <tr>
                                    <td>Reste à payer :</td><td>${rap} €</td>
                                </tr>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
        </div>                    
        <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.3/umd/popper.min.js" integrity="sha384-vFJXuSJphROIrBnz7yo7oB41mKfc8JzQZiCq4NCceLEaO4IHwicKwpJf9c9IpFgh" crossorigin="anonymous"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/js/bootstrap.min.js" integrity="sha384-h0AbiXch4ZDo7tp9hKZ4TsHbi047NrKGLO3SEJAg45jXxnGIfYzk4Si90RDIqNm1" crossorigin="anonymous"></script>
        <script src="/BigBaldsBurgers-war/js/paveNumerique.js" type='text/javascript' ></script> 
    </body>

</html>

