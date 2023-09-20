package com.intiFormation.entity;

import java.util.List;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Commercial extends Utilisateur{

	@OneToMany(mappedBy="commercial")
	private List<Appel> appels;
	
	@OneToMany(mappedBy="commercial")
	private List<Commentaire> commentaires;

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

	public Commercial() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Commercial(int id, String mail, String nom, String prenom, String telephone) {
		super(id, mail, nom, prenom, telephone);
		// TODO Auto-generated constructor stub
	}

	public Commercial(List<Appel> appels, List<Commentaire> commentaires) {
		super();
		this.appels = appels;
		this.commentaires = commentaires;
	}

	@Override
	public String toString() {
		return "Commercial [appels=" + appels + ", commentaires=" + commentaires + "]";
	}

	
	
	
	
	
	
}
