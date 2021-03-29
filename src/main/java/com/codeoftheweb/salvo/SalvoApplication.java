package com.codeoftheweb.salvo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import java.time.LocalDateTime;

@SpringBootApplication
public class SalvoApplication {
    public static void main(String[] args) {
        SpringApplication.run(SalvoApplication.class, args);
    }

    @Bean
    public CommandLineRunner initData(PlayerRepository playerRepository, GameRepository gameRepository, GamePlayerRepository gamePlayerRepository) {
        return (args) -> {

            Game game0 = new Game(LocalDateTime.now());
            Game game1 = new Game(LocalDateTime.now());
            Game game2 = new Game(LocalDateTime.now());
            Game game3 = new Game(LocalDateTime.now());
            Game game4 = new Game(LocalDateTime.now());

            Player player0 = new Player("j.bauer@ctu.gov");
            Player player1 = new Player("c.obrian@ctu.gov");
            Player player2 = new Player("kim_bauer@gmail.com");
            Player player3 = new Player("t.almeida@ctu.gov");

            gameRepository.save(game0);
            gameRepository.save(game1);
            gameRepository.save(game2);


            playerRepository.save(player0);
            playerRepository.save(player1);
            playerRepository.save(player2);
            playerRepository.save(player3);


            gamePlayerRepository.save(new GamePlayer(LocalDateTime.now(),game0, player0));
            gamePlayerRepository.save(new GamePlayer(LocalDateTime.now(),game0, player1));

            gamePlayerRepository.save(new GamePlayer(LocalDateTime.now(),game1, player2));
            gamePlayerRepository.save(new GamePlayer(LocalDateTime.now(),game1, player3));

            gamePlayerRepository.save(new GamePlayer(LocalDateTime.now(),game2, player1));
            gamePlayerRepository.save(new GamePlayer(LocalDateTime.now(),game2, player3));
        };

    }
}