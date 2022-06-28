package com.rick.problems;

public class StudentAttendanceRecordI {

    public static void main(String[] args) {
        String s = "PPALL";
        boolean res = new StudentAttendanceRecordI().checkRecord(s);
        System.out.println(res);
    }

    public boolean checkRecord(String s) {
        return !s.matches(".*A.*A.*") && !s.matches(".*LLL.*");
    }
}
