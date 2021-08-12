package com.dsfa.nc.pd.lesson.gen;

import com.dsfa.nc.pd.util.BaseJFinalGenerator;

import java.util.HashSet;
import java.util.Set;

/**
 * @ClassName Generator
 * @Description TODO
 * @Author pocky
 * @Date 2021/7/21
 **/
public abstract class LessonModelGenerator extends BaseJFinalGenerator {
    public static void main(String[] args) {
        Set<String> set = new HashSet<>();
        set.add("nc_courses_info");
        set.add("nc_courses_courseware");
        set.add("nc_courses_courseware_sub");
        set.add("nc_record_course");
        set.add("nc_record_courseware");
        genTables(set, "com.dsfa.nc.pd.lesson.model", "/dsfa-nc-pddx-lesson-persistence");
    }
}
