package com.codeoftheweb.salvo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import java.time.LocalDate;

@SpringBootApplication
public class SalvoApplication {
    public static void main(String[] args) {
		SpringApplication.run(SalvoApplication.class, args);
	}

	LocalDate date = LocalDate.now();


    @Bean
    public CommandLineRunner initData(PlayerRepository repository) {
        return (args) -> {
            repository.save(new Player("j.bauer@ctu.gov"));
            repository.save(new Player("c.obrian@ctu.gov"));
            repository.save(new Player("kim_bauer@gmail.com"));
            repository.save(new Player("t.almeida@ctu.gov"));
        };

    }

    @Bean
    public CommandLineRunner initData(GameRepository repository) {
        return (args) -> {
            repository.save(new Game());
            repository.save(new Game());
            repository.save(new Game());
        };

    }
}
