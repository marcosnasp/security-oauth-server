package com.example.spring.security.oauth;

import javax.sql.DataSource;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.oauth2.provider.client.JdbcClientDetailsService;

import com.example.spring.security.oauth.config.JdbcUserDetails;

@SpringBootApplication
public class SecurityOauthServerApplication {

	@Bean
	@ConfigurationProperties(prefix = "spring.datasource")
	public DataSource oauthDataSource() {
		return DataSourceBuilder.create().build();
	}

	@Bean
	public JdbcClientDetailsService clientDetailsService() {
		return new JdbcClientDetailsService(oauthDataSource());
	}
	
	@Bean
	public UserDetailsService userDetailsServiceBean() throws Exception {
		return new JdbcUserDetails();
	}
	
	public static void main(String[] args) {
		SpringApplication.run(SecurityOauthServerApplication.class, args);
	}

}
