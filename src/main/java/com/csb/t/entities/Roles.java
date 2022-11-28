package com.csb.t.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "Roles")
public class Roles {
    @Id
    @GeneratedValue(strategy =
            GenerationType.IDENTITY)
    private Long RoleId;

    @Column(name = "role", nullable = false, length = 50)
    private String Role;

    public Roles(){}
}
