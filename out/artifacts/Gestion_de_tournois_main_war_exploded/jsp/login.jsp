<%@ page pageEncoding="UTF-8" %>
<%@include file="template/debut.jsp"%>
<div class="container login-container">
    <div class="row">
        <div class="col-md-6 login-form">
            <br>
            <br>
            <h3>Se connecter</h3>
            <%@ include file="template/alerts.jsp"%>
             <form action="Login" method="post">

                <div class="form-group">
                    <input name="login" type="text" class="form-control"
                           placeholder="Identifiant" value=""/>
                </div>
                <div class="form-group">
                    <input name="password" type="password" class="form-control"
                           placeholder="Mot de passe" value=""/>
                </div>
                <div class="form-group">
                    <input type="submit" class="btnSubmit" value="S'identifier" name="connect"/>
                </div>
                <div class="form-group">
                    <a href="<c:url value="Register"/>" class="ForgetPwd">Pas encore enregistré ?</a>
                </div>
            </form>
        </div>
    </div>
</div>
<%@include file="template/fin.jsp"%>