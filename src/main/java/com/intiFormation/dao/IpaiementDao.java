package com.intiFormation.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.intiFormation.entity.Paiement;

public interface IpaiementDao extends JpaRepository<Paiement, Integer>{

}
