package in.tosc.digitaloceanapp.activities;

import android.support.test.espresso.contrib.DrawerActions;
import android.support.test.espresso.contrib.NavigationViewActions;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.view.Gravity;
import android.view.WindowManager;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import in.tosc.digitaloceanapp.R;

import static android.support.test.InstrumentationRegistry.getInstrumentation;
import static android.support.test.espresso.Espresso.*;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.*;
import static android.support.test.espresso.contrib.DrawerMatchers.isClosed;
import static android.support.test.espresso.matcher.ViewMatchers.*;
import static in.tosc.digitaloceanapp.matchers.RecyclerViewMatcher.withRecyclerView;
import static junit.framework.Assert.assertNotNull;

/**
 * Created by championswimmer on 15/07/17.
 */
@RunWith(AndroidJUnit4.class)
public class DropletActivityTest {
    public static DropletActivity dropletActivity;

    @Rule
    public ActivityTestRule<DropletActivity> actRule =
            new ActivityTestRule<DropletActivity>(DropletActivity.class);


    @Before
    public void setUp() {
        dropletActivity = actRule.getActivity();
        Runnable wakeUpDevice = new Runnable() {
            public void run() {
                dropletActivity.getWindow().addFlags(WindowManager.LayoutParams.FLAG_TURN_SCREEN_ON |
                        WindowManager.LayoutParams.FLAG_SHOW_WHEN_LOCKED |
                        WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
            }
        };
        dropletActivity.runOnUiThread(wakeUpDevice);
    }


    @Test
    public void testDropletInfo() {
        onView(withRecyclerView(R.id.dropletsRv).atPosition(0)).check(matches(isDisplayed()));

        openActionBarOverflowOrOptionsMenu(getInstrumentation().getTargetContext());
        onView(withText("Settings")).perform(click());


    }


    @Test
    public void clickOnYourNavigationItemShowsYourScreen1() {
        opendrawer();
        onView(withId(R.id.nav_view))
                .perform(NavigationViewActions.navigateTo(R.id.nav_about));

    }

    @Test
    public void clickOnYourNavigationItemShowsYourScreen2() {
        opendrawer();
        onView(withId(R.id.nav_view))
                .perform(NavigationViewActions.navigateTo(R.id.nav_billing));
    }

    @Test
    public void clickOnYourNavigationItemShowsYourScreen3() {
        opendrawer();
        onView(withId(R.id.nav_view))
                .perform(NavigationViewActions.navigateTo(R.id.nav_profile));

    }

    @Test
    public void clickOnYourNavigationItemShowsYourScreen4() {
        opendrawer();
        onView(withId(R.id.nav_view))
                .perform(NavigationViewActions.navigateTo(R.id.nav_manage));

    }


    @Test
    public void clickOnYourNavigationItemShowsYourScreen6() {
        opendrawer();
        onView(withId(R.id.nav_view))
                .perform(NavigationViewActions.navigateTo(R.id.nav_share));

    }

    @Test
    public void clickOnYourNavigationItemShowsYourScreen5() {
        opendrawer();
        onView(withId(R.id.nav_view))
                .perform(NavigationViewActions.navigateTo(R.id.nav_logout));

    }

    @After
    public void tearDown() {
        dropletActivity.finish();
    }

    public void opendrawer(){
        assertNotNull(onView(withId(R.id.drawer_layout))
                .check(matches(isClosed(Gravity.LEFT))) // Left Drawer should be closed.
                .perform(DrawerActions.open()));
    }

}
