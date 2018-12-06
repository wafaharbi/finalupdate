package com.example.wafa.studentapp;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class CourseParentCS383 extends AppCompatActivity {

    FirebaseAuth auth;
    FirebaseUser parentUser, StudentUser;
    DatabaseReference currentRef , studentRef;
    ListView listView ,listView2;
    String username;

    TextView names;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course_parent_cs383);

        listView = (ListView) findViewById(R.id.listInfoStudent);
        listView2 =(ListView) findViewById(R.id.list2);
        names = (TextView) findViewById(R.id.nameView);


        auth= FirebaseAuth.getInstance();
        parentUser = auth.getCurrentUser();

        currentRef = FirebaseDatabase.getInstance().getReference().child("Parents").child(parentUser.getUid());

        studentRef = FirebaseDatabase.getInstance().getReference().child("Student");

        String uid = FirebaseAuth.getInstance().getUid();

        currentRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                username = dataSnapshot.child("username").getValue(String.class);
                System.out.println(username);

                studentRef = FirebaseDatabase.getInstance().getReference().child("Student");

                Query studentQuery = studentRef.orderByChild("username").equalTo(username);
                studentQuery.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        for (DataSnapshot studentSnapshot: dataSnapshot.getChildren()) {
                            String key = studentSnapshot.getKey();
                            String email = studentSnapshot.child("email").getValue(String.class);
                            System.out.println(key+": "+email);

                            show(studentSnapshot);
                            showName(studentSnapshot);

                            showAttendance(studentSnapshot);



                           /* Intent i = new Intent(getApplicationContext(), ParentHome.class);
                            startActivity(i);
                            Log.v("*****************" ,"###############");*/
                        }

                    }
                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {
                        throw databaseError.toException(); // don't ignore errors
                    }
                });
            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                throw databaseError.toException(); // don't ignore errors
            }
        });


        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
       // setTitle("            CS2383");
    }



    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == android.R.id.home) {
            this.finish();
        }
        return super.onOptionsItemSelected(item);

    }


    public void showName(DataSnapshot dataSnapshot){
        final User user = new User();

        for(DataSnapshot da: dataSnapshot.getChildren()){

            final String name  = user.setName(dataSnapshot.child("name").getValue().toString());

            names.setText(name);
        }
    }



    public void showAttendance(DataSnapshot dataSnapshot){

        final Attendance attendance = new Attendance();
        for(DataSnapshot ds: dataSnapshot.getChildren()){

            final String weeks = attendance.setWeek(dataSnapshot.child("CS383").child("absence").child("week").getValue().toString());
            final String days = attendance.setDay(dataSnapshot.child("CS383").child("absence").child("day").getValue().toString());
            final String dates = attendance.setDate(dataSnapshot.child("CS383").child("absence").child("date").getValue().toString());


            ArrayList<String> arrayList = new ArrayList<>();
            arrayList.add(weeks);
            arrayList.add(days);
            arrayList.add(dates);
            ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, arrayList);

            listView2.setAdapter(arrayAdapter);
        }

    }

    public  void show(DataSnapshot dataSnapshot){

        final Marks info = new Marks();

        for(DataSnapshot ds: dataSnapshot.getChildren()) {

            final int quiz = info.setQuize((Integer)dataSnapshot.child("CS383").child("quiz").getValue(Integer.class));
            final int mid = info.setMid((Integer)dataSnapshot.child("CS383").child("mid").getValue(Integer.class));
            final int finals = info.setFinals((Integer)dataSnapshot.child("CS383").child("finals").getValue(Integer.class));
            final int total  = mid + quiz + finals;

            ArrayList<Integer> array = new ArrayList<>();

            //array.add(name);
            //array.add(attendance);
            array.add(quiz);
            array.add(mid);
            array.add(finals);
            array.add(total);

            ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, array);
            listView.setAdapter(arrayAdapter);

        }
    }
}
