package br.com.teste.appteste.service;

import java.util.Set;

import br.com.teste.appteste.domain.MenuItem;
import br.com.teste.appteste.mock.MockMenuItem;

/**
 * Created by rabsouza on 19/06/16.
 */

public class MenuItemService {

    public Set<MenuItem> loadActionsCountersByMenuItem(){
        return MockMenuItem.createDataMock();
    }

}
