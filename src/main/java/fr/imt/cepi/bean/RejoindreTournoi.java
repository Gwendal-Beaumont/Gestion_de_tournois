package fr.imt.cepi.bean;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

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

        //Variable du tournoi
        int nbEquipes = 0;
        int nbJoueursParEquipes = 0;
        int nbJoueurs = 0;


        //On relie un utilisateur à un tournoi
        try {
            ps = con.prepareStatement("INSERT INTO utilisateur_tournoi(id_utilisateur, id_tournoi) VALUES (?, ?)");
            ps.setInt(1, idUser);
            ps.setInt(2, idTournoi);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }

        //On récupère le nombre de joueur déjà inscrit
        try{
            ps = con.prepareStatement("SELECT count(id_utilisateur) FROM tst.utilisateur_tournoi WHERE id_tournoi = " + idTournoi);
            rs = ps.executeQuery();
            if(rs.next()){
                nbJoueurs = rs.getInt(1);
            }
        }catch(Exception e){
            e.printStackTrace();
        }

        //On récupère les infos du tournoi
        try{
            ps = con.prepareStatement("SELECT nb_joueurs_par_equipe, nb_equipes FROM tst.tournoi WHERE id = " + idTournoi);
            rs = ps.executeQuery();
            if(rs.next()){
                nbJoueursParEquipes = rs.getInt("nb_joueurs_par_equipe");
                nbEquipes = rs.getInt(2);
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        //On regarde si le tournoi est complet si oui on change la valeur
        if(nbJoueurs == nbJoueursParEquipes*nbEquipes){
            try{
                ps = con.prepareStatement("UPDATE tst.tournoi SET etat = 1 WHERE id = " + idTournoi);
                ps.executeUpdate();
            }catch (Exception e){
                e.printStackTrace();
            }
        }


        /**
         try {
         ps = con.prepareStatement("INSERT INTO equipe (nom) VALUES (?)");
         ps.setString(1, "Unnamed");
         ps.executeUpdate();
         } catch (Exception e) {
         e.printStackTrace();
         }

         int numEquipe = 0;

         //Décompte du nombre d'équipe pour en créer une nouvelle avec le bon id
         try {
         ps = con.prepareStatement("SELECT COUNT(*) FROM tst.equipe");
         rs = ps.executeQuery();
         if (rs.next()) {
         numEquipe = rs.getInt(1);
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
         */

    }

}
