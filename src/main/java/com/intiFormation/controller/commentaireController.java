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
import org.springframework.web.bind.annotation.RestController;

import com.intiFormation.entity.Commentaire;
import com.intiFormation.service.IcommentaireService;

@RestController
@CrossOrigin("http://localhost:4200")
public class commentaireController {

	@Autowired
	IcommentaireService service;
	
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////	
///////////////////////////////////////////Redéfinition des méthodes de la couche service///////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	

	@PostMapping("/com")
	public Commentaire addCommentaire(@RequestBody Commentaire commentaire) {
		
		
		return service.ajouterCommentaire(commentaire);
	}
	
	@DeleteMapping("/com/{id}")
	public void supprCommentaire(@PathVariable ("id") Integer id) {
		service.supprimerCommentaire(id);
		
	}
	
	@PutMapping("/com/{id}")
	public Commentaire modifCommentaire(@PathVariable Integer id) {
		Commentaire commentaireMod= service.afficherCommentaireById(id);
		
		return service.ajouterCommentaire(commentaireMod);
		
	}
	
	@GetMapping("/com/liste")
	public List<Commentaire> afficherAll(){
		
		return service.afficherAllCommentaire();
	}
	
	@GetMapping("/pr/{id}")
	public Commentaire afficherById(@PathVariable ("id") Integer id){
		
		
		return service.afficherCommentaireById(id);
	}
	
	
}
