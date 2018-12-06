package com.example.wafa.studentapp;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;


class SectionsPagerAdapterofCoursesTeacher6 extends FragmentPagerAdapter{     //courses tab of teacher


    public SectionsPagerAdapterofCoursesTeacher6(FragmentManager fm) {
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
                TeacherFragmentCS214 teacherFragmentCS214 = new TeacherFragmentCS214();
                return  teacherFragmentCS214;
            case 2:
                FragmentAttendanceCS214 fragmentAttendanceCS214 = new FragmentAttendanceCS214();
                return   fragmentAttendanceCS214;



           // FragmentAttendanceCS214
/*

1-TeacherFragment2
        2-TeacherFragmentIT215

        3-TeacherFragmentIT473

        4-TeacherFragmentCS383

        5-TeacherFragmentIT342

        6-TeacherFragmentCS214
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
