package com.consultacarros.app;

import com.consultacarros.app.Principal.Principal;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ConsultaDeCarrosApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ConsultaDeCarrosApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Principal principal = new Principal();
		principal.exibirMenu();
	}
}
