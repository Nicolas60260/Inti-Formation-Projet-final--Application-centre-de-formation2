package com.intiFormation.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.intiFormation.entity.Commentaire;

@Service
public interface IcommentaireService {

public Commentaire ajouterCommentaire(Commentaire commentaire);
	
	public List<Commentaire> afficherAllCommentaire();
	
	public Commentaire afficherCommentaireById(int id);
	
	public void supprimerCommentaire(int id);
}
