<%@ page pageEncoding="UTF-8" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@ include file="template/head_import.jsp" %>
    <title>login.jsp</title>
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/login.css">
</head>
<body>
<div class="login_box">
    <h1>Se connecter</h1>
    <%@ include file="template/alerts.jsp" %>
    <form action="Login" method="post">

        <input name="username" type="text" class="form-control"
               placeholder="Username" value="" required/>
        <input name="password" type="password" class="form-control"
               placeholder="Mot de passe" value="" required/>
        <input type="submit" class="btn_submit" value="Connexion" name="connect"/>
        <a href="<c:url value="Register"/>" class="ForgetPwd">Pas encore enregistré ?</a>

    </form>
</div>
</body>
</html>