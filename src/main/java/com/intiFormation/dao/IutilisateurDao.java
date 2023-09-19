package com.intiFormation.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.intiFormation.entity.Utilisateur;
import java.util.List;
import java.util.Optional;


public interface IutilisateurDao extends JpaRepository<Utilisateur, Integer>{
	public Optional<Utilisateur> findByUsername(String username);

}
