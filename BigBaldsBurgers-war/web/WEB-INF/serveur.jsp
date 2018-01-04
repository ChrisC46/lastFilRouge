<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css" type="text/css">
        <link rel="stylesheet" href="https://v40.pingendo.com/assets/bootstrap/bootstrap-4.0.0-beta.1.css" type="text/css"> </head>

    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>JSP Page</title>
</head>
<body>
    <h1>Hello Serveur</h1>
    <form>
        <div class="py-5">
            <div class="container">
                <div class="row">
                    <div class="col-md-12">
                        <p class="lead">Séléctionnez : </p>
                    </div>
                    <div class="col-md-12">
                        <div class="btn-group">
                            <c:url value="FrontControleur?section=emplacement&spec=empAll" var="all"/>
                            <a href="${all}" class="btn btn-outline-primary">Toutes les tables</a>
                            <c:url value="FrontControleur?section=emplacement&spec=empDispo" var="dispo"/>
                            <a href="${dispo}" class="btn btn-outline-primary">Table(s) disponible(s)</a>
                            <c:url value="FrontControleur?section=emplacement&spec=empOcc" var="occu"/>
                            <a href="${occu}" class="btn btn-outline-primary">Table(s) occupée(s)</a> 
                        </div><br><br>
                        <c:forEach var="emp" items="${emplacements}">  
                            <a class="btn btn-primary" href="">${emp.numero} </a>                            
                        </c:forEach> 
                           <c:forEach var="eDispo" items="${emplacementDispo}">  
                            <a class="btn btn-primary" href="">${eDispo} </a>                            
                        </c:forEach> 
                            <c:forEach var="eOccu" items="${emplacementOcc}">
                                <a class="btn btn-primary" href="">${eOccu} </a>
                            </c:forEach>        
                    </div>
                </div>
            </div>
        </div>
        <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.3/umd/popper.min.js" integrity="sha384-vFJXuSJphROIrBnz7yo7oB41mKfc8JzQZiCq4NCceLEaO4IHwicKwpJf9c9IpFgh" crossorigin="anonymous"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/js/bootstrap.min.js" integrity="sha384-h0AbiXch4ZDo7tp9hKZ4TsHbi047NrKGLO3SEJAg45jXxnGIfYzk4Si90RDIqNm1" crossorigin="anonymous"></script>
</body>
</html>
