package com.fabianotessarolo.todo.api;

import com.fabianotessarolo.todo.model.Todo;


import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

/**
 * Created by fabiano.tessarolo on 04/03/18.
 */

public interface TodoAPI {

    @GET(value = "/todo/descricao/{descricao}")
    Call<Todo> search(@Path(value = "descricao") String descricao);

    @POST(value = "/todo")
    Call<Void> save(@Body Todo todo);

    @GET(value = "/todo")
    Call<List<Todo>> list();





}
