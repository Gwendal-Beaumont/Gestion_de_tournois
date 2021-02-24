package fr.imt.cepi.servlet;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/create_tournament")
public class CreateTournamentServlet extends HttpServlet {
    static Logger logger = LogManager.getLogger(CreateTournamentServlet.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/jsp/create_tournament.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       String nom=req.getParameter("name");
       String visibility=  req.getParameter("visibility");
       System.out.println(visibility);
       logger.info("boolean:"+visibility);
       String date=req.getParameter("date");

    }
}
