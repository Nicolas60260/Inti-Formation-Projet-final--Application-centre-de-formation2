package com.intiFormation.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Prospect extends Personne{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String statut;
	@OneToMany(mappedBy="prospect")
	private List<Appel> appels;
	@OneToMany (mappedBy="prospect")
	private List<Commentaire> commentaires;
	
	
	
	public Prospect(int id, String mail, String nom, String prenom, Long telephone, int id2, String statut,
			List<Appel> appels, List<Commentaire> commentaires) {
		super(id, mail, nom, prenom, telephone);
		id = id2;
		this.statut = statut;
		this.appels = appels;
		this.commentaires = commentaires;
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
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getStatut() {
		return statut;
	}
	public void setStatut(String statut) {
		this.statut = statut;
	}
	public Prospect(int id, String mail, String nom, String prenom, Long telephone, int id2, String statut) {
		super(id, mail, nom, prenom, telephone);
		id = id2;
		this.statut = statut;
	}
	public Prospect() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Prospect(int id, String mail, String nom, String prenom, Long telephone) {
		super(id, mail, nom, prenom, telephone);
		// TODO Auto-generated constructor stub
	}
	
	
	
	
}
