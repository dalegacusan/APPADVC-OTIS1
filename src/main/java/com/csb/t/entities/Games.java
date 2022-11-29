package com.csb.t.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "Games")
public class Games {
    public Long getGameid() {
        return gameid;
    }

    public void setGameid(Long gameid) {
        this.gameid = gameid;
    }

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getRound() {
        return round;
    }

    public void setRound(int round) {
        this.round = round;
    }

    @Id
    @GeneratedValue(strategy =
            GenerationType.IDENTITY)
    private Long gameid;

    @ManyToOne
    @JoinColumn(name = "userid", nullable = false)
    private Users users;

    @Column(name = "score", nullable = false)
    private int score;

    @Column(name = "round", nullable = false)
    private int round;

    public Games(){}
}
