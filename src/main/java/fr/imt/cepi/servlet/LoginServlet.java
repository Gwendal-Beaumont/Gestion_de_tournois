package fr.imt.cepi.servlet;

import fr.imt.cepi.bean.Utilisateur;
import fr.imt.cepi.servlet.listeners.AppContextListener;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@WebServlet("/Login")
public class LoginServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    static Logger logger = LogManager.getLogger(LoginServlet.class);

    @Override

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/jsp/login.jsp").forward(request,response);
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // récupérations des paramètres de la requêtes : ici les champs input du formulaire
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        // Quelques contrôles
        String errorMsg = null;
        if (username == null || username.equals("")) {
            errorMsg = "Le username est obligatoire";
        }
        if (password == null || password.equals("")) {
            errorMsg = "Le mot de passe est obligatoire";
        }
        // S'il y a des erreurs, on met le message en attribut de la requête et on renvoie sur la page de login
        if (errorMsg != null) {
            request.setAttribute("errorMessage", errorMsg);
            getServletContext().getRequestDispatcher("/jsp/login.jsp").forward(request, response);
        } else {
            // Sinon on recherche l'utilisateur en base de données
            Connection con = null;
            PreparedStatement ps = null;
            ResultSet rs = null;
            try {
                con = AppContextListener.getConnection();
                ps = con.prepareStatement(
                        "select id, username, email from tst.utilisateur where username=? and password=? limit 1");
                ps.setString(1, username);
                ps.setString(2, password);
                rs = ps.executeQuery();
                if (rs.next()) {
                    // Si on l'a trouvé, on l'indique dans le log
                    Utilisateur utilisateur = new Utilisateur(rs.getString("username"), rs.getString("email"),
                            rs.getInt("id"));
                    logger.info("Utilisateur trouvé :" + utilisateur);
                    // Puis on met l'objet utilisateur dans la session
                    HttpSession session = request.getSession();
                    session.setAttribute("utilisateur", utilisateur);
                    // et on génère le résultat avec la page debut.jsp
                    response.sendRedirect("Home");
                } else {
                    // Sinon, message d'erreur dans la requête pour affichage dans la vue login.jsp.
                    logger.error("Utilisateur introuvable : " + username);
                    request.setAttribute("errorMessage", "Mauvais nom d'utilisateur ou mot de passe.");
                    getServletContext().getRequestDispatcher("/jsp/login.jsp").forward(request, response);
                }
            } catch (SQLException e) {
                // Sinon, log de l'erreur et renvoi sur la vue login.jsp avec un message d'erreur
                logger.error("Problème d'accès à la base de données : ", e);
                request.setAttribute("errorMessage", "Erreur technique : veuillez contacter l'administrateur de l'application.");
                getServletContext().getRequestDispatcher("/Login").forward(request, response);
            } finally {
                try {
                    rs.close();
                } catch (SQLException e) {
                }
                try {
                    ps.close();
                } catch (SQLException e) {
                }
            }
        }
    }

}
