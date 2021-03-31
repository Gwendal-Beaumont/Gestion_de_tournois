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

@WebServlet("/create_tournament")
public class CreateTournamentServlet extends HttpServlet {
    static Logger logger = LogManager.getLogger(CreateTournamentServlet.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // Attributs de connexion à la base SQL
        Connection con;
        PreparedStatement ps;
        ResultSet rs;

        // Tentative de connexion à la base de données
        try {
            // Annonce dans le logger de la tentative de récupération des données
            logger.info("Fetching all sports data");
            con = AppContextListener.getConnection();
            ps = con.prepareStatement("SELECT id, nom from sport ORDER BY nom");
            rs = ps.executeQuery();

            // Test de la validité de nos données (on regarde si notre résultat n'est pas vide
            if (rs.next()) {
                // On indique dans le log un accès réussi aux données
                logger.info("Fetched all sports data");
                // On crée notre Arrays de sports
                ArrayList<Sport> listeDesSports = new ArrayList<>();
                rs.beforeFirst();
                while (rs.next()) {
                    listeDesSports.add(new Sport(rs.getInt("id"), rs.getString("nom")));
                }
                req.setAttribute("sport", listeDesSports);
            }
            con.close();
            getServletContext().getRequestDispatcher("/jsp/create_tournament.jsp").forward(req, resp);
        } catch (SQLException e) {
            // Sinon, log de l'erreur et renvoi sur la vue login.jsp avec un message d'erreur
            logger.error("Problème d'accès à la base de données : ", e);
            req.setAttribute("errorMessage", "Erreur technique : veuillez contacter l'administrateur de l'application.");
            getServletContext().getRequestDispatcher("/jsp/create_tournament.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // On récupère les champs du formulaire de création de tournois
        String nom = req.getParameter("nom-tournoi");
        String visibility = req.getParameter("visibility");
        String date = req.getParameter("date-debut");
        System.out.println(date);

        String sport = req.getParameter("sport");

        Utilisateur user = (Utilisateur) req.getSession().getAttribute("utilisateur");

        // Conversion format date
        DateFormat date2 = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm");

        java.util.Date date3 = null;
        try {
            date3 = date2.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        java.sql.Timestamp date4 = new Timestamp(date3.getTime());


        // On crée nos attributs pour la base de données
        Connection con;
        PreparedStatement ps;

        // ID du tournoi créé
        int id_tournoi = 0;

        // On tente d'envoyer le tournoi à la base de données
        try {
            con = AppContextListener.getConnection();
            ps = con.prepareStatement("INSERT INTO tst.tournoi(nom, id_sport, visibility, date_debut, proprietaire) VALUES (?, ?, ?, ?, ?)");
            ps.setString(1, nom);
            ps.setInt(2, Integer.parseInt(sport));
            ps.setBoolean(3, visibility.equals("public")); // True = public
            ps.setTimestamp(4, date4);
            ps.setInt(5, user.getId());
            ps.executeUpdate();
            try (Connection con2 = AppContextListener.getConnection();
                 PreparedStatement ps2 = con.prepareStatement(
                         "SELECT id FROM tst.tournoi WHERE proprietaire=? ORDER BY id DESC LIMIT 1")) {
                ps2.setInt(1, user.getId());
                ResultSet rs2 = ps2.executeQuery();
                if (rs2.next()) {
                    id_tournoi = rs2.getInt("id");
                    logger.info("Le dernier tournoi de " + user.getUsername() + " (" + user.getId() + ") " + "a été trouvé et a pour id : " + id_tournoi);
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
            getServletContext().getRequestDispatcher("/jsp/create_tournament.jsp").forward(req, resp);

        }
        resp.sendRedirect("ManageTournaments?id_tournament=" + id_tournoi);
    }
}
