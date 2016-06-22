package br.com.teste.appteste.mock;

import com.google.common.collect.Sets;

import java.util.Set;

import br.com.teste.appteste.R;
import br.com.teste.appteste.domain.MenuItem;

/**
 * Created by rabsouza on 18/06/16.
 */

public class MockMenuItem {

    private MockMenuItem() {
    }

    public static Set<MenuItem> createDataMock() {
        Set<MenuItem> items = Sets.newHashSet();


        MenuItem menuItem = new MenuItem().idRes(R.id.nav_item_affiliates)
                .counter("" + Math.round(Math.random() * 999));
        items.add(menuItem);

        MenuItem menuItem1 = new MenuItem().idRes(R.id.nav_item_msgs).counter("+20");
        items.add(menuItem1);

        MenuItem menuItem2 = new MenuItem().idRes(R.id.nav_item_notifications)
                .counter("" + Math.round(Math.random() * 9));
        items.add(menuItem2);

        return items;
    }

}
