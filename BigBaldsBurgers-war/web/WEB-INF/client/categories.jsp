<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="py-3" style="">
    <div class="container-fluid">
        <div class="row col-md-9">
            <div class="col-md-3" style="">
                <div class="card">
                    <c:url value="FrontControleur?section=formules" var="formules" />
                    <div class="card-header"> <a href="${formules}"> Formules </a></div>
                    <div class="card-body">
                        <a href="${formules}"> <img class="img-fluid d-block" src="images/formule.png"></a> </div> 
                </div>
            </div>
            <div class="col-md-3" style="">
                <div class="card">
                    <c:url value="FrontControleur?section=entree" var="entree" />
                    <div class="card-header"><a href="${entree}">Entrees</a></div>
                    <div class="card-body">
                        <a href="${entree}"> <img class="img-fluid d-block" src="images/Entree.png"> </a>  </div>
                </div>
            </div>
            <div class="col-md-3" style="">
                <div class="card">
                    <c:url value="FrontControleur?section=burgers" var="burgers" />
                    <div class="card-header"><a href="${burgers}"> Burgers </a></div>
                    <div class="card-body">
                        <a href="${burgers}"> <img class="img-fluid d-block" src="images/burgers.png"> </a>  </div>
                </div>
            </div>
        </div>
    </div>
    <div class="py-3" style="">
        <div class="container-fluid">
            <div class="row col-md-9">
                <div class="col-md-3" style="">
                    <div class="card">
                        <c:url value="FrontControleur?section=accompagnements" var="accompagnements" />
                        <div class="card-header">  <a href="${accompagnements}">Accompagnements </a></div>
                        <div class="card-body">
                            <a href="${accompagnements}"> <img class="img-fluid d-block" src="images/accompagnement.png"> </a>  </div>
                    </div>
                </div>
                <div class="col-md-3" style="">
                    <div class="card">
                        <c:url value="FrontControleur?section=boisson" var="boisson" />
                        <div class="card-header"> <a href="${boisson}"> Boissons </a> </div>
                        <div class="card-body">
                            <a href="${boisson}">  <img class="img-fluid d-block" src="images/Boisson.png"> </a>  </div>
                    </div>
                </div>
                <div class="col-md-3" style="">
                    <div class="card">
                        <c:url value="FrontControleur?section=dessert" var="dessert" />
                        <div class="card-header">  <a href="${dessert}">  Desserts </a></div>
                        <div class="card-body">
                            <a href="${dessert}">   <img class="img-fluid d-block" src="images/dessert.png"> </a>  </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>