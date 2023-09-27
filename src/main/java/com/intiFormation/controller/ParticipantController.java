package com.intiFormation.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.intiFormation.dao.IparticipantDao;
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
	@Autowired
	private BCryptPasswordEncoder encoder;
	
	@Autowired
	IparticipantDao pdao;

	@GetMapping("/cf/list")
	public List<Participant> listeParticipant() {
		return participantService.selectAll();
	}

	@GetMapping("/pfc/{id}")
	public Participant participantById(@PathVariable("id") int id) {
		return participantService.selectById(id).get();
	}

	@PostMapping("/cf/add")
	public Participant saveParticipant(@RequestBody Participant participant) {
		Role role = roleservice.findByNom("PARTICIPANT");
		participant.setRole(role);
		
		// Section de traitement du mot de passe.
				/*
				 * Generation automatique du mot de passe à la création d'un utilisateur si l'Id
				 * == 0 Generation selon la première lettre du prénom, le nom de l'utilisateur
				 * et l'année en cours concaténés On insère les traitements dans le if ? Pour
				 * conserver + de mémoire si la section est pas sollicitée.
				 */
				Date dateannee = new Date();
				int annee = dateannee.getYear();
				String premiereLettre = participant.getPrenom().substring(0, 1);
				// Substring prénom
				// getnom

				int iduser = participant.getId();
				if (iduser == 0) {
					participant.setPassword(premiereLettre + participant.getNom() + annee);
				}
		participant.setPassword(encoder.encode(participant.getPassword()));
		return participantService.ajouter(participant);
	}

	@DeleteMapping("/a/delete/{id}")
	public void supprimerParticipant(@PathVariable("id") int id) {
		participantService.supprimer(id);
	}
	
	@GetMapping("/cf/trouverParticipantsParIdPaiement/{idPaiement}")
	public Participant trouverParticipantsParId(@PathVariable("idPaiement") int idPaiement)
	{
		return participantService.trouverParticipantsParId(idPaiement);
	}
}
