package fr.imt.cepi.bean;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RejoindreTournoi {
    private int idTournoi;
    private int idUser;

    public RejoindreTournoi(int idTournoi, int idUser) {
        this.idTournoi = idTournoi;
        this.idUser = idUser;
    }

    public int getIdTournoi() {
        return idTournoi;
    }

    public void setIdTournoi(int idTournoi) {
        this.idTournoi = idTournoi;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public void join(Connection con) {
        // On crée l'atttribut pour la base de données
        PreparedStatement ps;
        ResultSet rs;

        // On tente de rejoindre le tournoi en ajoutant l'utilisateur à la base de données et en créant l'équipe
        // nécessaire pour pouvoir ajouter le tout dans les tables de la base de données.

        int numEquipe = 0;

        //Décompte du nombre d'équipe pour en créer une nouvelle avec le bon id
        try {
            ps = con.prepareStatement("SELECT COUNT(*) FROM tst.equipe");
            rs = ps.executeQuery();
            if (rs.next()) {
                numEquipe = rs.getInt(1) + 1;
                rs.close();
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }


        //Insertion de la nouvelle équipe dans le tournoi
        try {
            ps = con.prepareStatement("INSERT INTO tst.tournoi_equipe (id_tournoi, id_equipe) VALUES (?,?)");
            ps.setInt(1, idTournoi);
            ps.setInt(2, numEquipe);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }


        //Insertion de l'utilisateur dans l'équipe

        try {
            ps = con.prepareStatement("INSERT INTO equipe_utilisateur (id_equipe, id_joueur) VALUES (?,?)");
            ps.setInt(1, numEquipe);
            ps.setInt(2, idUser);
            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }

        //Création de l'équipe
        try {
            ps = con.prepareStatement("INSERT INTO TABLE equipe (nom) VALUES (?)");
            ps.setString(1, "Unnamed");
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
