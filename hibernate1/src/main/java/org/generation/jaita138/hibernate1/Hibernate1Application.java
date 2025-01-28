
package org.generation.jaita138.hibernate1;

import org.generation.jaita138.hibernate1.Repo.UtenteRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Hibernate1Application implements CommandLineRunner {

    private final UtenteRepository utenteRepository;

    public Hibernate1Application(UtenteRepository utenteRepository) {
        this.utenteRepository = utenteRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(Hibernate1Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        // Avvia CLI Manager
        CliManager cliManager = new CliManager(utenteRepository);
        cliManager.printOptions();
    }
}