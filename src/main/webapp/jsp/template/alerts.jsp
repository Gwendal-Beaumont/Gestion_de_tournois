<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:if test="${message != null}">
<div class="alert alert-info" role="alert">
    <p>${message}</p>
</div>
</c:if>
<c:if test="${errorMessage != null}">
<div class="alert alert-danger" role="alert">
    <p>${errorMessage}</p>
</div>
</c:if>