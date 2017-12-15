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
        <jsp:include page="includes/navBar.jsp" />
        
        <div class="separ"></div>
        <div class="container">
            
              
        </div>
        <p> Formules </P>
        <c:forEach var="ca" items="${categorieCarte}">            
        <li>${ca.nom}</li>            
        </c:forEach>
        <br><p> Soda </P><br>
        <c:forEach var="de" items="${soda}">            
        <li>${de.nom}</li>            
        </c:forEach>
        

            <jsp:include page="includes/detailsCommande.jsp" />
    </body>
</html>
