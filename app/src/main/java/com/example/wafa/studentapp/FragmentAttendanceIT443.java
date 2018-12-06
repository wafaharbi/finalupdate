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
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.squareup.picasso.Picasso;

import de.hdodenhof.circleimageview.CircleImageView;


/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentAttendanceIT443 extends Fragment {

    RecyclerView mUserList;
    DatabaseReference mDatabase;
    private View mMainView;
    public FragmentAttendanceIT443() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)  {
        // Inflate the layout for this fragment
        mMainView=inflater.inflate(R.layout.fragment_parents, container, false);



        mUserList = (RecyclerView) mMainView.findViewById(R.id.parents_list);

        mUserList.setHasFixedSize(true);
        mUserList.setLayoutManager(new LinearLayoutManager(getContext()));
        mDatabase = FirebaseDatabase.getInstance().getReference().child("Student");
        // Inflate the layout for this fragment
        return mMainView;
    }


    @Override
    public void onStart() {
        super.onStart();

        FirebaseRecyclerAdapter<User , FragmentAttendanceCS214.UserViewHolder> firebaseRecyclerAdapter = new FirebaseRecyclerAdapter<User,FragmentAttendanceCS214.UserViewHolder>(
                User.class,
                R.layout.user_single_item,
                FragmentAttendanceCS214.UserViewHolder.class,
                mDatabase
        ) {
            @Override
            protected void populateViewHolder(FragmentAttendanceCS214.UserViewHolder viewHolder, User model, int position) {

                viewHolder.setName(model.getName());

                viewHolder.setUserImage(model.getImage() , getContext());


                // __ To get ID for Specific user __ !
                final String user_id = getRef(position).getKey();


                viewHolder.mView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        Intent i = new Intent(getContext(), ToAttendanceIT443.class);
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



