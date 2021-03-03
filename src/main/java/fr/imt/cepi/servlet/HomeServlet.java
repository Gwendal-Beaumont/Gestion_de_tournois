package fr.imt.cepi.servlet;

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

@WebServlet({"/Home"})
public class HomeServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    static Logger logger = LogManager.getLogger(HomeServlet.class);

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        Utilisateur utilisateur = (Utilisateur) session.getAttribute("utilisateur");

        // On cherche les sports associés à l'utilisateur dans la base de données
        try (Connection con = AppContextListener.getConnection();
             PreparedStatement ps = con.prepareStatement(
                     "SELECT id, nom, id_sport, visibility, date_debut, proprietaire FROM tst.tournoi WHERE proprietaire=?")) {
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
                            rs.getInt("id_sport"),
                            rs.getBoolean("visibility"),
                            rs.getTimestamp("date_debut").toLocalDateTime(),
                            rs.getInt("proprietaire")));
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

