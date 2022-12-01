package com.csb.t.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "Roles")
public class Roles {
    @Id
    @GeneratedValue(strategy =
            GenerationType.IDENTITY)
    private Long roleid;

    @Column(name = "role", nullable = false, length = 50)
    private String role;
}
