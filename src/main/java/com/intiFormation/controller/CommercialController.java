package com.intiFormation.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.intiFormation.entity.Commercial;
import com.intiFormation.entity.Utilisateur;
import com.intiFormation.service.IcommercialService;
import com.intiFormation.service.IutilisateurService;

@RestController
public class CommercialController {
	
	@Autowired
	private IcommercialService icommercialService;
	
	@GetMapping(path = "/listCommercial")//ok
	public List<Commercial> listCommercial(){
		return icommercialService.afficherAll();
	}
	
	@GetMapping(path = "/getCommercial/{id}")//ok
	public Commercial getUtilisateur(@PathVariable("id") int  id){
		return icommercialService.afficherParId(id);
	}
	
	@PostMapping(path = "/addNewCommercial")//ok
	public void SaveUser(@RequestBody Commercial personne) {
		icommercialService.ajouter(personne);
	}
	
	@PostMapping(path = "/modifyCommercial") //ok
	public void modifyUtilisateur(@RequestBody Commercial personne) {
		icommercialService.modifier(personne);
	}
	
	@DeleteMapping("/deleteCommercial/{id}")//ok
	public void deleteUtilisateur(@PathVariable("id") int  id) {
		icommercialService.supprimer(id);
	}

}
