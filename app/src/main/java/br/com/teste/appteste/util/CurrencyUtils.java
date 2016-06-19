package br.com.teste.appteste.util;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.Locale;

/**
 * Created by rabsouza on 19/06/16.
 */

public class CurrencyUtils {
    private static Locale locale = Locale.getDefault();
    private static NumberFormat numberFormat = NumberFormat.getCurrencyInstance(locale);

    public static String format(BigDecimal value) {
        if (value == null) {
            return "";
        }

        numberFormat.setMaximumFractionDigits(2);
        numberFormat.setMinimumFractionDigits(2);

        return numberFormat.format(value);
    }
}
