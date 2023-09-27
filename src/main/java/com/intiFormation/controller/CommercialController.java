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

import com.intiFormation.entity.Commercial;
import com.intiFormation.entity.Role;
import com.intiFormation.service.IcommercialService;
import com.intiFormation.service.IroleService;

@RestController
@CrossOrigin("http://localhost:4200")
@RequestMapping("/commercial")
public class CommercialController {

	// Injections
	@Autowired
	private IcommercialService icommercialService;
	@Autowired
	private IroleService iroleservice;
	@Autowired
	private BCryptPasswordEncoder encoder;

	@GetMapping(path = "/public/list") // ok
	public List<Commercial> listCommercial() {
		return icommercialService.afficherAll();
	}
	// chefchewen
	// akchar

	@GetMapping(path = "/public/{id}") // ok
	public Commercial getCommercial(@PathVariable("id") int id) {
		return icommercialService.afficherParId(id);
	}

	@PostMapping(path = "/a/add") // ok
	public void SaveUser(@RequestBody Commercial commercial) {
		Role role = iroleservice.findByNom("COMMERCIAL");
		commercial.setRole(role);
		// Section de traitement du mot de passe.
		/*
		 * Generation automatique du mot de passe à la création d'un utilisateur si l'Id
		 * == 0 Generation selon la première lettre du prénom, le nom de l'utilisateur
		 * et l'année en cours concaténés On insère les traitements dans le if ? Pour
		 * conserver + de mémoire si la section est pas sollicitée.
		 */
		Date dateannee = new Date();
		int annee = dateannee.getYear()+ 1900;
		String premiereLettre = commercial.getPrenom().substring(0, 1);
		// Substring prénom
		// getnom

		int iduser = commercial.getId();
		if (iduser == 0) {
			commercial.setPassword(premiereLettre + commercial.getNom() + annee);
		}
		commercial.setPassword(encoder.encode(commercial.getPassword()));
		icommercialService.ajouter(commercial);
	}

	@PostMapping(path = "/c/modify") // ok
	public void modifyCommercial(@RequestBody Commercial commercial) {
		icommercialService.modifier(commercial);
	}

	@DeleteMapping(path = "/a/delete/{id}") // ok
	public void deleteCommercial(@PathVariable("id") int id) {
		icommercialService.supprimer(id);
	}

}
