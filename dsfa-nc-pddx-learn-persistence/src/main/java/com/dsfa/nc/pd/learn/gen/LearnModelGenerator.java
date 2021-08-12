package com.dsfa.nc.pd.learn.gen;

import com.dsfa.nc.pd.util.BaseJFinalGenerator;

import java.util.HashSet;
import java.util.Set;

public class LearnModelGenerator extends BaseJFinalGenerator {
    public static void main(String[] args) {
        Set<String> tables = new HashSet<>();
        tables.add("nc_learn_year");

        genTables(tables, "com.dsfa.nc.pd.learn.model", "/dsfa-nc-pddx-learn-persistence");
    }
}
