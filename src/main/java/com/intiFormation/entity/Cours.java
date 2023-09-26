package com.intiFormation.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Cours {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private long duree;
	private String nom;

	private String fichier;// String ou String?

	@ManyToMany(mappedBy = "cours")
	@JsonIgnore
	private List<Formation> formations;

	public Cours() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Cours(int id, long duree, String nom, String fichier, List<Formation> formations) {
		super();
		this.id = id;
		this.duree = duree;
		this.nom = nom;
		this.fichier = fichier;
		this.formations = formations;
	}
	

	public Cours(int id, long duree, String nom, String fichier) {
		super();
		this.id = id;
		this.duree = duree;
		this.nom = nom;
		this.fichier = fichier;
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public long getDuree() {
		return duree;
	}

	public void setDuree(long duree) {
		this.duree = duree;
	}

	public String getFichier() {
		return fichier;
	}

	public void setFichier(String fichier) {
		this.fichier = fichier;
	}

	public List<Formation> getFormations() {
		return formations;
	}

	public void setFormations(List<Formation> formations) {
		this.formations = formations;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	@Override
	public String toString() {
		return "Cours [id=" + id + ", duree=" + duree + ", nom=" + nom + ", fichier=" + fichier + ", formations="
				+ formations + "]";
	}

}
