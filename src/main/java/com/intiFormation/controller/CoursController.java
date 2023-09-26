package com.intiFormation.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.intiFormation.entity.Cours;
import com.intiFormation.service.IcoursService;

@RestController
@RequestMapping("/cours")
@CrossOrigin("http://localhost:4200")
public class CoursController {
	@Autowired
	IcoursService coursService;
	@Autowired
	HttpSession session ;

	@GetMapping("/p/list")

	public List<Cours> listeCours() {
		return coursService.selectAll();
	}

	@GetMapping("/p/{id}")

	public Cours coursById(@PathVariable("id") int id) {
		return coursService.selectById(id).get();
	}

	
	@PostMapping("/f/add")
	public Cours saveCoursImg(@RequestParam("fichier") MultipartFile file,@RequestParam("id") int id
	, @RequestParam("nom") String nom, @RequestParam("duree") long duree) {
		String fichier = file.getOriginalFilename();
		Cours cours = new Cours(id,duree,nom,fichier);
		String path = session.getServletContext().getRealPath("/");
	
		try {
			byte barr[] = file.getBytes();

			BufferedOutputStream bout = new BufferedOutputStream(new FileOutputStream(path + "/dossiercours/" + fichier));
			System.out.println(path);
			bout.write(barr);
			bout.flush();
			bout.close();

		} catch (Exception e) {
			System.out.println(e);
		}
		return coursService.ajouter(cours);
	}


	@DeleteMapping("/a/delete/{id}")
	public void supprimerCours(@PathVariable("id") int id) {
		coursService.supprimer(id);
	}
}
