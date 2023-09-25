package com.intiFormation.entity;

import java.util.List;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Participant extends Utilisateur {

	private double sommeDue;

	@ManyToMany (mappedBy = "participants")
	@JsonIgnore
	private List<Formation> formations;
	
	@OneToMany(mappedBy = "participant")
	private List<Paiement> paiements;

	public double getSommeDue() {
		return sommeDue;
	}

	public void setSommeDue(double sommeDue) {
		this.sommeDue = sommeDue;
	}

	public List<Formation> getFormations() {
		return formations;
	}

	public void setFormations(List<Formation> formations) {
		this.formations = formations;
	}

	public List<Paiement> getPaiements() {
		return paiements;
	}

	public void setPaiements(List<Paiement> paiements) {
		this.paiements = paiements;
	}

	public Participant() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Participant(int id, String mail, String nom, String prenom, String telephone) {
		super(id, mail, nom, prenom, telephone);
		// TODO Auto-generated constructor stub
	}

	public Participant(double sommeDue, List<Formation> formations, List<Paiement> paiements) {
		super();
		this.sommeDue = sommeDue;
		this.formations = formations;
		this.paiements = paiements;
	}
	public Participant(Prospect prospect) {
		super(prospect.getMail(),prospect.getNom(),prospect.getPrenom(),prospect.getTelephone());
	}

	@Override
	public String toString() {

		return "Participant [sommeDue=" + sommeDue + ", formations=" + formations + ", paiements=" + paiements + "]";

	}

	
	
	
	
}
