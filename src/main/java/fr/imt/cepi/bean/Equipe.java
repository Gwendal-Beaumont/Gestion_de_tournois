package fr.imt.cepi.bean;

import fr.imt.cepi.servlet.listeners.AppContextListener;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class Equipe {

    //Attributs
    private int id_equipe;
    private String nom_equipe;
    private int id_Tournoi;

    private ArrayList<Utilisateur> joueurs_equipe = new ArrayList<Utilisateur>(); //correspond à une liste d'id des joueurs de l'équipe

    //Constructeur
    public Equipe(int id_equipe, String nom_equipe) {
        this.id_equipe = id_equipe;
        this.nom_equipe = nom_equipe;

    }

    public Equipe(String nom_equipe, int id_Tournoi) {
        this.nom_equipe = nom_equipe;
        this.id_Tournoi = id_Tournoi;
    }

    public Equipe(int id_equipe, String nom_equipe, int id_Tournoi) {
        this.id_equipe = id_equipe;
        this.nom_equipe = nom_equipe;
        this.id_Tournoi = id_Tournoi;
    }

    //Getter

    public String getNom_equipe() {
        return nom_equipe;
    }

    public int getId_equipe() {
        return id_equipe;
    }


    public ArrayList<Utilisateur> getJoueurs_equipe() {
        return joueurs_equipe;
    }

    //Setter

    public void setId_equipe(int id_equipe) {
        this.id_equipe = id_equipe;
    }

    public void setNom_equipe(String nom_equipe) {
        this.nom_equipe = nom_equipe;
    }


    public void setJoueurs_equipe(ArrayList<Utilisateur> joueurs_equipe) {
        this.joueurs_equipe = joueurs_equipe;
    }

    //Méthodes

    /**
     * Méthode permettant d'ajouter un joueur à une équipe incomplète
     *
     * @param joueur l'identifiant du joueur en question
     */
    public void ajouterJoueur(Utilisateur joueur) {

        joueurs_equipe.add(joueur);
    }


    //Ajoute ou modifie la base de données avec les informations contenu dans l'objet.
    public void updateBDD() {
        try (Connection con = AppContextListener.getConnection(); PreparedStatement ps = con.prepareStatement(
                "SELECT count(*) FROM equipe WHERE nom = ?  AND id_tournoi= ?")) {
            ps.setString(1, nom_equipe);
            ps.setInt(2, id_Tournoi);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                if (rs.getInt(1)==0) {
                    try (Connection con2 = AppContextListener.getConnection(); PreparedStatement ps2 = con2.prepareStatement(
                            "INSERT INTO tst.equipe(nom, id_tournoi) VALUES (?,?)")) {

                        ps2.setString(1, nom_equipe);
                        ps2.setInt(2, id_Tournoi);
                        ps2.executeUpdate();

                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                    try (Connection con3 = AppContextListener.getConnection(); PreparedStatement ps3 = con3.prepareStatement(
                            "SELECT id FROM equipe WHERE nom = ? and id_tournoi= ?")) {
                        ps3.setString(1, nom_equipe);
                        ps3.setInt(2, id_Tournoi);
                        ResultSet rs3 = ps3.executeQuery();
                        if (rs3.next()) {
                            id_equipe = rs3.getInt("id");
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                    for (Utilisateur joueur : joueurs_equipe) {
                        System.out.println(joueur.getId());
                        try (Connection con2 = AppContextListener.getConnection(); PreparedStatement ps2 = con2.prepareStatement(
                                "INSERT INTO tst.equipe_utilisateur(id_equipe, id_joueur, role) VALUES (?,?,?)")) {
                            ps2.setInt(1, id_equipe);
                            ps2.setInt(2, joueur.getId());
                            ps2.setInt(3,1);
                            ps2.executeUpdate();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }
            }


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
