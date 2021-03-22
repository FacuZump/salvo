package com.codeoftheweb.salvo;

import org.hibernate.annotations.GenericGenerator;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
public class Game {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private long id;
    private LocalDateTime userDate;

    public Game() { }

    public Game(LocalDateTime userDate) {
        this.userDate = userDate;
    }

    public LocalDateTime getUser() {
        return userDate;
    }

    public void setUser(LocalDateTime userName) {
        this.userDate = userName;
    }

    public LocalDateTime toLocalDateTime() {
        return userDate;
    }
}