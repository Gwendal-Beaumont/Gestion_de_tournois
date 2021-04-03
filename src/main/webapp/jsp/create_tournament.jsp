<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page pageEncoding="UTF-8" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@ include file="template/head_import.jsp" %>
    <title>Créer mon tournoi !</title>
    <link rel="stylesheet" type="text/css" href="<c:url value="/css/style.css"/>">
</head>

<body>
<%@include file="template/navbar.jsp" %>

<div class="crt-tournament-box">
    <div class="input-fields">
        <h1> Créer mon tournoi ! </h1>
        <form action="create_tournament" method="post">
            <h4>Choisir le nom du tournoi :</h4>
            <input name="nom-tournoi" type="text" class="form-control"
                   placeholder="Nom du tournoi" value="" required/>

            <h4>Choisir le sport :</h4>
            <select name="sport" id="sport" required>
                <option value="Sélectionner un sport" disabled selected hidden> Sélectionner un sport</option>
                <c:forEach items="${sport}" var="sport">
                    <option value="${sport.getId()}">${sport.getNom()}</option>
                </c:forEach>

            </select>

            <h4>Date de début du tournoi :</h4>
            <input name="date-debut" type="datetime-local" value="" required/>
            <p>Problème d'affichage ? Si vous êtes sous Internet Explorer, Firefox ou Safari, essayez avec un autre
                navigateur.<br></p>


            <div class="selection-visibility">
                <h4>Visibilité du tournoi : (public par défaut)</h4>
                <input name="visibility" type="radio" id="public" value="public" required/>
                <label for="public">Public</label>
                <input name="visibility" type="radio" id="prive" value="prive" required/>
                <label for="prive">Privé</label>
            </div>

            <input type="submit" class="btnSubmit" value="Créer mon tournoi"
                   <c:if test="${utilisateur.getUsername() == null}">disabled</c:if>/>

        </form>
    </div>
</div>

<%@ include file="template/footer.jsp" %>
</body>
</html>
