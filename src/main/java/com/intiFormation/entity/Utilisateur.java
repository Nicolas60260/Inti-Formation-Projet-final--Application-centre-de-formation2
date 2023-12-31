package com.intiFormation.entity;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@Inheritance
public class Utilisateur extends Personne{
	private String username;
	private String password;
	@ManyToOne
	@JoinColumn(name="idrole")
	private Role role;
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}
	public Utilisateur() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Utilisateur(int id, String mail, String nom, String prenom, String telephone) {
		super(id, mail, nom, prenom, telephone);
		// TODO Auto-generated constructor stub
	}
	
	public Utilisateur(String mail, String nom, String prenom, String telephone) {
		super( mail, nom, prenom, telephone);
		
	}
	@Override
	public String toString() {
		return "Utilisateur [username=" + username + ", password=" + password + ", role=" + role + "]";
	}
	
	
	
	
	
	
	
}
