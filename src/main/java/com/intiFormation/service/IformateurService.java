package com.intiFormation.service;

import java.util.List;
import java.util.Optional;

import com.intiFormation.entity.Formateur;

public interface IformateurService {
	public Formateur ajouter(Formateur formateur);
	public void supprimer(int id);
	public Optional<Formateur> selectById(int id);
	public List<Formateur> selectAll();
}
