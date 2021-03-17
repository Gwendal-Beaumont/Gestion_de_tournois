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
    <title>add_tournament</title>
    <%@ include file="template/head_import.jsp" %>
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/style.css">
</head>
<body>
    <%@include file="template/navbar.jsp"%>
    <h1> sélectionner votre équipe </h1>
    <form action="joinTeam" method="post">

        <select name="team" id="team" required>

            <option value="Sélectionner une équipe" disabled selected hidden>Sélectionner une équipe</option>
            <c:forEach items="${sports}" var="sport">
                <option value="${sport.getId()}">${sport.getNom()}</option>
            </c:forEach>

        </select>




    </form>


    <%@ include file="template/footer.jsp" %>
</body>
</html>
