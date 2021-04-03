<%@ page pageEncoding="UTF-8" %>
<header>
    <a href="<c:url value="/Home"/>"><img class="logo"
                                          src="<c:url value="/images/logo_white_48pt.svg"/>"
                                          alt="logo"></a>
    <nav>
        <ul class="nav__links">
            <li><a href="<c:url value="/Home"/>">Accueil</a></li>
            <li><a href="<c:url value="/ManageTournaments"/>">Tournois</a></li>
            <li><a href="<c:url value="/About"/>">&Agrave; propos</a></li>
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

                <div class="dropdown">
                    <button class="dropbtn">
                        <div class="btnSubmit"> Tournoi &blacktriangledown;</div>
                    </button>
                    <div class="dropdown-content">
                        <a href="<c:url value="/create_tournament"/>">Créer</a>
                        <a href="<c:url value="/AddTournament"/>">Rejoindre</a>
                    </div>
                </div>

                <div class="dropdown">
                    <button class="dropbtn">
                        <div class="btnSubmit"> Mon compte &blacktriangledown;</div>
                    </button>
                    <div class="dropdown-content">
                        <a href="<c:url value="/Profil"/>">Profil</a>
                        <a href="<c:url value="/Logout"/>">Déconnexion</a>
                    </div>
                </div>

            </div>


        </c:otherwise>
    </c:choose>


</header>
<section id="body_text">
