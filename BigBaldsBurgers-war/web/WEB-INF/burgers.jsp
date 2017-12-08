<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<h2>Nos burgers</h2>
<c:forEach items="${collection}" var="promo">
    <div class="produit-grid">
        <p>${promo.dateDebutPromo}</p>
        <p>${promo.dateFinPromo}</p>
        <p><strong>${promo.remise}</strong></p>
    </div>
</c:forEach>
