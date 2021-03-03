<%@ page pageEncoding="UTF-8" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <%@ include file="jsp/template/head_import.jsp" %>
    <title>index.jsp</title>
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/style.css">
</head>
<body>
<%@include file="jsp/template/navbar.jsp" %>

<c:choose>
    <c:when test="${utilisateur.getUsername() == null}"><p>Aucun utilisateur connecté ! ${utilisateur.getUsername()}</p></c:when>
    <c:otherwise><p>L'utilisateur connecté est ${utilisateur.getUsername()}.</p></c:otherwise>
</c:choose>

<%@ include file="jsp/template/footer.jsp" %>

</body>
</html>
