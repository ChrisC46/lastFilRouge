<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:forEach items="${collection}" var="promo">
    <div class="produit">
        <p>${promo.dateDebutPromo}</p>
        <p>${promo.dateFinPromo}</p>
        <p><strong>${promo.remise}</strong></p>
    </div>
</c:forEach>
<p>TEST</p>