<%@ page pageEncoding="UTF-8" %>
<html>
<head>
    <%@ include file="template/head_import.jsp" %>
    <title>home.jsp - ${utilisateur.getUsername()}</title>
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/style.css">
</head>
<body>
<%@include file="template/navbar.jsp" %>

<!-- Test de redirection pour vérifier si un utilisateur est connecté -->
<c:if test="${utilisateur.getUsername() == null}">
    <c:redirect url="/">Redirect</c:redirect>
</c:if>

<!-- L'historique des tournois d'un joueur devra apparaître dans la page Mes Tournois puis dans le Profil-->
<!-- <div class="jumbotron">
    <h1 class="display-4">Bonjour ${utilisateur.getUsername()},</h1>
    <br>
    <p>Historique des tournois pour ${utilisateur.getUsername()} en cours :</p>
    <c:forEach items="${listeTournois}" var="tournoi">
        <p>a<br></p>
    </c:forEach>

</div> -->

<div class = 'accueil'>
    <h1>Accueil</h1>
    <h4>Les tournois publics en cours</h4>
    <%@ include file="template/display_tournament.jsp" %>
</div>

<%@ include file="template/footer.jsp" %>

</body>
</html>