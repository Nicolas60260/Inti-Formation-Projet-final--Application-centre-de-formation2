package com.intiFormation.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.intiFormation.entity.Commentaire;

public interface IcommentaireDao extends JpaRepository<Commentaire, Integer> {

}
