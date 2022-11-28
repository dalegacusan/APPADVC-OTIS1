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
    private Long UserId;

    @Column(name = "username", nullable = false, length = 50)
    private String Username;

    @Column(name = "email", nullable = false, length = 200)
    private String Email;

    @Column(name = "password", nullable = false, length = 20)
    private String Password;

    @Column(name = "roleid", nullable = false)
    private int RoleId;

    @Column(name = "datecreated", updatable = false, nullable = false)
    @CreationTimestamp
    private LocalDateTime dateCreated;

    public String getUsername() {
        return Username;
    }

    public void setUsername(String username) {
        Username = username;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public int getRoleId() {
        return RoleId;
    }

    public void setRoleId(int roleId) {
        RoleId = roleId;
    }

    public LocalDateTime getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(LocalDateTime dateCreated) {
        this.dateCreated = dateCreated;
    }

    public Users(){}
}
