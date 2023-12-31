package com.intiFormation.controller;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.intiFormation.entity.Participant;
import com.intiFormation.entity.Prospect;
import com.intiFormation.service.IprospectService;

@RestController
@CrossOrigin("http://localhost:4200")
@RequestMapping("/prospect")
public class ProspectController {


	// Création du Bean Service pour appel à la couche Service et aux methodes CRUD de prospect

		@Autowired
		IprospectService service;
		
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////	
///////////////////////////////////////////Redéfinition des méthodes de la couche service///////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

		
	
		@PostMapping("/c/add")
		public Prospect addProspect(@RequestBody Prospect prospect) {
			
			
			return service.ajouterProspect(prospect);
		}
		
		@DeleteMapping("/c/delete/{id}")
		public void supprProspect(@PathVariable ("id") Integer id) {
			service.supprimerProspect(id);
			
		}
		
		@PutMapping("/c/modify")
		public Prospect modifProspect(@RequestBody Prospect prospect) {
			//Prospect prospectMod= service.afficherProspectById(id);
			
			return service.ajouterProspect(prospect);
			
		}
		
		@GetMapping("/c/list")
		public List<Prospect> afficherAll(){
			
			return service.afficherAllProspect();
		}
		
		@GetMapping("/c/{id}")
		public Prospect afficherById(@PathVariable ("id") Integer id){
			
			
			return service.afficherProspectById(id);
		}
		@PostMapping("/c/register")
		public Participant inscrireParticipant(@RequestBody Prospect prospect) {
			return service.inscrireParticipant(prospect);
			
		}
		
}
