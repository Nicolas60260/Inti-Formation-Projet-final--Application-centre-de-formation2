package com.intiFormation.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class Paiement {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Temporal(TemporalType.TIMESTAMP)
	private Date date;
	private String mode;
	private int montant;
	private boolean valide;

	
	@ManyToOne
	@JoinColumn(name = "idparticipant")
	@JsonBackReference // en post va prendre les donnée JSON en get va les ignorer
	private Participant participant;
	


	public Paiement(int id, Date date, String mode, int montant, Participant participant) {
		super();
		this.id = id;
		this.date = date;
		this.mode = mode;
		this.montant = montant;
		this.participant = participant;
	}
	
	
	public Paiement(int id, Date date, String mode, boolean valide, Participant participant) {
		super();
		this.id = id;
		this.date = date;
		this.mode = mode;
		this.valide = valide;
		this.participant = participant;
	}


	public int getMontant() {
		return montant;
	}

	public void setMontant(int montant) {
		this.montant = montant;
	}

	public Paiement() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getMode() {
		return mode;
	}

	public void setMode(String mode) {
		this.mode = mode;
	}

	public Participant getParticipant() {
		return participant;
	}

	public void setParticipant(Participant participant) {
		this.participant = participant;
	}

	public boolean isValide() {
		return valide;
	}

	public void setValide(boolean valide) {
		this.valide = valide;
	}

	@Override
	public String toString() {
		return "Paiement [id=" + id + ", date=" + date + ", mode=" + mode + ", valide=" + valide + ", participant="
				+ participant + "]";
	}

}
