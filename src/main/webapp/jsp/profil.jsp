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
    <div class="input-fields">
        <form action="Profil" method="post">
            <h3>Nom</h3>
            <input name="username" type="text" class="form-control"
                   placeholder="Username" value="${utilisateur.getUsername()}"/>

            <h3>Adresse mail </h3>
            <input name="email" type="email" class="form-control"
                   placeholder="Email" value="${utilisateur.getEmail()}"/>

            <h3>Mot de passe</h3>
            <input name="password" type="password" class="form-control"
                   placeholder="Mot de passe" value=""/>

            <h5>Saissez votre mot de passe actuel pour valider les changements</h5>
            <input name="checkpassword" type="password" class="form-control"
                   placeholder="Mot de passe" value="" required/>

            <br/>
            <br/>
            <br/>
            <input type="submit" class="btnSubmit" value="Modifier"/>

        </form>
    </div>
</div>

<div class="accueil">
    <h1> Mes tournois passés</h1>

<%@include file="template/display_tournament.jsp"%>
</div>

<%@ include file="template/footer.jsp" %>

</body>
</html>
