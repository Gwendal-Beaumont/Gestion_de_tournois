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

        <h4> nom</h4>
        <input name="username" type="text" class="form-control"
           placeholder="Username" value=${utilisateur.getUsername()} />

        <h4> adresse mail </h4>
        <input name="email" type="email" class="form-control"
           placeholder="Email" value=${utilisateur.getEmail()} />

        <h4> Mot de passe</h4>
        <input name="password" type="password" class="form-control"
               placeholder="Mot de passe" value="" />

        <h6> Saissez votre mot de passe actuel pour valider les changements</h6>
        <input name="checkpassword" type="password" class="form-control"
               placeholder="Mot de passe" value="" required />

    <br/>
    <input type="submit" class="btnSubmit" value="Modifier"/>


</form>
</div >



<h1> mes tournois en cours :</h1>

    <c:forEach items="${listeTournois}" var="tournoi">
        <p><br></p>
    </c:forEach>

<%@ include file="template/footer.jsp" %>

</body>
</html>
