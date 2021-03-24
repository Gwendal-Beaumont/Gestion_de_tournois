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
       String id=req.getParameter("id");
       int idtournoi=Integer.parseInt(id);
       Utilisateur user = (Utilisateur) req.getSession().getAttribute("utilisateur");
       int iduser = user.getId();
       
       // On crée nos attributs pour la base de données
            Connection con;
            PreparedStatement ps;
            ResultSet rs;

            
            try {
                con = AppContextListener.getConnection();

                //Décompte du nombre d'équipe pour en créer une nouvelle avec le bon id
                ps=con.prepareStatement("SELECT COUNT(*) FROM equipe");
                rs=ps.executeQuery();
                int numEquipe = 0;
                while (rs.next()){
                    numEquipe=1;
                }

                //Insertion de la nouvelle équipe dans le tournoi
                ps = con.prepareStatement("INSERT INTO TABLE tournoi_equipe VALUES (?,?)");
                ps.setInt(1, idtournoi);
                ps.setInt(2, numEquipe);
                rs= ps.executeQuery();
                ps.executeUpdate();

                //Insertion de l'utilisateur dans l'équipe
                ps=con.prepareStatement("INSERT INTO TABLE equipe_utilisateur VALUES (?,?)");
                ps.setInt(1, numEquipe);
                ps.setInt(2, iduser);
                rs= ps.executeQuery();
                ps.executeUpdate();

                //Création de l'équipe
                ps=con.prepareStatement("INSERT INTO TABLE equipe VALUES (?,?)");
                ps.setInt(1, numEquipe);
                ps.setString(2, "");
                rs= ps.executeQuery();
                ps.executeUpdate();

                getServletContext().getRequestDispatcher("/jsp/add_tournament.jsp").forward(req, resp);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }

    }
}
