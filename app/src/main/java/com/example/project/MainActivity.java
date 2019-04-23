package com.example.project;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private FirebaseAuth mAuth;
    private FirebaseUser currentUser;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageView imgNewParty = (ImageView)findViewById(R.id.imgNewParty);
        imgNewParty.setOnClickListener(this);
        ImageView imgExistingParty = findViewById(R.id.imgExParty);
        imgExistingParty.setOnClickListener(this);
        ImageView imgAccount = findViewById(R.id.imgAccount);
        imgAccount.setOnClickListener(this);
        ImageView imgExit = findViewById(R.id.imgExit);
        imgExit.setOnClickListener(this);

    }
    

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.imgNewParty:
                Intent intent1 = new Intent(MainActivity.this, ReserveParty.class);
                MainActivity.this.startActivity(intent1);
                break;

            case R.id.imgExParty:
                //Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                //RegisterActivity.this.startActivity(intent);
                break;

            case R.id.imgAccount:
                Intent intent2 = new Intent(MainActivity.this, AccountActivity.class);
                MainActivity.this.startActivity(intent2);
                break;

            case R.id.imgExit:
                FirebaseAuth.getInstance().signOut();
                finish();
                System.exit(0);

        }
    }
}
