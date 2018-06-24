package com.projetoOO.projetoOO;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan(basePackages = {"com.projetoOO.projetoOO.projModel"})
@EnableJpaRepositories(basePackages = {"com.projetoOO.projetoOO.projRepository"})
@ComponentScan(basePackages = {"com.projetoOO.projetoOO.projController"})

public class ProjetoOoApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProjetoOoApplication.class, args);
	}
}
