package fr.imt.cepi.bean;

import fr.imt.cepi.servlet.listeners.AppContextListener;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class FormTournoi {
    String nom;
    String visibility;
    String date;
    String id;
    String idsport;

    public FormTournoi(String nom, String visibility, String date, String id, String idsport) {
        this.nom = nom;
        this.visibility = visibility;
        this.date = date;
        this.id = id;
        this.idsport = idsport;
    }

    public void save(Connection con){
        // Conversion format date
        DateFormat date2=new SimpleDateFormat("yyyy-MM-dd'T'HH:mm");

        java.util.Date date3= null;
        try {
            date3 = date2.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        java.sql.Timestamp date4=new Timestamp(date3.getTime());



        // On crée nos attributs pour la base de données
        PreparedStatement ps;

        // On tente d'envoyer le tournoi à la base de données
        try {
            ps = con.prepareStatement("INSERT INTO tst.tournoi(nom, id_sport, visibility, date_debut, proprietaire) VALUES (?, ?, ?, ?, ?)");
            ps.setString(1, nom);
            ps.setInt(2, Integer.parseInt(idsport));
            ps.setBoolean(3, visibility.equals("public"));
            ps.setTimestamp(4, date4);
            ps.setInt(5, Integer.parseInt(id));
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
