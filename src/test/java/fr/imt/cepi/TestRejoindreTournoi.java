package fr.imt.cepi;

import fr.imt.cepi.bean.RejoindreTournoi;
import org.junit.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TestRejoindreTournoi {

    @Test
    public void testrejoindre() throws SQLException {
        DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
        Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/tst?useLegacyDatetimeCode=false&serverTimezone=Europe/Paris","tst","tst");
        RejoindreTournoi testrejoindre = new RejoindreTournoi(1, 1);
        // testrejoindre.join(con);
        con.close();
    }
}
