<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<h2>Nos formules</h2>
<div class="produit-grid">
    <h3>Menu A</h3>
    <p class="prix"><strong>15€ </strong></p>
    <c:url value="FrontControlleur?section=serveur&&consulter=menu" var="url01" />
    <p><a href="${url01}">Click!</a></p>
</div>
<div class="produit-grid">
    <h3>Menu B</h3>
    <p class="prix"><strong>15€ </strong></p>
    <c:url value="FrontControlleur?section=serveur&&consulter=menu" var="url01" />
    <p><a href="${url01}">Click!</a></p>
</div>
<div class="produit-grid">
    <h3>Menu C</h3>
    <p class="prix"><strong>15€ </strong></p>
    <c:url value="FrontControlleur?section=serveur&&consulter=menu" var="url01" />
    <p><a href="${url01}">Click!</a></p>
</div>
<div class="produit-grid">
    <h3>Menu D</h3>
    <c:url value="FrontControlleur?section=serveur&&consulter=menu" var="url01" />
        <p class="prix"><strong>15€ </strong></p>
    <p><a href="${url01}">Click!</a></p>
</div>
<div class="produit-grid">
    <h3>Menu F</h3>
    <p class="prix"><strong>15€ </strong></p>
    <c:url value="FrontControlleur?section=serveur&&consulter=menu" var="url01" />
     
    <p><a href="${url01}">Click!</a></p>
</div>
<c:forEach items="${collection}"  var="p">

    <div class="produit-grid">
        <h3>Menu G</h3>
        <p>${p.nom}</p>
        <p>${p.description}</p>
        <p class="prix"><strong> ${p.prix}</strong></p>
                <c:url value="FrontControlleur?section=serveur&&consulter=menu" var="url01" />
        <p><a href="${url01}">Click!</a></p>
    </div>
</c:forEach>