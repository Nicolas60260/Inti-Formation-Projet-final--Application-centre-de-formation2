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

import com.intiFormation.entity.Utilisateur;
import com.intiFormation.service.IutilisateurService;

@RestController
@RequestMapping("/utilisateur")
@CrossOrigin("http://localhost:4200")
public class UtilisateurController {

	@Autowired
	IutilisateurService utilisateurService;

	@GetMapping("/public")
	public List<Utilisateur> listeUtilisateur() {
		return utilisateurService.selectAll();
	}

	@GetMapping("/public/{id}")
	public Utilisateur utilisateurById(@PathVariable("id") int id) {
		return utilisateurService.selectById(id).get();
	}

	@PostMapping("/utilisateur/save")
	public Utilisateur saveUtilisateur(@RequestBody Utilisateur utilisateur) {
		return utilisateurService.ajouter(utilisateur);
	}

	@DeleteMapping("/admin/supprimer/{id}")
	public void supprimerUtilisateur(@PathVariable("id") int id) {
		utilisateurService.supprimer(id);
	}
}
