package fr.imt.cepi.servlet.filters;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter("/*")
public class AuthenticationFilter implements Filter {

    private final Logger logger = LogManager.getLogger(AuthenticationFilter.class);

    @Override
    public void init(FilterConfig fConfig) throws ServletException {
        logger.info("Initialisation du filtre d'Authentification");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) request;

        HttpServletResponse res = (HttpServletResponse) response;

        String uri = req.getRequestURI();
        logger.info("URI : " + uri);

        HttpSession session = req.getSession(false);

        if (session == null) {
            System.out.println("Session null");
            // Affichage de la page de connexion
            req.getServletContext().getRequestDispatcher("/index.jsp").forward(request,response);
        } else {
            // poursuit par le prochain filtre
            chain.doFilter(request, response);
        }
    }
    @Override
    public void destroy() {
    }

}
