package fr.imt.cepi.servlet;

import fr.imt.cepi.bean.RejoindreTournoi;
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
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@WebServlet("/AddTournament")

public class AddTournamentServlet extends HttpServlet {
    static Logger logger = LogManager.getLogger(AddTournamentServlet.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/jsp/add_tournament.jsp").forward(req, resp);
        System.out.println("test3");

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // On crée l'atttribut pour la base de données
        PreparedStatement ps;
        ResultSet rs;

        int idtournoi = Integer.parseInt(req.getParameter("id-tournoi"));
        System.out.println(idtournoi);

        //On récupère l'état du tournoi
        try (Connection con = AppContextListener.getConnection()) {
            ps = con.prepareStatement("SELECT etat FROM tst.tournoi WHERE id =" + idtournoi);
            rs = ps.executeQuery();
            if (rs.next()) {
                int etat = rs.getInt("etat");
                if (etat == 0) {

                    Utilisateur user = (Utilisateur) req.getSession().getAttribute("utilisateur");
                    int iduser = user.getId();

                    try (Connection con2 = AppContextListener.getConnection()) {
                        RejoindreTournoi joinTournoi = new RejoindreTournoi(idtournoi, iduser);
                        joinTournoi.join(con2);
                        logger.info("Tournoi (#" + idtournoi + ") rejoint avec succès");
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }

                } else {
                    req.setAttribute("errorMessage", "On ne peut plus rejoindre le tournoi");
                    getServletContext().getRequestDispatcher("/jsp/add_tournament.jsp").forward(req, resp);
                }

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        resp.sendRedirect("ManageTournaments?id_tournament=" + idtournoi);

    }
}

