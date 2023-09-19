package com.intiFormation.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

//rere
//comm2
//comm 3
@Entity
public class Role {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String nom;
	@JsonIgnore
	@OneToMany(mappedBy = "role")
	private List<Utilisateur> listeUtilisateur;
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
	public List<Utilisateur> getListeUtilisateur() {
		return listeUtilisateur;
	}
	public void setListeUtilisateur(List<Utilisateur> listeUtilisateur) {
		this.listeUtilisateur = listeUtilisateur;
	}
	public Role(int id, String nom, List<Utilisateur> listeUtilisateur) {
		super();
		this.id = id;
		this.nom = nom;
		this.listeUtilisateur = listeUtilisateur;
	}
	public Role() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Role [id=" + id + ", nom=" + nom + ", listeUtilisateur=" + listeUtilisateur + "]";
	}
	
	
}
