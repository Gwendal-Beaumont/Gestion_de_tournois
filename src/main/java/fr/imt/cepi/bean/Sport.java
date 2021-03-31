package fr.imt.cepi.bean;

public class Sport {
    private int id;
    private String nom;
    private String url;

    public Sport(int id, String nom, String url) {
        this.id = id;
        this.nom = nom;
        this.url = url;
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

    public String getUrl() {return url;}
}
