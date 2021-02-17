package fr.imt.cepi.servlet;

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
import java.util.Arrays;
import java.util.List;

@WebServlet({"/Home"})
public class HomeServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    static Logger logger = LogManager.getLogger(HomeServlet.class);

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<String> listeTournois = Arrays.asList("aaa", "bbb", "ccc","Tournoi e-sport Diablo III");
        request.setAttribute("listeTournoisJSP", listeTournois);
        getServletContext().getRequestDispatcher("/jsp/home.jsp").forward(request,response);
        HttpSession session = request.getSession();
        Utilisateur user = (Utilisateur) session.getAttribute("utilisateur");

        // On cherche les sports associés à l'utilisateur dans la base de données
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            con = AppContextListener.getConnection();
            ps = con.prepareStatement(
                    "SELECT nom FROM sport WHERE id=1 LIMIT 1");
            rs = ps.executeQuery();
            if (rs.next()){
                String sport = rs.getString("nom");
                session.setAttribute("sport", sport);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }
}
