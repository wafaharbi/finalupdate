package com.example.wafa.studentapp;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;


class SectionsPagerAdapterofCourses2 extends FragmentPagerAdapter{     //courses tab


    public SectionsPagerAdapterofCourses2(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
//FilesIT473Fragment
        switch(position) {
            case 0:
                FilesIT473Fragment  filesIT473Fragment  = new FilesIT473Fragment();
                return filesIT473Fragment;

            case 1:

                FilesIT443Fragment2 filesIT443Fragment2 = new FilesIT443Fragment2();
                return  filesIT443Fragment2;




//FilesIT443Fragment2


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
                return "Files";

            case 1:
                return "Mark & Absence";

            default:
                return null;
        }

    }

}
