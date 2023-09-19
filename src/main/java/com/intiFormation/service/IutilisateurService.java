package com.intiFormation.service;

import java.util.List;

import com.intiFormation.entity.Utilisateur;


public interface IutilisateurService {
	
	public List<Utilisateur> afficherAll();
	
	public Utilisateur afficherParId(int id);
	
	public void ajouter(Utilisateur u);
	
	public void supprimer(int id);
	
	public void modifier(Utilisateur u);
}
