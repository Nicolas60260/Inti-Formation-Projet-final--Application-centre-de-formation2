package com.intiFormation.service;

import java.util.List;

import com.intiFormation.entity.Appel;
import com.intiFormation.entity.Commercial;
import com.intiFormation.entity.Utilisateur;

public interface IcommercialService {

public List<Commercial> afficherAll();
	
	public Commercial afficherParId(int id);
	
	public void ajouter(Commercial c);
	
	public void supprimer(int id);
	
	public void modifier(Commercial c);
	
	
	
}
