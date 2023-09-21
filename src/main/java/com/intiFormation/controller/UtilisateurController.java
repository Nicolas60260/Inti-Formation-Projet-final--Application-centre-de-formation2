package com.intiFormation.controller;

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

import com.intiFormation.entity.Utilisateur;
import com.intiFormation.service.IutilisateurService;

@RestController
@CrossOrigin("http://localhost:4200")
@RequestMapping("/utilisateur")
public class UtilisateurController {
	
	@Autowired
	private BCryptPasswordEncoder encoder;
	
	@Autowired
	private IutilisateurService iutilisateurService;
	
	@GetMapping(path = "/a/list")// pas ok
	public List<Utilisateur> listUtilisateur(){
		return iutilisateurService.afficherAll();
	}
	
	@GetMapping(path = "/a/{id}")// ok
	public Utilisateur getUtilisateur(@PathVariable("id") int  id){
		return iutilisateurService.afficherParId(id);
	}
	
	@PostMapping(path = "/a/add")// ok
	public void SaveUser(@RequestBody Utilisateur utilisateur) {
		
		
		// Passage du mot de passe récupéré de l'objet en entrée, dans l'encodeur pour envoi vers BD
	utilisateur.setPassword(encoder.encode(utilisateur.getPassword()));
		
		iutilisateurService.ajouter(utilisateur);
	}
	
	@PostMapping(path = "/pcf/modify") //ok
	public void modifyUtilisateur(@RequestBody Utilisateur utilisateur) {
		utilisateur.setPassword(encoder.encode(utilisateur.getPassword()));
		iutilisateurService.modifier(utilisateur);
	}
	
	@DeleteMapping("/a/delete/{id}")
	public void deleteUtilisateur(@PathVariable("id") int  id) {
		iutilisateurService.supprimer(id);
	}

}
