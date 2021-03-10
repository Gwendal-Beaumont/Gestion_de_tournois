package fr.imt.cepi.servlet;

import fr.imt.cepi.bean.Sport;
import fr.imt.cepi.bean.Utilisateur;
import fr.imt.cepi.servlet.listeners.AppContextListener;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

@WebServlet("/Profil")
public class ChangeUserDataServlet extends HttpServlet {
    static Logger logger = LogManager.getLogger(ChangeUserDataServlet.class);

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/jsp/profil.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // On récupère les champs du formulaire de modification

        String nom = req.getParameter("username");
        String mail = req.getParameter("email");
        String motDePasse = req.getParameter("password");
        String checkmdp = req.getParameter("checkpassword");
        String mdpactuel = null;


        Utilisateur user = (Utilisateur) req.getSession().getAttribute("utilisateur");
        int iduser = user.getId();


        // On crée nos attributs pour la base de données
        Connection con;
        PreparedStatement ps;

        Connection con2;
        PreparedStatement ps2;
        ResultSet rs;
        

        try {
            con2 = AppContextListener.getConnection();
            ps2 = con2.prepareStatement("SELECT password FROM tst.utilisateur WHERE id=? ");
            ps2.setInt(1, iduser);
            rs = ps2.executeQuery();
            if (rs.next()) {
                mdpactuel = rs.getString("password");
                rs.close();
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        if (checkmdp.equals(mdpactuel)) {

            // On tente d'envoyer les modifications à la base de données
            try {
                con = AppContextListener.getConnection();
                ps = con.prepareStatement("UPDATE tst.utilisateur SET username=?,email=?,password=?  WHERE id=?");
                ps.setString(1, nom);
                ps.setString(2, mail);
                ps.setString(3, motDePasse);
                ps.setInt(4, iduser);

                ps.executeUpdate();
                getServletContext().getRequestDispatcher("/jsp/profil.jsp").forward(req, resp);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
