package com.csb.t.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "Roles")
public class Roles {
    @Id
    @GeneratedValue(strategy =
            GenerationType.IDENTITY)
    private Long roleid;

    @Column(name = "role", nullable = false, length = 50)
    private String role;

    public Roles(){}
}
