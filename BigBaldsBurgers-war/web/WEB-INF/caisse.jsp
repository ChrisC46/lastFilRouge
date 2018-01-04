<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>

    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css" type="text/css">
        <link rel="stylesheet" href="https://v40.pingendo.com/assets/bootstrap/bootstrap-4.0.0-beta.1.css" type="text/css"> </head>

    <body class="text-center text-uppercase">
        <div class="py-5 my-5">
            <div class="container">
                <div class="row">
                    <div class="col-md-4">
                        <ul class="nav nav-pills flex-column">
                            <li class="nav-item">
                                <c:url value="FrontControleur?section=PaiementCtrl" var="url21" />  
                                <a href="${url21}" class="active nav-link"><i class=""></i>voir les tables à encaisser</a>
                            </li>
                            <c:forEach items="${lTable}" var="t">
                                <li class="nav-item">
                                    <c:url value="FrontControleur?section=DetailPaiementCtrl&numTable=${t.numero}" var="url22" />
                                    <a class="nav-link" href="${url22}">table numéro ${t.numero}</a>
                                </li>
                            </c:forEach>
                        </ul>
                    </div>
                    <div class="col-md-4">
                        <table class="table">
                            
                            <thead>
                                <tr>
                                    <th>Quantité</th>
                                    <th>Produit</th>
                                    <th>Montant</th>
                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach var="d" items="${lDetail}">
                                
                                <tr>
                                    <td>${d.qteCommande}</td>
                                    <td>${d.formule.nom}${d.produit.nom}</td>
                                    <td>${d.prixLigneDeCo} €</td>
                                </tr>
                                </c:forEach>
                           
                               
                            </tbody>
                        </table>
                    </div>
                    <div class="col-md-4">
                        <div class="btn-group">
                            <a href="#" class="btn btn-outline-primary">CB</a>
                            <a href="#" class="btn btn-outline-primary">ESPECES</a>
                            <a href="#" class="btn btn-outline-primary">CHEQUE</a>
                            <a href="#" class="btn btn-outline-primary">T RESTO</a>
                        </div>
                    </div>
                </div>
            </div>
        </div>
         <div class="py-5">
    <div class="container">
      <div class="row">
        <div class="col-md-12">
          <table class="table">
              <%--
            <thead>
              <tr>
                <th></th>
                <th>First Name</th>
                <th>Last Name</th>
              </tr>
            </thead>
              --%>
            <tbody>
              <tr>
                <td>Montant HT :</td>
                <td>€</td>
              </tr>
              <tr>
                <td>TVA à ...  :</td>
                <td>€</td>
              </tr>
              <tr>
                <td>TVA à ...  :</td>
                <td>€</td>
              </tr>
              <tr>
                <td>Montant TTC :</td>
                <td>€</td>
              </tr>
            </tbody>
          </table>
        </div>
      </div>
    </div>
  </div>                    
        <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.3/umd/popper.min.js" integrity="sha384-vFJXuSJphROIrBnz7yo7oB41mKfc8JzQZiCq4NCceLEaO4IHwicKwpJf9c9IpFgh" crossorigin="anonymous"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/js/bootstrap.min.js" integrity="sha384-h0AbiXch4ZDo7tp9hKZ4TsHbi047NrKGLO3SEJAg45jXxnGIfYzk4Si90RDIqNm1" crossorigin="anonymous"></script>
    </body>

</html>


<%-- 
    Document   : caisse
    Created on : 18 déc. 2017, 16:44:57
    Author     : Tofi


<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css" type="text/css">
        <link rel="stylesheet" href="https://v40.pingendo.com/assets/bootstrap/bootstrap-4.0.0-beta.1.css" type="text/css">
    </head>


    <body class="text-center text-uppercase w-25 h-25 my-1">
        <div class="py-5">
            <div class="container">
                <div class="row">
                    <div class="col-md-12">
                        <ul class="nav nav-pills flex-column text-center" style="">
                            <li class="nav-item">
                                <c:url value="FrontControleur?section=PaiementCtrl" var="url21" />  
                                <a href="${url21}" class="active nav-link"><i class=""></i>voir les tables à encaisser</a>
                            </li>
                            
                                <c:forEach items="${lTable}" var="t">
                                    <li class="nav-item">
                                        <a class="nav-link" href="#">table numéro ${t.numero}</a>
                                    </li>
                                </c:forEach>
                            

                        </ul>
                    </div>
                </div>
            </div>
        </div>
        <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.3/umd/popper.min.js" integrity="sha384-vFJXuSJphROIrBnz7yo7oB41mKfc8JzQZiCq4NCceLEaO4IHwicKwpJf9c9IpFgh" crossorigin="anonymous"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/js/bootstrap.min.js" integrity="sha384-h0AbiXch4ZDo7tp9hKZ4TsHbi047NrKGLO3SEJAg45jXxnGIfYzk4Si90RDIqNm1" crossorigin="anonymous"></script>
    <pingendo onclick="window.open('https://pingendo.com/', '_blank')" style="cursor:pointer;position: fixed;bottom: 10px;right:10px;padding:4px;background-color: #00b0eb;border-radius: 8px; width:110px;display:flex;flex-direction:row;align-items:center;justify-content:center;font-size:14px;color:white">made with&nbsp;&nbsp;
        <img src="https://pingendo.com/site-assets/Pingendo_logo_big.png" class="d-block" alt="Pingendo logo" height="16">
    </pingendo>
</body>
<%--
    <body>
        <h1>Hello caissier!</h1>

        <nav>

            <c:url value="FrontControleur?section=PaiementCtrl" var="url21" />
            <a href="${url21}">voir les tables à encaisser</a>
            <div>
               

                    <select>
                         <c:forEach items="${lTable}" var="t">
                        <option value="${t.numero}">table numéro ${t.numero}</option>
                         </c:forEach>
                    </select>


                
            </div>
        </nav>

    </body>

</html>
--%>