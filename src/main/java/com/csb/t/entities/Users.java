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
@Table(name = "Users")
public class Users {
    @Id
    @GeneratedValue(strategy =
            GenerationType.IDENTITY)
    private Long userid;

    @Column(name = "username", nullable = false, length = 50)
    private String username;

    @Column(name = "email", nullable = false, length = 200)
    private String email;

    @Column(name = "password", nullable = false, length = 20)
    private String password;

    @Column(name = "roleid", nullable = false)
    private int roleid;

    @Column(name = "datecreated", updatable = false, nullable = false)
    @CreationTimestamp
    private LocalDateTime datecreated;
}
