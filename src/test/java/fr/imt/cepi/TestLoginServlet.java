package fr.imt.cepi;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import fr.imt.cepi.servlet.LoginServlet;
import fr.imt.cepi.servlet.listeners.AppContextListener;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockedStatic;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.sql.SQLException;

/**
 * Exemple de test des Servlets avec mockito
 */
public class TestLoginServlet extends Mockito {

    @Mock
    HttpServletRequest request;
    @Mock
    HttpServletResponse response;
    @Mock
    RequestDispatcher dispatcherLogin;
    @Mock
    ServletContext context;
    @Mock
    HttpSession session;
    @Mock
    ServletConfig config;

    @Before
    public void setUp() throws Exception, SQLException {
        MockitoAnnotations.initMocks(this);

        when(request.getSession()).thenReturn(session);

        HikariConfig config = new HikariConfig("src/main/webapp/WEB-INF/db.properties");
        HikariDataSource dataSource = new HikariDataSource(config);
        Mockito.mockStatic(AppContextListener.class).
                when((MockedStatic.Verification) AppContextListener.getConnection()).thenReturn(dataSource.getConnection());


    }

    @Test
    public void testLoginServlet() throws Exception {

        LoginServlet servlet = new LoginServlet();
        servlet.init(config);
        when(servlet.getServletContext()).thenReturn(context);

        when(servlet.getServletContext().getRequestDispatcher("/jsp/login.jsp")).thenReturn(dispatcherLogin);

        // Avec des identifiants qui n'existent pas
        when(request.getParameter("login")).thenReturn("user");
        when(request.getParameter("password")).thenReturn("pwd");
        servlet.doPost(request, response);

        verify(dispatcherLogin).forward(request, response);
        verify(request, atLeast(1)).getParameter("login");
        verify(request, atLeast(1)).getParameter("password");


        // Avec des identifiants qui existent
        when(request.getParameter("login")).thenReturn("bertin");
        when(request.getParameter("password")).thenReturn("d");
        servlet.doPost(request, response);

        Mockito.verify(response, Mockito.times(1)).sendRedirect("Home");
        verify(request, atLeast(1)).getParameter("login");
        verify(request, atLeast(1)).getParameter("password");
    }
}