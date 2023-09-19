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

import com.intiFormation.entity.Formateur;
import com.intiFormation.service.IformateurService;

@RestController
@RequestMapping("/formateur")
@CrossOrigin("http://localhost:4200")
public class FormateurController {
	@Autowired
	IformateurService formateurService;

	@GetMapping("/public")
	public List<Formateur> listeFormateur() {
		return formateurService.selectAll();
	}

	@GetMapping("/public/{id}")
	public Formateur formateurById(@PathVariable("id") int id) {
		return formateurService.selectById(id).get();
	}

	@PostMapping("/formateur/save")
	public Formateur saveFormateur(@RequestBody Formateur formateur) {
		return formateurService.ajouter(formateur);
	}

	@DeleteMapping("/admin/supprimer/{id}")
	public void supprimerFormateur(@PathVariable("id") int id) {
		formateurService.supprimer(id);
	}

}
