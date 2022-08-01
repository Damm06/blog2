package com.project.blog2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class Blog2Application {

	public static void main(String[] args) {
		SpringApplication.run(Blog2Application.class, args);
	}

}
