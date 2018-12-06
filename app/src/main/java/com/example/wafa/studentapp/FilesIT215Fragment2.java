package com.example.wafa.studentapp;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;



/**
 * A simple {@link Fragment} subclass.
 */
public class FilesIT215Fragment2 extends Fragment {

    private View mMainView;

    private DatabaseReference mUserDatabase,currentUser , mAttendance;   //databaseReference

    private FirebaseUser mCurrentUser;
//Android Layout

    CircleImageView mDisplayImage;
    Button mNameBtn, mImageBtn , update;
    ListView listView , listView2;
    TextView Viewname;
    public FilesIT215Fragment2() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        mMainView=inflater.inflate(R.layout.fragment_files_it215_fragment2, container, false);



        listView = (ListView) mMainView.findViewById(R.id.listInfoStudent);
        listView2 = (ListView) mMainView.findViewById(R.id.list2);


        mCurrentUser = FirebaseAuth.getInstance().getCurrentUser();
        String current_uid = mCurrentUser.getUid();

        currentUser = FirebaseDatabase.getInstance().getReference().child("Student").child(current_uid);
        Viewname = (TextView) mMainView.findViewById(R.id.nameView);


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


        //Student
        mUserDatabase = FirebaseDatabase.getInstance().getReference().child("Student").child(current_uid).child("IT215");
        mUserDatabase.keepSynced(true);

        mUserDatabase.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {


                showUserProfile(dataSnapshot);


            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });


        mAttendance = FirebaseDatabase.getInstance().getReference().child("Student").child(current_uid).child("IT215").child("absence");

        mAttendance.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                showAttendance(dataSnapshot);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        // Inflate the layout for this fragment
        return mMainView;
    }

    public void showAttendance(DataSnapshot dataSnapshot) {
        final Attendance attendance = new Attendance();

        for (DataSnapshot ds : dataSnapshot.getChildren()) {

            final String weeks = attendance.setWeek(dataSnapshot.child("week").getValue().toString());
            final String days = attendance.setDay(dataSnapshot.child("day").getValue().toString());
            final String dates = attendance.setDate(dataSnapshot.child("date").getValue().toString());


            ArrayList<String> arrayList = new ArrayList<>();
            arrayList.add(weeks);
            arrayList.add(days);
            arrayList.add(dates);
            ArrayAdapter arrayAdapter = new ArrayAdapter(getContext(), android.R.layout.simple_list_item_1, arrayList);

            listView2.setAdapter(arrayAdapter);

        }


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
            array.add(quiz);
            array.add(mid);
            array.add(finals);
            array.add(total);

            ArrayAdapter arrayAdapter = new ArrayAdapter(getContext(), android.R.layout.simple_list_item_1, array);

            listView.setAdapter(arrayAdapter);


        }
    }


}


