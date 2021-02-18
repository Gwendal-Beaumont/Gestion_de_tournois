<%@ page pageEncoding="UTF-8" %>
<header>
    <a href="${pageContext.request.contextPath}/"><img class="logo" src="images/sports-white-48dp.svg" alt="logo"></a>
    <nav>
        <ul class="nav__links">
            <li><a href="${pageContext.request.contextPath}/Home">Accueil</a></li>
            <li><a href="#">Tournois publics</a></li>
            <li><a href="#">&Agrave; propos</a></li>
        </ul>
    </nav>
    <div class="login_register_navbar">
        <a class="cta" href="${pageContext.request.contextPath}/Login">
            <button>Connexion</button>
        </a>
        <a class="register_navbar" href="${pageContext.request.contextPath}/Register">S'enregistrer</a>
    </div>
</header>