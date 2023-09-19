package com.intiFormation.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.intiFormation.dao.IutilisateurDao;
import com.intiFormation.entity.Utilisateur;

@Service
public class utilisateurService implements IutilisateurService{
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

}
