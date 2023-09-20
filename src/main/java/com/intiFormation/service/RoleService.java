package com.intiFormation.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.intiFormation.dao.IroleDao;
import com.intiFormation.entity.Role;
@Service
public class RoleService implements IroleService {

	@Autowired
	IroleDao dao;
	
	@Override
	public Role findByNom(String nom) {
		
		return dao.findByNom(nom);
	}

	@Override
	public Role ajouterRole(Role role) {
		// TODO Auto-generated method stub
		return dao.save(role);
	}

	@Override
	public List<Role> afficherAllRole() {
		// TODO Auto-generated method stub
		return dao.findAll();
	}

	@Override
	public Role afficherRoleById(int id) {
		// TODO Auto-generated method stub
		return dao.findById(id).get();
	}

	@Override
	public void supprimerRole(int id) {
		// TODO Auto-generated method stub
dao.deleteById(id);
	}

}
