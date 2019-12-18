package br.com.cinq;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {
	
	/**
	 * Requisicoes:
	 * http://localhost:8080/cities
	 * http://localhost:8080/cities?country=Uni
	 */
	
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
