package fr.imt.cepi;

import fr.imt.cepi.bean.FormTournoi;
import org.junit.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TestFormTournoi {
    @Test
    public void testsave() throws SQLException {
        DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
        Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/tst?useLegacyDatetimeCode=false&serverTimezone=Europe/Paris","tst","tst");
        FormTournoi testTournoi=new FormTournoi("test","0","2021-03-03T11:47","2","2") ;
        testTournoi.save(con);
        con.close();
    }
}

