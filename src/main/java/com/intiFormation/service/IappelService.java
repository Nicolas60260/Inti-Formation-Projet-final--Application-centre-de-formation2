package com.intiFormation.service;

import java.util.List;
import java.util.Optional;

import com.intiFormation.entity.Appel;

public interface IappelService {
	
	public Appel ajouterAppel(Appel appel);
	public void supprimerAppel(int id);
	public Appel selectAppelById(int id);
	public List<Appel> selectAllAppels();

}
