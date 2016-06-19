package br.com.teste.appteste.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import br.com.teste.appteste.R;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link AffiliatesFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class AffiliatesFragment extends BaseFragment {

    public AffiliatesFragment() {
    }

    public static AffiliatesFragment newInstance() {
        AffiliatesFragment fragment = new AffiliatesFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_affiliates, container, false);
    }

}
