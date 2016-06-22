package br.com.teste.appteste.fragment;


import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import br.com.teste.appteste.R;


/**
 * A simple {@link BaseFragment} subclass.
 * Use the {@link AboutAppFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class AboutAppFragment extends BaseFragment {

    private static final String TAG = AboutAppFragment.class.getSimpleName();

    public AboutAppFragment() {
    }

    public static AboutAppFragment newInstance() {
        AboutAppFragment fragment = new AboutAppFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Log.d(TAG, "onCreateView: Create new fragment About App!");

        return inflater.inflate(R.layout.fragment_about_app, container, false);
    }

}
