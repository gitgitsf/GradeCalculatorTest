package com.veryfargo.mytest;

public class GradeCalculator {

    private static final String GRADE_A = "A";
    private static final String GRADE_B = "B";
    private static final String GRADE_C = "C";
    private static final String GRADE_D = "D";
    private static final String GRADE_F = "F";

    public String whatIsMyGrade(double total, double yourScore) {

        double aPct = total * 0.9;  // 90%
        double bPct = total * 0.8;
        double cPct = total * 0.7;
        double dPct = total * 0.6;

        if (yourScore >= aPct) return GRADE_A;
        else if (yourScore >= bPct)  return GRADE_B;
        else if (yourScore >= cPct)  return GRADE_C;
        else if (yourScore >= dPct)  return GRADE_D;

        return GRADE_F;
    }


}
