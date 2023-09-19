package com.intiFormation.service;

import java.util.List;

import com.intiFormation.dao.IcommentaireDao;
import com.intiFormation.entity.Commentaire;

public class commentaireService implements IcommentaireService {

	IcommentaireDao dao;
	
	@Override
	public Commentaire ajouterCommentaire(Commentaire commentaire) {


		return dao.save(commentaire);
	}

	@Override
	public List<Commentaire> afficherAllCommentaire() {


		return dao.findAll();
	}

	@Override
	public Commentaire afficherCommentaireById(int id) {
		
		return dao.getById(id);
	}

	@Override
	public void supprimerCommentaire(int id) {
		dao.deleteById(id);

	}

}
