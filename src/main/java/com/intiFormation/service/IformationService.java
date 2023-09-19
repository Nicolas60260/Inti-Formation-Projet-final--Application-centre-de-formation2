package com.intiFormation.service;

import java.util.List;
import java.util.Optional;

import com.intiFormation.entity.Formation;

public interface IformationService {
	public Formation ajouter(Formation formation);
	public void supprimer(int id);
	public Optional<Formation> selectById(int id);
	public List<Formation> selectAll();
}
