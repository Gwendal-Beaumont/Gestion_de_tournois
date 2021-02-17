<%@ page pageEncoding="UTF-8" %>
<%@ include file="template/debut.jsp" %>
<title>Enregistrement</title>
<div class="container login-container">
    <div class="row">
        <div class="col-md-6 login-form">
            <h3>Remplissez tous les champs pour vous enregistrer</h3>
            <%@ include file="template/alerts.jsp" %>
            <form action="Register" method="post">
                <div class="form-group">
                    <input name="nom" type="text" class="form-control"
                           placeholder="Nom" value=""/>
                </div>
                <div class="form-group">
                    <input name="login" type="text" class="form-control"
                           placeholder="Username" value=""/>
                </div>
                <div class="form-group">
                    <input name="nom" type="email" class="form-control"
                           placeholder="Adresse mail" value=""/>
                </div>
                <div class="form-group">
                    <input name="password" type="password" class="form-control"
                           placeholder="Mot de passe" value=""/>
                </div>
                <div class="form-group">
                    <input name="passwordConfirmation" type="password" class="form-control"
                           placeholder="Mot de passe (confirmation)" value=""/>
                </div>
                <div class="form-group">
                    <label for="acceptCGU"><input name="acceptCGU" id="acceptCGU" type="checkbox" class="form-control"
                                                  value="acceptedCGU">J'accepte les conditions générales d'utilisation
                        (CGU).</label><br>
                </div>
                <div class="form-group">
                    <input type="submit" class="btnSubmit" value="S'enregistrer"/>
                </div>
                <div class="form-group">
                    <a href="<c:url value="Login"/>" class="ForgetPwd">Déjà enregistré ?</a>
                </div>
            </form>
        </div>
    </div>
</div>
<%@ include file="template/fin.jsp" %>