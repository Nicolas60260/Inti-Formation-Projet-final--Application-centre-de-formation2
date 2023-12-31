package com.intiFormation.entity;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonBackReference;




//Annotations à compléter
@Entity
public class Appel {
	
	
	
//////////////////////////Attributs inhérents à Commentaire//////////////////////////
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;
	@Temporal(TemporalType.TIMESTAMP)
	Date debutAppel;
	long duree;
	boolean rdv;
	
//////////////////////////Attributs avec liens à d'autres classes//////////////////////////
	
	
	@ManyToOne
	@JoinColumn(name="idcommercial")
	@JsonBackReference // fait qu'on peut utiliser post mais pas get ! on peut pas get le commercial par juste l'appel mais l'inverse si 
	Commercial commercial; // avec managed reference
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "idcommentaire")
	@JsonManagedReference
	Commentaire commentaire;
	
	//Relations à gérer
	@ManyToOne
	@JoinColumn(name="idprospect")
	Prospect prospect;

	
///////////////////////////Constructeurs////////////////////////// 


//Constructeur tous paramètres
	public Appel(int id, Date debutAppel, long duree, boolean rDV, Commercial commercial, Commentaire commmentaire,
			Prospect prospect) {
		super();
		this.id = id;
		this.debutAppel = debutAppel;
		this.duree = duree;
		rdv = rDV;
		this.commercial = commercial;
		this.commentaire = commmentaire;
		this.prospect = prospect;
	}


	
	
	// Constructeur par défaut
	
	public Appel() {
		super();
		// TODO Auto-generated constructor stub
	}




	
///////////////////////////Getters setters////////////////////////// 

	public int getId() {
		return id;
	}




	public void setId(int id) {
		this.id = id;
	}




	public Date getDebutAppel() {
		return debutAppel;
	}




	public void setDebutAppel(Date debutAppel) {
		this.debutAppel = debutAppel;
	}




	public long getDuree() {
		return duree;
	}




	public void setDuree(long duree) {
		this.duree = duree;
	}




	public boolean isRDV() {
		return rdv;
	}




	public void setRDV(boolean rDV) {
		rdv = rDV;
	}




	public Commercial getCommercial() {
		return commercial;
	}




	public void setCommercial(Commercial commercial) {
		this.commercial = commercial;
	}




	public Commentaire getCommentaire() {
		return commentaire;
	}




	public void setCommentaire(Commentaire commmentaire) {
		this.commentaire = commmentaire;
	}




	public Prospect getProspect() {
		return prospect;
	}




	public void setProspect(Prospect prospect) {
		this.prospect = prospect;
	}


///////////////////////////Méthode toString//////////////////////////

	@Override
	public String toString() {
		return "Appel [id=" + id + ", debutAppel=" + debutAppel + ", duree=" + duree + ", RDV=" + rdv
				 + "]";
	}
	
	
	
}
