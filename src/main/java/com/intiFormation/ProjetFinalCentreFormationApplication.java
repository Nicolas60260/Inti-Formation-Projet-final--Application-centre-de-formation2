package com.intiFormation;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.intiFormation.entity.Role;
import com.intiFormation.service.IroleService;

@SpringBootApplication
public class ProjetFinalCentreFormationApplication {
	@Autowired
	private IroleService roleservice;

	public static void main(String[] args) {
		SpringApplication.run(ProjetFinalCentreFormationApplication.class, args);
	}

	@PostConstruct
	public void init() {
		Role ADMIN = new Role(1, "ADMIN");
		Role COMMERCIAL = new Role(2, "COMMERCIAL");
		Role FORMATEUR = new Role(3, "FORMATEUR");
		Role PARTICIPANT = new Role(4, "PARTICIPANT");

		roleservice.ajouterRole(ADMIN);
		roleservice.ajouterRole(COMMERCIAL);
		roleservice.ajouterRole(FORMATEUR);
		roleservice.ajouterRole(PARTICIPANT);

	}

}
