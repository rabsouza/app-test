package br.com.teste.appteste.mock;

import com.google.common.collect.Lists;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.List;
import java.util.Random;

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
        String title = createRandomStr(Math.round(Math.random() * 200) + 100);
        String desc = createRandomStr(Math.round(Math.random() * 500) + 300);
        BigDecimal value = new BigDecimal(Math.random());
        boolean notification = Math.random() < 0.5;

        return new Sale().id(id).date(date).title(title).desc(desc).value(value).notification(notification);
    }

    private static Calendar createRandomDate() {
        Calendar date = Calendar.getInstance();
        date.add(Calendar.DAY_OF_YEAR, -Long.valueOf(Math.round(Math.random() * 360)).intValue());
        return date;
    }

    private static String createRandomStr(Long size) {
        char[] chars = "abcdefghijklmnopqrstuvwxyz0123456789 .!?-".toCharArray();
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < size; i++) {
            char c = chars[random.nextInt(chars.length)];
            sb.append(c);
        }
        return sb.toString();
    }
}
