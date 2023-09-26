package com.intiFormation.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.intiFormation.entity.Participant;
import com.intiFormation.entity.Prospect;



// Annotations service


public interface IprospectService {

	// Methodes CRUD uniquement 
	
	
	public Prospect ajouterProspect(Prospect prospect);
	
	public List<Prospect> afficherAllProspect();
	
	public Prospect afficherProspectById(int id);
	
	public void supprimerProspect(int id);
	
	public Participant inscrireParticipant(Prospect prospect);
	
	
	
	//Autres methodes
	
}
