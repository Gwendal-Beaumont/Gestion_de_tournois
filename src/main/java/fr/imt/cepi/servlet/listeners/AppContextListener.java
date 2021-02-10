package fr.imt.cepi.servlet.listeners;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.apache.logging.log4j.core.config.ConfigurationSource;
import org.apache.logging.log4j.core.config.Configurator;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;

@WebListener
public class AppContextListener implements ServletContextListener {

    private static HikariDataSource dataSource;

    public static Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        ServletContext ctx = servletContextEvent.getServletContext();

        String webAppPath = ctx.getRealPath("/");

        // Initialisation du pool de connexion
        try {
            HikariConfig config = new HikariConfig(webAppPath + "WEB-INF/db.properties");
            dataSource = new HikariDataSource(config);
            System.out.println("Connection base de données OK");
        } catch (Exception e) {
            e.printStackTrace();
        }

        // initialisation de log4j2
        String log4jProp = webAppPath + "WEB-INF/log4j2.xml";
        try {
            InputStream inputStream = new FileInputStream(log4jProp);
            ConfigurationSource source = new ConfigurationSource(inputStream);
            Configurator.initialize(null, source);
            System.out.println("Configuration log4j effectuée");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        Connection con = (Connection) servletContextEvent.getServletContext().getAttribute("DBConnection");
        try {
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
