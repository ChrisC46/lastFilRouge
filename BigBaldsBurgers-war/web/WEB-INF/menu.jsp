<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<div class="produit">
    <h2>Menu ${nomMenu}</h2>
    <h3 class="separ">Entrée</h3>
    <div class="menu-choix">
        <h4>Entrée 1</h4>
        <p>lorem ipsum lorem ipsum lorem ipsum  </p>
        <div class="menu-choix-input">
            <input type="radio" id="entree1"name="entree" value="entree1">
        </div>
    </div>


    <div class="menu-choix">
        <h4>Entrée 2</h4>
        <p>lorem ipsum lorem ipsum lorem ipsum </p>  
        <div class="menu-choix-input">
            <input type="radio" id="entree2" name="entree" value="entree2">
        </div>

        <!-- <label for="entree2">Entrée 2</label> -->
    </div>
    <div class="menu-choix">
        <h4>Entrée 3</h4>
        <p>lorem ipsum lorem ipsum lorem ipsum </p>
        <div class="menu-choix-input">
            <input type="radio" id="entree3" name="entree" value="entree3"> 
        </div>
    </div>
    
     <h3 class="separ">Plat</h3>
    <div class="menu-choix">
        <h4>Plat 1</h4>
        <p>lorem ipsum lorem ipsum lorem ipsum  </p>
        <div class="menu-choix-input">
            <input type="radio" id="entree1"name="entree" value="entree1">
        </div>
    </div>


    <div class="menu-choix">
        <h4>Plat 2</h4>
        <p>lorem ipsum lorem ipsum lorem ipsum </p>  
        <div class="menu-choix-input">
            <input type="radio" id="entree2" name="entree" value="entree2">
        </div>

        <!-- <label for="entree2">Entrée 2</label> -->
    </div>
    <div class="menu-choix">
        <h4>Plat 3</h4>
        <p>lorem ipsum lorem ipsum lorem ipsum </p>
        <div class="menu-choix-input">
            <input type="radio" id="entree3" name="entree" value="entree3"> 
        </div>
    </div>

</div>
    <!--
    <ul>
        <li>Entrée 1 <input type="radio" value="plat1"/></li>
        <li>Entrée 2 <input type="radio" value="plat2" /></li>
        <li>Entrée 3 <input type="radio" value="plat3" /></li>
    </ul>
    <h3 class="separ">Plat</h3>

    <ul>
        <li>Plat 1 <input type="radio" value="plat1"/></li>
        <li>Plat 2 <input type="radio" value="plat2" /></li>
        <li>Plat 3 <input type="radio" value="plat3" /></li>
    </ul>



    <h3 class="separ">Déssert</h3>
        <ul>
        <li>Déssert 1 <input type="radio" value="plat1"/></li>
        <li>Déssert 2 <input type="radio" value="plat2" /></li>
        <li>Déssert 3 <input type="radio" value="plat3" /></li>    
    
    
    </ul>

    
    
    <p class="prix"><strong>15 €</strong></p>
    <c:url value="FrontControlleur?section=serveur&&ajouter" var="url01" />
<p><a href="${url01}">confirmer</a></p>
    <c:set var="p" value="${prod}" /> 
    <p>${p.nom}</p>
    <p>${p.description}</p>
    <p class="prix"><strong>${p.prix}</strong></p>
    <c:url value="FrontControlleur?section=serveur&&panier=add" var="url01" />
<p><a href="${url01}">ajout!</a></p>
</div>