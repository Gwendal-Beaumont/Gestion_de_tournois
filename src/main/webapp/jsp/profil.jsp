<%--
  Created by IntelliJ IDEA.
  User: jeanb
  Date: 03/03/2021
  Time: 09:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@ include file="template/head_import.jsp" %>
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/style.css">
    <title> Mon profil </title>
</head>
<body>
<%@ include file="template/navbar.jsp" %>
<h1> Mon profil</h1>

<div class="crt-tournament-box">
    <form action="Profil" method="post">

        <h4>Nom</h4>
        <input name="username" type="text" class="form-control"
               placeholder="Username" value="${utilisateur.getUsername()}"/>

        <h4>Adresse mail </h4>
        <input name="email" type="email" class="form-control"
               placeholder="Email" value="${utilisateur.getEmail()}"/>

        <h4>Mot de passe</h4>
        <input name="password" type="password" class="form-control"
               placeholder="Mot de passe" value=""/>

        <h6>Saissez votre mot de passe actuel pour valider les changements</h6>
        <input name="checkpassword" type="password" class="form-control"
               placeholder="Mot de passe" value="" required/>

        <br/>
        <input type="submit" class="btnSubmit" value="Modifier"/>


    </form>
</div>

<div class="history-tournaments">
    <h1> Mes tournois passés :</h1>

    <div class="history-tournaments-list">
        <c:forEach items="${listeTournois}" var="tournoi">
            <h3>Tournoi ${tournoi.getNom_tournoi()} (id : #${tournoi.getId()})</h3>
            <ul>
                <li>Sport pratiqué : ${tournoi.getId_sport()}</li>
                <li>Visibilité :
                    <c:choose>
                        <c:when test="${tournoi.getVisibility() == true}">Public</c:when>
                        <c:when test="${tournoi.getVisibility() == false}">Privé</c:when>
                    </c:choose>
                </li>
                <li>Date de début : ${tournoi.getStringDate()}</li>
            </ul>
        </c:forEach>
    </div>
</div>

<%@ include file="template/footer.jsp" %>

</body>
</html>
