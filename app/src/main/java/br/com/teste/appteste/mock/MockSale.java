package br.com.teste.appteste.mock;

import com.google.common.collect.Lists;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.List;

import br.com.teste.appteste.domain.Sale;

/**
 * Created by rabsouza on 19/06/16.
 */

public class MockSale {

    private MockSale() {
    }

    public static List<Sale> createDataMock() {
        List<Sale> sales = Lists.newArrayList();

        for (int i = 0; i < 10; i++) {
            sales.add(createNewSale());
        }

        return sales;
    }

    private static Sale createNewSale() {
        long id = Math.round(System.currentTimeMillis() * Math.random());
        Calendar date = createRandomDate();
        String title = createRandomStr((int) Math.round(Math.random() * 100) + 30);
        String desc = createRandomStr((int) Math.round(Math.random() * 200) + 100);
        BigDecimal value = new BigDecimal(Math.random() * 999999);
        boolean notification = Math.random() < 0.5;

        return new Sale().id(id).date(date).title(title).desc(desc).value(value).notification(notification);
    }

    private static Calendar createRandomDate() {
        Calendar date = Calendar.getInstance();
        date.add(Calendar.DAY_OF_YEAR, -Long.valueOf(Math.round(Math.random() * 360)).intValue());
        return date;
    }

    private static String createRandomStr(int size) {
        String fakeStr = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod " +
                "tempor incididunt ut labore et dolore magna aliqua. " +
                "Ut enim ad minim veniam, quis nostrud exercitation ullamco " +
                "laboris nisi ut aliquip ex ea commodo consequat. " +
                "Duis aute irure dolor in reprehenderit in voluptate " +
                "velit esse cillum dolore eu fugiat nulla pariatur. " +
                "Excepteur sint occaecat cupidatat non proident, sunt " +
                "in culpa qui officia deserunt mollit anim id est laborum.";
        return fakeStr.substring(0, size);
    }
}
