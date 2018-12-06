package com.example.wafa.studentapp;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.SpannableString;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class ContactUS extends AppCompatActivity {

    TextView contac_us  , link,txt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_us);


        //Row Back
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
       setTitle("              ");

        TextView textView = (TextView) findViewById(R.id.tv_text);

        textView.setText(new SpannableString(textView.getText()));

        TextJustification.justify(textView);     //Text Justification  class for paragraph


        TextView email1 = (TextView) findViewById(R.id.email1);
        email1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //open email to sind

                Intent i = new Intent(Intent.ACTION_SENDTO, Uri.fromParts("mailto", "ParentStudentApp@gmail.com", null));
                // i.putExtra(Intent.EXTRA_SUBJECT,"");
                // i.putExtra(Intent.EXTRA_TEXT,"body");
                startActivity(Intent.createChooser(i, "Send email ."));
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
    }}