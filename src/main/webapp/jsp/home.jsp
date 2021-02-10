<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page pageEncoding="UTF-8" %>
<%@ include file="template/debut.jsp"%>
<div class="jumbotron">
    <h1 class="display-4">Bonjour ${utilisateur.nom}
    </h1>
    <a href="<c:url value="Logout"/>">Déconnexion</a>
</div>

<%@ include file="template/fin.jsp"%>
