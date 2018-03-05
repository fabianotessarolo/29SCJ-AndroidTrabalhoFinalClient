package com.fabianotessarolo.todo.api;

import com.fabianotessarolo.todo.model.Login;
import com.fabianotessarolo.todo.model.Todo;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

/**
 * Created by fabiano.tessarolo on 04/03/18.
 */

public interface LoginAPI {

    @POST(value = "/app/login")
    Call<Login> login(@Body Login login);

}
