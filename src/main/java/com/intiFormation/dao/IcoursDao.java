package com.intiFormation.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.intiFormation.entity.Cours;

public interface IcoursDao  extends JpaRepository<Cours, Integer>{

}
