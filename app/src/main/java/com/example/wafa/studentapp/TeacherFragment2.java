package com.example.wafa.studentapp;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.squareup.picasso.Picasso;

import de.hdodenhof.circleimageview.CircleImageView;


/**
 * A simple {@link Fragment} subclass.
 */
public class TeacherFragment2 extends Fragment {   //IT443
    RecyclerView mUserList;
    DatabaseReference mDatabase;
    private View mMainView;

    public TeacherFragment2() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        mMainView=inflater.inflate(R.layout.fragment_teacher_fragment2, container, false);



        mUserList = (RecyclerView) mMainView.findViewById(R.id.users_list);
        mUserList.setHasFixedSize(true);
        mUserList.setLayoutManager(new LinearLayoutManager(getContext()));
        mDatabase = FirebaseDatabase.getInstance().getReference().child("Student");


        // Inflate the layout for this fragment
        return mMainView;
    }



    @Override
    public void onStart() {
        super.onStart();

        FirebaseRecyclerAdapter<User , StudentChatTeacher.UserViewHolder> firebaseRecyclerAdapter = new FirebaseRecyclerAdapter<User, StudentChatTeacher.UserViewHolder>(
                User.class,
                R.layout.user_single_item,
                StudentChatTeacher.UserViewHolder.class,
                mDatabase
        ) {
            @Override
            protected  void populateViewHolder(final StudentChatTeacher.UserViewHolder viewHolder, User model, int position) {



                // __ To get ID for Specific user __ !

                FirebaseUser firebaseUser = FirebaseAuth.getInstance().getCurrentUser();


                final  String currntUser = firebaseUser.getUid();
                final String user_id = getRef(position).getKey();



                viewHolder.setName(model.getName());

                viewHolder.setUserImage(model.getImage() , getContext());






                viewHolder.mView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        Intent i = new Intent(getContext(), editStudentIT443.class);
                        i.putExtra("user_id" , user_id);
                        startActivity(i);
                    }
                });

            }
        };

        mUserList.setAdapter(firebaseRecyclerAdapter);
    }

    public static class UserViewHolder extends  RecyclerView.ViewHolder{

        View mView;


        public UserViewHolder(View itemView) {
            super(itemView);
            mView = itemView;
        }



        public void  setName(String name){

            TextView UserName = (TextView) mView.findViewById(R.id.user_single_name);


            UserName.setText(name);
        }

        public  void setUserImage(String image, Context ctx){

            CircleImageView userImageView = (CircleImageView) mView.findViewById(R.id.user_single_img);

            Picasso.with(ctx).load(image).placeholder(R.drawable.default_img).into(userImageView);
        }


    }


}




