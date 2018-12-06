package com.example.wafa.studentapp;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class editStudentIT215 extends AppCompatActivity {

    DatabaseReference reference , currentUser ;

    ListView listView;
    Button btnEdit;

    TextView Viewname;
    public String user_id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_student_it215);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        setTitle("            ");
        btnEdit = (Button) findViewById(R.id.btnIT215);

        listView = (ListView) findViewById(R.id.listInfoStudent);


        user_id=   getIntent().getStringExtra("user_id");


        currentUser = FirebaseDatabase.getInstance().getReference().child("Student").child(user_id);



        Viewname = (TextView) findViewById(R.id.nameView);


        currentUser.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                User info = new User();

                for (DataSnapshot ds : dataSnapshot.getChildren()) {


                    final String name = info.setName(dataSnapshot.child("name").getValue().toString());

                    Viewname.setText(name);



                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });


        // sendMessage();

        reference = FirebaseDatabase.getInstance().getReference().child("Student").child(user_id).child("IT215");

        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {


                showUserProfile(dataSnapshot);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id=item.getItemId();
        if(id == android.R.id.home){
            this.finish();
        }
        return super.onOptionsItemSelected(item);
    }


    public void showUserProfile(DataSnapshot dataSnapshot) {

        final Marks info = new Marks();


        for (DataSnapshot ds : dataSnapshot.getChildren()) {


            // final String name = info.setName(dataSnapshot.child("name").getValue().toString());
            final int quiz = info.setQuize((Integer) dataSnapshot.child("quiz").getValue(Integer.class));
            final int mid = info.setMid((Integer) dataSnapshot.child("mid").getValue(Integer.class));
            final int finals = info.setFinals((Integer) dataSnapshot.child("finals").getValue(Integer.class));
            int total = quiz + mid + finals;
            //final String finals = dataSnapshot.child("image").getValue().toString();

            // Picasso.with(OtherStudentProfile.this).load(image).placeholder(R.drawable.default_img).into(mDisplayImage);

            ArrayList<Integer> array = new ArrayList<>();
            //array.add(name);
            // array.add(attendance);
            array.add(quiz);
            array.add(mid);
            array.add(finals);
            array.add(total);

            ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, array);

            listView.setAdapter(arrayAdapter);



            btnEdit.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {




                    Intent i = new Intent(getApplicationContext(), IT215MarkUpdate.class);

                    i.putExtra("user_id" , user_id);
                    //i.putExtra("attenda", info.getName());
                    i.putExtra("quiz", info.getQuize());
                    i.putExtra("mid", info.getMid());
                    i.putExtra("finals", info.getFinals());

                    startActivity(i);
                }
            });
        }
    }


}

