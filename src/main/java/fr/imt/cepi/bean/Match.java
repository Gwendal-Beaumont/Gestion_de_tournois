package fr.imt.cepi.bean;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class Match {
    /**
     * Classe définissant les principaux paramètres d'un match donné.
     */
    //Attributs
    private int id_match, id_tournoi, id_sport;
    private LocalDateTime heure_debut;
    private int duree_match_secondes;
    private int[] score;
    private ArrayList<Equipe> equipes;
    private String etat;

    //Constructeur
    public Match(int id_tournoi, int id_match, int id_sport, LocalDateTime heure_debut, int duree_match_secondes, ArrayList<Equipe> equipes) {
        this.id_tournoi = id_tournoi;
        this.id_match = id_match;
        this.id_sport = id_sport;
        this.heure_debut = heure_debut;
        this.duree_match_secondes = duree_match_secondes;
        this.equipes = equipes;
        this.score = new int[equipes.size()];
        this.etat = "en_attente";
    }

    public Match(int id_tournoi, int id_match) {
        this.id_match = id_match;
        this.id_tournoi = id_tournoi;
        this.score = new int[equipes.size()];
        this.etat = "en_attente";
    }

    //Méthodes
    public void addEquipe(Equipe eq) {
        equipes.add(eq);
    }

    public Equipe getWinner() {
        if (score[0] > score[1]) {
            return equipes.get(0);
        } else if (score[1] > score[0]) {
            return equipes.get(1);
        } else System.out.println("Egaux");
        return null;
    }

    //Getter & Setter

    /**
     * Getter permettant de récupérer l'identifiant du tournoi associé.
     *
     * @return int
     */
    public int getId_tournoi() {
        return id_tournoi;
    }

    /**
     * Getter permettant d'obtenir l'identifiant du match.
     *
     * @return int
     */
    public int getId_match() {
        return this.id_match;
    }

    /**
     * Getter permettant d'obtenir l'horaire de début du match.
     *
     * @return LocalDateTime
     */
    public LocalDateTime getHeure_debut() {
        return this.heure_debut;
    }

    /**
     * Setter permettant de redéfinir l'horaire de début d'un match
     */
    public void setHeure_debut(LocalDateTime nouvelle_heure) {
        this.heure_debut = nouvelle_heure;
    }

    /**
     * Setter permettant de redéfinir la durée d'un match.
     */
    public void setDuree_match_secondes(int duree_secondes) {
        this.duree_match_secondes = duree_secondes;
    }

    /**
     * Getter permettant de récupérer le score actuel du match.
     *
     * @return int[]
     */
    public int[] getScore() {
        return this.score;
    }

    /**
     * Setter permettant de modifier le score d'une équipe.
     */
    public void setScore(int numero_equipe, int nouveau_score) {
        this.score[numero_equipe] = nouveau_score;
    }

    /**
     * Getter permettant d'obtenir les équipes compostant le match.
     *
     * @return ArrayList<Equipe>
     */
    public ArrayList<Equipe> getEquipes() {
        return this.equipes;
    }

    /**
     * Getter permettant de savoir si le match est en cours ou pas.
     *
     * @return string
     */
    public String getEtat() {
        return this.etat;
    }

    /**
     * Setter permettant de débuter le match ou de relancer le match en pause
     */
    public void demarrer() {
        this.etat = "en_cours";
    }

    /**
     * Setter permettant d'interrompre le match
     */
    public void stop() {
        this.etat = "suspendu";
    }

    /**
     * Setter permettant de réinitialiser le match comme s'il n'avait pas encore eu lieu
     */
    public void reinitialiser() {
        this.etat = "en_attente";
    }

    /**
     * Setter permettant de terminer le match
     */
    public void finir() {
        this.etat = "fini";
    }
}