package com.intiFormation.service;

import java.util.List;
import java.util.Optional;

import com.intiFormation.entity.Cours;

public interface IcoursService {
	public Cours ajouter(Cours cours);
	public void supprimer(int id);
	public Optional<Cours> selectById(int id);
	public List<Cours> selectAll();
}
