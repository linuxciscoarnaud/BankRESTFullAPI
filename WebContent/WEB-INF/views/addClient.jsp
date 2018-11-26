<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<form:form method="POST" modelAttribute="newClient" class="form-horizontal">

    <fieldset>
        <legend>Add new client</legend>
            <div class="form-group">
                <label class="control-label col-lg-2 col-lg-2" for="nomClient">Nom</label>
                <div class="col-lg-10">
                    <form:input id="nomClient" path="nomClient" type="text" class="form:input-large"/>
                </div>
            </div>
            
            <div class="form-group">
                <label class="control-label col-lg-2 col-lg-2" for="adresseClient">Adresse</label>
                    <form:input id="adresseClient" path="adresseClient" type="text" class="form:input-large"/>
                <div class="col-lg-10">
                </div>
            </div>
            
            <div class="form-group">
                <div class="col-lg-offset-2 col-lg-10">
                    <input type="submit" id="btnAdd" class="btn btn-primary" value ="Add"/>
                </div>
            </div>
    </fieldset>

</form:form>