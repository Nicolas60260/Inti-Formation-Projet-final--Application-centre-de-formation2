package com.intiFormation.entity;

import java.util.List;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity

public class Formateur extends Utilisateur {

	@OneToMany(mappedBy = "formateur")
	@JsonIgnore
	private List<Formation> formations;

<<<<<<< HEAD
=======
	public Formateur(int id, String mail, String nom, String prenom, Long telephone, String username, String password,
			Role role, List<Formation> formations) {
		super(id, mail, nom, prenom, telephone, username, password, role);

		this.formations = formations;
	}

	public Formateur() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Formateur(int id, String mail, String nom, String prenom, Long telephone, String username, String password,
			Role role) {
		super(id, mail, nom, prenom, telephone, username, password, role);
		// TODO Auto-generated constructor stub
	}


	public Formateur(int id, String mail, String nom, String prenom, Long telephone) {
		super(id, mail, nom, prenom, telephone);
		// TODO Auto-generated constructor stub
	}

>>>>>>> main
	public List<Formation> getFormations() {
		return formations;
	}

	public void setFormations(List<Formation> formations) {
		this.formations = formations;
	}

	public Formateur() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Formateur(int id, String mail, String nom, String prenom, Long telephone) {
		super(id, mail, nom, prenom, telephone);
		// TODO Auto-generated constructor stub
	}

	public Formateur(List<Formation> formations) {
		super();
		this.formations = formations;
	}

	@Override
	public String toString() {
		return "Formateur [formations=" + formations + "]";
	}


	
	
	
	
	

}
