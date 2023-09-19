package com.intiFormation.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.intiFormation.dao.IformateurDao;
import com.intiFormation.entity.Formateur;

@Service
public class FormateurService implements IformateurService {
	@Autowired
	IformateurDao dao;

	@Override
	public Formateur ajouter(Formateur formateur) {
		return dao.save(formateur);
	}

	@Override
	public void supprimer(int id) {
		dao.deleteById(id);
	}

	@Override
	public Optional<Formateur> selectById(int id) {
		return dao.findById(id);
	}

	@Override
	public List<Formateur> selectAll() {
		return dao.findAll();
	}

}
