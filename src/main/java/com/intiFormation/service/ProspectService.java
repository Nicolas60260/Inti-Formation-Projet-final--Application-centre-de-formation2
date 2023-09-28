package com.intiFormation.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.intiFormation.dao.IparticipantDao;
import com.intiFormation.dao.IprospectDao;
import com.intiFormation.entity.Participant;
import com.intiFormation.entity.Prospect;
import com.intiFormation.entity.Role;

//Annotation service + implémentation de l'interface du service
@Service
public class ProspectService implements IprospectService {

	// Création du Bean Dao pour appel à la couche Dao et aux methodes CRUD

	@Autowired
	IprospectDao dao;
	
	@Autowired
	IparticipantDao participantDao;
	
	@Autowired
	IroleService roleservice;
	@Autowired
	private BCryptPasswordEncoder encoder;

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////	
///////////////////////////////////////////Redéfinition des méthodes de l'interface///////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	
	public Prospect ajouterProspect(Prospect prospect) {

		return dao.save(prospect);

	}

	public List<Prospect> afficherAllProspect() {

		return dao.findAll();
	}

	public Prospect afficherProspectById(int id) {

		Prospect prospect = dao.findById(id).get();

		return prospect;
	}

	public void supprimerProspect(int id) {
		dao.deleteById(id);

	}

	@Override
	public Participant inscrireParticipant(Prospect prospect) {
		Participant participant = new Participant(prospect);
		Role role = roleservice.findByNom("PARTICIPANT");
		participant.setRole(role);
		
		// Section de traitement du mot de passe.
				/*
				 * Generation automatique du mot de passe à la création d'un utilisateur si l'Id
				 * == 0 Generation selon la première lettre du prénom, le nom de l'utilisateur
				 * et l'année en cours concaténés On insère les traitements dans le if ? Pour
				 * conserver + de mémoire si la section est pas sollicitée.
				 */
				Date dateannee = new Date();
				int annee = dateannee.getYear();
				String premiereLettre = participant.getPrenom().substring(0, 1);
				// Substring prénom
				// getnom

				int iduser = participant.getId();
				if (iduser == 0) {
					participant.setPassword(premiereLettre + participant.getNom() + annee);
				}
				System.out.println(participant.getPassword());
		participant.setPassword(encoder.encode(participant.getPassword()));
		return participantDao.save(participant);
	}

}
