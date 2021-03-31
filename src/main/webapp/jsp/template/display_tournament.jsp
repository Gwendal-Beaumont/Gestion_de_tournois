<%--
  Created by IntelliJ IDEA.
  User: lenaderoche
  Date: 31/03/2021
  Time: 09:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

    <c:forEach items="${listeTournois}" var="tournoi">
        <div class = 'wrap' style = "
            background-image: url(${tournoi.getSport().getUrl()});
            background-repeat: no-repeat;
            background-position: center;
            background-size: cover;">
            <div class = 'content'>
                <p>
                    ${tournoi.getNom_tournoi()}
                </p>
            </div>
        </div>
    </c:forEach>