<%--
  Created by IntelliJ IDEA.
  User: lenaderoche
  Date: 10/03/2021
  Time: 08:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>manage_tournaments.jsp</title>
    <%@ include file="template/head_import.jsp" %>
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/style.css">
</head>
<body>
<%@include file="template/navbar.jsp" %>
<div class="paramtournoi">

    <h1>${tournoi.getNom_tournoi()} (#${tournoi.getId()})</h1>
    <h4>sport : ${tournoi.getSport().getNom()}</h4>
    <h4>date_du_tournoi : ${tournoi.getStringDate()}</h4>
    <h4>etat_du_tournoi : ${tournoi.getEtat()}</h4>
    <h4>Equipes</h4>

    <table>

        <tr>
            <td>équipe A</td>
            <td>id_joueur 1</td>
            <td>id_joueur 2</td>
            <td>id_joueur 3</td>
        </tr>
        <tr>
            <td>équipe B</td>
            <td>id_joueur 1</td>
            <td>id_joueur 2</td>
            <td>id_joueur 3</td>
        </tr>
        <tr>
            <td>équipe C</td>
            <td>id_joueur 1</td>
            <td>id_joueur 2</td>
            <td>id_joueur 3</td>
        </tr>

    </table>


</div>
<p>ID du tournoi : ${id_tournament}</p>
<%@ include file="template/footer.jsp" %>
</body>
</html>
