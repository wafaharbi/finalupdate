package com.example.wafa.studentapp;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;


class SectionsPagerAdapterofCoursesTeacher2 extends FragmentPagerAdapter{     //courses tab of teacher


    public SectionsPagerAdapterofCoursesTeacher2(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
//FilesIT473Fragment
        switch(position) {
            case 0:
                TeacherFragment1  teacherFragment1  = new TeacherFragment1();
                return teacherFragment1;

            case 1:
                TeacherFragmentIT215 teacherFragmentIT215 = new TeacherFragmentIT215();
                return  teacherFragmentIT215;


            case 2:
                FragmentAttendanceIT215  fragmentAttendanceIT215= new FragmentAttendanceIT215();
                return   fragmentAttendanceIT215;
/*

1-TeacherFragment2
        2-TeacherFragmentIT215
*/

            default:
                return  null;
        }

    }

    @Override
    public int getCount() {
        return 3;
    }

    public CharSequence getPageTitle(int position){

        switch (position) {
            case 0:
                return "Files";

            case 1:
                return "students";

            case 2:
                return "Attendance";

            default:
                return null;
        }

    }

}
