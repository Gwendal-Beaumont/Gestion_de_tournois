package fr.imt.cepi.bean;

import java.util.ArrayList;
import java.util.Collections;

public class File {

    /**
     * Classe permettant d'ordonner les matches dans un tournoi ouvert opposant plusieurs participants individuels
     * (type tournoi artistique). Les participants ne s'affrontent pas directement.
     */

    //Attributs
    private final ArrayList<Equipe> liste_participants;
    private ArrayList<Match> ordre_passage;
    private final int id_tournoi, nbr_participants;
    private int[][] tableau_scores;

    //Constructeur
    public File(int id_tournoi, ArrayList<Equipe> liste_participants) {
        this.id_tournoi = id_tournoi;
        this.liste_participants = liste_participants;
        this.nbr_participants = liste_participants.size();
    }

    //Méthodes

    /**
     * Getter permettant d'obtenir l'id du tournoi.
     *
     * @return int
     */
    public int getId_tournoi() {
        return this.id_tournoi;
    }

    /**
     * Getter permettant d'obtenir la liste des participants
     *
     * @return ArrayList
     */
    public ArrayList<Equipe> getListe_participants() {
        return this.liste_participants;
    }

    /**
     * Getter permettant de récupérer le tableau des scores
     *
     * @return int[][]
     */
    public int[][] getTableau_scores() {
        return this.tableau_scores;
    }

    /**
     * Methode permettant de créer l'ordre de passage des différentes équipes de la file d'équipes.
     */
    public void creation() {
        ArrayList<Match> ordre_passage = new ArrayList<>();
        for (Equipe elt : liste_participants) {
            ArrayList<Equipe> equipe = new ArrayList<>();
            equipe.add(elt);
            ordre_passage.add(new Match(getId_tournoi(), equipe));
        }
        Collections.shuffle(ordre_passage);
        this.ordre_passage = ordre_passage;
    }

    /**
     * Getter permettant de récupérer l'ordre de passage
     *
     * @return ArrayList<Match>
     */
    public ArrayList<Match> getOrdre_passage() {
        return this.ordre_passage;
    }

    /**
     * Cette méthode permet de recalculer le classement de la file.
     */
    public void refreshClassement() {

        int[][] tableau_scores = new int[nbr_participants][2];

        ArrayList<Match> ordre = getOrdre_passage();

        for (int i = 0; i < nbr_participants; i++) {
            double score_max = ordre.get(0).getScore()[0];
            int position = 0;

            for (int j = 0; j < getOrdre_passage().size(); j++) {
                Match match = ordre.get(j);
                if (match.getEtat().equals("fini")) {
                    if (score_max < match.getScore()[0]) {
                        score_max = match.getScore()[0];
                        position = j;
                    }
                }
            }
            tableau_scores[i][0] = ordre.get(position).getEquipes().get(0).getId_equipe();
            tableau_scores[i][1] = ordre.get(position).getScore()[0];
            ordre.remove(position);
        }
        this.tableau_scores = tableau_scores;
    }

    /**
     * Cette méthode permet de désigner le ou les équipes vainqueures de la poule en fonction de leur nombre de points.
     *
     * @param nbr_vainqueurs Nombre de vainqueurs souhaité au sein de la file
     * @return ArrayList
     */
    public ArrayList<Equipe> vainqueurs(int nbr_vainqueurs) {

        int[][] tab = getTableau_scores();
        ArrayList<Equipe> participants = getListe_participants();
        ArrayList<Equipe> vainqueurs = new ArrayList<>();

        for (int i = 0; i < nbr_vainqueurs; i++) {
            for (int j = 0; j < nbr_participants; j++) {
                if (tab[i][0] == participants.get(j).getId_equipe()) {
                    vainqueurs.add(participants.get(j));
                }
            }
        }
        return vainqueurs;
    }
}