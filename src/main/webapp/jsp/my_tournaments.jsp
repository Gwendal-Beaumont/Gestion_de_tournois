<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@ include file="template/head_import.jsp" %>
    <title>Mes tournois</title>
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/style.css">
</head>
<body>
<%@include file="template/navbar.jsp" %>

<div class="jumbotron">

    <p>Les tournois auxquels vous participez :</p>
    <c:forEach items="${listeTournois}" var="tournoi">
        <p>${tournoi.getNom_tournoi()}<br>
        </p>
    </c:forEach>

</div>

<%@ include file="template/footer.jsp" %>
</body>
</html>
