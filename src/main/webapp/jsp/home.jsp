<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page pageEncoding="UTF-8" %>
<html>
<head>
    <%@ include file="template/head_import.jsp" %>
    <title>home.jsp - ${utilisateur.nom}</title>
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/style.css">
</head>
<body>
<%@include file="template/navbar.jsp" %>
<div class="jumbotron">
    <h1 class="display-4">Bonjour ${utilisateur.getLogin()},
    </h1>
    <c:forEach items="${listeTournoisJSP}" var="unTournois">
        <div>${unTournois} pour *é* ${utilisateur.getLogin()}</div>
    </c:forEach>

    <div>Premier test, le sport associé à l'id 1 est : ${sport} !</div>
    <br>
    <a href="<c:url value="Logout"/>">Déconnexion</a>
    <br/>
    <a href="create_tournament.jsp"> Créer mon tournoi </a>



</div>

<%@ include file="template/footer.jsp" %>

</body>
</html>