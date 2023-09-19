package com.intiFormation.service;

import java.util.List;
import java.util.Optional;

import com.intiFormation.entity.Participant;

public interface IparticipantService {

	public Participant ajouter(Participant participant);
	public void supprimer(int id);
	public Optional<Participant> selectById(int id);
	public List<Participant> selectAll();
}
