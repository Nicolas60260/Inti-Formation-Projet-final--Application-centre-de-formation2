package com.intiFormation.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.intiFormation.entity.Appel;
import com.intiFormation.entity.Commentaire;
import java.util.List;


public interface IcommentaireDao extends JpaRepository<Commentaire, Integer> {
	public Commentaire findByAppel(Appel appel);
}
