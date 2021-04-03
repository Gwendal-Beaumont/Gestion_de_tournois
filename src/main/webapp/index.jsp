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
<c:redirect url="/Home">Redirect</c:redirect>
<%@ include file="jsp/template/footer.jsp" %>

</body>
</html>
