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

import com.intiFormation.dao.IcoursDao;
import com.intiFormation.entity.Cours;
import com.intiFormation.entity.Formateur;
import com.intiFormation.entity.Formation;
import com.intiFormation.service.IcoursService;
import com.intiFormation.service.IformateurService;
import com.intiFormation.service.IformationService;

@RestController
@RequestMapping("/formation")
@CrossOrigin("http://localhost:4200")
public class FormationController {
	@Autowired
	IformationService formationService;
	@Autowired
	IcoursService coursService;
	@Autowired
	IformateurService formateurService;

	@GetMapping("/public/list")
	public List<Formation> listeFormation() {
		return formationService.selectAll();
	}

	@GetMapping("/public/{id}")//ok
	public Formation formationById(@PathVariable("id") int id) {
		return formationService.selectById(id).get();
	}
	
	@GetMapping("/a/cours/{idcours}")
	public List<Formation> formationsByCours(@PathVariable("idcours") int idcours){
		Cours cours = coursService.selectById(idcours).get();
		return formationService.findByCours(cours);
	}
	
	@GetMapping("/f/formateur/{id}")
	public List<Formation> formationsByFormateur(@PathVariable("id") int id){
		Formateur formateur = formateurService.selectById(id).get();
		return formationService.findByFormateur(formateur);
	}
	@PostMapping("/f/add")
	public Formation saveFormation(@RequestBody Formation formation) {
		return formationService.ajouter(formation);
	}

	@DeleteMapping("/a/delete/{id}")
	public void supprimerFormation(@PathVariable("id") int id) {
		formationService.supprimer(id);

	}
}
