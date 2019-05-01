package com.example.project;

import android.annotation.TargetApi;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.ContextThemeWrapper;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.DatePicker;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;


import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Calendar;

public class ReserveParty extends AppCompatActivity {
    FirebaseAuth firebaseAuth;
    FirebaseDatabase firebaseDatabase;
    FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
    DatePickerDialog datePickerDialog;
    TextView txtDate, txtTime, txtPartyColors, txtPartyLocation, txtPartyName,
    txtNumGuests, txtTheme;
    Switch switchBalloons, switchCake;
    Button btnReserve;
    Calendar calendar;
    int year, month, dayOfMonth;
    String balloons, cake = "No";
    PartyPlanner partyPlanner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reserve_party);


        firebaseAuth = FirebaseAuth.getInstance();
        btnReserve = findViewById(R.id.btnReserve);
        txtDate = findViewById(R.id.txtDate);
        txtTime = findViewById(R.id.txtPartyTime);
        txtPartyColors = findViewById(R.id.txtPartyColors);
        txtPartyLocation = findViewById(R.id.txtLocation);
        txtPartyName = findViewById(R.id.txtPartyName);
        txtNumGuests = findViewById(R.id.txtNumGuests);
        txtTheme = findViewById(R.id.txtPartyTheme);
       switchBalloons = findViewById(R.id.switchBalloons);
       switchCake = findViewById(R.id.switchCake);
        partyPlanner = new PartyPlanner();

        txtTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar currentTime = Calendar.getInstance();
                int hour = currentTime.get(Calendar.HOUR_OF_DAY);
                int minute = currentTime.get(Calendar.MINUTE);

                TimePickerDialog timePickerDialog;
                timePickerDialog = new TimePickerDialog(ReserveParty.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                        txtTime.setText(hourOfDay + ":" + minute + " PM");  // we'll just assume PM
                    }
                }, hour, minute, true);
                timePickerDialog.setTitle("select party time");
                timePickerDialog.show();
            }
        });

        txtDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calendar = Calendar.getInstance();
                year = calendar.get(Calendar.YEAR);
                month = calendar.get(Calendar.MONTH);
                dayOfMonth = calendar.get(Calendar.DAY_OF_MONTH);
                datePickerDialog = new DatePickerDialog(ReserveParty.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        txtDate.setText(month + "/" + dayOfMonth + "/" + year);
                    }
                }, year, month, dayOfMonth);
                datePickerDialog.show();
            }
        });


    switchBalloons.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            if (isChecked)
                balloons ="Yes";
        }
    });

                        switchCake.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                            @Override
                            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                                if (isChecked)
                                    cake ="Yes";
                            }
                        });

                        btnReserve.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                        if (txtDate.getText().toString().isEmpty() || txtTime.getText().toString().isEmpty() || txtNumGuests.getText().toString().isEmpty() ||
                        txtPartyColors.getText().toString().isEmpty() || txtPartyLocation.getText().toString().isEmpty() || txtPartyName.getText().toString().isEmpty() || txtTheme.getText().toString().isEmpty()){
                            Toast.makeText(ReserveParty.this, "Please fill out the required information", Toast.LENGTH_LONG).show();
                            return;
                        }else {
                            try {
                                FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
                               final DatabaseReference ref = firebaseDatabase.getReference(firebaseAuth.getUid());


                                ref.addListenerForSingleValueEvent(new ValueEventListener() {
                                    @Override
                                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                                        if (dataSnapshot.hasChild("Party")){
                                            Toast.makeText(ReserveParty.this,"Error, you already have a party reserved!", Toast.LENGTH_LONG).show();
                                            return;
                                        }else{

                                            Party newParty = new Party(balloons, cake, txtPartyColors.getText().toString(), txtDate.getText().toString(), txtPartyLocation.getText().toString(),
                                                    txtPartyName.getText().toString(), txtNumGuests.getText().toString(), txtTheme.getText().toString(), txtTime.getText().toString());
                                            ref.child("Party").setValue(newParty);
                                            Toast.makeText(ReserveParty.this,partyPlanner.getRandomName() + " has claimed your order! We will be in contact soon.", Toast.LENGTH_LONG).show();
                                        }
                                    }
                                    @Override
                                    public void onCancelled(@NonNull DatabaseError databaseError) {}
                                });

                            }catch(Exception e){
                                Toast.makeText(ReserveParty.this,"Error: " + e, Toast.LENGTH_LONG).show();
                            }
                        }
                            }
                        });
    }

}
