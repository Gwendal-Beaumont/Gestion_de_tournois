package fr.imt.cepi.servlet;

import fr.imt.cepi.bean.Equipe;
import fr.imt.cepi.bean.Sport;
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
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

@WebServlet("/AddTournament")

public class AddTournamentServlet extends HttpServlet {
    static Logger logger = LogManager.getLogger(AddTournamentServlet.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        // Attributs de connexion à la base SQL
        Connection con;
        PreparedStatement ps;
        ResultSet rs;
        try {
            // Annonce dans le logger de la tentative de récupération des données
            logger.info("Fetching all sports data");
            con = AppContextListener.getConnection();
            ps = con.prepareStatement("SELECT id, nom from equipe ORDER BY nom");
            rs = ps.executeQuery();
            if (rs.next()) {
                // On indique dans le log un accès réussi aux données
                logger.info("Fetched all sports data");
                // On crée notre Arrays de sports
                ArrayList<Equipe> listeDesEquipes = new ArrayList<>();
                rs.beforeFirst();
                while (rs.next()) {
                    listeDesEquipes.add(new Equipe(rs.getInt("id"), rs.getString("nom")));
                }
                req.setAttribute("team", listeDesEquipes);
            }
            con.close();
            getServletContext().getRequestDispatcher("/jsp/create_tournament.jsp").forward(req, resp);
    } catch (SQLException e) {
            logger.error("Problème d'accès à la base de données : ", e);
            req.setAttribute("errorMessage", "Erreur technique : veuillez contacter l'administrateur de l'application.");
            getServletContext().getRequestDispatcher("/jsp/add_tournament.jsp").forward(req, resp);
        }
        }

        @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/jsp/add_tournament.jsp").forward(req, resp);

    }
}
