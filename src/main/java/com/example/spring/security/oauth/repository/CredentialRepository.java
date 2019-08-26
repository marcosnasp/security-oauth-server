package com.example.spring.security.oauth.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.spring.security.oauth.domain.Credentials;

public interface CredentialRepository extends JpaRepository<Credentials, Long> {
	Credentials findByName(String name);
}