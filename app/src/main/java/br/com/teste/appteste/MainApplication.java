package br.com.teste.appteste;

import android.app.Application;
import android.util.Log;

/**
 * Created by rabsouza on 18/06/16.
 */
public class MainApplication extends Application {

    private static final String TAG = MainApplication.class.getSimpleName();

    private static MainApplication instance = null;

    // TODO Utilizando fixo por não ter tempo de carregar via google plus!
    private final String user = "Rafael Batista";
    private final String email = "rabsouza@gmail.com";
    private final String urlPhoto = "https://lh3.googleusercontent.com/-jUgxO0LdL9kmSkY7jEd-Na9YWzxNHcqH_m8P3C5IuFDV3fVD7X6fPqhGk8BJXGcKXSn__bFSg=w1366-h768-rw-no";

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

    public String getUser() {
        return user;
    }

    public String getEmail() {
        return email;
    }

    public String getUrlPhoto() {
        return urlPhoto;
    }
}
