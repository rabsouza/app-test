package br.com.teste.appteste.util;

import android.util.Log;

import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * Created by rabsouza on 19/06/16.
 */

public class DateUtils {
    private static final String TAG = DateUtils.class.getSimpleName();

    private static SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");

    public static String format(Calendar date) {
        Log.d(TAG, "format: Format the date for string with formatting: dd/MM/yyyy");
        if (date == null) {
            return "";
        }
        return format.format(date.getTime());
    }
}
