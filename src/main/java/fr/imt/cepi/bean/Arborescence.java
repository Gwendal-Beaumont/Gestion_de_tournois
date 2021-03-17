package fr.imt.cepi.bean;

import java.util.ArrayList;
import java.lang.Math;

public class Arborescence {
    //Attributs
    ArrayList<Equipe> listeEquipe = new ArrayList<>();
    ArrayList<ArrayList<Match>> listeMatch = new ArrayList<>();
    int id_tournoi;
    //Constructeurs

    public Arborescence(ArrayList<Equipe> listeEquipe, int id_tournoi) {
        this.listeEquipe = listeEquipe;
        this.id_tournoi = id_tournoi;
    }

    //Methodes
    public void creeArboresence(int nbPlayer) {
        if (Math.floor(Math.log(nbPlayer)) == Math.log(nbPlayer)) {
            double nbEtape = Math.log(nbPlayer);
            for (int i = 0; i < nbEtape; i++) {
                ArrayList<Match> Etape = new ArrayList();
                for (int j = 0; j <= Math.pow(2, nbEtape) - Math.pow(2, i); j++) {
                    Etape.add(new Match(id_tournoi, Integer.parseInt(Integer.toString(j) + Integer.toString(i))));
                }
            }
        } else {
            System.out.println("Le nombre d'équipes n'est pas une puissance de 2");
        }
    }

    public void initialisation() {
        if (listeMatch.isEmpty()) {
            System.out.println("L'arborescence n'as pas était crée");
        } else {
            int i = 0;
            for (Match m : listeMatch.get(0)) {
                m.addEquipe(listeEquipe.get(i++));
                m.addEquipe(listeEquipe.get(i++));
            }
        }
    }

    public void updateArbre() {
        if (listeMatch.isEmpty()) {
            System.out.println("L'arborescence n'a pas été créer");
        } else {
            for (int i = (int) (Math.log(listeEquipe.size()) - 1); i > 0; i--)
                for (int j = 0; j < listeMatch.get(i).size(); j++) {
                    if (listeMatch.get(i).get(j).getEtat() == "Fini") {
                        listeMatch.get(i + 1).get(j / 2).addEquipe(listeMatch.get(i).get(j).getWinner());
                    }
                }
        }
    }

    public void addEquipe(Equipe eq) {
        listeEquipe.add(eq);
    }
    //Setter
}
