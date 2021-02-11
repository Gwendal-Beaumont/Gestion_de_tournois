import java.util.ArrayList;

public class Tournoi {

    /**
     * Classe définissant les principaux paramètres du tournoi.
     */
    //Attributs
    private ArrayList<Match> listeMatches;
    private ArrayList<Equipe> listeEquipes;
    private String nomTournoi;
    static private int idTournoi = 0;
    private int idSport;
    private String typeTournoi;

    //Constructeur
    public Tournoi() {
        this.idTournoi++;
    }

    //Méthodes

    /**
     * Setter permettant de définir la liste de matches du tournoi.
     * @param matches
     */
    public void setMatches(ArrayList<Match> matches) {
        this.listeMatches = matches;
    }

    /**
     * Getter permettant de récupérer la liste des matches du tournoi.
     * @return ArrayList
     */
    public ArrayList getMatches() {
        return listeMatches;
    }

    /**
     * Setter permettant de définir la liste des équipes du tournoi.
     * @param equipes
     */
    public void setEquipes(ArrayList<Equipe> equipes) {
        this.listeEquipes = equipes;
    }

    /**
     * Getter permettant de récupérer la liste des équipes du tournoi.
     * @return ArrayList
     */
    public ArrayList getEquipes() {
        return listeEquipes;
    }

    /**
     * Setter permettant de définir le nom du tournoi.
     * @param nom
     */
    public void setNomTournoi(String nom) {
        this.nomTournoi = nom;
    }

    /**
     * Getter permettant de récupérer le nom du tournoi.
     * @return String
     */
    public String getNomTournoi() {
        return nomTournoi;
    }


}
