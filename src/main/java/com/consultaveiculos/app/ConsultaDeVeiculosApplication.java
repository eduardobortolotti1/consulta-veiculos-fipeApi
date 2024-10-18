package com.consultaveiculos.app;

import com.consultaveiculos.app.Principal.Principal;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ConsultaDeVeiculosApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ConsultaDeVeiculosApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Principal principal = new Principal();
		principal.exibirMenu();
	}
}
