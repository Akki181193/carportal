package com.carportal.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "userTable1")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="username",nullable = false)
    private String username;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "mobile", nullable = false, length = 10)
    private String mobile;

    @Column(name = "password", nullable = false, length = 1000)
    private String password;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}