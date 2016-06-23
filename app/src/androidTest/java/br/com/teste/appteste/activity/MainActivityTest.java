package br.com.teste.appteste.activity;

import android.support.design.widget.NavigationView;
import android.support.test.filters.LargeTest;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.widget.TextView;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import br.com.teste.appteste.R;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.contrib.DrawerActions.open;
import static android.support.test.espresso.contrib.DrawerMatchers.isClosed;
import static android.support.test.espresso.contrib.NavigationViewActions.navigateTo;
import static android.support.test.espresso.matcher.ViewMatchers.isAssignableFrom;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withParent;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static junit.framework.Assert.assertNotNull;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class MainActivityTest {

    @Rule
    public ActivityTestRule<MainActivity> mActivityTestRule =
            new ActivityTestRule<>(MainActivity.class);

    @Test
    public void checkExistsTheElementsActivity() {
        MainActivity activity = mActivityTestRule.getActivity();

        Toolbar toolbar = (Toolbar) activity.findViewById(R.id.toolbar);
        assertNotNull(toolbar);

        DrawerLayout drawerLayout = (DrawerLayout) activity.findViewById(R.id.drawer_layout);
        assertNotNull(drawerLayout);

        NavigationView navigationView = (NavigationView) activity.findViewById(R.id.nav_view);
        assertNotNull(navigationView);
    }

    @Test
    public void checkExistMenuInnavigationDrawer() {
        MainActivity activity = mActivityTestRule.getActivity();

        NavigationView navigationView = (NavigationView) activity.findViewById(R.id.nav_view);
        assertNotNull(navigationView);

        assertThat(navigationView.getMenu().size(), equalTo(7));

        assertNotNull(navigationView.getMenu().findItem(R.id.nav_item_about_app));
        assertNotNull(navigationView.getMenu().findItem(R.id.nav_item_affiliates));
        assertNotNull(navigationView.getMenu().findItem(R.id.nav_item_msgs));
        assertNotNull(navigationView.getMenu().findItem(R.id.nav_item_my_products));
        assertNotNull(navigationView.getMenu().findItem(R.id.nav_item_my_profile));
        assertNotNull(navigationView.getMenu().findItem(R.id.nav_item_my_sales));
        assertNotNull(navigationView.getMenu().findItem(R.id.nav_item_notifications));
    }

    @Test
    public void shouldShowMyProfileWhenStartingMainActivity() {
        // Left Drawer should be closed.
        onView(withId(R.id.drawer_layout))
                .check(matches(isClosed(Gravity.LEFT)));

        // Check title toolbar
        onView(allOf(isAssignableFrom(TextView.class), withParent(isAssignableFrom(Toolbar.class))))
                .check(matches(withText(R.string.my_profile)));
    }

    @Test
    public void shouldShowMySalesWhenClickMenuMySales() {
        // Open Drawer.
        onView(withId(R.id.drawer_layout))
                .check(matches(isClosed(Gravity.LEFT)))
                .perform(open());

        onView(withId(R.id.nav_view))
                .perform(navigateTo(R.id.nav_item_my_sales));

        // Check title toolbar
        onView(allOf(isAssignableFrom(TextView.class), withParent(isAssignableFrom(Toolbar.class))))
                .check(matches(withText(R.string.my_sales)));
    }

    @Test
    public void shouldShowMyProductsWhenClickMenuMyProducts() {
        // Open Drawer.
        onView(withId(R.id.drawer_layout))
                .check(matches(isClosed(Gravity.LEFT)))
                .perform(open());

        onView(withId(R.id.nav_view))
                .perform(navigateTo(R.id.nav_item_my_products));

        // Check title toolbar
        onView(allOf(isAssignableFrom(TextView.class), withParent(isAssignableFrom(Toolbar.class))))
                .check(matches(withText(R.string.my_products)));
    }

    @Test
    public void notShouldShowAffiliatesWhenClickMenuAffiliatesDisabled() {
        // Open Drawer.
        onView(withId(R.id.drawer_layout))
                .check(matches(isClosed(Gravity.LEFT)))
                .perform(open());

        onView(withId(R.id.nav_view))
                .perform(navigateTo(R.id.nav_item_affiliates));

        // Check title toolbar
        onView(allOf(isAssignableFrom(TextView.class), withParent(isAssignableFrom(Toolbar.class))))
                .check(matches(withText(R.string.my_profile)));
    }

    @Test
    public void ShouldShowMessageWhenClickMenuMessage() {
        // Open Drawer.
        onView(withId(R.id.drawer_layout))
                .check(matches(isClosed(Gravity.LEFT)))
                .perform(open());

        onView(withId(R.id.nav_view))
                .perform(navigateTo(R.id.nav_item_msgs));

        // Check title toolbar
        onView(allOf(isAssignableFrom(TextView.class), withParent(isAssignableFrom(Toolbar.class))))
                .check(matches(withText(R.string.msgs)));
    }

    @Test
    public void ShouldShowNotificationsWhenClickMenuNotifications() {
        // Open Drawer.
        onView(withId(R.id.drawer_layout))
                .check(matches(isClosed(Gravity.LEFT)))
                .perform(open());

        onView(withId(R.id.nav_view))
                .perform(navigateTo(R.id.nav_item_notifications));

        // Check title toolbar
        onView(allOf(isAssignableFrom(TextView.class), withParent(isAssignableFrom(Toolbar.class))))
                .check(matches(withText(R.string.notifications)));
    }

    @Test
    public void ShouldShowMyProfileWhenClickMenuMyProfile() {
        // Open Drawer.
        onView(withId(R.id.drawer_layout))
                .check(matches(isClosed(Gravity.LEFT)))
                .perform(open());

        onView(withId(R.id.nav_view))
                .perform(navigateTo(R.id.nav_item_my_profile));

        // Check title toolbar
        onView(allOf(isAssignableFrom(TextView.class), withParent(isAssignableFrom(Toolbar.class))))
                .check(matches(withText(R.string.my_profile)));
    }

    @Test
    public void ShouldShowAboutWhenClickMenuAbout() {
        // Open Drawer.
        onView(withId(R.id.drawer_layout))
                .check(matches(isClosed(Gravity.LEFT)))
                .perform(open());

        onView(withId(R.id.nav_view))
                .perform(navigateTo(R.id.nav_item_about_app));

        // Check title toolbar
        onView(withText(R.string.about_app)).check(matches(isDisplayed()));
    }

}