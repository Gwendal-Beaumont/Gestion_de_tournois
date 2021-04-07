package fr.imt.cepi.bean;

import fr.imt.cepi.servlet.listeners.AppContextListener;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
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
    private Sport sport;
    private int nbEquipes;
    private int nbPlayersByTeam;
    private ArrayList<Utilisateur> listeJoueur = new ArrayList<Utilisateur>();
    private Boolean visibility;
    private LocalDateTime date;
    private int proprietaire;
    private int etat; //0 inscriptions ouvertes / 1 inscriptions fermees / 2 tournoi en cours / 3 Tournoi terminé

    // Constructeur
    public Tournoi(int id, String nom_tournoi, ArrayList<Equipe> liste_equipes, int nbEquipes, int nbPlayersByTeam, Sport sport, Boolean visibility, LocalDateTime date, int proprietaire, int etat) {
        this.id = id;
        this.nom_tournoi = nom_tournoi;
        this.liste_equipes = liste_equipes;
        this.ordre_matches = new ArrayList<>();
        this.sport = sport;
        this.visibility = visibility;
        this.date = date;
        this.proprietaire = proprietaire;
        this.etat = etat;
    }

    public Tournoi(int id, String nom_tournoi, ArrayList<Equipe> liste_equipes, Sport sport, Boolean visibility, LocalDateTime date, int proprietaire, int etat) {
        this.id = id;
        this.nom_tournoi = nom_tournoi;
        this.liste_equipes = liste_equipes;

        this.sport = sport;
        this.visibility = visibility;
        this.date = date;
        this.proprietaire = proprietaire;
        this.etat = etat;
    }

    public Tournoi(int id, String nom_tournoi, ArrayList<Equipe> liste_equipes, ArrayList<Match> ordre_matches, Sport sport, int nbEquipes, int nbPlayersByTeam, Boolean visibility, LocalDateTime date, int proprietaire, int etat) {
        this.id = id;
        this.nom_tournoi = nom_tournoi;
        this.liste_equipes = liste_equipes;
        this.ordre_matches = ordre_matches;
        this.sport = sport;
        this.nbEquipes = nbEquipes;
        this.nbPlayersByTeam = nbPlayersByTeam;
        this.visibility = visibility;
        this.date = date;
        this.proprietaire = proprietaire;
        this.etat = etat;
    }

    public Tournoi(int id, String nom_tournoi, ArrayList<Equipe> liste_equipes, Sport sport, Boolean visibility, LocalDateTime date, int proprietaire, int etat, int nbPlayersByTeam, int nbEquipes) {
        this.id = id;
        this.nom_tournoi = nom_tournoi;
        this.liste_equipes = liste_equipes;

        this.sport = sport;
        this.nbEquipes = nbEquipes;
        this.nbPlayersByTeam = nbPlayersByTeam;

        this.visibility = visibility;
        this.date = date;
        this.proprietaire = proprietaire;
        this.etat = etat;
    }
    //Méthodes

    /**
     * Setter permettant de définir la liste de matches du tournoi.
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
     * Getter permettant de récupérer le sport du tournoi
     *
     * @return int id du sport
     */
    public Sport getSport() {
        return sport;
    }


    /**
     * Getter permettant de récupérer l'état du tournoi
     *
     * @return String etat tournoi
     */
    public String getEtat() {
        switch (etat) {
            case 0:
                return "Inscriptions en cours";
            case 1:
                return "Inscriptions fermées";
            case 2:
                return "Tournoi en cours";
            case 3:
                return "Tournoi terminé";
            default:
                return "Etat invalide";
        }
    }

    /**
     * Getter permettant de récupérer l'état du tournoi pour la page HTML
     *
     * @return String etat tournoi
     */
    public String getEtatJSP() {
        switch (etat) {
            case 0:
                return "Inscriptions en cours";
            case 1:
                return "Inscriptions ferm&eacute;es";
            case 2:
                return "Tournoi en cours";
            case 3:
                return "Tournoi termin&eacute;";
            default:
                return "&Eacute;tat invalide";
        }
    }

    @Override
    public String toString() {
        return "Tournoi{" +
                "id=" + id +
                ", nom_tournoi='" + nom_tournoi + '\'' +
                ", liste_equipes=" + liste_equipes +
                ", ordre_matches=" + ordre_matches +
                ", sport=" + sport +
                ", visibility=" + visibility +
                ", date=" + DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss").format(date) +
                ", proprietaire=" + proprietaire +
                "} \n";
    }

    /**
     * Méthode permettant de fermer les inscriptions
     */
    public void fermerInscriptions() {
        this.etat = 1;
    }

    public void addUtilisateur() {

    }

    /**
     * Méthode permettant d'ouvrir les inscriptions
     */
    public void ouvrirInscriptions() {
        this.etat = 0;
    }

    /**
     * Méthode permettant de changer l'état des inscriptions si le tournoi n'a pas encore démarré
     */
    public void changerEtat() {
        if (this.etat < 2) { //on verifie que le tournoi n'ait pas déjà démarré le tournoi
            if (this.etat == 0) { //si les inscriptions sont ouvertes, on les ferme
                this.etat = 1;
            } else {            //sinon on les ouvre
                this.etat = 0;
            }
        } else {
            this.etat = 2;
            //afficher que le tournoi a déjà démarré et qu'on ne peut pas ouvrir les inscriptions
        }
    }

    /**
     * Méthode qui permet de changer l'état du tournoi pour le démarrer (qu'il soit ouvert ou fermé)
     */
    public void demarrerTournoi() {
        this.etat = 2;
    }


    /**
     * Getter permettant de récupérer l'id du tournoi
     *
     * @return int id du tournoi
     */
    public int getId() {
        return id;
    }

    public Boolean getVisibility() {
        return visibility;
    }

    public String getDate() {
        return date.toString().replace('T', ' ');
    }

    public void creeEquipe() {

        if (etat == 1) {
            //On récupère la liste des utilisateurs du tournoi

            try (Connection con = AppContextListener.getConnection(); PreparedStatement ps = con.prepareStatement(
                    "SELECT tst.utilisateur.username, tst.utilisateur.email, tst.utilisateur.id FROM tst.utilisateur_tournoi JOIN tst.utilisateur ON tst.utilisateur_tournoi.id_utilisateur= tst.utilisateur.id WHERE tst.utilisateur_tournoi.id_tournoi=" + id)) {
                ResultSet rs;
                rs = ps.executeQuery();
                while (rs.next()) {
                    listeJoueur.add(new Utilisateur(
                            rs.getString(1),
                            rs.getString(2),
                            rs.getInt(3)
                    ));

                }

                ArrayList<Integer> listeTrie = new ArrayList<Integer>();
                ArrayList<Integer> listeRandom = new ArrayList<Integer>();

                for (int i = 0; i < listeJoueur.size(); i++) {
                    listeTrie.add(i);

                }
                int indiceRandom = 0;

                for (int i = 0; i < listeJoueur.size(); i++) {
                    indiceRandom = (int) (Math.random() * listeTrie.size());
                    listeRandom.add(listeTrie.get(indiceRandom));
                    listeTrie.remove(indiceRandom);

                }
                int k = 0;

                for (int i = 0; i < nbEquipes; i++) {

                    liste_equipes.add(new Equipe(
                            "Equipe " + String.valueOf(i),
                            id
                    ));
                    for (int j = 0; j < nbPlayersByTeam; j++) {

                        liste_equipes.get(i).ajouterJoueur(listeJoueur.get(listeRandom.get(k)));
                        k++;
                    }

                }
                //On ajoute les équipes à la base de données.
                for (Equipe eq : liste_equipes) {
                    eq.updateBDD();

                }

            } catch (Exception e) {
                e.printStackTrace();

            }
        } else {

        }
    }

}
