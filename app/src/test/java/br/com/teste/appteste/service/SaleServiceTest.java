package br.com.teste.appteste.service;

import android.util.Log;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;

import br.com.teste.appteste.domain.Sale;
import br.com.teste.appteste.mock.MockSale;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.powermock.api.mockito.PowerMockito.mockStatic;
import static org.powermock.api.mockito.PowerMockito.when;

@RunWith(PowerMockRunner.class)
@PrepareForTest({
        Log.class,
        MockSale.class
})
public class SaleServiceTest {

    @InjectMocks
    private SaleService saleService;

    @Before
    public void setup() {
        mockStatic(Log.class);
        mockStatic(MockSale.class);
    }

    @Test
    public void shouldReturnEmptySalesWhenFindSalesWithUserNull() {
        List<Sale> actions = saleService.findSalesByUser(null);
        assertThat(actions, is(hasSize(0)));
    }

    @Test
    public void shouldReturnEmptySalesWhenFindSalesWithUserEmpty() {
        List<Sale> actions = saleService.findSalesByUser(null);
        assertThat(actions, is(hasSize(0)));
    }

    @Test
    public void shouldReturnEmptySalesWhenFindSalesWithUserInvalid() {
        List<Sale> menus = new ArrayList<>();
        when(MockSale.createDataMock()).thenReturn(menus);

        List<Sale> actions = saleService.findSalesByUser("abc");
        assertThat(actions, is(hasSize(0)));
    }

    @Test
    public void shouldReturnSalesWhenFindSalesWithUserVaLid() {
        List<Sale> menus = new ArrayList<>();
        menus.add(new Sale());
        when(MockSale.createDataMock()).thenReturn(menus);

        List<Sale> actions = saleService.findSalesByUser("abc");
        assertThat(actions, is(hasSize(1)));
    }

    @Test
    public void shouldReturnOrderedSalesWhenFindSalesWithUserVaLid() {
        List<Sale> menus = new ArrayList<>();

        menus.add(new Sale().id(1l).date(Calendar.getInstance()));

        Calendar date = Calendar.getInstance();
        date.add(Calendar.DAY_OF_YEAR, -1);
        menus.add(new Sale().id(2l).date(date));

        date = Calendar.getInstance();
        date.add(Calendar.DAY_OF_YEAR, 1);
        menus.add(new Sale().id(3l).date(date));

        when(MockSale.createDataMock()).thenReturn(menus);

        List<Sale> actions = saleService.findSalesByUser("abc");
        assertThat(actions, is(hasSize(3)));
        Iterator<Sale> saleIterator = actions.iterator();
        assertThat(saleIterator.next().getId(), equalTo(3l));
        assertThat(saleIterator.next().getId(), equalTo(1l));
        assertThat(saleIterator.next().getId(), equalTo(2l));
    }

}