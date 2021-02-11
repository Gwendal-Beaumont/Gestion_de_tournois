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
    private Boolean tournoiPublic;

    //Constructeur
    public Tournoi() {
        this.idTournoi++;
    }

    //Méthodes

    /**
     * Setter permettant de définir la liste de matches du tournoi.
     * @param matches Liste des matches qui ont lieu durant le tournoi
     */
    public void setMatches(ArrayList<Match> matches) {
        this.listeMatches = matches;
    }

    /**
     * Getter permettant de récupérer la liste des matches du tournoi.
     * @return ArrayList
     */
    public ArrayList<Match> getMatches() {
        return listeMatches;
    }

    /**
     * Setter permettant de définir la liste des équipes du tournoi.
     * @param equipes Liste des équipes prenant part au tournoi
     */
    public void setEquipes(ArrayList<Equipe> equipes) {
        this.listeEquipes = equipes;
    }

    /**
     * Getter permettant de récupérer la liste des équipes du tournoi.
     * @return ArrayList
     */
    public ArrayList<Equipe> getEquipes() {
        return listeEquipes;
    }

    /**
     * Setter permettant de définir le nom du tournoi.
     * @param nom Nom du tournoi
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

    /**
     * Getter permettant de récupérer l'identifiant du tournoi.
     * @return int
     */
    public int getIdTournoi() {
        return idTournoi;
    }

    /**
     * Setter permettant de définir le type de sport du tournoi.
     * @param idSport Type de sport désiré
     */
    public void setIdSport(int idSport) {
        this.idSport = idSport;
    }

    /**
     * Getter permettant de récupérer le type de sport du tournoi.
     * @return int
     */
    public int getIdSport() {
        return idSport;
    }

    /**
     * Setter permettant de définir si le tournoi est public ou privé.
     * @param type public (true) ou privé (false)
     */
    public void setTypeTournoi(Boolean type) {
        this.tournoiPublic = type;
    }

    /**
     * Getter permettant de savoir si le tournoi est public (true) ou privé (false).
     * @return Boolean
     */
    public Boolean getTournoiPublic() {
        return tournoiPublic;
    }

}
