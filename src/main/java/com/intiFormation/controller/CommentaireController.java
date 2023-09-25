package com.intiFormation.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.intiFormation.entity.Appel;
import com.intiFormation.entity.Commentaire;
import com.intiFormation.entity.Prospect;
import com.intiFormation.service.IappelService;
import com.intiFormation.service.IcommentaireService;
import com.intiFormation.service.IprospectService;

@RestController
@CrossOrigin("http://localhost:4200")
@RequestMapping("/commentaire")
public class CommentaireController {

	@Autowired
	IcommentaireService service;
	@Autowired
	IappelService appelService;
	@Autowired
	IprospectService prospectService;

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////	
///////////////////////////////////////////Redéfinition des méthodes de la couche service///////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	@PostMapping("/c/add")
	public void addCommentaire(@RequestBody Commentaire commentaire) {
		/*
		 * System.out.println(commentaire); System.out.println(commentaire.getAppel());
		 * if (commentaire.getAppel()!=null && commentaire.getAppel().getId()==0) { //
		 * Si quand on ajoute un commentaire l'appel n'est pas renseigné, on le set à
		 * null dans la BD commentaire.setAppel(null);
		 * System.out.println("Je suis dans condition une" + commentaire.getAppel()); }
		 */

		if (commentaire.getProspect() != null) {
			if (commentaire.getProspect().getId() == 0) { // Si quand on ajoute un commentaire le prospect n'est pas
															// renseigné on le set à null dans la bd
				commentaire.setProspect(null);
			} else {
				Prospect prospect = prospectService.afficherProspectById(commentaire.getProspect().getId());
				commentaire.setProspect(prospect);
				commentaire.setAppel(null);
				System.out.println(commentaire);
				System.out.println(prospect);
				service.ajouterCommentaire(commentaire);
			}
		}

		if (commentaire.getAppel() != null) {
			if (commentaire.getAppel().getId() == 0) {
				Appel appel = appelService.selectAppelById(commentaire.getAppel().getId());// Si quand on ajoute uncommentaire l'appel n'est pasrenseigné on le set à null dans la bd
				commentaire.setAppel(null);
				appel.setCommentaire(null);
				System.out.println(service.ajouterCommentaire(commentaire));
			} else {
				System.out.println(commentaire);
				service.ajouterCommentaire(commentaire);
				Appel appel = appelService.selectAppelById(commentaire.getAppel().getId());
				appel.setCommentaire(commentaire);
				System.out.println(appelService.ajouterAppel(appel));
				System.out.println(appel);
			}
		} else {

		}

		// Création de l'objet date qui prend la date du moment de la création du
		// commentaire
		// au format dd/MM/yyyy hh:mm:ss
		Date datePostComm = new Date();
		// on set la date du commentaire
		commentaire.setDate(datePostComm);

		// return service.ajouterCommentaire(commentaire);
	}

	@DeleteMapping("/a/delete/{id}")
	public void supprCommentaire(@PathVariable("id") Integer id) {
		Commentaire commentaire = service.afficherCommentaireById(id);
		if (commentaire.getAppel() != null) { // Si l'appel exsite on set l'appel dans la BD à null lors de la
												// suppression
			Appel appel = commentaire.getAppel();
			appel.setCommentaire(null);
		}

		service.supprimerCommentaire(id);

	}

	@PutMapping("/c/modify")
	public Commentaire modifCommentaire(@RequestBody Commentaire commentaire) {
		// Commentaire commentaireMod= service.afficherCommentaireById(commentaire);

		return service.ajouterCommentaire(commentaire);

	}

	@GetMapping("/c/list")
	public List<Commentaire> afficherAll() {
		System.out.println(service.afficherAllCommentaire());
		return service.afficherAllCommentaire();
	}

	@GetMapping("/c/{id}")
	public Commentaire afficherById(@PathVariable("id") Integer id) {

		return service.afficherCommentaireById(id);
	}

	@GetMapping("/c/appel/{id}")
	public Appel afficherByAppelId(@PathVariable("id") Integer id) {
		Commentaire commentaire = service.afficherCommentaireById(id);
		if (commentaire.getAppel() == null) {
			return null;
		} else {

			return appelService.findByCommentaire(commentaire);
		}
	}

	@GetMapping("/c/prospect/{id}")
	public List<Commentaire> afficherByProspectId(@PathVariable("id") Integer id) {
		Prospect prospect = prospectService.afficherProspectById(id);
		return service.findByProspect(prospect);
	}

}
