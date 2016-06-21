package br.com.teste.appteste.activity;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.IdRes;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.common.base.Strings;
import com.squareup.picasso.Picasso;

import br.com.teste.appteste.MainApplication;
import br.com.teste.appteste.R;
import br.com.teste.appteste.fragment.AffiliatesFragment;
import br.com.teste.appteste.fragment.MsgsFragment;
import br.com.teste.appteste.fragment.MyProductsFragment;
import br.com.teste.appteste.fragment.MyProfileFragment;
import br.com.teste.appteste.fragment.MySalesFragment;
import br.com.teste.appteste.fragment.NotificationsFragment;
import br.com.teste.appteste.fragment.dialog.AboutDialog;

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
            loadNavigationViewHeader(navigationView);
            Log.d(TAG, "setUpNavDrawer: Active Navigation Drawer!");
            navigationView.setNavigationItemSelectedListener(
                    new NavigationView.OnNavigationItemSelectedListener() {
                        @Override
                        public boolean onNavigationItemSelected(MenuItem menuItem) {
                            menuItem.setChecked(true);

                            closeDrawer();
                            onNavDrawerItemSelected(menuItem);
                            return true;
                        }
                    });
        }
    }

    private void loadNavigationViewHeader(NavigationView navigationView) {
        if (navigationView != null && navigationView.getHeaderCount() > 0) {
            View view = navigationView.getHeaderView(0);
            if (view != null) {
                MainApplication instance = MainApplication.getInstance();

                TextView textViewName = (TextView) view.findViewById(R.id.nav_view_header_name);
                if (textViewName != null) {
                    textViewName.setText(instance.getUser());
                }

                TextView textViewMail = (TextView) view.findViewById(R.id.nav_view_header_mail);
                if (textViewMail != null) {
                    textViewMail.setText(instance.getEmail());
                }

                ImageView imageViewBlack = (ImageView) view.findViewById(R.id.nav_view_header_back);
                if (imageViewBlack != null) {
                    Picasso.with(navigationView.getContext())
                            .load(instance.getUrlPhoto()).fit().into(imageViewBlack);
                }

                ImageView imageViewImg = (ImageView) view.findViewById(R.id.nav_view_header_img);
                if (imageViewImg != null) {
                    Picasso.with(navigationView.getContext())
                            .load(instance.getUrlPhoto()).fit().into(imageViewImg);
                }
            }
        }


    }

    private void changeToolbarTitle(MenuItem menuItem) {
        CharSequence title = menuItem.getTitle();
        Log.i(TAG, String.format("onNavigationItemSelected: Select menu item: %s!", title));
        if (toolbar != null) {
            toolbar.setTitle(title);
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
                AboutDialog.showAbout(getSupportFragmentManager());
                break;
            case R.id.nav_item_affiliates:
                changeToolbarTitle(menuItem);
                replaceFragment(AffiliatesFragment.newInstance());
                toast(R.string.toast_blank_fragment);
                break;
            case R.id.nav_item_msgs:
                changeToolbarTitle(menuItem);
                replaceFragment(MsgsFragment.newInstance());
                break;
            case R.id.nav_item_my_products:
                changeToolbarTitle(menuItem);
                replaceFragment(MyProductsFragment.newInstance());
                toast(R.string.toast_blank_fragment);
                break;
            case R.id.nav_item_my_profile:
                changeToolbarTitle(menuItem);
                replaceFragment(MyProfileFragment.newInstance());
                toast(R.string.toast_blank_fragment);
                break;
            case R.id.nav_item_my_sales:
                changeToolbarTitle(menuItem);
                replaceFragment(MySalesFragment.newInstance());
                break;
            case R.id.nav_item_notifications:
                changeToolbarTitle(menuItem);
                replaceFragment(NotificationsFragment.newInstance());
                toast(R.string.toast_blank_fragment);
                break;
        }
    }

    protected void replaceFragment(Fragment fragment) {
        if (fragment != null) {
            Log.d(TAG, "replaceFragment: Change to fragment!");
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.container, fragment).commit();
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
