package com.intiFormation.entity;

import java.util.List;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
@Entity
public class Formateur extends Utilisateur{
	@OneToMany(mappedBy="formateur")
	private List<Formation> formations;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public List<Formation> getFormations() {
		return formations;
	}
	public void setFormations(List<Formation> formations) {
		this.formations = formations;
	}
	public Formateur(int id, String mail, String nom, String prenom, Long telephone, int id2, String username,
			String password, Role role, int id3, List<Formation> formations) {
		super(id, mail, nom, prenom, telephone, id2, username, password, role);
		id = id3;
		this.formations = formations;
	}
	public Formateur() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Formateur(int id, String mail, String nom, String prenom, Long telephone, int id2, String username,
			String password, Role role) {
		super(id, mail, nom, prenom, telephone, id2, username, password, role);
		// TODO Auto-generated constructor stub
	}
	public Formateur(int id, String mail, String nom, String prenom, Long telephone) {
		super(id, mail, nom, prenom, telephone);
		// TODO Auto-generated constructor stub
	}
	

}
