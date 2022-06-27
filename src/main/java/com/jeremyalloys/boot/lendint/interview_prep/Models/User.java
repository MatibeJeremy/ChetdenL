package com.jeremyalloys.boot.lendint.interview_prep.Models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Column;

// Database User object representation. Play around!
@Entity
@Table(name="USERS")
public class User {
    @Id
    @Column(name="ID")
    @GeneratedValue
    private long id;
    @Column(name="EMAIL")
    private String email;
    @Column(name="FIRST_NAME")
    private String first_name;

    public User() {
        super();
    }

    public User(long id, String email, String first_name) {
        super();
        this.id = id;
        this.email = email;
        this.first_name = first_name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return first_name;
    }

    public void setFirstName(String name) {
        this.first_name = name;
    }

    
}
