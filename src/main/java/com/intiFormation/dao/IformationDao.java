package com.intiFormation.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.intiFormation.entity.Formation;
import java.util.List;
import java.util.Set;
import com.intiFormation.entity.Cours;


public interface IformationDao  extends JpaRepository<Formation, Integer>{
	public List<Formation> findByCours(Cours cours);
}
