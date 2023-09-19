package com.intiFormation.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.intiFormation.dao.IpaiementDao;
import com.intiFormation.entity.Paiement;

@Service
public class PaiementService implements IpaiementService{
	@Autowired
	IpaiementDao dao;

	@Override
	public Paiement ajouter(Paiement paiement) {
		return dao.save(paiement);
	}

	@Override
	public void supprimer(int id) {
		dao.deleteById(id);
	}

	@Override
	public Optional<Paiement> selectById(int id) {
		return dao.findById(id);
	}

	@Override
	public List<Paiement> selectAll() {
		return dao.findAll();
}}
