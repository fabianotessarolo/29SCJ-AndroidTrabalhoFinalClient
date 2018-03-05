package com.fabianotessarolo.todo.model;

/**
 * Created by fabiano.tessarolo on 04/03/18.
 */

public class Login {

    String username;
    String password;
    boolean logged;


    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isLogged() {
        return logged;
    }

    public void setLogged(boolean logged) {
        this.logged = logged;
    }
}


