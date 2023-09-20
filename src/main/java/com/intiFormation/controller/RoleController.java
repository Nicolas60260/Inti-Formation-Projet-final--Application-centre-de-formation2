package com.intiFormation.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.intiFormation.entity.Role;
import com.intiFormation.service.IroleService;


@RestController
@CrossOrigin("http://localhost:4200")
@RequestMapping("/role")
public class RoleController {
	@Autowired
	IroleService service;
	
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////	
///////////////////////////////////////////Redéfinition des méthodes de la couche service///////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////



	@PostMapping("/a/add")
	public Role addRole(@RequestBody Role role) {
		
		
		return service.ajouterRole(role);
	}
	
	@DeleteMapping("/a/delete/{id}")
	public void supprRole(@PathVariable ("id") Integer id) {
		service.supprimerRole(id);
		
	}
	
	@PutMapping("/a/modify")
	public Role modifRole(@RequestBody Role role) {
		//Role roleMod= service.afficherRoleById(id);
		
		return service.ajouterRole(role);
		
	}
	
	@GetMapping("/a/list")
	public List<Role> afficherAll(){
		
		return service.afficherAllRole();
	}
	
	@GetMapping("/a/{id}")
	public Role afficherById(@PathVariable ("id") Integer id){
		
		
		return service.afficherRoleById(id);
	}
	
}
