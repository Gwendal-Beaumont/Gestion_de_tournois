package fr.imt.cepi.bean;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class EncrypteurMDP {
    private String messageAEncypter;

    public EncrypteurMDP(String messageAEncypter) {
        this.messageAEncypter = messageAEncypter;
    }

    public String encrypt() throws NoSuchAlgorithmException {
        MessageDigest messageDigest = MessageDigest.getInstance("SHA-512");

        byte[] data = messageAEncypter.getBytes(StandardCharsets.UTF_8);
        messageDigest.update(data);
        byte[] byteData = messageDigest.digest();

        StringBuffer hexString = new StringBuffer();
        for (int i=0;i<byteData.length;i++) {
            String hex=Integer.toHexString(0xff & byteData[i]);
            if(hex.length()==1) hexString.append('0');
            hexString.append(hex);
        }
        return hexString.toString();
    }
}
