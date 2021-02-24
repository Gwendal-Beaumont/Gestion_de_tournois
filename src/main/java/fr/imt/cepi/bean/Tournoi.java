package fr.imt.cepi.bean;

import fr.imt.cepi.bean.Equipe;
import fr.imt.cepi.bean.Match;

import java.io.Serializable;
import java.time.LocalDate;
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
    private LocalDate date;
    private int proprietaire;

    // Constructeur
    public Tournoi(int id, String nom_tournoi, ArrayList<Equipe> liste_equipes, int id_sport, Boolean visibility, LocalDate date, int proprietaire) {
        this.id = id;
        this.nom_tournoi = nom_tournoi;
        this.liste_equipes = liste_equipes;
        this.ordre_matches = new ArrayList<>();
        this.id_sport = id_sport;
        this.visibility = visibility;
        this.date = date;
        this.proprietaire = proprietaire;
    }

    //Méthodes

    /**
     * Setter permettant de définir la liste de matches du tournoi.
     *
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
     *
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
     *
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
}
