package com.intiFormation.entity;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Personne {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	private int id;
	private String mail;
	private String nom;
	private String prenom;
	private String telephone;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public Personne(int id, String mail, String nom, String prenom, String telephone) {
		super();
		this.id = id;
		this.mail = mail;
		this.nom = nom;
		this.prenom = prenom;
		this.telephone = telephone;
	}
	
	
	public Personne(String mail, String nom, String prenom, String telephone) {
		super();
		this.mail = mail;
		this.nom = nom;
		this.prenom = prenom;
		this.telephone = telephone;
	}
	public Personne() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
}
