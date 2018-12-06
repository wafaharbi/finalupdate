package com.example.wafa.studentapp;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;


class SectionsPagerAdapterofCourses3 extends FragmentPagerAdapter{     //courses tab


    public SectionsPagerAdapterofCourses3(FragmentManager fm) {
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

                FilesCS383Fragment2 filesCS383Fragment2 = new FilesCS383Fragment2();
                return  filesCS383Fragment2;


           //   1-FilesIT473Fragment
           //  2-FilesIT443Fragment2
          //    3- FilesCS383Fragment2

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
