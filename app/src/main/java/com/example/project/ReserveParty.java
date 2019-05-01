package com.example.project;

import android.annotation.TargetApi;
import android.app.DatePickerDialog;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.ContextThemeWrapper;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.TimePicker;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Calendar;

public class ReserveParty extends AppCompatActivity {
    FirebaseAuth firebaseAuth;
    FirebaseDatabase firebaseDatabase;
    FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
    DatePickerDialog datePickerDialog;
    TextView txtDate;
    Button btnDatePicker, btnReserve;
    Calendar calendar;
    int year, month, dayOfMonth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reserve_party);


        new TimePicker(new ContextThemeWrapper(ReserveParty.this, android.R.style.Widget_Holo_Light));
        firebaseAuth = FirebaseAuth.getInstance();
        btnReserve = findViewById(R.id.btnReserve);
        btnDatePicker = findViewById(R.id.btnSelectDate);
        txtDate = findViewById(R.id.txtDate);

        Switch cakeSwitch = findViewById(R.id.switchBalloons);


        btnDatePicker.setOnClickListener(new View.OnClickListener() {
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



                        // cakeSwitch.setOnCheckedChangeListener

                        btnReserve.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {

                                FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
                                DatabaseReference ref = firebaseDatabase.getReference(firebaseAuth.getUid());
                                Party newParty = new Party("Yes", "Yes", "Yes", "Yes", "Yes", "Yes", "Yes", "Yes", "Yes");
                                ref.child("Party").setValue(newParty);

                            }
                        });
    }

}
