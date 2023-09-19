package com.intiFormation.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.intiFormation.dao.IcoursDao;
import com.intiFormation.entity.Cours;

@Service
public class CoursService implements IcoursService {

	@Autowired
	IcoursDao dao;

	@Override
	public Cours ajouter(Cours cours) {
		return dao.save(cours);
	}

	@Override
	public void supprimer(int id) {
		dao.deleteById(id);
	}

	@Override
	public Optional<Cours> selectById(int id) {
		return dao.findById(id);
	}

	@Override
	public List<Cours> selectAll() {
		return dao.findAll();
	}

}
