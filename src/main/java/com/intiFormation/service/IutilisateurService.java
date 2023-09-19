package com.intiFormation.service;

import java.util.List;
import java.util.Optional;

import com.intiFormation.entity.Utilisateur;

public interface IutilisateurService {
	
	public Utilisateur ajouter(Utilisateur utilisateur);
	public void supprimer(int id);
	public Optional<Utilisateur> selectById(int id);
	public List<Utilisateur> selectAll();
	public Optional<Utilisateur> findByUsername(String username);

}
