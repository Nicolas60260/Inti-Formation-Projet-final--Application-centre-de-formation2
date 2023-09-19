package com.intiFormation.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.intiFormation.entity.Utilisateur;
import com.intiFormation.service.IutilisateurService;

@RestController
public class UtilisateurController {
	
	@Autowired
	private IutilisateurService iutilisateurService;
	
	@GetMapping(path = "/listUtilisateur")// pas ok
	public List<Utilisateur> listUtilisateur(){
		return iutilisateurService.afficherAll();
	}
	
	@GetMapping(path = "/getUtilisateur/{id}")// ok
	public Utilisateur getUtilisateur(@PathVariable("id") int  id){
		return iutilisateurService.afficherParId(id);
	}
	
	@PostMapping(path = "/addNewUtilisateur")// ok
	public void SaveUser(@RequestBody Utilisateur personne) {
		iutilisateurService.ajouter(personne);
	}
	
	@PostMapping(path = "/modifyUtilisateur") //ok
	public void modifyUtilisateur(@RequestBody Utilisateur personne) {
		iutilisateurService.modifier(personne);
	}
	
	@DeleteMapping("/deleteUtilisateur/{id}")
	public void deleteUtilisateur(@PathVariable("id") int  id) {
		iutilisateurService.supprimer(id);
	}

}
