<%@ page pageEncoding="UTF-8" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--Footer--%>

<section id="footer">
    <div class="container footer-row">
        <hr>
        <div class="footer-left-col">
            <div class="footer-links">
                <div class="link-title">
                    <h4>Produit</h4>
                    <small>Tarifs</small><br>
                    <small>Essai gratuit</small>
                </div>
                <div class="link-title">
                    <h4>&Agrave; propos</h4>
                    <a href="<c:url value="/MentionsLegales" />"><small>Mentions légales</small></a><br>
                    <a href="<c:url value="/About" />"><small>FAQ</small></a>
                </div>
                <div class="link-title">
                    <h4>Support</h4>
                    <small>RGPD</small><br>
                    <small>Nous contacter</small>
                </div>
                <div class="link-title">
                    <h4>Découvrir</h4>
                    <small>Le projet</small><br>
                    <small>Solutions</small>
                </div>
            </div>
        </div>
        <div class="footer-right-col">
            <div class="footer-info">
                <div class="copyright-text">
                    <small>Ce site a été créé avec &#9825;</small><br>
                    <small>&copy; Copyright 2021 - CEPI Tournoi</small>
                </div>
                <div class="footer-logo">
                    <img class="footer-logo" src="${pageContext.request.contextPath}/images/logo_black_48pt.svg" alt="logo">
                </div>
            </div>
        </div>
    </div>
</section>
</section>