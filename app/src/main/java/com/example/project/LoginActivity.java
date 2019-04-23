package com.example.project;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    EditText txtEmail, txtPassword;
    Button btnLogin, btnRegister;
    private FirebaseAuth firebaseAuth;
    private String mCustomToken;
    private final String TAG = "CUSTOMTAG";
    User currentUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        txtEmail = findViewById(R.id.txtEmail);
        txtPassword = findViewById(R.id.txtPassword);


        firebaseAuth = FirebaseAuth.getInstance();

        Button btnLogin = (Button) findViewById(R.id.btnLogin);
        btnLogin.setOnClickListener(this);
        Button btnRegister = (Button) findViewById(R.id.btnRegister);
        btnRegister.setOnClickListener(this);
    }

    public void onClick(View v) {

        if (v.getId() == R.id.btnLogin){
            if (txtEmail.getText().toString().isEmpty() || txtPassword.getText().toString().isEmpty()) {
                Toast.makeText(LoginActivity.this, "Please enter a username & password", Toast.LENGTH_SHORT).show();
                return;
            }
            String email = txtEmail.getText().toString().trim();
            String password = txtPassword.getText().toString().trim();


            firebaseAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if(task.isSuccessful()){

                        FirebaseUser firebaseUser = firebaseAuth.getInstance().getCurrentUser();
                        Toast.makeText(LoginActivity.this,"Successful", Toast.LENGTH_SHORT).show();

                        Intent newIntent = new Intent(LoginActivity.this, MainActivity.class);
                        LoginActivity.this.startActivity(newIntent);
                    }else{
                        Toast.makeText(LoginActivity.this,"Incorrect username/password", Toast.LENGTH_SHORT).show();
                    }
                }
            });

        }else{
            Intent myIntent = new Intent(LoginActivity.this, RegisterActivity.class);
            LoginActivity.this.startActivity(myIntent);
        }
    }

}
