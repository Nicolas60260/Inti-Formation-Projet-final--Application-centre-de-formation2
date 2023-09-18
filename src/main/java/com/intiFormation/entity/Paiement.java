package com.intiFormation.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Paiement {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private Date date;
	private String mode;

	@ManyToOne
	@JoinColumn(name = "idparticipant")
	private Participant participant;

	public Paiement(int id, Date date, String mode, Participant participant) {
		super();
		this.id = id;
		this.date = date;
		this.mode = mode;
		this.participant = participant;
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

	@Override
	public String toString() {
		return "Paiement [id=" + id + ", date=" + date + ", mode=" + mode + ", participant=" + participant + "]";
	}

}
