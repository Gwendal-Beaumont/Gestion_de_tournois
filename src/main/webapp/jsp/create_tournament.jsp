<%@ page pageEncoding="UTF-8" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Créer mon tournoi !</title>
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/style.css">

</head>

<body>
<%@include file="template/navbar.jsp" %>
<h1> Créer mon tournoi ! </h1>

<form action="create_tournament" method="post">
    <input name="name" type="text" class="form-control"
           placeholder="nom du tournoi" value="" required/>

    <select name="sport" id="sport" required>

        <option value="Acrosport">Acrosport</option>
        <option value="Aerobic"> Aérobic</option>
        <option value="Aéromodélisme"> Aéromodélisme</option>
        <option value="Aikido"> Aikido</option>
        <option value="Airsoft"> Airsoft</option>
        <option value="Alpinisme"> Alpinisme</option>
        <option value="Athlétisme"> Athlétisme</option>
        <option value="Aviron"> Aviron</option>
        <option value="Babyfoot"> Babyfoot</option>
        <option value="Badminton"> Badminton</option>
        <option value="Baseball"> Baseball</option>
        <option value="Basketball"> Basketball</option>
        <option value="Beach soccer"> Beach soccer</option>
        <option value="Beach tennis"> Beach tennis</option>
        <option value="Beach volley"> Beach volley</option>
        <option value="Billard"> Billard</option>
        <option value="Boxe"> Boxe</option>
        <option value="Boxe anglaise"> Boxe anglaise</option>
        <option value="Boxe chinoise"> Boxe chinoise</option>
        <option value="Boxe française"> Boxe française</option>
        <option value="Boxe thaïlandaise"> Boxe thaïlandaise</option>
        <option value="Bras de fer"> Bras de fer</option>
        <option value="Catch"> Catch</option>
        <option value="Combat"> Combat</option>
        <option value="Curling"> Curling</option>
        <option value="E-sport"> E-sport</option>
        <option value="Echecs"> Echecs</option>
        <option value="Enduro"> Enduro</option>
        <option value="Escrime"> Escrime</option>
        <option value="Extreme Football League"> Extreme Football League</option>
        <option value="Football"> Football</option>
        <option value="Football américain"> Football américain</option>
        <option value="Football australien"> Football australien</option>
        <option value="Full contact"> Full contact</option>
        <option value="Futsal"> Futsal</option>
        <option value="Gymnastique"> Gymnastique</option>
        <option value="Gymnastique artistique"> Gymnastique artistique</option>
        <option value="Gymnastique rythmique"> Gymnastique rythmique</option>
        <option value="Haltérophilie"> Haltérophilie</option>
        <option value="Handball"> Handball</option>
        <option value="Handisport"> Handisport</option>
        <option value="Hockey"> Hockey</option>
        <option value="Hockey sur gazon"> Hockey sur gazon</option>
        <option value="Hockey sur glace"> Hockey sur glace</option>
        <option value="Horse ball"> Horse ball</option>
        <option value="Ju-Jitsu"> Ju-Jitsu</option>
        <option value="Judo"> Judo</option>
        <option value="Karaté"> Karaté</option>
        <option value="Karting"> Karting</option>
        <option value="Kick boxing"> Kick boxing</option>
        <option value="Krav-maga"> Krav-maga</option>
        <option value="Kung fu"> Kung fu</option>
        <option value="Lancer du javelot"> Lancer de javelot</option>
        <option value="Lancer du marteau"> Lancer de marteau</option>
        <option value="Lancer du poids"> Lancer de poids</option>
        <option value="Lutte"> Lutte</option>
        <option value="Marche"> Marche</option>
        <option value="Marche nordique"> Marche nordique</option>
        <option value="Monocycle"> Monocycle</option>
        <option value="Natation"> Natation</option>
        <option value="Natation synchronisée"> Natation synchronisée</option>
        <option value="Paintball"> Paintball</option>
        <option value="Patinage"> Patinage</option>
        <option value="Patinage artistique"> Patinage artistique</option>
        <option value="Patinage"> Patinage</option>
        <option value="Patinage de vitesse"> Patinage de vitesse</option>
        <option value="Pentathlon"> Pentathlon</option>
        <option value="Patinage"> Patinage</option>
        <option value="Pétanque"> Pétanque</option>
        <option value="Planche à voile"> Planche à voile</option>
        <option value="Plongeon"> Plongeon</option>
        <option value="Rallycross"> Rallycross</option>
        <option value="Rugby"> Rugby</option>
        <option value="Rugby subaquatique"> Rugby subaquatique</option>
        <option value="Saut à la perche"> Saut à la perche</option>
        <option value="Saut en longueur"> Saut en longueur</option>
        <option value="Ski acrobatique"> Ski acrobatique</option>
        <option value="Ski alpin"> Ski alpin</option>
        <option value="Ski de fond"> Ski de fond</option>
        <option value="Skicross"> Skicross</option>
        <option value="Snowboard"> Snowboard</option>
        <option value="Snowkite"> Snowkite</option>
        <option value="Softball"> Softball</option>
        <option value="Speed riding"> Speed riding</option>
        <option value="Squash"> Squash</option>
        <option value="Sumo"> Sumo</option>
        <option value="Taekwondo"> Taekwondo</option>
        <option value="Tennis"> Tennis</option>
        <option value="Tennis de table"> Tennis de table</option>
        <option value="Teqball"> Teqball</option>
        <option value="Tir"> Tir</option>
        <option value="Tir à l'arc"> Tir à l'arc</option>
        <option value="Trail"> Trail</option>
        <option value="Trampoline"> Trampoline</option>
        <option value="Triathlon"> Triathlon</option>
        <option value="ULM"> ULM</option>
        <option value="Ultimate"> Ultimate</option>
        <option value="Ultimate fresbee"> Ultimate fresbee</option>
        <option value="Volleyball"> Volleyball</option>
        <option value="Waterpolo"> Waterpolo</option>


    </select>

    <input name="date" type="datetime-local" value=""/>
    <input name="visibility" type="checkbox" id="prive" value="1"/>
    <label for="prive"> privé </label>

    <input type="submit" class="btnSubmit" value="Créer mon tournoi"/>
</form>
<%@ include file="template/footer.jsp" %>
</body>
</html>
