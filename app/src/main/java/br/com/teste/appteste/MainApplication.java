package br.com.teste.appteste;

import android.app.Application;
import android.util.Log;

/**
 * Created by rabsouza on 18/06/16.
 */
public class MainApplication extends Application {

    private static final String TAG = MainApplication.class.getSimpleName();

    private static MainApplication instance = null;

    public static MainApplication getInstance() {
        return instance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d(TAG, "onCreate: MainApplication!");

        instance = this;
    }

    @Override
    public void onTerminate() {
        super.onTerminate();
        Log.d(TAG, "onTerminate: MainApplication!");
    }
}
