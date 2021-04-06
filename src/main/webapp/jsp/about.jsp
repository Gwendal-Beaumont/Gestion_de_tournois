<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page pageEncoding="UTF-8" %>
<html>
<head>
    <%@ include file="template/head_import.jsp" %>
    <title>&Agrave; propos</title>
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/style.css">
</head>
<body>
<%@ include file="template/navbar.jsp" %>

<section id="about-section">
    <h1>Qu'est-ce que TMaker ?</h1>
    <p><span class="tabulation"></span>TMaker c'est un outil qui permet de gérer des tournois pour
        différents sports (football, basketball, tennis, échecs, e-sport etc). Il est possible de créer, modifier,
        supprimer, participer des tournois et de gérer sa propre équipe ! Il existe des tournois dits publics qui sont
        affichés et dont l'évolution est accessible depuis la page d'accueil, et les tournois privés, visibles
        uniquement par les joueurs participants à ce tournoi.</p>
    <h1>Qui êtes vous et comment est venue l'idée de cette application ?</h1>
    <p><span class="tabulation"></span>Nous sommes une équipe de cinq élèves-ingénieurs de l’école des Mines d’Alès (IMT
        Mines Alès) et, le sport étant une part importante de la vie de l’école, ce projet a été choisi par le groupe
        pour répondre à la création de tournois au sein de celle-ci mais aussi pour répondre au cours de l’UE Elective :
        Conception et Elaboration d’un Produit Informatique (CEPI). Pouvoir proposer un prototype fonctionnel d’un
        système élaboré de gestion de tournois nous permet de mettre en œuvre nos capacités en codage informatique HTML,
        CSS, Java et SQL (l’entièreté du site repose sur JSP et la liaison d’une base de données et le code d’affichage
        au format HTML).</p>
    <h1>Comment fonctionne ce site ?</h1>
    <p><span class="tabulation"></span>Ce site est divisé en plusieurs onglets dont le nom est plutôt univoque. Tout
        d'abord l'onglet d'accueil. Comme son nom l'indique, cet onglet sert de hub à l'utilisateur et permet de
        consulter en une seule page les tournois en cours pour l'utilisateur. Celui des tournois permets de consulter
        des tournois publics en cours, modifier un tournoi ou créer un nouveau tournoi ! L'onglet Profil, uniquement
        disponible pour les utilisateurs connectés, permet de modifier son nom, son adresse mail ou son mot de passe.
    </p>
</section>

<%@ include file="template/footer.jsp" %>
</body>
</html>
