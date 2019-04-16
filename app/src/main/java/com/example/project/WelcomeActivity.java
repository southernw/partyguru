package com.example.project;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class WelcomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.welcome_activity);


        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
               final Intent intent = new Intent(WelcomeActivity.this, LoginActivity.class);   // create login activity intent, will pause five seconds
                WelcomeActivity.this.startActivity(intent);                                                // and then launch main activity
                WelcomeActivity.this.finish();
            }
        }, 5000);

    }
}
