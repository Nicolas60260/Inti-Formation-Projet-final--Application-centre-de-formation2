package com.intiFormation.service;

import java.util.List;

import com.intiFormation.entity.Appel;
import com.intiFormation.entity.Commentaire;

public interface IcommentaireService {

public Commentaire ajouterCommentaire(Commentaire commentaire);
	
	public List<Commentaire> afficherAllCommentaire();
	
	public Commentaire afficherCommentaireById(int id);
	
	public void supprimerCommentaire(int id);
	
	public Commentaire findByAppel(Appel appel);
}
