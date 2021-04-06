package fr.imt.cepi.servlet;

import fr.imt.cepi.bean.Sport;
import fr.imt.cepi.bean.Tournoi;
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

@WebServlet("/ManageTournaments")

public class ManageTournamentsServlet extends HttpServlet {
    static Logger logger = LogManager.getLogger(ManageTournamentsServlet.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id_tournament = req.getParameter("id_tournament");
        logger.info("Tournoi en cours de modification : "+id_tournament);
        int id;
        try {
            id = Integer.parseInt(id_tournament);
        } catch (NumberFormatException e) {
            id = 0;
        }
        try (Connection con = AppContextListener.getConnection(); PreparedStatement ps = con.prepareStatement(
                "SELECT tournoi.id, tournoi.nom, id_sport, sport.nom, sport.image, visibility, date_debut, proprietaire, etat FROM tst.tournoi JOIN tst.sport ON sport.id = id_sport  WHERE tournoi.id = ?;"
        ) ){
            ps.setInt(1,id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()){
                Tournoi tournoi = new Tournoi(
                        rs.getInt("id"),
                        rs.getString("nom"),
                        new ArrayList<>(),
                        new Sport(rs.getInt("id_sport"), rs.getString("sport.nom"), rs.getString("sport.image")),
                        rs.getBoolean("visibility"),
                        rs.getTimestamp("date_debut").toLocalDateTime(),
                        rs.getInt("proprietaire"),
                        rs.getInt("etat"));
                System.out.println(tournoi);
                req.setAttribute("tournoi", tournoi);
            }
            rs.close();
            getServletContext().getRequestDispatcher("/jsp/manage_tournaments.jsp").forward(req, resp);
        } catch (SQLException e){
            getServletContext().getRequestDispatcher("/jsp/manage_tournaments.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/jsp/manage_tournaments.jsp").forward(req, resp);
    }
}
