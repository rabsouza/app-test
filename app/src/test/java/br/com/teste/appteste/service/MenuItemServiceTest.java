package br.com.teste.appteste.service;

import android.util.Log;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import java.util.HashSet;
import java.util.Set;

import br.com.teste.appteste.domain.MenuItem;
import br.com.teste.appteste.mock.MockMenuItem;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.powermock.api.mockito.PowerMockito.mockStatic;

@RunWith(PowerMockRunner.class)
@PrepareForTest({
        Log.class,
        MockMenuItem.class
})
public class MenuItemServiceTest {

    @InjectMocks
    private MenuItemService menuItemService;

    @Before
    public void setup() {
        mockStatic(Log.class);
        mockStatic(MockMenuItem.class);
    }

    @Test
    public void shouldReturnEmptyActionsWhenFindActionsCountersWithMailNull() {
        Set<MenuItem> actions = menuItemService.findActionsCountersByMenuItem(null);
        assertThat(actions, is(hasSize(0)));
    }

    @Test
    public void shouldReturnEmptyActionsWhenFindActionsCountersWithMailEmpty() {
        Set<MenuItem> actions = menuItemService.findActionsCountersByMenuItem(null);
        assertThat(actions, is(hasSize(0)));
    }

    @Test
    public void shouldReturnEmptyActionsWhenFindActionsCountersWithMailInvalid() {
        Set<MenuItem> menus = new HashSet<>();
        PowerMockito.when(MockMenuItem.createDataMock()).thenReturn(menus);

        Set<MenuItem> actions = menuItemService.findActionsCountersByMenuItem("abc");
        assertThat(actions, is(hasSize(0)));
    }

    @Test
    public void shouldReturnActionsWhenFindActionsCountersWithMailVaLid() {
        Set<MenuItem> menus = new HashSet<>();
        menus.add(new MenuItem());
        PowerMockito.when(MockMenuItem.createDataMock()).thenReturn(menus);

        Set<MenuItem> actions = menuItemService.findActionsCountersByMenuItem("abc");
        assertThat(actions, is(hasSize(1)));
    }

}