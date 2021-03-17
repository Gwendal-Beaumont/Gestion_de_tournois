package fr.imt.cepi.servlet;

import fr.imt.cepi.bean.Equipe;
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
        getServletContext().getRequestDispatcher("/jsp/add_tournament.jsp").forward(req, resp);
        }

        @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       String id=req.getParameter("id");
       int idtournoi=Integer.parseInt(id);
       Utilisateur user = (Utilisateur) req.getSession().getAttribute("utilisateur");
       int iduser = user.getId();
       // On crée nos attributs pour la base de données
            Connection con;
            PreparedStatement ps;
            ResultSet rs;
            try {
                int id_equipe=1;
                con = AppContextListener.getConnection();
                ps = con.prepareStatement("INSERT INTO TABLE equipe_utilisateur VALUES (?,?)");
                ps.setInt(1, iduser);
                ps.setInt(2,id_equipe);
                rs = ps.executeQuery();
                ps.executeUpdate();
                getServletContext().getRequestDispatcher("/jsp/add_tournament.jsp").forward(req, resp);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }

    }
}
