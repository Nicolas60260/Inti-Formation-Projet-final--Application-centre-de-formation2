package com.intiFormation.service;

import java.util.List;
import java.util.Optional;

import com.intiFormation.entity.Appel;
import com.intiFormation.entity.Commentaire;
import com.intiFormation.entity.Commercial;
import com.intiFormation.entity.Prospect;

public interface IappelService {
	
	public Appel ajouterAppel(Appel appel);
	public void supprimerAppel(int id);
	public Appel selectAppelById(int id);
	public List<Appel> selectAllAppels();
	public List<Appel> findByProspect(Prospect prospect);
	public Appel findByCommentaire(Commentaire commentaire);
	
	public List<Appel> findByCommentaireIsNull();
	public List<Appel> findByCommercial(Commercial commercial);




}
