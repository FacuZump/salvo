package com.codeoftheweb.salvo;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static java.util.stream.Collectors.toList;

@Entity
public class Ship {

    private String shipType;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private long id;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "ship")
    private Set<GamePlayer> gamePlayers = new HashSet<>();

    public Ship() {}

    public Ship(String shipType, GamePlayer gamePlayer){
        this.shipType = shipType;
        this.gamePlayer = gamePlayer;
    }

    public List<Ship> getShips() {
        return gamePlayers.stream().map(sub -> sub.getShip()).collect(toList());
    }

    public String getShipType() {
        return shipType;
    }

    public void setShipType(String shipType) {
        this.shipType = shipType;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Set<GamePlayer> getGamePlayers() {
        return gamePlayers;
    }

    public void setGamePlayers(Set<GamePlayer> gamePlayers) {
        this.gamePlayers = gamePlayers;
    }
}