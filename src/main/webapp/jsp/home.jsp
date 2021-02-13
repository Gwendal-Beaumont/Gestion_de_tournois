<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page pageEncoding="UTF-8" %>
<%@ include file="template/debut.jsp" %>
<title>Accueil - ${utilisateur.nom}</title>
<div class="jumbotron">
    <h1 class="display-4">Bonjour ${utilisateur.nom},
    </h1>
    <c:forEach items="${listeTournoisJSP}" var="unTournois">
        <div>${unTournois} pour ** ${utilisateur.nom}</div>
    </c:forEach>
    <br>
    <a href="<c:url value="Logout"/>">Déconnexion</a>
</div>

<%@ include file="template/fin.jsp" %>
