package com.fabianotessarolo.todo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.TextView;

import com.fabianotessarolo.todo.adapters.TodoArrayAdapter;
import com.fabianotessarolo.todo.api.TodoAPI;
import com.fabianotessarolo.todo.model.Todo;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity{


    private TextView id;
    private TextView descricao;
    private CheckBox done;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://android-trabalho-final-api.herokuapp.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        TodoAPI service = retrofit.create(TodoAPI.class);

        Call<List<Todo>> call = service.list();
        call.enqueue(new Callback<List<Todo>>() {

            @Override
            public void onResponse(Call<List<Todo>> call, Response<List<Todo>> response) {

                ArrayList<Todo> players = null;
                //todos = call;



                //ListView lv = (ListView) this.getView().findViewById(android.R.id.list);


                //TodoArrayAdapter adapter = new TodoArrayAdapter(getActivity(), todos);

                //lv.setAdapter(adapter);

                //List<Todo> todoData = response.body();

                try {

                    //List<Todo> todoData = response.body();



                } catch (Exception e) {
                    Log.d("onResponse", "There is an error");
                    e.printStackTrace();
                }
            }
            @Override
            public void onFailure(Call<List<Todo>> call, Throwable t) {
                Log.d("onFailure", t.toString());
            }
        });



        //list.setAdapter(adapter);

//
//        Button ButtonArray= (Button) findViewById(R.id.RetrofitArray);
//        Button ButtonObject= (Button) findViewById(R.id.RetrofitObject);
//
//        ButtonArray.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                View VisibleArray = findViewById(R.id.RetrofitArray);
//                VisibleArray.setVisibility(View.GONE);
//                View VisibleObject = findViewById(R.id.RetrofitObject);
//                VisibleObject.setVisibility(View.GONE);
//                getRetrofitArray();
//            }
//        });
//
//        ButtonObject.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                View VisibleArray = findViewById(R.id.RetrofitArray);
//                VisibleArray.setVisibility(View.GONE);
//                View VisibleObject = findViewById(R.id.RetrofitObject);
//                VisibleObject.setVisibility(View.GONE);
//                //getRetrofitObject();
//            }
//        });

    }



    void getRetrofitArray() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://android-trabalho-final-api.herokuapp.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        TodoAPI service = retrofit.create(TodoAPI.class);
        Call<List<Todo>> call = service.list();
        call.enqueue(new Callback<List<Todo>>() {

            @Override
            public void onResponse(Call<List<Todo>> call, Response<List<Todo>> response) {

                try {

                    List<Todo> todoData = response.body();

                    //ListView lv = (ListView) getView().findViewById(android.R.id.list);


                    //ListView lv = (ListView) getView().findViewById(android.R.id.list);
                    //ListView list = (ListView) findViewById(R.id.lista);

                    Log.d("Size", " " + todoData.size());

                    for (int i = 0; i < todoData.size(); i++) {


                        Log.d("iterating", todoData.get(i).getDescricao());

                        if (i == 0) {
                            //id.setText("StudentId  :  " + StudentData.get(i).getStudentId());
                            //descricao.setText("Descricao  :  " + todoData.get(i).getDescricao());
                           // done.set("Done  :  " + todoData.get(i).getDescricao());

                        } else if (i == 1) {
                            //id.setText("StudentId  :  " + StudentData.get(i).getStudentId());
                            //descricao.setText("Descricao  :  " + todoData.get(i).getDescricao());
                            // done.set("Done  :  " + todoData.get(i).getDescricao());
                        }
                    }


                } catch (Exception e) {
                    Log.d("onResponse", "There is an error");
                    e.printStackTrace();
                }
            }
            @Override
            public void onFailure(Call<List<Todo>> call, Throwable t) {
                Log.d("onFailure", t.toString());
            }
        });
    }
}



