package br.com.teste.appteste.mocks;

import java.util.HashSet;
import java.util.Set;

import br.com.teste.appteste.R;
import br.com.teste.appteste.domains.MenuItem;

/**
 * Created by rabsouza on 18/06/16.
 */

public class MockMenuItem {

    private MockMenuItem() {
    }

    public static Set<MenuItem> createDataMock() {
        Set<MenuItem> items = new HashSet<MenuItem>();

        items.add(new MenuItem().idRes(R.id.nav_item_affiliates).counter("121"));
        items.add(new MenuItem().idRes(R.id.nav_item_msgs).counter("+50"));
        items.add(new MenuItem().idRes(R.id.nav_item_notifications).counter("15"));

        return items;
    }

}
