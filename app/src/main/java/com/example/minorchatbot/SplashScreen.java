package com.example.minorchatbot;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;

public class SplashScreen extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_screen);



        YoYo.with(Techniques.FadeIn)
                .duration(2700)
                .repeat(0)
                .playOn(findViewById(R.id.companyLogo));
        YoYo.with(Techniques.FadeIn)
                .duration(2700)
                .repeat(0)
                .playOn(findViewById(R.id.CompanyName));

        final Handler handler = new Handler();
        final Runnable r = new Runnable() {
            public void run() {
                handler.postDelayed(this, 2700);
                getsavedValues();
            }
        };
        getsavedValues();
    }

    private void getsavedValues() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
