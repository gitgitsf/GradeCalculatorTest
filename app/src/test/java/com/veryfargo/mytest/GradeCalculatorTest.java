package com.veryfargo.mytest;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertNotSame;
import static junit.framework.Assert.assertSame;

/**
 * Created by meewah12 on 6/6/16.
 */
public class GradeCalculatorTest {

    GradeCalculator mGradeCalculator;

    @Before
    public void setUp() throws Exception {

        mGradeCalculator = new GradeCalculator();

    }


    @Test
    public void testWhatIsMyGrade() throws Exception {

        //expected: A, 92 is >= 100 * 90%
        assertSame("A", mGradeCalculator.whatIsMyGrade(100.0d, 92.0d), "A");
        //                                                              |--> return String value
        assertSame("B", mGradeCalculator.whatIsMyGrade(100d, 82d), "B");
        assertSame("C", mGradeCalculator.whatIsMyGrade(100.0d, 72d), "C");
        assertSame("D", mGradeCalculator.whatIsMyGrade(100d, 62d), "D");
        assertSame("F", mGradeCalculator.whatIsMyGrade(100d, 52d), "F");

        assertNotSame("A", "B");

    }

}