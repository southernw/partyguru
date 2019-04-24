package com.example.project;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseException;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class AccountActivity extends AppCompatActivity {

    private EditText firstname, lastname, email, password, phonenum;
    FirebaseAuth firebaseAuth;
    FirebaseDatabase firebaseDatabase;
    FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
    Button updateButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account);

        firstname = findViewById(R.id.txtfirst_name);
        lastname = findViewById(R.id.txtlast_name);
        email = findViewById(R.id.txt_email);
        password = findViewById(R.id.txt_password);
        phonenum = findViewById(R.id.txtphone_num);

        firebaseAuth = FirebaseAuth.getInstance();
        firebaseDatabase = FirebaseDatabase.getInstance();
        updateButton = findViewById(R.id.btnUpdate);

        updateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateUserInfo();
            }
        });

        DatabaseReference databaseReference = firebaseDatabase.getReference(firebaseAuth.getUid());
            databaseReference.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                    final DatabaseReference databaseReference = firebaseDatabase.getReference(firebaseAuth.getUid());
                    User currentUser = dataSnapshot.child("User").getValue(User.class);
                    firstname.setText(currentUser.getFirstName());
                    lastname.setText(currentUser.getLastName());
                    email.setText(currentUser.getEmail());
                    password.setText(currentUser.getPassword());
                    phonenum.setText(currentUser.getPhoneNum());
                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {
                    Toast.makeText(AccountActivity.this, databaseError.getMessage(), Toast.LENGTH_LONG).show();
                }
            });
        }

        private void updateUserInfo() {
            DatabaseReference databaseReference = firebaseDatabase.getReference(firebaseAuth.getUid());

            try {
                databaseReference.child("User").child("email").setValue(email.getText().toString().trim());
                databaseReference.child("User").child("firstName").setValue(firstname.getText().toString().trim());
                databaseReference.child("User").child("lastName").setValue(lastname.getText().toString().trim());
                databaseReference.child("User").child("password").setValue(password.getText().toString().trim());
                databaseReference.child("User").child("phoneNum").setValue(phonenum.getText().toString().trim());

                Toast.makeText(this,"User information updated. ", Toast.LENGTH_LONG).show();
            } catch (DatabaseException e) {
                Toast.makeText(this, e.getMessage(), Toast.LENGTH_LONG).show();
            }
        }
}
