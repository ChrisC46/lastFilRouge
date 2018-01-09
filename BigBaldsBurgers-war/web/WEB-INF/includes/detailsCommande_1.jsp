<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<div class="col-md-3.detailsCommande" style="">
                    
            <div>
            <h1>Commande</h1>
            <table>
                <table>
                <thead>
                    <tr>
                        <th>nom</th>
                        <th>reference</th>
                        <th>qte</th>
                        <th>prixHT</th>
                        <th>prixTTC</th>
                        <th>action</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${maListe}" var="l">
                        <tr>
                            <td>${l.produit.nom}</td>
                            <td>${l.produit.reference}</td>
                            <td>${l.qte}</td>
                            <td>${l.prixHT}</td>
                            <td>${l.prixTTC}</td>
                            <td>
                                <c:url value="FrontControleur?section=operations-panier&origine=panier&action=add&ref=${l.produit.reference}" var="urlp" />
                                <c:url value="FrontControleur?section=operations-panier&origine=panier&action=del&ref=${l.produit.reference}" var="urlx" />
                                <c:url value="FrontControleur?section=operations-panier&origine=panier&action=dec&ref=${l.produit.reference}" var="urld" />
                                <a href="${urlp}"> + </a> | <a href="${urld}"> - </a> | <a href="${urlx}"> x </a>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
            </table>

        </div>
