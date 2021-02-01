package com.server.EmailAuthentication;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class EmailAuthenticationApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmailAuthenticationApplication.class, args);
	}

}
