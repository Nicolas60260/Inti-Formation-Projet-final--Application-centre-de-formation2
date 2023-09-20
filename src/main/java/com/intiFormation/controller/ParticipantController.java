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

import com.intiFormation.entity.Participant;
import com.intiFormation.entity.Role;
import com.intiFormation.service.IparticipantService;
import com.intiFormation.service.IroleService;

@RestController
@RequestMapping("/participant")
@CrossOrigin("http://localhost:4200")
public class ParticipantController {
	@Autowired
	IparticipantService participantService;
@Autowired
IroleService roleservice;
	
	
	@GetMapping("/c/f/list")
	public List<Participant> listeParticipant() {
		return participantService.selectAll();
	}

	@GetMapping("/p/c/f/{id}")
	public Participant participantById(@PathVariable("id") int id) {
		return participantService.selectById(id).get();
	}

	@PostMapping("/c/f/add")
	public Participant saveParticipant(@RequestBody Participant participant) {
		Role role = roleservice.findByNom("PARTICIPANT");
		participant.setRole(role);
		
		
		return participantService.ajouter(participant);
	}

	@DeleteMapping("/a/delete/{id}")
	public void supprimerParticipant(@PathVariable("id") int id) {
		participantService.supprimer(id);
	}
}
