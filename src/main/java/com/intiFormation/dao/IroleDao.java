package com.intiFormation.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.intiFormation.entity.Role;
import java.util.List;


public interface IroleDao extends JpaRepository<Role, Integer> {

	//public Role findRoleByNom(String nom);
	
	// Méthode réalisée pour l'attribution d'un role à un type final d'utilisateur (Commercial, Participant...)
	public Role findByNom(String nom);
	
}
