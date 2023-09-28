package com.intiFormation.service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import com.intiFormation.entity.Cours;
import com.intiFormation.entity.Formateur;
import com.intiFormation.entity.Formation;

public interface IformationService {
	public Formation ajouter(Formation formation);
	public void supprimer(int id);
	public Optional<Formation> selectById(int id);
	public List<Formation> selectAll();
	public List<Formation> findByCours(Cours cours);
	public List<Formation> findByFormateur(Formateur formateur);

}
