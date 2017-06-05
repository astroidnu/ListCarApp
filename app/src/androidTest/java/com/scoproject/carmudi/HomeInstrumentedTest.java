package com.scoproject.carmudi;

import android.support.test.espresso.contrib.RecyclerViewActions;
import android.support.test.espresso.intent.rule.IntentsTestRule;
import android.support.test.filters.LargeTest;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import com.scoproject.carmudi.component.DaggerTestComponent;
import com.scoproject.carmudi.component.TestComponent;
import com.scoproject.carmudi.ui.home.HomeActivity;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.contrib.RecyclerViewActions.scrollToPosition;
import static android.support.test.espresso.matcher.ViewMatchers.hasDescendant;
import static android.support.test.espresso.matcher.ViewMatchers.isCompletelyDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static com.scoproject.carmudi.utils.RecyclerViewMatcher.withRecyclerView;

/**
 * Created by ibnumuzzakkir on 6/4/17.
 */
@RunWith(AndroidJUnit4.class)
@LargeTest
public class HomeInstrumentedTest {
    private TestComponent testComponent;

    @Rule
    public ActivityTestRule<HomeActivity> myActivityRule = new ActivityTestRule<>(HomeActivity.class, true, false);

    @Before
    public void SetUp(){
        testComponent = DaggerTestComponent.builder().appComponent(CarmudiApp.getApp().component()).build();
        testComponent.inject(this);
    }


    @Test
    public void onCheckCarList() throws InterruptedException{
        myActivityRule.launchActivity(null);
        onView(withId(R.id.home_recyclerview))
                .check(matches(isCompletelyDisplayed()));
    }

    @Test
    public void sortDialogShowTest() throws InterruptedException {
        myActivityRule.launchActivity(null);
        onView(withId(R.id.toolbar_sort)).perform(click());
        onView(withId(R.id.sorting_recyclerview)).check(matches(isDisplayed()));
    }

    @Test
    public void sortDialogItemClickTest() throws InterruptedException{
        myActivityRule.launchActivity(null);
        onView(withId(R.id.toolbar_sort)).perform(click());
        onView(withId(R.id.sorting_recyclerview)).check(matches(isDisplayed()));
        onView(withRecyclerView(R.id.sorting_recyclerview).atPosition(0))
                .check(matches(hasDescendant(withText("oldest"))));
        onView(withId(R.id.sorting_recyclerview))
                .perform(RecyclerViewActions.actionOnItemAtPosition(0, click()));
        onView(withId(R.id.home_recyclerview))
                .check(matches(isCompletelyDisplayed()));
    }

    @Test
    public void onLoadMoreTest() throws InterruptedException{
        myActivityRule.launchActivity(null);
        onView(withId(R.id.home_recyclerview)).perform(scrollToPosition(5));
        onView(withId(R.id.home_swiperefresh)).check(matches(isDisplayed()));
        onView(withId(R.id.home_recyclerview))
                .check(matches(isCompletelyDisplayed()));
    }
}
