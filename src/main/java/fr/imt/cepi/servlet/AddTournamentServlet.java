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
import java.sql.SQLException;

@WebServlet("/AddTournament")

public class AddTournamentServlet extends HttpServlet {
    static Logger logger = LogManager.getLogger(AddTournamentServlet.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/jsp/add_tournament.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int idtournoi =Integer.parseInt(req.getParameter("id-tournoi"));
        System.out.println(idtournoi);

        Utilisateur user = (Utilisateur) req.getSession().getAttribute("utilisateur");
        int iduser = user.getId();

        try (Connection con = AppContextListener.getConnection()) {
            RejoindreTournoi joinTournoi = new RejoindreTournoi(idtournoi, iduser);
            joinTournoi.join(con);
            logger.info("Tournoi (#"+idtournoi+") rejoint avec succès");
        } catch (SQLException e) {
            e.printStackTrace();
        }

        getServletContext().getRequestDispatcher("/jsp/add_tournament.jsp").forward(req, resp);
    }
}

