package com.example.project;

import android.arch.persistence.room.Database;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseException;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class ExistingPartyActivity extends AppCompatActivity {
    FirebaseAuth firebaseAuth;
    FirebaseDatabase firebaseDatabase;
    FirebaseUser user;
    TextView txtPartyTime, txtPartyDate, txtPartyTheme, txtPartyName, txtPartyLocation, txtNumGuests, txtPartyColors;
    Button getRes;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_existing_party);

        user = FirebaseAuth.getInstance().getCurrentUser();
        firebaseAuth = FirebaseAuth.getInstance();
        firebaseDatabase = FirebaseDatabase.getInstance();

        txtPartyTime = findViewById(R.id.txt_party_time);
        txtPartyDate = findViewById(R.id.txt_party_date);
        txtPartyTheme = findViewById(R.id.txt_party_theme);
        txtPartyName = findViewById(R.id.txt_party_name);
        txtPartyLocation = findViewById(R.id.txt_party_location);
        txtNumGuests = findViewById(R.id.txt_num_guests);
        txtPartyColors = findViewById(R.id.txt_party_colors);
        getRes = findViewById(R.id.btnGetRes);

        getRes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatabaseReference databaseReference = firebaseDatabase.getReference(firebaseAuth.getUid());


                databaseReference.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        DatabaseReference databaseReference = firebaseDatabase.getReference(firebaseAuth.getUid());
                        Party party = dataSnapshot.child("Party").getValue(Party.class);
                       try{
                           txtPartyTime.setText(party.getPartyTime());
                           txtPartyDate.setText(party.getPartyDate());
                           txtPartyTheme.setText(party.getPartyTheme());
                           txtPartyName.setText(party.getPartyName());
                           txtPartyLocation.setText(party.getPartyLocation());
                           txtNumGuests.setText(party.getPartyNumGuests());
                           txtPartyColors.setText(party.getPartyColors());
                       }catch(NullPointerException e){
                           Toast.makeText(ExistingPartyActivity.this, "Error, no party found.", Toast.LENGTH_SHORT).show();
                       }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {}
                });
            }
        });

    }
}
