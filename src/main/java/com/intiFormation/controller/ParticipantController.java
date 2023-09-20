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
import com.intiFormation.service.IparticipantService;

@RestController
@RequestMapping("/participant")
@CrossOrigin("http://localhost:4200")
public class ParticipantController {
	@Autowired
	IparticipantService participantService;

	@GetMapping("/public") //ok
	public List<Participant> listeParticipant() {
		return participantService.selectAll();
	}

	@GetMapping("/public/{id}") //ok
	public Participant participantById(@PathVariable("id") int id) {
		return participantService.selectById(id).get();
	}

	@PostMapping("/formateur/save") //ok
	public Participant saveParticipant(@RequestBody Participant participant) {
		return participantService.ajouter(participant);
	}

	@DeleteMapping("/admin/supprimer/{id}") //ok
	public void supprimerParticipant(@PathVariable("id") int id) {
		participantService.supprimer(id);
	}
}
