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
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

@WebServlet({"/Home"})
public class HomeServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    static Logger logger = LogManager.getLogger(HomeServlet.class);

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
                System.out.println(listeTournoi);
                request.setAttribute("listeTournois", listeTournoi);
            }
            rs.close();
            getServletContext().getRequestDispatcher("/jsp/home.jsp").forward(request, response);
        } catch (SQLException throwables) {
            getServletContext().getRequestDispatcher("/jsp/home.jsp").forward(request, response);
        }
    }
}

