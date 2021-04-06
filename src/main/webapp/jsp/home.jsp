<%@ page pageEncoding="UTF-8" %>
<html>
<head>
    <%@ include file="template/head_import.jsp" %>
    <title>Accueil - ${utilisateur.getUsername()}</title>
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/style.css">
</head>
<body>
<%@include file="template/navbar.jsp" %>

<div class='accueil'>
    <h1>Accueil</h1>
    <h4>Les tournois publics en cours :</h4>
    <%@ include file="template/display_tournament.jsp" %>
</div>

<%@ include file="template/footer.jsp" %>

</body>
</html>