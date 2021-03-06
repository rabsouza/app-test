package br.com.teste.appteste.service;

import android.util.Log;

import com.google.common.collect.ComparisonChain;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import br.com.teste.appteste.domain.Sale;
import br.com.teste.appteste.mock.MockSale;

/**
 * Created by rabsouza on 19/06/16.
 */

public class SaleService {
    private static final String TAG = SaleService.class.getSimpleName();

    private Comparator<Sale> saleComparator = new Comparator<Sale>() {
        @Override
        public int compare(Sale lhs, Sale rhs) {
            return ComparisonChain.start().compare(lhs.getDate(), rhs.getDate()).result();
        }
    };

    public List<Sale> findSalesByUser(String user) {
        Log.i(TAG, String.format("findSalesByUser: Find sales by user: %s!", user));

        List<Sale> sales = MockSale.createDataMock();
        Collections.sort(sales, saleComparator);
        Collections.reverse(sales);
        return sales;
    }
}
