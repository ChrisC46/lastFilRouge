
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css" type="text/css">
        <link rel="stylesheet" href="https://v40.pingendo.com/assets/bootstrap/bootstrap-4.0.0-beta.1.css" type="text/css"> </head>

    <body>
        <div class="py-5">
            <div class="container">
                <div class="row">
                    <div class="col-md-12">
                        <ul class="nav nav-pills" style="opacity: 0.5;">
                            <li class="nav-item">
                                <a href="#" class="active nav-link"> <i class="fa fa-home fa-home"></i>&nbsp;Home</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" href="#">Deconnection</a>
                            </li>
                            <li class="nav-item text-right">
                                <a href="#" class="nav-link text-right"> <i class="fa fa-bell fa-bell"></i>&nbsp;Appel Serveur</a>
                            </li>
                        </ul>
                    </div>
                </div>
            </div>
        </div> 

        <div class="py-5">
            <div class="container">
                <div class="row">
                    <div class="col-md-12">         
                        <c:url value="FrontControleur?section=cuisine&describe=all" var="comAll"/>
                        <a href="${comAll}" class="btn btn-outline-primary">Toutes les commandes</a>
                        <c:url value="FrontControleur?section=cuisine&describe=transmis" var="comTran"/>
                        <a href="${comTran}" class="btn btn-outline-primary">Commandes transmises</a>
                        <c:url value="FrontControleur?section=cuisine&describe=preparation" var="comPrepa"/>
                        <a href="${comPrepa}" class="btn btn-outline-primary">Commandes en préparations</a>
                        <c:url value="FrontControleur?section=cuisine&describe=pret" var="comPret"/>
                        <a href="${comPret}" class="btn btn-outline-primary">Commandes prêtes</a>
                    </div>
                </div>
            </div>
        </div><br> 
        <div class="py-5">
            <div class="container">       
                <div class="row">
                    <c:forEach var="ligneCom" items="${ligneCommande}">
                        <div class="col-md-3">Commande n°${ligneCom.commande.id} </div>
                        <div class="col-md-3">${ligneCom.produit.nom} ${ligneCom.formule.nom} | Quantité : ${ligneCom.qteCommande}  </div> 
                        <div class="col-md-3">Cuisson : ${ligneCom.typeCuissonLigneCo.cuisson} | + ${ligneCom.commentSpec}</div>
                        <div class="col-md-3"><a class="btn btn-primary" href="" onclick="${commandeUpdate}" > ${ligneCom.suiviCuisine.nom} </a></div>
                        </c:forEach>    
                </div>
            </div>
        </div>
        <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.3/umd/popper.min.js" integrity="sha384-vFJXuSJphROIrBnz7yo7oB41mKfc8JzQZiCq4NCceLEaO4IHwicKwpJf9c9IpFgh" crossorigin="anonymous"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/js/bootstrap.min.js" integrity="sha384-h0AbiXch4ZDo7tp9hKZ4TsHbi047NrKGLO3SEJAg45jXxnGIfYzk4Si90RDIqNm1" crossorigin="anonymous"></script>
    </body>

</html>
