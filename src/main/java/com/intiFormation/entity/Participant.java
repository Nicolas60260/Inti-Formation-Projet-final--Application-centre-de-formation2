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



@Entity
public class Participant extends Utilisateur {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private double sommeDue;
	
	@ManyToMany (mappedBy = "participants")
	private List<Formation> formations;
	
	@OneToMany(mappedBy = "participant")
	private List<Paiement> paiements;
	
	
	public Participant() {
		super();
		// TODO Auto-generated constructor stub
	}
	

	public Participant(int id, double sommeDue, List<Formation> formations, List<Paiement> paiements) {
		super();
		this.id = id;
		this.sommeDue = sommeDue;
		this.formations = formations;
		this.paiements = paiements;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}


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


	@Override
	public String toString() {
		return "Participant [id=" + id + ", sommeDue=" + sommeDue + ", formations=" + formations + ", paiements="
				+ paiements + "]";
	}
	
	
}
