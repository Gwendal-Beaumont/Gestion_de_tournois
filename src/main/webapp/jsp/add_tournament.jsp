<%--
  Created by IntelliJ IDEA.
  User: lenaderoche
  Date: 17/03/2021
  Time: 09:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Rejoindre un tournoi </title>
    <%@ include file="template/head_import.jsp" %>
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/style.css">
</head>
<body>
    <%@include file="template/navbar.jsp"%>

    <form action="AddTournament" method="post">
        <h4> saisissez le code </h4>
        <input id="id-tournoi" type="text" class="form-control"
               placeholder="" value="" required/>
        <input type="submit" class="btnSubmit" value="Rejoindre"/>
    </form>


    <%@ include file="template/footer.jsp" %>
</body>
</html>
