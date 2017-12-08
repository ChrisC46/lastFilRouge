<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="menuBar">
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
        <c:url value="FrontControlleur?section=serveur&&consulter=boissons" var="url06" />
        <li><a href="${url06}">Nos Boissons</a></li>
    </ul>
</div>