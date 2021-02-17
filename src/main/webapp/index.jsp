<%--
  Created by IntelliJ IDEA.
  User: gwend
  Date: 10/02/2021
  Time: 10:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>index.jsp</title>
  </head>
  <body>
  <%@include file="jsp/template/navbar.jsp"%>
  <a href="${pageContext.request.contextPath}/Login">login</a>
  <a href="${pageContext.request.contextPath}/Register">register</a>
  <a href="${pageContext.request.contextPath}/Home">home</a>
  </body>
</html>
