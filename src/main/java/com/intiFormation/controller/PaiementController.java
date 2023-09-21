package com.intiFormation.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.intiFormation.entity.Paiement;
import com.intiFormation.entity.Participant;
import com.intiFormation.service.IpaiementService;
import com.intiFormation.service.IparticipantService;

@RestController
@RequestMapping("/paiement")
@CrossOrigin("http://localhost:4200")
public class PaiementController {
	@Autowired
	IpaiementService paiementService;
	
	@Autowired
	IparticipantService participantService;

	@GetMapping("/a/list")
	public List<Paiement> listePaiement() {
		return paiementService.selectAll();
	}

	@GetMapping("/a/{id}")
	public Paiement paiementById(@PathVariable("id") int id) {
		return paiementService.selectById(id).get();
	}
	
	@GetMapping("/pa/participant/{id}")
	public List<Paiement> paiementByParticipant(@PathVariable("id") int id) {
		Participant participant = participantService.selectById(id).get();
		return paiementService.findByParticipant(participant);
	}

	@PostMapping("/p/add")
	public Paiement savePaiement(@RequestBody Paiement paiement) {
		return paiementService.ajouter(paiement);
	}

	@DeleteMapping("/a/delete/{id}")
	public void supprimerPaiement(@PathVariable("id") int id) {
		paiementService.supprimer(id);
	}
}
