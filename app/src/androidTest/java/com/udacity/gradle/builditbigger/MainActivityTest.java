package com.udacity.gradle.builditbigger;

import android.support.test.espresso.intent.rule.IntentsTestRule;
import android.support.test.runner.AndroidJUnit4;

import com.example.jokesandrolib.ShowJokeActivity;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.intent.Intents.intended;
import static android.support.test.espresso.intent.matcher.IntentMatchers.hasComponent;
import static android.support.test.espresso.intent.matcher.IntentMatchers.hasExtra;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static org.hamcrest.core.AllOf.allOf;


@RunWith(AndroidJUnit4.class)
public class MainActivityTest {
    private static String staticTestJoke = "Chuck Norris can make a Happy Meal menu cry";

    @Rule
    public IntentsTestRule<MainActivity> mMainActivityTestRule =
            new IntentsTestRule<>(MainActivity.class);

    @Test
    public void clickOnTellJoke_displayLoadedJoke() throws Exception {

        // Click on the button
        onView(withId(R.id.tell_joke)).perform(click());

        // Check the result -forever Chuk Norris-
        intended(
                allOf(hasComponent(ShowJokeActivity.class.getCanonicalName()),
                        hasExtra(ShowJokeActivity.EXTRA_DATA, staticTestJoke)
                )
        );
    }
}

