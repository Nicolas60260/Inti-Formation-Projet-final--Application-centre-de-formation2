package com.intiFormation.controller;

import java.util.Date;
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

import com.intiFormation.entity.Commentaire;
import com.intiFormation.service.IcommentaireService;

@RestController
@CrossOrigin("http://localhost:4200")
@RequestMapping("/commentaire")
public class commentaireController {

	@Autowired
	IcommentaireService service;
	
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////	
///////////////////////////////////////////Redéfinition des méthodes de la couche service///////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	

	@PostMapping("/c/add")
	public Commentaire addCommentaire(@RequestBody Commentaire commentaire) {
		// Création de l'objet date qui prend la date du moment de la création du commentaire
		// au format dd/MM/yyyy hh:mm:ss
		Date datePostComm= new Date();
		//on set la date du commentaire
		commentaire.setDate(datePostComm);
		
		
		return service.ajouterCommentaire(commentaire);
	}
	
	@DeleteMapping("/a/delete/{id}")
	public void supprCommentaire(@PathVariable ("id") Integer id) {
		service.supprimerCommentaire(id);
		
	}
	
	@PutMapping("/c/modify")
	public Commentaire modifCommentaire(@RequestBody Commentaire commentaire) {
	//	Commentaire commentaireMod= service.afficherCommentaireById(commentaire);
		
		return service.ajouterCommentaire(commentaire);
		
	}
	
	@GetMapping("/c/list")
	public List<Commentaire> afficherAll(){
		
		return service.afficherAllCommentaire();
	}
	
	@GetMapping("/c/{id}")
	public Commentaire afficherById(@PathVariable ("id") Integer id){
		
		
		return service.afficherCommentaireById(id);
	}
	
	
}
