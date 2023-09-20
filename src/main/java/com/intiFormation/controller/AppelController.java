package com.intiFormation.controller;

import java.util.List;
import java.util.Optional;

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

import com.intiFormation.entity.Appel;
import com.intiFormation.service.IappelService;
import com.intiFormation.service.IcommentaireService;

@RestController
@CrossOrigin("http://localhost:4200")
@RequestMapping("/call")
public class AppelController {

	// Injection
	@Autowired
	IappelService service;
	@Autowired
	IcommentaireService serviceCommentaire;
	
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////	
///////////////////////////////////////////Redéfinition des méthodes de la couche service///////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	@PostMapping()
	public Appel addAppel(@RequestBody Appel appel) {
		
		
		return service.ajouterAppel(appel);
	}
	
	@DeleteMapping("/{id}")
	public void supprAppel(@PathVariable ("id") Integer id) {
		service.supprimerAppel(id);
		
	}
	
	@PutMapping
	public Appel modifAppel(@RequestBody Appel appel) {
//	Appel appelSend = service.selectAppelById(appel.getId());
		return service.ajouterAppel(appel);
	}
	
	@GetMapping("/liste")
	public List<Appel> afficherAll(){
		
		return service.selectAllAppels();
	}
	
	@GetMapping("/{id}")
	public Appel afficherById(@PathVariable ("id") Integer id){
		
		
		return service.selectAppelById(id);
	}
	
}
