package br.com.teste.appteste.service;

import java.util.List;

import br.com.teste.appteste.domain.Sale;
import br.com.teste.appteste.mock.MockSale;

/**
 * Created by rabsouza on 19/06/16.
 */

public class SaleService {

    public List<Sale> findSalesByUser(String user) {
        return MockSale.createDataMock();
    }
}
