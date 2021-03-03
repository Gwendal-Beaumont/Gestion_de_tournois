package fr.imt.cepi.bean;

import java.io.Serializable;

public class Utilisateur implements Serializable {

	private static final long serialVersionUID = 6297385302078200511L;

	private int id;
	private final String username;
	private final String email;
	private int role_general = 0;

	public Utilisateur(String username, String email, int id) {
		this.username = username;
		this.email = email;
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public void setId(int pId) {
		id = pId;
	}

	public String getUsername() {
		return username;
	}

	public String getEmail() {
		return email;
	}

	@Override
	public String toString() {
		return "Utilisateur [id=" + id + ", username=" + username + ", email=" + email + "]";
	}

	public void setRole_general(int nouveauRole) { this.role_general = nouveauRole; }

}
