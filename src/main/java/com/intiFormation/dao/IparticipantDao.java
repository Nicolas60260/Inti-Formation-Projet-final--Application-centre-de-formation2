package com.intiFormation.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.intiFormation.entity.Participant;

public interface IparticipantDao extends JpaRepository<Participant, Integer>{
//	@Query("from Participant p where p.paiements.id=:idPaiement")
//	public Participant searchParticipantByIdPaiement(@Param("idPaiement") int idPaiement);
	
	public Participant findByPaiements_id(int id);
}
