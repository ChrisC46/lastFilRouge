
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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



        <div class="row col-md-9" style="float:left">
            <div class="col-md-3" >
                <div class="card">
                    <strong> ${produit.nom}</strong>
                    <img class="img-fluid d-block" src=${produit.image}>
                    <p> ${produit.prix}euros</p>
                    <p> ${produit.description}</p>
                    <p>${proprietes} </p>
                    <p>${ingredients} </p>
                    <button type="button" class="btn btn-primary btn-lg btn-block">Selectionner</button>
                </div>



            </div>

        </div>
        <%@include file="/WEB-INF/includes/detailsCommande.jsp" %>
        <div class="py-5" style=""></div>
        <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.3/umd/popper.min.js" integrity="sha384-vFJXuSJphROIrBnz7yo7oB41mKfc8JzQZiCq4NCceLEaO4IHwicKwpJf9c9IpFgh" crossorigin="anonymous"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/js/bootstrap.min.js" integrity="sha384-h0AbiXch4ZDo7tp9hKZ4TsHbi047NrKGLO3SEJAg45jXxnGIfYzk4Si90RDIqNm1" crossorigin="anonymous"></script>
    </body>

</html>