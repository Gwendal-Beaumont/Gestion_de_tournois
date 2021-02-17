package fr.imt.cepi.bean;

import java.io.Serializable;

public class Utilisateur implements Serializable {

	private static final long serialVersionUID = 6297385302078200511L;

	private int id;
	private final String nom;
	private final String login;
	private int role_general = 0;

	public Utilisateur(String nom, String login, int id) {
		this.nom = nom;
		this.login = login;
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public void setId(int pId) {
		id = pId;
	}

	public String getNom() {
		return nom;
	}

	public String getLogin() {
		return login;
	}

	@Override
	public String toString() {
		return "Utilisateur [id=" + id + ", nom=" + nom + ", login=" + login + "]";
	}

	public void setRole_general(int nouveauRole) { this.role_general = nouveauRole; }

}
