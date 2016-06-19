package br.com.teste.appteste.activities;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.IdRes;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.common.base.Strings;

import br.com.teste.appteste.R;

/**
 * Created by rabsouza on 18/06/16.
 */

public class BaseActivity extends AppCompatActivity {
    private static final String TAG = BaseActivity.class.getSimpleName();

    protected DrawerLayout drawerLayout;
    private NavigationView navigationView;
    private Toolbar toolbar;

    protected void setUpToolbar() {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        if (toolbar != null) {
            Log.d(TAG, "setUpToolbar: Active support toolbar!");
            setSupportActionBar(toolbar);
        }
    }

    protected void setUpNavDrawer() {
        final ActionBar actionBar = getSupportActionBar();

        actionBar.setHomeAsUpIndicator(R.drawable.ic_menu);
        actionBar.setDisplayHomeAsUpEnabled(true);

        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        navigationView = (NavigationView) findViewById(R.id.nav_view);
        if (navigationView != null && drawerLayout != null) {
            Log.d(TAG, "setUpNavDrawer: Active Navigation Drawer!");
            navigationView.setNavigationItemSelectedListener(
                    new NavigationView.OnNavigationItemSelectedListener() {
                        @Override
                        public boolean onNavigationItemSelected(MenuItem menuItem) {
                            CharSequence title = menuItem.getTitle();
                            Log.i(TAG, String.format("onNavigationItemSelected: Select menu item: %s!", title));
                            if (toolbar != null) {
                                toolbar.setTitle(title);
                            }
                            menuItem.setChecked(true);

                            closeDrawer();
                            onNavDrawerItemSelected(menuItem);
                            return true;
                        }
                    });
        }
    }

    protected void setMenuCounter(@IdRes int itemId, String count) {
        if (navigationView != null) {
            MenuItem item = navigationView.getMenu().findItem(itemId);
            TextView view = (TextView) item.getActionView();
            if (view != null) {
                Log.d(TAG, String.format(
                        "setMenuCounter: Load counter to menu item: %s!", item.getTitle()));
                if (!Strings.isNullOrEmpty(count)) {
                    view.setText(count);
                    view.setVisibility(View.VISIBLE);
                } else {
                    view.setVisibility(View.INVISIBLE);
                }
            }
        }
    }

    private void onNavDrawerItemSelected(MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case R.id.nav_item_about_app:
                toast("Em construção, por favor aguarde!!!");
                break;
            case R.id.nav_item_affiliates:
                toast("Em construção, por favor aguarde!!!");
                break;
            case R.id.nav_item_msgs:
                toast("Em construção, por favor aguarde!!!");
                break;
            case R.id.nav_item_my_products:
                toast("Em construção, por favor aguarde!!!");
                break;
            case R.id.nav_item_my_profile:
                toast("Em construção, por favor aguarde!!!");
                break;
            case R.id.nav_item_my_sales:
                toast("Em construção, por favor aguarde!!!");
                break;
            case R.id.nav_item_notifications:
                toast("Em construção, por favor aguarde!!!");
                break;
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                if (drawerLayout != null) {
                    openDrawer();
                    return true;
                }
        }
        return super.onOptionsItemSelected(item);
    }

    protected void openDrawer() {
        if (drawerLayout != null) {
            Log.d(TAG, "openDrawer!");
            drawerLayout.openDrawer(GravityCompat.START);
        }
    }

    protected void closeDrawer() {
        if (drawerLayout != null) {
            Log.d(TAG, "closeDrawer!");
            drawerLayout.closeDrawer(GravityCompat.START);
        }
    }

    protected Context getContext() {
        return this;
    }

    protected Activity getActivity() {
        return this;
    }

    protected void toast(String msg) {
        Toast.makeText(getContext(), msg, Toast.LENGTH_SHORT).show();
    }

    protected void toast(int msg) {
        Toast.makeText(getContext(), msg, Toast.LENGTH_SHORT).show();
    }

}
