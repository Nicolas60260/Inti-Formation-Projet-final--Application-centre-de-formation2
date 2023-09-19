package com.intiFormation.service;

import java.util.List;
import java.util.Optional;

import com.intiFormation.entity.Paiement;

public interface IpaiementService {
	public Paiement ajouter(Paiement paiement);
	public void supprimer(int id);
	public Optional<Paiement> selectById(int id);
	public List<Paiement> selectAll();
}
