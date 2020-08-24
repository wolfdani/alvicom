package com.wolfdani.alvicom;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages={"com.wolfdani.alvicom.repository"})
public class AlvicomApplication {

	public static void main(String[] args) {
		SpringApplication.run(AlvicomApplication.class, args);
	}
}
