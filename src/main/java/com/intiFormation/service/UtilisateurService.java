package com.intiFormation.service;

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
		
		@Override
		public Utilisateur ajouter(Utilisateur utilisateur) {
			return dao.save(utilisateur);
		}

		@Override
		public void supprimer(int id) {
	dao.deleteById(id);		
		}

		@Override
		public Optional<Utilisateur> selectById(int id) {
			return dao.findById(id);
		}

		@Override
		public List<Utilisateur> selectAll() {
			return dao.findAll();
		}

		@Override
		public Optional<Utilisateur> findByUsername(String username) {
			// TODO Auto-generated method stub
			return null;
		}

}
