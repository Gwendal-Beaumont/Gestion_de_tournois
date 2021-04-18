<%--
  Created by IntelliJ IDEA.
  User: lenaderoche
  Date: 10/03/2021
  Time: 08:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page pageEncoding="UTF-8" %>
<html>
<head>
    <title>Gestion du tournoi (#${tournoi.getId()})</title>
    <%@ include file="template/head_import.jsp" %>
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/style.css">
</head>
<body>
<%@include file="template/navbar.jsp" %>
<%@ include file="template/alerts.jsp" %>
<div class="paramtournoi">


    <h1>${tournoi.getNom_tournoi()} (#${tournoi.getId()})</h1>
    <h4>Sport : ${tournoi.getSport().getNom()}</h4>
    <h4>Date du tournoi : ${tournoi.getDate()}</h4>
    <h4>&Eacute;tat du tournoi : ${tournoi.getEtatJSP()}</h4>
    <br/>
    <h4>Liste des joueurs : <c:forEach items="${listeUtilisateur}"
                                       var="utilisateur"> ${utilisateur.getUsername()} |</c:forEach>
    </h4>
    <br/>
    <h4>&Eacute;quipes</h4>

    <table>
        <c:forEach items="${listeEquipe}" var="equipe">
            <tr>
                <td>${equipe.getNom_equipe()}</td>
                <c:forEach items="${equipe.getJoueurs_equipe()}" var="joueur">
                    <td>${joueur.getUsername()}</td>
                </c:forEach>
            </tr>
        </c:forEach>

    </table>
    <br/>
    <input type="button" class="btnSubmit" onclick="${tournoi.creeEquipe()}; window.location.reload()"
           value="Créer équipes">

</div>

<%@ include file="template/footer.jsp" %>
</body>
</html>
