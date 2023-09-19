package com.intiFormation.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.intiFormation.entity.Utilisateur;

@Service
public class CustomUserDetailsService implements UserDetailsService {

	@Autowired
	IutilisateurService utilisateurService;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Utilisateur utilisateur= utilisateurService.findByUsername(username).get();
		
		if(utilisateur==null) {
			throw new UsernameNotFoundException(username);
		}
		
		List<GrantedAuthority> authorities = getAuthorities(utilisateur);
		
		return new User(utilisateur.getUsername(),utilisateur.getPassword(),authorities);
	}
	
	private List<GrantedAuthority> getAuthorities(Utilisateur utilisateur){
		List<GrantedAuthority> authorities = new ArrayList<>();
		authorities.add(new SimpleGrantedAuthority(utilisateur.getRole().getNom()));
		
		return authorities;
		
	}
}
