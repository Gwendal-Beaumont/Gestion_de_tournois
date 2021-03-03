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
    private boolean en_cours;

    //Constructeur
    public Match(int id_tournoi, int id_match, int id_sport, LocalDateTime heure_debut, int duree_match_secondes, ArrayList<Equipe> equipes) {
        this.id_tournoi = id_tournoi;
        this.id_match = id_match;
        this.id_sport = id_sport;
        this.heure_debut = heure_debut;
        this.duree_match_secondes = duree_match_secondes;
        this.equipes = equipes;
        this.score = new int[equipes.size()];
        this.en_cours = false;

    }
    //Méthodes

    /**
     * Getter permettant de récupérer l'identifiant du tournoi associé.
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
     * @return boolean
     */
    public boolean getEn_cours() {
        return this.en_cours;
    }

    /**
     * Setter permettant de débuter le match ou de relancer le match en pause
     */
    public void reprise() {
        this.en_cours = true;
    }

    /**
     * Setter permettant d'interrompre ou de clôturer le match.
     */
    public void stop() {
        this.en_cours = false;
    }

}
