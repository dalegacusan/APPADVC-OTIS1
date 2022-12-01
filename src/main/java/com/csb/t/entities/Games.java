package com.csb.t.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
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

    @Column(name = "round", nullable = false)
    private int round;

    @Column(name = "datecreated", updatable = false, nullable = false, columnDefinition="TIMESTAMP default CURRENT_TIMESTAMP on update CURRENT_TIMESTAMP")
    @CreationTimestamp
    private LocalDateTime datecreated;
}
