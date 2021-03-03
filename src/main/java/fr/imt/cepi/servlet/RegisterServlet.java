package fr.imt.cepi.servlet;

import fr.imt.cepi.servlet.listeners.AppContextListener;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@WebServlet("/Register")
public class RegisterServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    static Logger logger = LogManager.getLogger(RegisterServlet.class);


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/jsp/register.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Récupération des valeurs des champs du formulaire
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        // Quelques contrôles
        String errorMsg = null;
        if (username == null || username.equals("")) {
            errorMsg = "Le username est obligatoire.";
        }
        if (password == null || password.equals("")) {
            errorMsg = "Le mot de passe est obligatoire";
        }
        if (email == null || email.equals("")) {
            errorMsg = "L'email est obligatoire";
        }
        // S'il y a des erreurs, on met le message en attribut de la requête et on renvoie sur la page de login
        if (errorMsg != null) {
            request.setAttribute("errorMessage", errorMsg);
            getServletContext().getRequestDispatcher("/jsp/register.jsp").forward(request, response);
        } else {
            Connection con = null;
            PreparedStatement ps = null;
            try {
                con = AppContextListener.getConnection();
                ps = con.prepareStatement("insert into tst.utilisateur(username, email, password) values (?,?,?)");
                ps.setString(1, username);
                ps.setString(2, email);
                ps.setString(3, password);
                ps.execute();
                logger.info("Utilisateur enregistré avec le username " + username);
                // On affiche la page d'accueil
                request.setAttribute("message",
                        "Enregistrement effectué avec succès, veuillez vous identifier.");
                getServletContext().getRequestDispatcher("/jsp/login.jsp").forward(request, response);
            } catch (SQLException e) {
                // Sinon, log de l'erreur et renvoi sur la vue login.jsp avec un message d'erreur
                logger.error("Problème d'accès à la base de données : ", e);
                request.setAttribute("errorMessage", "Erreur technique : veuillez contacter l'administrateur de l'application.");
                getServletContext().getRequestDispatcher("/jsp/login.jsp").forward(request, response);
            } finally {
                try {
                    ps.close();
                } catch (SQLException e) {
                }
            }
        }
    }
}
