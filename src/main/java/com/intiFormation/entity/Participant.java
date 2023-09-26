package com.intiFormation.entity;

import java.util.*;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class Participant extends Utilisateur {

	private double sommeDue;

	@ManyToMany 
	@JoinTable(name = "Participant_Formation", joinColumns = @JoinColumn(name = "idparticipant"), inverseJoinColumns = @JoinColumn(name = "idformation"))
	private Set<Formation> formations;
	
	@OneToMany(mappedBy = "participant")
	@JsonManagedReference // en get va retourner les paiements, en post va les ignorer
	private List<Paiement> paiements;

	public double getSommeDue() {
		return sommeDue;
	}

	public void setSommeDue(double sommeDue) {
		this.sommeDue = sommeDue;
	}

	public Set<Formation> getFormations() {
		return formations;
	}

	public void setFormations(Set<Formation> formations) {
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

	public Participant(double sommeDue, Set<Formation> formations, List<Paiement> paiements) {
		super();
		this.sommeDue = sommeDue;
		this.formations = formations;
		this.paiements = paiements;
	}

	@Override
	public String toString() {

		return "Participant [sommeDue=" + sommeDue + ", formations=" + formations + ", paiements=" + paiements + "]";

	}

	
	
	
	
}
