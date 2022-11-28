package com.csb.t.entities;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

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

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getRoleId() {
        return this.roleid;
    }

    public void setRoleId(int roleId) {
        this.roleid = roleId;
    }

    public LocalDateTime getDateCreated() {
        return this.datecreated;
    }

    public void setDateCreated(LocalDateTime dateCreated) {
        this.datecreated = dateCreated;
    }

    public Users(){}
}
