package com.intiFormation.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.intiFormation.dao.IparticipantDao;
import com.intiFormation.entity.Participant;

@Service
public class ParticipantService implements IparticipantService{
@Autowired
IparticipantDao dao;
	
	@Override
	public Participant ajouter(Participant participant) {
		return dao.save(participant);
	}

	@Override
	public void supprimer(int id) {
dao.deleteById(id);		
	}

	@Override
	public Optional<Participant> selectById(int id) {
		return dao.findById(id);
	}

	@Override
	public List<Participant> selectAll() {
		return dao.findAll();
	}

	@Override
	public Participant trouverParticipantsParId(int id) {
		return dao.findByPaiements_id(id);
	}

}
