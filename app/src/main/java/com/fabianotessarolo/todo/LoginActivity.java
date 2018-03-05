package com.fabianotessarolo.todo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;
import com.fabianotessarolo.todo.sessions.SessionManagement;


public class LoginActivity extends AppCompatActivity {

    private EditText inputUsername, inputPassword;
    private ProgressBar progressBar;
    private Button btncadastrar, btnLogin, btnReset;

    // Session Manager Class
    SessionManagement session;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Session Manager
        session = new SessionManagement(getApplicationContext());


        if(session.isLoggedIn()){
            startActivity(new Intent(LoginActivity.this, MainActivity.class));
            finish();

        }

        setContentView(R.layout.activity_login);

        progressBar = findViewById(R.id.progressBar);
        inputUsername = findViewById(R.id.username);
        inputPassword = findViewById(R.id.password);
        btnLogin = findViewById(R.id.btn_login);
        btnReset = findViewById(R.id.btn_reset_password);
        btncadastrar = findViewById(R.id.btn_cadastrar);


        btncadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginActivity.this, CadastroUsuarioActivity.class));
            }
        });

        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginActivity.this, LoginActivity.class));
            }
        });

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = inputUsername.getText().toString().trim();
                String password  = inputPassword.getText().toString();

                if(TextUtils.isEmpty(username)){
                    Toast.makeText(getApplicationContext(), "Informe um email", Toast.LENGTH_SHORT).show();
                }

                if(TextUtils.isEmpty(password)){
                    Toast.makeText(getApplicationContext(), "Digite uma senha", Toast.LENGTH_SHORT).show();

                }

                //progressBar.setVisibility(View.VISIBLE);

                if (!username.isEmpty() && !password.isEmpty()){
                    session.createLoginSession(username,password);
                }


                if(session.isLoggedIn()){
                    startActivity(new Intent(LoginActivity.this, MainActivity.class));
                    finish();

                }



            }
        });

    }
}