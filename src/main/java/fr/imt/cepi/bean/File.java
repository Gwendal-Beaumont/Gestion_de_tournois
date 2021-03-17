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

    //Constructeur
    public File(int id_tournoi, ArrayList<Equipe> liste_participants) {
        this.id_tournoi = id_tournoi;
        this.liste_participants = liste_participants;
        this.nbr_participants = liste_participants.size();
    }

    //Méthodes

    /**
     * Getter permettant d'obtenir l'id du tournoi.
     * @return int
     */
    public int getId_tournoi() {
        return this.id_tournoi;
    }

    public void creation() {
        ArrayList<Match> ordre_passage = new ArrayList<>();
        for(Equipe elt : liste_participants) {
            ArrayList<Equipe> equipe = new ArrayList<>();
            equipe.add(elt);
            ordre_passage.add(new Match(getId_tournoi(), equipe));
        }
        Collections.shuffle(ordre_passage);
        this.ordre_passage = ordre_passage;
    }

    public ArrayList<Match> getOrdre_passage() {
        return this.ordre_passage;
    }
}
