package com.csb.t.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "Games")
public class Games {
    @Id
    @GeneratedValue(strategy =
            GenerationType.IDENTITY)
    private Long gameid;

    @ManyToOne
    @JoinColumn(name = "userid", nullable = false)
    private Users users;

    @Column(name = "score", nullable = false)
    private int score;

    public Games(){}
}
