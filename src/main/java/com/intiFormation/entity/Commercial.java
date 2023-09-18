package com.intiFormation.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
@Entity
public class Commercial extends Utilisateur{
//Commentaire
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@OneToMany(mappedBy="commercial")
	private List<Appel> appels;
	
	@OneToMany(mappedBy="commercial")
	private List<Commentaire> commentaires;
	
	
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
	public List<Appel> getAppels() {
		return appels;
	}
	public void setAppels(List<Appel> appels) {
		this.appels = appels;
	}
	public Commercial(int id, String mail, String nom, String prenom, Long telephone, int id2, String username,
			String password, Role role, int id3, List<Appel> appels) {
		super(id, mail, nom, prenom, telephone, id2, username, password, role);
		id = id3;
		this.appels = appels;
	}
	public Commercial() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Commercial(int id, String mail, String nom, String prenom, Long telephone, int id2, String username,
			String password, Role role) {
		super(id, mail, nom, prenom, telephone, id2, username, password, role);
		// TODO Auto-generated constructor stub
	}
	public Commercial(int id, String mail, String nom, String prenom, Long telephone) {
		super(id, mail, nom, prenom, telephone);
		// TODO Auto-generated constructor stub
	}
	public Commercial(int id, String mail, String nom, String prenom, Long telephone, int id2, String username,
			String password, Role role, int id3, List<Appel> appels, List<Commentaire> commentaires) {
		super(id, mail, nom, prenom, telephone, id2, username, password, role);
		id = id3;
		this.appels = appels;
		this.commentaires = commentaires;
	}
	
	
}
