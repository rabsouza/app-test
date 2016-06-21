package br.com.teste.appteste.service;

import android.util.Log;

import java.util.Set;

import br.com.teste.appteste.domain.MenuItem;
import br.com.teste.appteste.mock.MockMenuItem;

/**
 * Created by rabsouza on 19/06/16.
 */

public class MenuItemService {

    private static final String TAG = MenuItemService.class.getSimpleName();

    public Set<MenuItem> findActionsCountersByMenuItem(String email) {
        Log.i(TAG, String.format("findActionsCountersByMenuItem: Find all actions by mail:", email));
        return MockMenuItem.createDataMock();
    }

}
