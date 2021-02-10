package fr.imt.cepi.servlet;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/Logout")
public class LogoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static Logger logger = LogManager.getLogger(LogoutServlet.class);

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Cookie[] cookies = request.getCookies();
		if (cookies != null) {
			for (Cookie cookie : cookies) {
				if (cookie.getName().equals("JSESSIONID")) {
					logger.info("JSESSIONID=" + cookie.getValue());
					break;
				}
			}
		}
		HttpSession session = request.getSession(false);
		if (session != null) {
			logger.info("Logout de l'utilisateur " + session.getAttribute("utilisateur"));
			session.invalidate();
		}
		// redirection vers la page d'accueil
		response.sendRedirect("Login");
	}

}
