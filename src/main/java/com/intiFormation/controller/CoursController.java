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

import com.intiFormation.entity.Cours;
import com.intiFormation.service.IcoursService;

@RestController
@RequestMapping("/cours")
@CrossOrigin("http://localhost:4200")
public class CoursController {
	@Autowired
	IcoursService coursService;

	@GetMapping("/public") //ok
	public List<Cours> listeCours() {
		return coursService.selectAll();
	}

	@GetMapping("/public/{id}")//ok
	public Cours coursById(@PathVariable("id") int id) {
		return coursService.selectById(id).get();
	}

	@PostMapping("/cours/save") //ok
	public Cours saveCours(@RequestBody Cours cours) {
		return coursService.ajouter(cours);
	}

	@DeleteMapping("/admin/supprimer/{id}")//ok
	public void supprimerCours(@PathVariable("id") int id) {
		coursService.supprimer(id);
	}
}
