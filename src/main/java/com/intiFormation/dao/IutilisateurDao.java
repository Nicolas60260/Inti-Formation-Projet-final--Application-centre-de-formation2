package com.intiFormation.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.intiFormation.entity.Utilisateur;


public interface IutilisateurDao extends JpaRepository <Utilisateur,Integer>{

}
