package com.intiFormation.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.intiFormation.entity.Appel;
import com.intiFormation.entity.Prospect;

public interface IprospectDao extends JpaRepository<Prospect, Integer>{
}
