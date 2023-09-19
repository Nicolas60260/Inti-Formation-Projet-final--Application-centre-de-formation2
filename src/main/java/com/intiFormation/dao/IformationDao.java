package com.intiFormation.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.intiFormation.entity.Formation;

public interface IformationDao  extends JpaRepository<Formation, Integer>{

}
