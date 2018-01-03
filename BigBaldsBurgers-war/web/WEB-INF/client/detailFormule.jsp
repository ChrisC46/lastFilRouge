
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


        <div class="col-md-3" style="">
            <div class="card">
                <strong> ${produit.nom}</strong>
                <img class="img-fluid d-block" src=${produit.image}>
                <p> ${produit.prix}euros</p>
                <p> ${produit.description}</p>
                <button type="button" class="btn btn-primary btn-lg btn-block">Selectionner</button>

            </div>
            
                </div>
                <strong> Choix du Burger </strong> <br>
                <c:forEach var="burger" items="${burger}">
                    <label class="radio-inline"><input type="radio" name="optradio">${burger.nom}</label>
                </c:forEach><br>
                <strong> Choix de l'accompagnement </strong>  <br>
                <c:forEach var="accompagnement" items="${accompagnement}">
                    <label class="radio-inline"><input type="radio" name="optradio">${accompagnement.nom}</label>
                </c:forEach><br>
                <strong> Choix de la boisson </strong>  <br>
                <c:forEach var="boisson" items="${boisson}">
                    <label class="radio-inline"><input type="radio" name="optradio">${boisson.nom}</label>
                </c:forEach>
                    

            

            <div class="py-5" style=""></div>
            <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
            <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.3/umd/popper.min.js" integrity="sha384-vFJXuSJphROIrBnz7yo7oB41mKfc8JzQZiCq4NCceLEaO4IHwicKwpJf9c9IpFgh" crossorigin="anonymous"></script>
            <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/js/bootstrap.min.js" integrity="sha384-h0AbiXch4ZDo7tp9hKZ4TsHbi047NrKGLO3SEJAg45jXxnGIfYzk4Si90RDIqNm1" crossorigin="anonymous"></script>
            <pingendo onclick="window.open('https://pingendo.com/', '_blank')" style="cursor:pointer;position: fixed;bottom: 10px;right:10px;padding:2px;background-color: #00b0eb;border-radius: 8px; width:100px;display:flex;flex-direction:row;align-items:center;justify-content:center;font-size:12px;color:white">made with&nbsp;&nbsp;

                </body>

                </html>