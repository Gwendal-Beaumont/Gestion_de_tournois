package fr.imt.cepi.bean;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Tournoi implements Serializable {

    /**
     * Classe définissant les principaux paramètres du tournoi.
     */
    //Attributs
    private int id;
    private String nom_tournoi;
    private ArrayList<Equipe> liste_equipes;
    private ArrayList<Match> ordre_matches;
    private int id_sport;
    private Boolean visibility;
    private LocalDateTime date;
    private int proprietaire;
    private int etat; //0 inscriptions ouvertes / 1 inscriptions fermees / 2 tournoi en cours / 3 Tournoi terminé

    // Constructeur
    public Tournoi(int id, String nom_tournoi, ArrayList<Equipe> liste_equipes, int id_sport, Boolean visibility, LocalDateTime date, int proprietaire, int etat) {
        this.id = id;
        this.nom_tournoi = nom_tournoi;
        this.liste_equipes = liste_equipes;
        this.ordre_matches = new ArrayList<>();
        this.id_sport = id_sport;
        this.visibility = visibility;
        this.date = date;
        this.proprietaire = proprietaire;
        this.etat = etat;
    }

    //Méthodes

    /**
     * Setter permettant de définir la liste de matches du tournoi.
     */
    public void setMatches(ArrayList<Match> matches) {
        this.ordre_matches = matches;
    }

    /**
     * Getter permettant de récupérer la liste des matches du tournoi.
     *
     * @return ArrayList
     */
    public ArrayList<Match> getMatches() {
        return ordre_matches;
    }

    /**
     * Setter permettant de définir la liste des équipes du tournoi.
     */
    public void setEquipes(ArrayList<Equipe> equipes) {
        this.liste_equipes = equipes;
    }

    /**
     * Getter permettant de récupérer la liste des équipes du tournoi.
     *
     * @return ArrayList
     */
    public ArrayList<Equipe> getEquipes() {
        return liste_equipes;
    }

    /**
     * Setter permettant de définir le nom du tournoi.
     */
    public void setNom_tournoi(String nom) {
        this.nom_tournoi = nom;
    }

    /**
     * Getter permettant de récupérer le nom du tournoi.
     *
     * @return String
     */
    public String getNom_tournoi() {
        return nom_tournoi;
    }

    /**
     * Getter permettant de récupérer le sport du tournoi
     *
     * @return int id du sport
     */
    public int getId_sport() {
        return id_sport;
    }


    /**
     * Getter permettant de récupérer l'état du tournoi
     *
     * @return String etat tournoi
     */
    public String getEtat() {
        if (this.etat == 0) {
            return "inscriptions en cours";
        } else if (this.etat == 1) {
            return "inscriptions fermées";
        } else {
            return "tournoi en cours";
        }
    }

    @Override
    public String toString() {
        return "Tournoi{" +
                "id=" + id +
                ", nom_tournoi='" + nom_tournoi + '\'' +
                ", liste_equipes=" + liste_equipes +
                ", ordre_matches=" + ordre_matches +
                ", id_sport=" + id_sport +
                ", visibility=" + visibility +
                ", date=" + DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss").format(date) +
                ", proprietaire=" + proprietaire +
                '}';
    }

    /**
     * Méthode permettant de fermer les inscriptions
     */
    public void fermerInscriptions() {
        this.etat = 1;
    }

    /**
     * Méthode permettant d'ouvrir les inscriptions
     */
    public void ouvrirInscriptions() {
        this.etat = 0;
    }

    /**
     * Méthode permettant de changer l'état des inscriptions si le tournoi n'a pas encore démarré
     */
    public void changerEtat() {
        if (this.etat < 2) { //on verifie que le tournoi n'ait pas déjà démarré le tournoi
            if (this.etat == 0) { //si les inscriptions sont ouvertes, on les ferme
                this.etat = 1;
            } else {            //sinon on les ouvre
                this.etat = 0;
            }
        } else {
            this.etat = 2;
            //afficher que le tournoi a déjà démarré et qu'on ne peut pas ouvrir les inscriptions
        }
    }

    /**
     * Méthode qui permet de changer l'état du tournoi pour le démarrer (qu'il soit ouvert ou fermé)
     */
    public void demarrerTournoi() {
        this.etat = 2;
    }


    /**
     * Getter permettant de récupérer l'id du tournoi
     *
     * @return int id du tournoi
     */
    public int getId() {
        return id;
    }

    public Boolean getVisibility() {
        return visibility;
    }

    public String getStringDate() {
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm");
        String formattedDate = date.format(dateFormat);
        return formattedDate;
    }
}
