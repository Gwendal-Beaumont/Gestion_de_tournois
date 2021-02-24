<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@ include file="template/head_import.jsp" %>
    <title>about.jsp</title>
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/style.css">
</head>
<body>
<%@ include file="template/navbar.jsp" %>

<section id="about-section">
    <h1>Qu'est-ce que [nom de la webapp] ?</h1>
    <p><span class="tabulation"></span>[Nom de la webapp] c'est un outil qui permet de gérer des tournois pour
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
    <h1>Autres...</h1>
    <p><span class="tabulation"></span>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Curabitur non dictum
        magna. Sed vitae quam condimentum, luctus massa accumsan, molestie ex. Integer ac volutpat quam, non iaculis
        leo. Donec aliquam hendrerit lorem et pharetra. Quisque tristique tincidunt elit in malesuada. Cras in sapien
        hendrerit, hendrerit urna quis, sodales nulla. Lorem ipsum dolor sit amet, consectetur adipiscing elit. Fusce
        orci sem, aliquam a rhoncus et, faucibus a dolor. Etiam nec vestibulum arcu. Aliquam id dapibus erat.
    </p>
    <p><span class="tabulation"></span>Phasellus gravida eros in congue bibendum. Phasellus mauris arcu, bibendum sit
        amet dignissim id, pharetra vitae dui. Praesent interdum purus quis elit blandit aliquam. Suspendisse iaculis
        felis sed elit hendrerit, at tempus tellus interdum. Fusce vitae magna in nunc ullamcorper sagittis ac in
        sapien. Nullam eget vehicula eros, eu dignissim tortor. In sodales dignissim ipsum. Etiam tincidunt quam nec
        mattis vulputate. Nunc commodo metus ut purus hendrerit rhoncus. Integer nibh lectus, mollis id felis quis,
        feugiat pharetra est. Quisque et tincidunt quam.
    </p>
    <p><span class="tabulation"></span>Vivamus interdum leo ac erat eleifend tristique. Suspendisse a mollis leo, eu
        vehicula quam. Etiam nec blandit leo. Nunc risus purus, ultrices in posuere pulvinar, dapibus quis velit.
        Phasellus ac tincidunt purus, sed pharetra velit. Phasellus dignissim nisl sit amet lacinia maximus. Ut luctus
        venenatis massa, sit amet fermentum turpis accumsan vel. Ut pharetra justo ante, sed feugiat est porttitor id.
        Cras gravida ornare velit, vel imperdiet quam ornare dignissim. Curabitur egestas semper nisl non tincidunt.
        Phasellus fringilla lacus enim, venenatis finibus libero mollis ut. Donec erat nisi, cursus quis aliquet id,
        ornare vitae tellus. Etiam ultricies odio lobortis, suscipit erat eu, posuere tellus. Maecenas vehicula enim at
        urna volutpat tincidunt. Nam feugiat pretium mi, sit amet consectetur erat congue consectetur. In malesuada leo
        ut massa pharetra, a porttitor dui vulputate.
    </p>
    <p><span class="tabulation"></span>Vivamus euismod libero sem, et blandit lectus pellentesque et. Sed ut ligula
        lacinia, finibus nibh eu, accumsan nisi. Ut in augue egestas, efficitur elit non, iaculis enim. Ut porttitor
        placerat nisl. Phasellus viverra efficitur sem, ut accumsan odio fringilla at. Phasellus mattis massa in ex
        tincidunt gravida. Suspendisse accumsan commodo mi nec lobortis. Nam imperdiet at mauris sit amet semper. Nulla
        in odio ut ante sagittis rhoncus. Vestibulum aliquet turpis sit amet efficitur tempor. Curabitur a condimentum
        libero, at luctus ligula. Etiam accumsan pretium faucibus.
    </p>
    <p><span class="tabulation"></span>Donec sed lorem dui. Morbi vestibulum non enim vel interdum. Nam in dolor et sem
        malesuada eleifend et ac neque. Praesent augue lectus, elementum eget pretium nec, elementum eget metus. Cras
        suscipit nunc vel neque tristique tristique. Vestibulum dapibus elit non sapien ultrices tincidunt. Morbi congue
        nulla sit amet gravida vulputate. Etiam pellentesque eros eget neque vulputate, ultricies congue nisl posuere.
        Donec pulvinar tempor nulla, eget aliquam metus. Aenean ullamcorper, sem vel commodo hendrerit, odio purus
        venenatis lorem, posuere consequat turpis ante ac metus. Proin sed tortor sed libero dictum vulputate at
        dignissim turpis. Proin lorem diam, commodo id massa nec, maximus vehicula lorem. Curabitur a ipsum malesuada,
        egestas lorem ac, lobortis mauris. Maecenas pretium, leo in mattis hendrerit, nisl nisi tempor nulla, ac finibus
        purus mauris et orci. Donec ut congue elit. Aenean ultricies turpis id nulla rhoncus finibus.
    </p>
</section>

<%@ include file="template/footer.jsp" %>
</body>
</html>
