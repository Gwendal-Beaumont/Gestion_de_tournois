package fr.imt.cepi.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/ManageTournaments")

public class ManageTournamentsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id_tournament = req.getParameter("id_tournament");
        req.setAttribute("id_tournament", id_tournament);
        getServletContext().getRequestDispatcher("/jsp/manage_tournaments.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/jsp/manage_tournaments.jsp").forward(req, resp);
    }
}
