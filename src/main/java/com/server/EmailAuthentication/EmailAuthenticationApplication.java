package com.server.EmailAuthentication;

import org.junit.runner.RunWith;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootApplication
@EnableJpaAuditing
@RunWith(SpringRunner.class)
public class EmailAuthenticationApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmailAuthenticationApplication.class, args);
	}
}
