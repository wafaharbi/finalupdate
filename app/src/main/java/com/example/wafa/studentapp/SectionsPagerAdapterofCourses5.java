package com.example.wafa.studentapp;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;


class SectionsPagerAdapterofCourses5 extends FragmentPagerAdapter{     //courses tab


    public SectionsPagerAdapterofCourses5(FragmentManager fm) {
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

                FilesIT342Fragment2 filesIT342Fragment2 = new FilesIT342Fragment2();
                return  filesIT342Fragment2;

            //   1-FilesIT473Fragment

            //  2-FilesIT443Fragment2

            //  3- FilesCS383Fragment2

            //  4-FilesIT215Fragment2

             //  5-FilesIT342Fragment2

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
