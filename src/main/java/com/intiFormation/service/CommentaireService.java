package com.intiFormation.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.intiFormation.dao.IcommentaireDao;
import com.intiFormation.entity.Appel;
import com.intiFormation.entity.Commentaire;
import com.intiFormation.entity.Prospect;

@Service
public class CommentaireService implements IcommentaireService {

@Autowired
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
		
		return dao.findById(id).get();
	}

	@Override
	public void supprimerCommentaire(int id) {
		dao.deleteById(id);

	}

	@Override
	public Commentaire findByAppel(Appel appel) {
		return dao.findByAppel(appel);
	}

	@Override
	public List<Commentaire> findByProspect(Prospect prospect) {
		return dao.findByProspect(prospect);
	}

}
