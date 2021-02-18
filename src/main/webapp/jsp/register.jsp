<%@ page pageEncoding="UTF-8" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>register.jsp</title>
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/login.css">
</head>
<body>
<div class="login_box">
    <h1>S'enregistrer</h1>
    <%@ include file="template/alerts.jsp" %>
    <form action="Register" method="post">

        <input name="login" type="text" class="form-control"
               placeholder="Username" value="" required/>
        <input name="nom" type="text" class="form-control"
               placeholder="Nom" value="" required/>
        <input name="password" type="password" class="form-control"
               placeholder="Mot de passe" value="" required/>
        <input type="submit" class="btnSubmit" value="S'enregistrer"/>
        <a href="<c:url value="Login"/>" class="ForgetPwd">Déjà enregistré ?</a>

    </form>
</div>
</body>
</html>