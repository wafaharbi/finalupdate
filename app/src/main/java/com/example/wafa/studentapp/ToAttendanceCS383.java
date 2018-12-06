package com.example.wafa.studentapp;

import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ToAttendanceCS383 extends AppCompatActivity {

    DatabaseReference reference , currentUser;
    FloatingActionButton floatingActionButton;
    public String user_id;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_to_attendance_cs383);


        floatingActionButton = (FloatingActionButton) findViewById(R.id.fab);


        user_id=   getIntent().getStringExtra("user_id");


        currentUser = FirebaseDatabase.getInstance().getReference().child("Student").child(user_id).child("CS383").child("absence");

        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                SaveAttendance();

            }
        });


        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        setTitle("            ");

    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == android.R.id.home) {
            this.finish();
        }
        return super.onOptionsItemSelected(item);

    }

    public void SaveAttendance(){

        EditText weeks = (EditText)findViewById(R.id.weekEdit);
        EditText days = (EditText)findViewById(R.id.dayedit);

        final String w = weeks.getText().toString();
        final  String d= days.getText().toString();
        DatePicker picker= (DatePicker) findViewById( R.id.datePicker);

        Date date = new Date();

        date.setMonth(picker.getMonth());
        date.setYear(picker.getYear());
        date.setDate(picker.getDayOfMonth());

        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy  HH:mm");

        final String dateFormat = format.format(date);

        currentUser.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                Attendance attendance = new Attendance();

                dataSnapshot.getRef().child("week").setValue(w);
                dataSnapshot.getRef().child("day").setValue(d);
                dataSnapshot.getRef().child("date").setValue(dateFormat);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });


    }

}
