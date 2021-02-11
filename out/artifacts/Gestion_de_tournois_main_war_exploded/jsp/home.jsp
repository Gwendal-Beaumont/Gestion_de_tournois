<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page pageEncoding="UTF-8" %>
<%@ include file="template/debut.jsp" %>
<div class="jumbotron">
    <h1 class="display-4">Bonjour ${utilisateur.nom},
    </h1>
    <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aenean imperdiet tortor sem, in tristique odio auctor
        eget. Praesent pretium porta metus ut tempor. Cras consequat gravida lectus at iaculis. Nam ut ante sit amet
        purus bibendum consequat consequat at odio. In rutrum tellus est, auctor luctus augue venenatis quis. Ut sit
        amet ultricies augue. Suspendisse tincidunt, dui et dignissim venenatis, augue erat egestas est, nec commodo
        arcu ex id est. Vivamus purus libero, malesuada ac imperdiet nec, hendrerit non erat. Cras congue porttitor
        sodales. In consectetur auctor justo, ac volutpat sapien tempor sed. Nullam nec vehicula arcu, eget finibus
        mauris. Cras lacinia auctor massa, sed mattis ante commodo et. Nunc eu ex dolor. </p>
    <p>Libero dui, posuere sed ullamcorper at, suscipit vitae lectus. Praesent placerat tempus volutpat. Cras tempor
        purus id efficitur commodo. In hac habitasse platea dictumst. Nam malesuada purus non justo pellentesque
        efficitur. Pellentesque venenatis iaculis neque ut tempus. Mauris feugiat arcu ut nunc tincidunt, at laoreet
        magna placerat. Nullam nec massa porttitor, fringilla elit eu, facilisis nisl. Donec nisl sem, sodales a mollis
        eget, lobortis nec magna. Quisque fringilla bibendum lectus quis volutpat. Fusce iaculis fermentum ligula,
        eleifend rhoncus diam mollis quis. Praesent pulvinar, neque ac auctor sodales, nunc velit lobortis dui, et
        cursus enim nisi sit amet est.</p>
    <c:forEach items="${listeTournoisJSP}" var="unTournois">
        <div>${unTournois} pour ** ${utilisateur.nom}</div>
    </c:forEach>
    <br>
    <a href="<c:url value="Logout"/>">Déconnexion</a>
</div>

<%@ include file="template/fin.jsp" %>
