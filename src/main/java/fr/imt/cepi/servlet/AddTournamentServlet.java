package fr.imt.cepi.servlet;

import fr.imt.cepi.bean.Equipe;
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
        String idT = req.getParameter("id-tournoi");
        int idtournoi = 1;
        Utilisateur user = (Utilisateur) req.getSession().getAttribute("utilisateur");
        int iduser = user.getId();

        // On crée nos attributs pour la base de données

        ResultSet rs;

        int numEquipe = 0;

        //Décompte du nombre d'équipe pour en créer une nouvelle avec le bon id
        try (Connection con = AppContextListener.getConnection(); PreparedStatement ps = con.prepareStatement("SELECT COUNT(*) FROM equipe")) {
            rs = ps.executeQuery();
            if(rs.next()) {
                numEquipe=rs.getInt(1)+1;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }


        //Insertion de la nouvelle équipe dans le tournoi
        try (Connection con = AppContextListener.getConnection(); PreparedStatement ps = con.prepareStatement(
                "INSERT INTO TABLE tournoi_equipe (id_tournoi, id_equipe) VALUES (?,?)")) {
            ps.setInt(1, idtournoi);
            ps.setInt(2, numEquipe);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }


        //Insertion de l'utilisateur dans l'équipe

        try (Connection con = AppContextListener.getConnection(); PreparedStatement ps = con.prepareStatement(
                "INSERT INTO TABLE equipe_utilisateur (id_equipe,id_joueur) VALUES (?,?)")) {
            ps.setInt(1, numEquipe);
            ps.setInt(2, iduser);
            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }

        //Création de l'équipe
        try (Connection con = AppContextListener.getConnection(); PreparedStatement ps = con.prepareStatement(
                "INSERT INTO TABLE equipe (nom) VALUES (?)")) {
            ps.setString(1, "");
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }

        getServletContext().getRequestDispatcher("/jsp/add_tournament.jsp").forward(req, resp);
    }
}

