package com.example.wafa.studentapp;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.method.LinkMovementMethod;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class University extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_university);
        //Arrow to return back
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //Text Justification
        TextView description1 = (TextView) findViewById(R.id.description1);  // Justify paragraph 1
        TextView description2 = (TextView) findViewById(R.id.description2);    // Justify paragraph 2

        setTitle("      ");

        description1.setText(new SpannableString(description1.getText()));

        TextJustification.justify(description1);     //Text Justification  class



        description2.setText(new SpannableString(description2.getText()));

        TextJustification.justify(description2);

         //by click the textview will open (link)website
        TextView txt = (TextView) findViewById(R.id.textView18);
        txt.setMovementMethod(LinkMovementMethod.getInstance());
    }

    //function call by Intent ACTION_CALL
    public void call(View v){

        String number = "01638000050";
        Uri call = Uri.parse("tel:" + number);
        Intent surf = new Intent(Intent.ACTION_CALL, call);
        startActivity(surf);
    }
    //function to show Location by Intent ACTION_VIEW
    public void showLocation(View v) {

        Uri gmmIntentUri = Uri.parse("geo:26.3605550,43.7676730");
        Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
        mapIntent.setPackage("com.google.android.apps.maps");
        startActivity(mapIntent);}

    //Return to home
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id=item.getItemId();
        if(id == android.R.id.home){
            this.finish();
        }
        return super.onOptionsItemSelected(item);
    }


}


