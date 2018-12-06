 package com.example.wafa.studentapp;

import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

 public class CourseViewTI473 extends AppCompatActivity {
     private ViewPager mViewPager;
     private SectionsPagerAdapterofCourses mSectionsPagerAdapter;     //courses tab
     private TabLayout mTabLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course_view_ti473);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        setTitle("           Course View ");
        //Tabs
        mViewPager = (ViewPager) findViewById(R.id.main_tabPager);
        mSectionsPagerAdapter = new SectionsPagerAdapterofCourses(getSupportFragmentManager());

        mViewPager.setAdapter(mSectionsPagerAdapter);

        mTabLayout = (TabLayout) findViewById(R.id.main_tabs);
        mTabLayout.setupWithViewPager(mViewPager);

    }

     @Override
     public boolean onOptionsItemSelected(MenuItem item) {
         int id=item.getItemId();
         if(id == android.R.id.home){
             this.finish();
         }
         return super.onOptionsItemSelected(item);
     }


/*
     public void filesUploads(View v ){

         Intent i = new Intent(CourseViewTI473.this, ViewUploadsActivity.class);
         startActivity(i);
     }

     public void ViewInfo(View v ){

         Intent i = new Intent(CourseViewTI473.this, CourseStudentIT473.class);
         startActivity(i);
     }*/
}
