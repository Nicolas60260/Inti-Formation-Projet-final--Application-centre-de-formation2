package com.intiFormation.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.intiFormation.dao.IcommercialDao;
import com.intiFormation.dao.IutilisateurDao;
import com.intiFormation.entity.Appel;
import com.intiFormation.entity.Commercial;
@Service
public class CommercialService implements IcommercialService{
	@Autowired
	IcommercialDao dao;

	@Override
	public List<Commercial> afficherAll() {
		return dao.findAll();
	}

	@Override
	public Commercial afficherParId(int id) {
		return dao.findById(id).get();
	}

	@Override
	public void ajouter(Commercial c) {
		dao.save(c);
		
	}

	@Override
	public void supprimer(int id) {
		dao.deleteById(id);
		
	}

	@Override
	public void modifier(Commercial c) {
		dao.save(c);
		
	}


}
