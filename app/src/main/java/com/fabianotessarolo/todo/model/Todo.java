package com.fabianotessarolo.todo.model;

/**
 * Created by fabiano.tessarolo on 04/03/18.
 */

public class Todo {


    private String id;
    private String descricao;
    private boolean done;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }

}
