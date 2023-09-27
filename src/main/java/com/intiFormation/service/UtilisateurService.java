package com.intiFormation.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.intiFormation.dao.IutilisateurDao;
import com.intiFormation.entity.Utilisateur;

@Service
public class UtilisateurService implements IutilisateurService{
	@Autowired
	IutilisateurDao dao;
	
	public List<Utilisateur> afficherAll()
	{
		return dao.findAll();
	}
	
	public Utilisateur afficherParId(int id)
	{
		return dao.findById(id).get();
	}
	
	public void ajouter(Utilisateur u)
	{
		dao.save(u);
	}
	
	public void supprimer(int id)
	{
		dao.deleteById(id);
	}
	
	public void modifier(Utilisateur u)
	{
		dao.save(u);
	}

	@Override
	public Optional<Utilisateur> findByUsername(String username) {
		return dao.findByUsername(username);
	}
	
	
	

}
