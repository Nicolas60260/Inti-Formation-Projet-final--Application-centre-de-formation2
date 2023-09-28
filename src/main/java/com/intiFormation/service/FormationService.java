package com.intiFormation.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.intiFormation.dao.IformationDao;
import com.intiFormation.entity.Cours;
import com.intiFormation.entity.Formateur;
import com.intiFormation.entity.Formation;

@Service
public class FormationService implements IformationService {
	@Autowired
	IformationDao dao;

	@Override
	public Formation ajouter(Formation formation) {
		return dao.save(formation);
	}

	@Override
	public void supprimer(int id) {
		dao.deleteById(id);
	}

	@Override
	public Optional<Formation> selectById(int id) {
		return dao.findById(id);
	}

	@Override
	public List<Formation> selectAll() {
		return dao.findAll();
	}
	
	public List<Formation> findByCours(Cours cours){
		return dao.findByCours(cours);
	}

	@Override
	public List<Formation> findByFormateur(Formateur formateur) {
		return dao.findByFormateur(formateur);
	}


}
