<%-- 
    Document   : accueil
    Created on : 6 déc. 2017, 16:23:47
    Author     : cdi313
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="/BigBaldsBurgers-war/css/baldcss.css" rel="stylesheet" type="text/css"/>

        <title>Big Balds Burger</title>
    </head>
    <body>
        <h1>Composez votre commande</h1>
        <div>
            <nav>
                <c:url value="FrontControlleur?section=serveur&&consulter=menus" var="url01" />
                <ul>
                    <li><a href="${url01}" >Nos Menus</a></li>
                        <c:url value="FrontControlleur?section=serveur&&consulter=offres" var="url02" />
                    <li><a href="${url02}" >Nos Offres</a></li>
                        <c:url value="FrontControlleur?section=serveur&&consulter=burgers" var="url03" />
                    <li><a href="${url03}" >Nos Burgers</a></li>
                        <c:url value="FrontControlleur?section=serveur&&consulter=accompagnements" var="url04" />
                    <li><a href="${url04}">Nos Accompagnements</a></li>
                        <c:url value="FrontControlleur?section=serveur&&consulter=desserts" var="url05" />
                    <li><a href="${url05}">Nos Désserts</a></li>
                        <c:url value="FrontControlleur?serveur&&consulter=boissons" var="url06" />
                    <li><a href="${url06}">Nos Boissons</a></li>
                </ul>
            </nav>
        </div>

        <div class="container">
            <c:forEach items="${collection}"  var="p">
                <div class="produit">
                    <p>${p.nom}</p>
                    <p>${p.description}</p>
                    <p class="prix"><strong>${p.prix}</strong></p>
                </div>
            </c:forEach>
            <p>${nom}</p>
        </div>


        <div class="detailsCommande">
            <h3>Détail de la commande</h3>

            <ul>

                <li>Item 1</li>
                <p>10€</p>
            </ul>
            <hr />
            <p class="total"><strong>Total</strong></p>
            <p><strong>1230203541 €</strong></p>

        </div>

    </body>
</html>
