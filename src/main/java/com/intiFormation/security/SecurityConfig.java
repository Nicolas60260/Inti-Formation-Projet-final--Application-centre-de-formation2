package com.intiFormation.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.intiFormation.config.RequestFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	UserDetailsService userDetailsService;

	@Autowired
	private RequestFilter jwtrequestfilter;

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService);
	}

	@Bean
	protected AuthenticationManager authenticationManager() throws Exception { 
		// TODO Auto-generated method stub
		return super.authenticationManager();
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		http.csrf().disable().authorizeRequests().antMatchers(HttpMethod.OPTIONS).permitAll()
				.antMatchers("/login","/*/public/**","/dossiercours/**").permitAll()
				.antMatchers("/*/p/**").hasAnyAuthority("PARTICIPANT","ADMIN","FORMATEUR")
				.antMatchers("/*/pfc/**").hasAnyAuthority("PARTICIPANT","ADMIN","FORMATEUR","COMMERCIAL")
				.antMatchers("/*/cf/**").hasAnyAuthority("ADMIN","FORMATEUR","COMMERCIAL")
				.antMatchers("/*/pa/**").hasAnyAuthority("PARTICIPANT")
			    .antMatchers("/*/f/**").hasAnyAuthority("FORMATEUR","ADMIN")
			    .antMatchers("/*/c/**").hasAnyAuthority("ADMIN","COMMERCIAL")
				.antMatchers("/*/a/**").hasAnyAuthority("ADMIN")
				.anyRequest().authenticated()

				.and().sessionManagement()
				.sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
				.addFilterBefore(jwtrequestfilter, UsernamePasswordAuthenticationFilter.class);

	}

	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
}
