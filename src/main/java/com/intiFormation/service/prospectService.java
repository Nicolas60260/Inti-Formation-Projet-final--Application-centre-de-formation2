package com.intiFormation.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.intiFormation.dao.IprospectDao;
import com.intiFormation.entity.Prospect;

//Annotation service + implémentation de l'interface du service
@Service
public class prospectService implements IprospectService {

	// Création du Bean Dao pour appel à la couche Dao et aux methodes CRUD

	@Autowired
	IprospectDao dao;

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////	
///////////////////////////////////////////Redéfinition des méthodes de l'interface///////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	
	public Prospect ajouterProspect(Prospect prospect) {

		return dao.save(prospect);

	}

	public List<Prospect> afficherAllProspect() {

		return dao.findAll();
	}

	public Prospect afficherProspectById(int id) {

		Prospect prospect = dao.findById(id).get();

		return prospect;
	}

	public void supprimerProspect(int id) {
		dao.deleteById(id);

	}

}
