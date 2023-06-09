package com.springOAuth2.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.springOAuth2.repo.UserRepository;

@Service
public class LoginUserDetailsService implements UserDetailsService {
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
		Optional<com.springOAuth2.entity.User> emp = userRepository.findByName(name);
		com.springOAuth2.entity.User em = emp.orElseThrow(() -> new UsernameNotFoundException("User Not found exp"));
		return new User(em.getName(),em.getPassword(),em.getRoles());
	}

}
