package com.intiFormation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.intiFormation.config.AuthentificationRequest;
import com.intiFormation.config.AuthentificationResponse;
import com.intiFormation.config.jwtUtil;

@RestController
@CrossOrigin("http://localhost:4200")
public class AuthentificationController {
	
	@Autowired
	private jwtUtil jwtokenUtil;
	
	@Autowired		
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private UserDetailsService customUserDetailsService;

	@RequestMapping(value="/login" ,method =RequestMethod.POST) // Ou  @PostMapping sans le RequestMethod.POST
	public AuthentificationResponse authenticate(@RequestBody AuthentificationRequest authentificationRequest) throws Exception
	{
		System.out.println("---------------------------------------------------");
		System.out.println(authentificationRequest.getPassword() + authentificationRequest.getUsername());
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authentificationRequest.getUsername(), authentificationRequest.getPassword()));
			System.out.println(authentificationRequest);
			
		} catch (BadCredentialsException e) {
			// TODO: handle exception
			throw new Exception("incorrect username ou password",e);
		}
		
		final UserDetails userdetails=customUserDetailsService.loadUserByUsername(authentificationRequest.getUsername());
		final String jwt=jwtokenUtil.generateToken(userdetails);
		
		
		return new AuthentificationResponse(jwt);}
}

