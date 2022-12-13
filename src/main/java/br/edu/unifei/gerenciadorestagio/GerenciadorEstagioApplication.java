package br.edu.unifei.gerenciadorestagio;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing

public class GerenciadorEstagioApplication {

	public static void main(String... args) {

		SpringApplication.run(GerenciadorEstagioApplication.class, args);
	}

}
