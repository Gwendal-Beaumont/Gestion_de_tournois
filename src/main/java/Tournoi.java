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
    private ArrayList<Match> liste_matches;
    private int id_sport;
    private Boolean visibility;
    private LocalDate date;
    private int proprietaire;
    private int etat; //0 inscriptions ouvertes / 1 inscriptions fermees / 2 tournoi démarré

    // Constructeur
    public Tournoi(int id, String nom_tournoi, ArrayList<Equipe> liste_equipes, int id_sport, Boolean visibility, LocalDate date, int proprietaire, int etat){
        this.id = id;
        this.nom_tournoi = nom_tournoi;
        this.liste_equipes = liste_equipes;
        liste_matches = new ArrayList<Match>();
        this.id_sport = id_sport;
        this.visibility = visibility;
        this.date = date;
        this.proprietaire = proprietaire;
        this.etat = etat;
    }

    //Méthodes

    /**
     * Setter permettant de définir la liste de matches du tournoi.
     *
     * @param matches
     */
    public void setMatches(ArrayList<Match> matches) {
        this.liste_matches = matches;
    }

    /**
     * Getter permettant de récupérer la liste des matches du tournoi.
     *
     * @return ArrayList
     */
    public ArrayList getMatches() {
        return liste_matches;
    }

    /**
     * Setter permettant de définir la liste des équipes du tournoi.
     *
     * @param equipes
     */
    public void setEquipes(ArrayList<Equipe> equipes) {
        this.liste_equipes = equipes;
    }

    /**
     * Getter permettant de récupérer la liste des équipes du tournoi.
     *
     * @return ArrayList
     */
    public ArrayList getEquipes() {
        return liste_equipes;
    }

    /**
     * Setter permettant de définir le nom du tournoi.
     *
     * @param nom
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
     * Méthode permettant de fermer les inscriptions
     */
    public void fermerInscriptions(){
        this.etat = 1;
    }

    /**
     * Méthode permettant d'ouvrir les inscriptions
     */
    public void ouvrirInscriptions(){
        this.etat = 0;
    }

    /**
     * Méthode permettant de changer l'état des inscriptions si le tournoi n'a pas encore démarré
     */
    public void changerEtat() {
        if (this.etat < 2){ //on verifie que le tournoi n'ait pas déjà démarré le tournoi
            if (this.etat ==0){ //si les inscriptions sont ouvertes, on les ferme
                this.etat = 1;
            } else {            //sinon on les ouvre
                this.etat = 0;
            }
        } else {
            //afficher que le tournoi a déjà démarré et qu'on ne peut pas ouvrir les inscriptions
        }
    }

    /**
     * Méthode qui permet de changer l'état du tournoi pour le démarrer (qu'il soit ouvert ou fermé)
     */
    public void demarrerTournoi(){
        this.etat = 2;
    }

}
