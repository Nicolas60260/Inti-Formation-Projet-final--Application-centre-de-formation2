package com.intiFormation.entity;

import java.util.*;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Formation {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String nom;
	@Temporal(TemporalType.DATE)//TIMESTAMP si on veut les minutes, secondes, etc..
	private Date dateDebut;
	@Temporal(TemporalType.DATE)
	private Date dateFin;
	private double prix;

	@ManyToOne
	@JoinColumn(name = "idformateur")
	private Formateur formateur;

	@ManyToMany (mappedBy = "formations")
	@JsonIgnore
	private List<Participant> participants;
	
	@ManyToMany
	@JoinTable(name = "Formation_Cours", joinColumns = @JoinColumn(name = "idformation"), inverseJoinColumns = @JoinColumn(name = "idcours"))
	private Set <Cours> cours;

	public Formation(int id, String nom, Date dateDebut, Date dateFin, double prix, Formateur formateur,
			List<Participant> participants, Set<Cours> cours) {
		super();
		this.id = id;
		this.nom = nom;
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
		this.prix = prix;
		this.formateur = formateur;
		this.participants = participants;
		this.cours = cours;
	}

	public Formation() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Formateur getFormateur() {
		return formateur;
	}

	public void setFormateur(Formateur formateur) {
		this.formateur = formateur;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Date getDateDebut() {
		return dateDebut;
	}

	public void setDateDebut(Date dateDebut) {
		this.dateDebut = dateDebut;
	}

	public Date getDateFin() {
		return dateFin;
	}

	public void setDateFin(Date dateFin) {
		this.dateFin = dateFin;
	}

	public double getPrix() {
		return prix;
	}

	public void setPrix(double prix) {
		this.prix = prix;
	}

	public List<Participant> getParticipants() {
		return participants;
	}

	public void setParticipants(List<Participant> participants) {
		this.participants = participants;
	}

	public Set<Cours> getCours() {
		return cours;
	}

	public void setCours(Set<Cours> cours) {
		this.cours = cours;
	}

	@Override
	public String toString() {
		return "Formation [id=" + id + ", nom=" + nom + ", dateDebut=" + dateDebut + ", dateFin=" + dateFin + ", prix="
				+ prix + ", formateur=" + formateur + "]";
	}

}
