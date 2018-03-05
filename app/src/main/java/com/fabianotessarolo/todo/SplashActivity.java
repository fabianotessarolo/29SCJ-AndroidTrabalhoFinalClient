package com.fabianotessarolo.todo;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class SplashActivity extends AppCompatActivity {

    private ImageView ivLogo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        ivLogo = findViewById(R.id.ivLogo);
        load();
    }

    private void load(){
        Animation animLogo = AnimationUtils.loadAnimation(this, R.anim.animacao_splash);
        animLogo.reset();

        if(ivLogo != null){
            ivLogo.clearAnimation();
            ivLogo.startAnimation(animLogo);
        }

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent nextScreen = new Intent(SplashActivity.this, LoginActivity.class);
                startActivity(nextScreen);
                SplashActivity.this.finish();
            }
        }, 3500);

    }
}
