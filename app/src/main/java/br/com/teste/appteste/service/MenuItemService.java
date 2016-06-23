package br.com.teste.appteste.service;

import android.util.Log;

import com.google.common.base.Strings;
import com.google.common.collect.Sets;

import java.util.Set;

import br.com.teste.appteste.domain.MenuItem;
import br.com.teste.appteste.mock.MockMenuItem;

/**
 * Created by rabsouza on 19/06/16.
 */

public class MenuItemService {

    private static final String TAG = MenuItemService.class.getSimpleName();

    public Set<MenuItem> findActionsCountersByMenuItem(String email) {
        Log.i(TAG, String.format(
                "findActionsCountersByMenuItem: Find actions by mail: %s!", email));
        if (Strings.isNullOrEmpty(email)) {
            return Sets.newHashSet();
        }

        return MockMenuItem.createDataMock();
    }

}
