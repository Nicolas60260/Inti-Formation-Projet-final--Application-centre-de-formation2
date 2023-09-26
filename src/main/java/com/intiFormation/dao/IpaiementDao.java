package com.intiFormation.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.intiFormation.entity.Paiement;
import com.intiFormation.entity.Participant;

public interface IpaiementDao extends JpaRepository<Paiement, Integer>{
	
	public List<Paiement> findByParticipant(Participant participant);
	

}
