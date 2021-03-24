package fr.imt.cepi.bean;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Poule {

    /**
     * Classe permettant d'ordonner les matches dans un tournoi de type "poule"
     */

    //Attributs
    private ArrayList<Match> ordre_matches;
    private final int id_tournoi, nbr_equipes;
    private int points_pour_victoire, points_pour_nul;
    private final ArrayList<Equipe> liste_equipes;
    private int[][] tableau_scores;

    //Constructeur
    public Poule(int id_tournoi, ArrayList<Equipe> liste_equipes, int points_pour_victoire, int points_pour_nul) {
        this.liste_equipes = liste_equipes;
        this.nbr_equipes = liste_equipes.size();
        this.points_pour_victoire = points_pour_victoire;
        this.points_pour_nul = points_pour_nul;
        this.id_tournoi = id_tournoi;
    }

    //Méthodes

    /**
     * Cette méthode permet de générer aléatoirement l'ordre des matches de la poule.
     */
    public void creation() {
        Random r = new Random();
        ArrayList<Match> ordre_matches = new ArrayList<>();
        for (int i = 0; i < nbr_equipes; i++) {
            for (int j = i + 1; j < nbr_equipes; j++) {
                boolean domicile = r.nextBoolean();
                ArrayList<Equipe> equipes_match = new ArrayList<>();
                if (domicile) {
                    equipes_match.add(liste_equipes.get(i));
                    equipes_match.add(liste_equipes.get(j));
                } else {
                    equipes_match.add(liste_equipes.get(j));
                    equipes_match.add(liste_equipes.get(i));
                }
                ordre_matches.add(new Match(getId_tournoi(), equipes_match));
            }
        }
        Collections.shuffle(ordre_matches);
        this.ordre_matches = ordre_matches;
    }

    /**
     * Getter permettant de récupérer l'id du tournoi'
     *
     * @return int
     */
    public int getId_tournoi() {
        return this.id_tournoi;
    }

    /**
     * Getter permettant de récupérer la position d'une équipe dans la liste des équipes
     *
     * @return int
     */
    public int getPositionEquipe(Equipe equipe) {
        for (int position = 0; position < liste_equipes.size(); position++) {
            if (liste_equipes.get(position).equals(equipe)) {
                return position;
            }
        }
        return (-1);
    }

    /**
     * Getter permettant d'obtenir l'ordre des matches de la poule.
     *
     * @return ArrayList<Match>
     */
    public ArrayList<Match> getOrdre_matches() {
        return this.ordre_matches;
    }

    /**
     * Getter permettant d'obtenir le nombre de points attribués à l'équipe en cas de victoire
     *
     * @return int
     */
    public int getPoints_pour_victoire() {
        return this.points_pour_victoire;
    }

    /**
     * Setter permettant de définir le nombre de points à attribuer à l'équipe en cas de victoire
     *
     * @param points Nombre de points en cas de victoire
     */
    public void setPoints_pour_victoire(int points) {
        this.points_pour_victoire = points;
    }

    /**
     * Getter permettant d'obtenir le nombre de points attribués aux deux équipes en cas de match nul
     *
     * @return int
     */
    public int getPoints_pour_nul() {
        return this.points_pour_nul;
    }

    /**
     * Setter permettant de définir le nombre de points à attribuer aux deux équipes en cas de match nul
     *
     * @param points Nombre de points en cas de mtch nul
     */
    public void setPoints_pour_nul(int points) {
        this.points_pour_nul = points;
    }

    /**
     * Cette méthode permet d'actualiser le tableau de scores de la poule
     */
    public void refreshScores() {
        int[][] tableau_scores = new int[nbr_equipes][7];

        for (int i = 0; i < nbr_equipes; i++) {
            tableau_scores[i][0] = liste_equipes.get(i).getId_equipe();
        }

        for (int i = 0; i < getOrdre_matches().size(); i++) {
            Match match = getOrdre_matches().get(i);
            if (match.getEtat().equals("fini")) {
                ArrayList<Equipe> equipes = match.getEquipes();
                Equipe e1 = match.getEquipes().get(0);
                Equipe e2 = match.getEquipes().get(1);
                int id1 = getPositionEquipe(e1);
                int id2 = getPositionEquipe(e2);

                tableau_scores[id1][5] += 1;
                tableau_scores[id2][5] += 1;

                int[] score = getOrdre_matches().get(i).getScore();
                if (score[0] == score[1]) {

                    tableau_scores[id1][3] += 1;
                    tableau_scores[id2][3] += 1;
                    tableau_scores[id1][1] += getPoints_pour_nul();
                    tableau_scores[id2][1] += getPoints_pour_nul();
                } else if (score[0] > score[1]) {

                    tableau_scores[id1][2] += 1;
                    tableau_scores[id2][4] += 1;
                    tableau_scores[id1][1] += getPoints_pour_victoire();
                } else {

                    tableau_scores[id1][4] += 1;
                    tableau_scores[id2][2] += 1;
                    tableau_scores[id2][1] += getPoints_pour_victoire();
                }

                tableau_scores[id1][6] += score[0];
                tableau_scores[id1][6] -= score[1];
                tableau_scores[id2][6] += score[1];
                tableau_scores[id2][6] -= score[0];
            }
        }
        this.tableau_scores = tableau_scores;
    }

    /**
     * Getter permettant d'obtenir le tableau des scores de la poule
     *
     * @return int[][]
     */
    public int[][] getTableau_scores() {
        return this.tableau_scores;
    }

    /**
     * Cette méthode permet de désigner le ou les équipes vainqueures de la poule.
     *
     * @param nbr_vainqueurs Nombre de vainqueurs souhaités dans la poule
     * @return ArrayList<Equipe>
     */
    public ArrayList<Equipe> vainqueurs(int nbr_vainqueurs) {

        refreshScores();
        int[][] tab = getTableau_scores();
        ArrayList<Integer> positions_a_trier = new ArrayList<>();
        ArrayList<Equipe> classement_final = new ArrayList<>();
        for (int i = 0; i < nbr_equipes; i++) {
            positions_a_trier.add(i);
        }
        ArrayList<Integer> classement_int = departager(positions_a_trier, "points");
        for (int i = 0; i < nbr_vainqueurs; i++) {
            for (int j = 0; j < nbr_equipes; j++) {
                if (tab[i][0] == liste_equipes.get(j).getId_equipe()) {
                    classement_final.add(liste_equipes.get(j));
                }
            }
        }
        return classement_final;
    }

    /**
     * Fonction permettant de départager deux équipes ex_aequo en termes de points, en fonction de leur nombre de
     * victoires, puis de défaites, puis en fonction de leur Goal Average, puis en fonction de leur ID.
     *
     * @param positions_a_trier Place des équipes à trier au sein du tableau de scores
     * @return ArrayList
     */
    public ArrayList<Integer> departager(ArrayList<Integer> positions_a_trier, String critere) {

        ArrayList<Integer> classement = new ArrayList<>();
        int[][] tab = getTableau_scores();
        int nbr_a_trier = positions_a_trier.size();

        switch (critere) {

            case "points":
                while (classement.size() < nbr_a_trier) {

                    int points_min = tab[0][1];
                    for (int i = 1; i < nbr_equipes; i++) {
                        if (tab[i][1] < points_min) {
                            points_min = tab[i][1];
                        }
                    }

                    int nbr_ex_aequo = 0;
                    ArrayList<Integer> positions_ex_aequo = new ArrayList<>();
                    for (int i = 1; i < nbr_equipes; i++) {
                        if (points_min == tab[i][1]) {
                            nbr_ex_aequo += 1;
                            positions_ex_aequo.add(i);
                        }
                    }

                    if (nbr_ex_aequo == 1) {
                        classement.add(0, positions_ex_aequo.get(0));
                    } else {
                        classement.addAll(0, departager(positions_ex_aequo, "victoires"));
                    }
                    for (int elt : positions_ex_aequo) {
                        positions_a_trier.remove(elt);
                    }
                }

            case "victoires":
                while (classement.size() < nbr_a_trier) {

                    int victoires_min = tab[0][2];
                    for (int i = 1; i < nbr_equipes; i++) {
                        if (tab[i][2] < victoires_min) {
                            victoires_min = tab[i][2];
                        }
                    }

                    int nbr_ex_aequo = 0;
                    ArrayList<Integer> positions_ex_aequo = new ArrayList<>();
                    for (int i = 1; i < nbr_equipes; i++) {
                        if (victoires_min == tab[i][2]) {
                            nbr_ex_aequo += 1;
                            positions_ex_aequo.add(i);
                        }
                    }

                    if (nbr_ex_aequo == 1) {
                        classement.add(0, positions_ex_aequo.get(0));
                    } else {
                        classement.addAll(0, departager(positions_ex_aequo, "defaites"));
                    }
                    for (int elt : positions_ex_aequo) {
                        positions_a_trier.remove(elt);
                    }
                }

            case "defaites":
                while (classement.size() < nbr_a_trier) {

                    int defaites_max = tab[0][4];
                    for (int i = 1; i < nbr_equipes; i++) {
                        if (tab[i][4] > defaites_max) {
                            defaites_max = tab[i][4];
                        }
                    }

                    int nbr_ex_aequo = 0;
                    ArrayList<Integer> positions_ex_aequo = new ArrayList<>();
                    for (int i = 1; i < nbr_equipes; i++) {
                        if (defaites_max == tab[i][4]) {
                            nbr_ex_aequo += 1;
                            positions_ex_aequo.add(i);
                        }
                    }

                    if (nbr_ex_aequo == 1) {
                        classement.add(0, positions_ex_aequo.get(0));
                    } else {
                        classement.addAll(0, departager(positions_ex_aequo, "goal_average"));
                    }
                    for (int elt : positions_ex_aequo) {
                        positions_a_trier.remove(elt);
                    }
                }

            case "goal_average":
                while (classement.size() < nbr_a_trier) {

                    int goal_average_min = tab[0][6];
                    for (int i = 1; i < nbr_equipes; i++) {
                        if (tab[i][6] < goal_average_min) {
                            goal_average_min = tab[i][6];
                        }
                    }

                    int nbr_ex_aequo = 0;
                    ArrayList<Integer> positions_ex_aequo = new ArrayList<>();
                    for (int i = 1; i < nbr_equipes; i++) {
                        if (goal_average_min == tab[i][6]) {
                            nbr_ex_aequo += 1;
                            positions_ex_aequo.add(i);
                        }
                    }

                    if (nbr_ex_aequo == 1) {
                        classement.add(0, positions_ex_aequo.get(0));
                    } else {
                        classement.addAll(0, departager(positions_ex_aequo, "id"));
                    }
                    for (int elt : positions_ex_aequo) {
                        positions_a_trier.remove(elt);
                    }
                }

            case "id":
                while (classement.size() < nbr_a_trier) {

                    int id_max = tab[0][0];
                    int pos = 0;
                    for (int i = 1; i < nbr_equipes; i++) {
                        if (tab[i][0] > id_max) {
                            id_max = tab[i][0];
                            pos = i;
                        }
                    }
                    classement.add(0, pos);
                }
        }
        return classement;
    }
}