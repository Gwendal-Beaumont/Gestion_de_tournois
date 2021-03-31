package fr.imt.cepi.servlet;

import fr.imt.cepi.bean.Sport;
import fr.imt.cepi.bean.Tournoi;
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
import java.sql.*;
import java.util.ArrayList;

@WebServlet("/Profil")
public class ChangeUserDataServlet extends HttpServlet {
    static Logger logger = LogManager.getLogger(ChangeUserDataServlet.class);

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        Utilisateur utilisateur = (Utilisateur) session.getAttribute("utilisateur");

        // On cherche les tournois associés à l'utilisateur dans la base de données
        try (Connection con = AppContextListener.getConnection();
             PreparedStatement ps = con.prepareStatement(
                     "SELECT tournoi.id, tournoi.nom, id_sport, sport.nom, sport.image, visibility, date_debut, proprietaire, etat FROM tst.tournoi JOIN tst.sport ON sport.id = id_sport  WHERE proprietaire=?;")) {
            ps.setInt(1, utilisateur.getId());
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                // On indique dans le log un accès réussi aux données
                logger.info("Fetched all tournaments data");
                ArrayList<Tournoi> listeTournoi = new ArrayList<>();
                rs.beforeFirst();
                while (rs.next()) {
                    if (rs.getInt("etat") == 3) {
                        listeTournoi.add(new Tournoi(
                                rs.getInt("id"),
                                rs.getString("nom"),
                                new ArrayList<>(),
                                new Sport(rs.getInt("id_sport"), rs.getString("sport.nom"), rs.getString("sport.image")),
                                rs.getBoolean("visibility"),
                                rs.getTimestamp("date_debut").toLocalDateTime(),
                                rs.getInt("proprietaire"),
                                rs.getInt("etat")));
                    }
                }
                System.out.println("Liste des tournois trouvés :");
                System.out.println(listeTournoi);
                request.setAttribute("listeTournois", listeTournoi);
            }
            rs.close();
            getServletContext().getRequestDispatcher("/jsp/profil.jsp").forward(request, response);
        } catch (SQLException throwables) {
            getServletContext().getRequestDispatcher("/jsp/profil.jsp").forward(request, response);
        }
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
                logger.info("Mot de passe récupéré");
                rs.close();
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        if (checkmdp.equals(mdpactuel)) {

            // On tente d'envoyer les modifications à la base de données
            try {
                con = AppContextListener.getConnection();
                ps = con.prepareStatement("UPDATE tst.utilisateur SET username=?,email=?,password=? WHERE id=?");
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
