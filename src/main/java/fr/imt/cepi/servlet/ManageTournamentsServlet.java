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

@WebServlet("/ManageTournaments")

public class ManageTournamentsServlet extends HttpServlet {
    static Logger logger = LogManager.getLogger(ManageTournamentsServlet.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id_tournament = req.getParameter("id_tournament");
        logger.info("Tournoi en cours de modification : " + id_tournament);
        int id;
        try {
            id = Integer.parseInt(id_tournament);
        } catch (NumberFormatException e) {
            id = 0;
        }
        try (Connection con = AppContextListener.getConnection(); PreparedStatement ps = con.prepareStatement(
                "SELECT tournoi.id, tournoi.nom, id_sport, sport.nom, sport.image, visibility, date_debut, proprietaire, etat, nb_joueurs_par_equipe, nb_equipes FROM tst.tournoi JOIN tst.sport ON sport.id = id_sport  WHERE tournoi.id = ?;"
        )) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Tournoi tournoi = new Tournoi(
                        rs.getInt("id"),
                        rs.getString("nom"),
                        new ArrayList<>(),
                        new Sport(rs.getInt("id_sport"), rs.getString("sport.nom"), rs.getString("sport.image")),
                        rs.getBoolean("visibility"),
                        rs.getTimestamp("date_debut").toLocalDateTime(),
                        rs.getInt("proprietaire"),
                        rs.getInt("etat"),
                        rs.getInt("nb_joueurs_par_equipe"),
                        rs.getInt("nb_equipes")
                );

                System.out.println(tournoi);
                req.setAttribute("tournoi", tournoi);
            }
            rs.close();

        } catch (SQLException e) {
            getServletContext().getRequestDispatcher("/jsp/manage_tournaments.jsp").forward(req, resp);
        }
        ArrayList<Utilisateur> listeUtilisateur = new ArrayList<>();

        try (Connection con2 = AppContextListener.getConnection(); PreparedStatement ps2 = con2.prepareStatement(
                "SELECT utilisateur.id, utilisateur.username, utilisateur.email FROM utilisateur_tournoi JOIN utilisateur ON utilisateur_tournoi.id_utilisateur = utilisateur.id WHERE utilisateur_tournoi.id_tournoi = ?")) {
            ps2.setInt(1, id);
            ResultSet rs2 = ps2.executeQuery();
            while (rs2.next()) {
                listeUtilisateur.add(new Utilisateur(
                        rs2.getString("username"),
                        rs2.getString("email"),
                        rs2.getInt("id")
                ));
            }
            req.setAttribute("listeUtilisateur", listeUtilisateur);

        } catch (Exception e) {
            e.printStackTrace();
        }

        try (Connection con2 = AppContextListener.getConnection(); PreparedStatement ps2 = con2.prepareStatement(
                "SELECT id,nom, id_tournoi FROM equipe WHERE id_tournoi = ?"
        )) {

            ps2.setInt(1, id);
            ResultSet rs2 = ps2.executeQuery();
            ArrayList<Equipe> listeEquipe = new ArrayList<>();
            while (rs2.next()) {
                listeEquipe.add(new Equipe(
                        rs2.getInt("id"),
                        rs2.getString("nom"),
                        rs2.getInt("id_tournoi")
                ));
            }
            rs2.close();
            for (Equipe eq : listeEquipe) {
                try (Connection con3 = AppContextListener.getConnection(); PreparedStatement ps3 = con3.prepareStatement(
                        "SELECT utilisateur.username, utilisateur.email, utilisateur.id FROM utilisateur JOIN equipe_utilisateur ON utilisateur.id = equipe_utilisateur.id_joueur WHERE equipe_utilisateur.id_equipe = ?")) {
                    ps3.setInt(1, eq.getId_equipe());
                    ResultSet rs3 = ps3.executeQuery();
                    while (rs3.next()) {
                        eq.ajouterJoueur(new Utilisateur(
                                rs3.getString("username"),
                                rs3.getString("email"),
                                rs3.getInt("id")
                        ));
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            req.setAttribute("listeEquipe", listeEquipe);

            getServletContext().getRequestDispatcher("/jsp/manage_tournaments.jsp").forward(req, resp);
        } catch (SQLException e) {
            getServletContext().getRequestDispatcher("/jsp/manage_tournaments.jsp").forward(req, resp);
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/jsp/manage_tournaments.jsp").forward(req, resp);
    }
}
