package com.fabianotessarolo.todo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.fabianotessarolo.todo.api.TodoAPI;
import com.fabianotessarolo.todo.model.Todo;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class CreateTodoActivity extends AppCompatActivity {

    private EditText etDescricao;
    private CheckBox etDone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_todo);
        etDescricao = (EditText) findViewById(R.id.etDescricao);
        etDone = (CheckBox) findViewById(R.id.etDone);
    }

    private Retrofit getRetrofit() {
        return new Retrofit.Builder()
                .baseUrl("https://android-trabalho-final-api.herokuapp.com/")
                .addConverterFactory(GsonConverterFactory.create()).build();
    }

    public void save (View v) {
        TodoAPI api = getRetrofit().create(TodoAPI.class);
        Todo todo = new Todo();
        todo.setDescricao(etDescricao.getText().toString());
        todo.setDone(etDone.isChecked());
        api.save(todo).enqueue(new Callback<Void>() {

            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                Toast.makeText(CreateTodoActivity.this,
                        "Gravado com sucesso",
                        Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {
                Toast.makeText(CreateTodoActivity.this,
                        "Erro ao gravar",
                        Toast.LENGTH_SHORT).show();
            }
        });


    }
}
