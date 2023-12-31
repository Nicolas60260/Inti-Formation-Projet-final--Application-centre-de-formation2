package com.intiFormation.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity

public class Prospect extends Personne {

	private String statut;
	@OneToMany(mappedBy = "prospect", cascade = CascadeType.REMOVE)
	@JsonIgnore
	private List<Appel> appels;
	@OneToMany(mappedBy = "prospect", cascade = CascadeType.REMOVE)
	@JsonIgnore
	private List<Commentaire> commentaires;
	public Prospect(int id, String mail, String nom, String prenom, String telephone, String statut, List<Appel> appels,
			List<Commentaire> commentaires) {
		super(id, mail, nom, prenom, telephone);
		this.statut = statut;
		this.appels = appels;
		this.commentaires = commentaires;
	}
	public Prospect() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Prospect(int id, String mail, String nom, String prenom, String telephone) {
		super(id, mail, nom, prenom, telephone);
		// TODO Auto-generated constructor stub
	}
	public String getStatut() {
		return statut;
	}
	public void setStatut(String statut) {
		this.statut = statut;
	}
	public List<Appel> getAppels() {
		return appels;
	}
	public void setAppels(List<Appel> appels) {
		this.appels = appels;
	}
	public List<Commentaire> getCommentaires() {
		return commentaires;
	}
	public void setCommentaires(List<Commentaire> commentaires) {
		this.commentaires = commentaires;
	}

	@Override
	public String toString() {
		return "Prospect [statut=" + statut + ", appels=" + appels + ", commentaires=" + commentaires + "]";

	}



	


}
