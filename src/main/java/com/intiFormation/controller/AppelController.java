package com.intiFormation.controller;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

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
import com.intiFormation.entity.Commercial;
import com.intiFormation.entity.EmailScheduleRequest;
import com.intiFormation.entity.Prospect;
import com.intiFormation.service.IappelService;
import com.intiFormation.service.IcommentaireService;
import com.intiFormation.service.IcommercialService;
import com.intiFormation.service.IemailService;
import com.intiFormation.service.IprospectService;

@RestController
@CrossOrigin("http://localhost:4200")
@RequestMapping("/appel")
public class AppelController {

	// Injection
	@Autowired
	IappelService service;
	@Autowired
	IcommentaireService serviceCommentaire;
	@Autowired
	IprospectService prospectService;
	@Autowired
	IemailService mailservice;
	@Autowired
	IcommercialService commercialService;

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////	
///////////////////////////////////////////Redéfinition des méthodes de la couche service///////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	@PostMapping("/c/add")
	public Appel addAppel(@RequestBody Appel appel) {
		appel.setProspect(prospectService.afficherProspectById(appel.getProspect().getId()));
		appel.setCommercial(commercialService.afficherParId(appel.getCommercial().getId()));
		if (appel.isRDV()) {
			System.out.println(scheduleEmail(appel));
		}
		return service.ajouterAppel(appel);
	}

	@DeleteMapping("/a/delete/{id}")
	public void supprAppel(@PathVariable("id") Integer id) {
		service.supprimerAppel(id);
	}

	@PutMapping("/c/modify")
	public Appel modifAppel(@RequestBody Appel appel) {
//	Appel appelSend = service.selectAppelById(appel.getId());
		return service.ajouterAppel(appel);
	}

	@GetMapping("/c/list")
	public List<Appel> afficherAll() {

		return service.selectAllAppels();
	}
	
	
	
	@GetMapping("/c/comvide")
	public List<Appel> afficherByCommentaireNull(){
		return service.findByCommentaireIsNull();
	}
	
	@GetMapping("/c/{id}")
	public Appel afficherById(@PathVariable("id") Integer id) {

		return service.selectAppelById(id);
	}
	
	@GetMapping("/c/commercialappels/{id}")
	public List<Appel> afficherByCommercialId(@PathVariable("id") Integer id) {
		Commercial commercial = commercialService.afficherParId(id);
		return service.findByCommercial(commercial);}
		
	@GetMapping("/c/prospect/{id}")
	public List<Appel> afficherByProspectId(@PathVariable("id") Integer id) {
		Prospect prospect = prospectService.afficherProspectById(id);
		return service.findByProspect(prospect);
	}
	
	@GetMapping("/c/commercial/{id}")
	public Commercial afficherCommercial(@PathVariable("id")int id) {
		Appel appel = service.selectAppelById(id);
		
		return appel.getCommercial();
	}
	
	public String scheduleEmail(Appel appel) {
		
		// Créez un formateur de date avec le format de la chaîne
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        
     // Créez un objet Calendar avec le fuseau horaire "Europe/Paris"
        TimeZone parisTimeZone = TimeZone.getTimeZone("Europe/Paris");
        Calendar calendar = Calendar.getInstance(parisTimeZone);
		
        // Obtenez la date et l'heure spécifiées dans la requête
        Date scheduledTime = appel.getDebutAppel() ;
        
        calendar.setTime(scheduledTime);
        calendar.add(Calendar.MINUTE, -30);
        System.out.println(calendar);
     // Obtenez la date du calendrier (en tenant compte du fuseau horaire)
        scheduledTime = calendar.getTime();
        System.out.println();
        
        // Calculez le délai entre maintenant et la date spécifiée
        long delay = scheduledTime.getTime() - new Date().getTime();
        
        String text = "Rendez vous entre" + appel.getProspect().getNom() + " " + appel.getProspect().getPrenom() 
        		+ " et " + appel.getCommercial().getNom() + " " + appel.getCommercial().getPrenom() + ", le " 
        		+ appel.getDebutAppel().getDate() + " " + appel.getDebutAppel().getMonth() + " à " + appel.getDebutAppel().getHours() +":" + appel.getDebutAppel().getMinutes();
        String subject ="Rdv telephonique";
        
        // Planifiez l'envoi de l'e-mail à l'heure spécifiée
        mailservice.scheduleEmail(appel.getProspect().getMail(), subject, text, delay);
        mailservice.scheduleEmail(appel.getCommercial().getMail(), subject, text, delay);
        
        return "E-mail programmé avec succès pour " + scheduledTime;
    }
	
}
