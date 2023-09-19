package com.intiFormation.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.intiFormation.dao.IappelDao;
import com.intiFormation.entity.Appel;


@Service
public class appelService implements IappelService{
@Autowired
IappelDao dao;
	
	
	@Override
	public Appel ajouterAppel(Appel appel) {
		// TODO Auto-generated method stub
		return dao.save(appel);
	}

	@Override
	public void supprimerAppel(int id) {
	dao.deleteById(id);
		
	}

	@Override
	public Appel selectAppelById(int id) {


		
		return dao.findById(id).get();
	}

	@Override
	public List<Appel> selectAllAppels() {
		// TODO Auto-generated method stub
		return dao.findAll();
	}

}
