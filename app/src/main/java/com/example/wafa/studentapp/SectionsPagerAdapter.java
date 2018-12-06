package com.example.wafa.studentapp;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;



class SectionsPagerAdapter extends FragmentPagerAdapter{


    public SectionsPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {

        switch(position) {
            case 0:
                StudentsFragment  studentsFragment  = new StudentsFragment();
                return studentsFragment;

            case 1:
                ParentsFragment parentsFragment = new ParentsFragment();
                return  parentsFragment;


            default:
                return  null;
        }

    }

    @Override
    public int getCount() {
        return 2;
    }

    public CharSequence getPageTitle(int position){

        switch (position) {
            case 0:
                return "Students";

            case 1:
                return "Parents";

           

            default:
                return null;
        }

    }

}
