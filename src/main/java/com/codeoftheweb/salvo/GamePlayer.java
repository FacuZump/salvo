package com.codeoftheweb.salvo;

import org.hibernate.annotations.GenericGenerator;
import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class GamePlayer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private long id;

    private LocalDateTime LocalDate;

    @ManyToOne
    @JoinColumn(name = "player_id")
    public Player player;

    @ManyToOne
    @JoinColumn(name = "game_id")
    public Game game;

    @ManyToOne
    @JoinColumn(name = "ship_id")
    public Ship ship;

    public GamePlayer() {}

    public GamePlayer(LocalDateTime localDate, Game game, Player player){
        this.LocalDate = localDate;
        this.player = player;
        this.game = game;

    }

    public LocalDateTime getLocalDate() {
        return LocalDate;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setLocalDate(LocalDateTime localDate) {
        LocalDate = localDate;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public Ship getShip() {
        return ship;
    }

    public void setShip(Ship ship) {
        this.ship = ship;
    }
}

