package com.veryfargo.mytest;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.test.suitebuilder.annotation.LargeTest;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

/**
 * Created by meewah12 on 6/7/16.
 */
@RunWith(AndroidJUnit4.class)
@LargeTest
public class MainActivityInstrumentationTest {

    private static final String NAME_TO_BE_ENTERED = "John";
    private static final double TOTAL_SCORE = 100d;
    private static final String SCORE_TO_BE_ENTERED = "97";
    private static final double SCORE_ENTERED = 96d;

    GradeCalculator mGradeCalculator = new GradeCalculator();

    @Rule
    public ActivityTestRule<MainActivity> mActivityRule = new ActivityTestRule<>(
            MainActivity.class);

    private MainActivity mMainActivity;

    @Before
    public void setup() { mMainActivity = mActivityRule.getActivity(); }

    @Test
    public void onClick(){

        onView(withId(R.id.etName)).perform(typeText(NAME_TO_BE_ENTERED), closeSoftKeyboard()); // Name
        onView(withId(R.id.etScore)).perform(typeText(SCORE_TO_BE_ENTERED), closeSoftKeyboard()); // Score

        onView(withText("What Is My Grade?")).perform(click()); //Button

        String expectedText = "Hello, " + NAME_TO_BE_ENTERED + ", you got a " + "A" + "!";
        onView(withId(R.id.tvMessage)).check(matches(withText(expectedText)));

    }




}
