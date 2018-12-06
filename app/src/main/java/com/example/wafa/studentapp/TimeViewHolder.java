package com.example.wafa.studentapp;

import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

public class TimeViewHolder extends RecyclerView.ViewHolder {

    View mView;

    TextView textTitle, textTime , textDate;
    CardView noteCard;


    public TimeViewHolder(@NonNull View itemView) {
        super(itemView);

        mView = itemView;

        textTitle = mView.findViewById(R.id.note_title);
        textTime = mView.findViewById(R.id.note_time);
        ////// this
        textDate=mView.findViewById(R.id.tableDate);
        noteCard = mView.findViewById(R.id.note_card);
    }

    public void setNoteTitle(String title) {

        textTitle.setText(title);
    }

    ///// this

    public void setNoteDate(String date){
        textDate.setText(date);
    }

    public void setNoteTime(String time) {

        textTime.setText(time);
    }
}

