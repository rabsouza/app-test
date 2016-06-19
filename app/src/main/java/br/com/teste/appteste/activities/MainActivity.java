package br.com.teste.appteste.activities;

import android.os.Bundle;
import android.util.Log;

import java.util.Set;

import br.com.teste.appteste.R;
import br.com.teste.appteste.domains.MenuItem;
import br.com.teste.appteste.mocks.MockMenuItem;

public class MainActivity extends BaseActivity {

    private static final String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d(TAG, "onCreate: MainActivity!");

        setUpToolbar();
        setUpNavDrawer();
        loadCountersMenuItems();
    }

    private void loadCountersMenuItems() {
        Set<MenuItem> items = MockMenuItem.createDataMock();
        Log.i(TAG, String.format(
                "loadCountersMenuItems: Loads counters %s for menu items!", items.size()));
        for (MenuItem menuItem : items) {
            setMenuCounter(menuItem.getIdRes(), menuItem.getCounter());
        }
    }
}
