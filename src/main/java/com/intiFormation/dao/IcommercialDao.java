package com.intiFormation.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.intiFormation.entity.Commercial;
import com.intiFormation.entity.Utilisateur;

public interface IcommercialDao extends JpaRepository <Commercial,Integer>{

}