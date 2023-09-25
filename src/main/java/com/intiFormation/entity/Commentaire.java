package com.intiFormation.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonBackReference;





// Annotations à compléter


@Entity
public class Commentaire {
	
	
//////////////////////////Attributs inhérents à Commentaire//////////////////////////
	
	
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private int id;
private String texte;
@Temporal(TemporalType.TIMESTAMP)
private Date date;




//////////////////////////Attributs avec liens vers d'autres classes//////////////////////////


@ManyToOne
@JoinColumn(name="idcommercial")

private Commercial commercial;


@OneToOne(mappedBy = "commentaire")
@JsonBackReference
private Appel appel;


@ManyToOne
@JoinColumn(name="idprospect") // Ou listecommentaire peut-être

private Prospect prospect;




///////////////////////////Constructeurs////////////////////////// 


//Constructeur tous paramètres
public Commentaire(int id, String texte, Date date, Commercial commercial, Appel appel, Prospect prospect) {
	super();
	this.id = id;
	this.texte = texte;
	this.date = date;
	this.commercial = commercial;
	this.appel = appel;
	this.prospect = prospect;
}


// Constructeur par défaut
public Commentaire() {
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


public String getTexte() {
	return texte;
}


public void setTexte(String texte) {
	this.texte = texte;
}


public Date getDate() {
	return date;
}


public void setDate(Date date) {
	this.date = date;
}


public Commercial getCommercial() {
	return commercial;
}


public void setCommercial(Commercial commercial) {
	this.commercial = commercial;
}


public Appel getAppel() {
	return appel;
}


public void setAppel(Appel appel) {
	this.appel = appel;
}


public Prospect getProspect() {
	return prospect;
}


public void setProspect(Prospect prospect) {
	this.prospect = prospect;
}




///////////////////////////Methode toString////////////////////////// 


@Override
public String toString() {
	return "Commentaire [id=" + id + ", texte=" + texte + ", date=" + date + ", appel=" + appel + "]";
}
}
