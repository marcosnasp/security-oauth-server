package com.example.spring.security.oauth.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.example.spring.security.oauth.domain.Credentials;
import com.example.spring.security.oauth.repository.CredentialRepository;

public class JdbcUserDetails implements UserDetailsService {

	@Autowired
	private CredentialRepository credentialRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Credentials credentials = credentialRepository.findByName(username);

		if (credentials == null) {
			throw new UsernameNotFoundException("User" + username + "can not be found");
		}

		User user = new User(credentials.getName(), credentials.getPassword(), credentials.isEnabled(), true, true,
				true, credentials.getAuthorities());
		return user;

	}
}