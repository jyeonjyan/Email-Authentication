package com.server.EmailAuthentication;

import com.server.EmailAuthentication.service.EmailService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
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
