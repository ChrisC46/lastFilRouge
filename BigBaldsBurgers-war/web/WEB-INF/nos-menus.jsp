<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<p>test</p>
<c:forEach items="${collection}"  var="p">
    
    <div class="produit">
        <p>${p.nom}</p>
        <p>${p.description}</p>
        <p class="prix"><strong>${p.prix}</strong></p>
    </div>
</c:forEach>