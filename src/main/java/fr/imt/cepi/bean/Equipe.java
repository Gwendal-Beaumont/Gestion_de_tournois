package fr.imt.cepi.bean;

import java.util.ArrayList;

public class Equipe {

    //Attributs
    private int id_equipe;
    private String nom_equipe;
    private int nb_joueurs;
    private ArrayList<Utilisateur> joueurs_equipe; //correspond à une liste d'id des joueurs de l'équipe

    //Constructeur
    public Equipe(int id_equipe, String nom_equipe, int nb_joueurs, ArrayList<Utilisateur> joueurs_equipe){
        this.id_equipe = id_equipe;
        this.nom_equipe = nom_equipe;
        this.nb_joueurs = nb_joueurs;
        this.joueurs_equipe = joueurs_equipe;
    }

    //Getter

    public String getNom_equipe() {
        return nom_equipe;
    }

    public int getId_equipe() {
        return id_equipe;
    }

    public int getNb_joueurs() {
        return nb_joueurs;
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

    public void setNb_joueurs(int nb_joueurs) {
        this.nb_joueurs = nb_joueurs;
    }

    public void setJoueurs_equipe(ArrayList<Utilisateur> joueurs_equipe) {
        this.joueurs_equipe = joueurs_equipe;
    }

    //Méthodes

    /**
     * Méthode permettant de savoir si l'équipe est complete
     * @return true si elle est complète
     */
    public boolean equipeComplete(){
        int n = joueurs_equipe.size();
        return (n == nb_joueurs);
    }

    /**
     * Méthode permettant d'ajouter un joueur à une équipe
     * @param id_joueur l'identifiant du joueur en question
     */
    public void ajouterJoueur(Utilisateur id_joueur){
        joueurs_equipe.add(id_joueur);
    }
}
