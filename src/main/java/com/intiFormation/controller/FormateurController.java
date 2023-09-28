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

import com.intiFormation.entity.Formateur;
import com.intiFormation.entity.Role;
import com.intiFormation.service.IformateurService;
import com.intiFormation.service.IroleService;

@RestController
@RequestMapping("/formateur")
@CrossOrigin("http://localhost:4200")
public class FormateurController {
	@Autowired
	IformateurService formateurService;
	@Autowired
	IroleService roleservice;
	@Autowired
	private BCryptPasswordEncoder encoder;


	@GetMapping("/public/list")
	public List<Formateur> listeFormateur() {
		return formateurService.selectAll();
	}

	@GetMapping("/public/{id}") // ok
	public Formateur formateurById(@PathVariable("id") int id) {
		return formateurService.selectById(id).get();
	}

	@PostMapping("/f/add")
	public Formateur saveFormateur(@RequestBody Formateur formateur) {
		Role role = roleservice.findByNom("FORMATEUR");
		formateur.setRole(role);

		// Section de traitement du mot de passe.
		/*
		 * Generation automatique du mot de passe à la création d'un utilisateur si l'Id
		 * == 0 Generation selon la première lettre du prénom, le nom de l'utilisateur
		 * et l'année en cours concaténés On insère les traitements dans le if ? Pour
		 * conserver + de mémoire si la section est pas sollicitée.
		 */
		Date dateannee = new Date();
		int annee = dateannee.getYear() + 1900;
		String premiereLettre = formateur.getPrenom().substring(0, 1);
		// Substring prénom
		// getnom

		int iduser = formateur.getId();
		if (iduser == 0) {
			formateur.setPassword(premiereLettre+formateur.getNom()+annee);
			System.out.println(annee);
			System.out.println(premiereLettre+formateur.getNom()+annee);
		}
		formateur.setPassword(encoder.encode(formateur.getPassword()));

		return formateurService.ajouter(formateur);
	}

	@DeleteMapping("/a/delete/{id}")
	public void supprimerFormateur(@PathVariable("id") int id) {
		formateurService.supprimer(id);
	}

}
