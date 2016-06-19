package br.com.teste.appteste.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import br.com.teste.appteste.R;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link MsgsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MsgsFragment extends BaseFragment {

    public MsgsFragment() {
    }

    public static MsgsFragment newInstance() {
        MsgsFragment fragment = new MsgsFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_msgs, container, false);
    }

}
