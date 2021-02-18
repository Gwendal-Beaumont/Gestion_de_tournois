<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page pageEncoding="UTF-8" %>
<%@ include file="template/debut.jsp" %>
<%@ include file="template/navbar.jsp" %>
<title>home.jsp - ${utilisateur.nom}</title>
<div class="jumbotron">
    <h1 class="display-4">Bonjour ${utilisateur.getLogin()},
    </h1>
    <!-- <c:forEach items="${listeTournoisJSP}" var="unTournois">
        <div>${unTournois} pour ** ${utilisateur.getLogin()}</div>
    </c:forEach>

    -->

    <div>Premier test, le sport associé à l'id 1 est : ${sport} hehe</div>
    <br>
    <a href="<c:url value="Logout"/>">Déconnexion</a>
</div>

<%@ include file="template/fin.jsp" %>
