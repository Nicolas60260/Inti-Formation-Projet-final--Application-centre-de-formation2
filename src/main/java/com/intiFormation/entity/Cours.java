package com.intiFormation.entity;

import java.io.File;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Cours {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private long duree;
	private File fichier;

	@ManyToMany(mappedBy = "cours")
	private List<Formation> formations;

	public Cours() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Cours(int id, long duree, File fichier, List<Formation> formations) {
		super();
		this.id = id;
		this.duree = duree;
		this.fichier = fichier;
		this.formations = formations;
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

	public File getFichier() {
		return fichier;
	}

	public void setFichier(File fichier) {
		this.fichier = fichier;
	}

	public List<Formation> getFormations() {
		return formations;
	}

	public void setFormations(List<Formation> formations) {
		this.formations = formations;
	}

	@Override
	public String toString() {
		return "Cours [id=" + id + ", duree=" + duree + ", fichier=" + fichier + "]";
	}

}
