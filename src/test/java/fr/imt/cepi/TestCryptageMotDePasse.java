package fr.imt.cepi;

import fr.imt.cepi.bean.EncrypteurMDP;
import org.junit.Test;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TestCryptageMotDePasse {

    @Test
    public void testcryptage() throws NoSuchAlgorithmException, SQLException {
        MessageDigest messageDigest = MessageDigest.getInstance("SHA-512");

        byte[] data = "1".getBytes(StandardCharsets.UTF_8);
        messageDigest.update(data);
        byte[] byteData = messageDigest.digest();

        StringBuffer hexString = new StringBuffer();
        for (int i=0;i<byteData.length;i++) {
            String hex=Integer.toHexString(0xff & byteData[i]);
            if(hex.length()==1) hexString.append('0');
            hexString.append(hex);
        }
        System.out.println("En format hexa : " + hexString.toString());

        String messageCR = new EncrypteurMDP("1").encrypt();
        System.out.println("En format hexa : " + messageCR.length());

        Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/tst?useLegacyDatetimeCode=false&serverTimezone=Europe/Paris","tst","tst");
        PreparedStatement ps = con.prepareStatement("UPDATE tst.utilisateur SET password = ? WHERE id=3");
        ps.setString(1, new EncrypteurMDP("toto").encrypt());
        ps.executeUpdate();
    }
}
