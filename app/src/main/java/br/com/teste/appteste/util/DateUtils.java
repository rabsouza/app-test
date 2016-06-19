package br.com.teste.appteste.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * Created by rabsouza on 19/06/16.
 */

public class DateUtils {

    private static SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");

    public static String format(Calendar date) {
        if(date == null){
            return "";
        }
        return format.format(date.getTime());
    }
}
