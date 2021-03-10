<%@ page pageEncoding="UTF-8" %>
<header>
    <a href="<c:url value="/"/>"><img class="logo"
                                      src="<c:url value="/images/logo_white_48pt.svg"/>"
                                      alt="logo"></a>
    <nav>
        <ul class="nav__links">
            <c:choose>
                <c:when test="${utilisateur.getUsername() == null}">
                    <li><a href="<c:url value="/"/>">Accueil</a></li>
                </c:when>
                <c:otherwise>
                    <li><a href="<c:url value="/Home"/>">Accueil</a></li>
                </c:otherwise>
            </c:choose>
            <li><a href="<c:url value="/create_tournament"/>">Créer mon tournoi</a></li>
            <li><a href="<c:url value="/ManageTournaments"/>">Tournois</a></li>
            <li><a href="<c:url value="/jsp/about.jsp"/>">&Agrave; propos</a></li>
        </ul>
    </nav>

    <c:choose>
        <c:when test="${utilisateur.getUsername() == null}">
            <div class="login_register_navbar">
                <a class="cta" href="<c:url value="/Login"/>">
                    <button>Connexion</button>
                </a>
                <a class="register_navbar" href="<c:url value="/Register"/>">S'enregistrer</a>
            </div>
        </c:when>
        <c:otherwise>
            <div class="login_register_navbar">
                <a class="cta" href="<c:url value="Logout"/>">
                    <button>Déconnexion</button>
                </a>
                <a class="cta" href="<c:url value="/jsp/profil.jsp"/>">

                    <button> Profil </button>
                </a>
            </div>
        </c:otherwise>
    </c:choose>






</header>
<section id="body_text">