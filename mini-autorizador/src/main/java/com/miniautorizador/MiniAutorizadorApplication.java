package com.miniautorizador;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@EntityScan(basePackages = {"com.miniautorizador.model"})
@ServletComponentScan(basePackages = {"com.miniautorizador.*"})
@EnableJpaRepositories(basePackages = {"com.miniautorizador.repository"})
@EnableTransactionManagement
@EnableWebMvc
@RestController
@EnableAutoConfiguration
public class MiniAutorizadorApplication {

	public static void main(String[] args) {
		SpringApplication.run(MiniAutorizadorApplication.class, args);
	}

}
