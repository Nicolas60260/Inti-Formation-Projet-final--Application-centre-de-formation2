package com.intiFormation.service;

import java.util.List;

import com.intiFormation.entity.Role;
import com.intiFormation.entity.Role;

public interface IroleService {

	public Role findByNom(String nom);
	
public Role ajouterRole(Role role);
	
	public List<Role> afficherAllRole();
	
	public Role afficherRoleById(int id);
	
	public void supprimerRole(int id);
}
