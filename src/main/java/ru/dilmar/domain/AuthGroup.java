package ru.dilmar.domain;

import javax.persistence.*;

@Entity
public class AuthGroup {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private int id;

    private String username;


    private String authgroup;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAuthgroup() {
        return authgroup;
    }

    public void setAuthgroup(String authgroup) {
        this.authgroup = authgroup;
    }
}
