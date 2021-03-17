<%@ page pageEncoding="UTF-8" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@ include file="template/head_import.jsp" %>
    <title>register.jsp</title>
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/login.css">
</head>
<body>
<div class="login_box">
    <h1>S'enregistrer</h1>
    <%@ include file="template/alerts.jsp" %>
    <form action="Register" method="post">

        <input name="username" type="text" class="form-control"
               placeholder="Username" value="" required/>
        <input name="email" type="email" class="form-control"
               placeholder="Email" value="" required/>
        <input name="password" type="password" class="form-control"
               placeholder="Mot de passe" value="" required/>
        <input type="submit" class="btnSubmit" value="S'enregistrer"/>
        <a href="<c:url value="Login"/>" class="ForgetPwd">Déjà enregistré ?</a>

    </form>
    <br>
    <br>
    <a href="<c:url value="/"/>">Retour vers la page d'accueil</a>
</div>
</body>
</html>