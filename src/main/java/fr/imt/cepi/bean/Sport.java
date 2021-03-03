package fr.imt.cepi.bean;

public class Sport {
    private int id;
    private String nom;

    public Sport(int id, String nom) {
        this.id = id;
        this.nom = nom;
    }

    @Override
    public String toString() {
        return "Sport : " + nom + ", id : " + id + "\n";
    }

    public int getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }
}
