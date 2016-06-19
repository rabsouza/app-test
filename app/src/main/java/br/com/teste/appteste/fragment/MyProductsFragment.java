package br.com.teste.appteste.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import br.com.teste.appteste.R;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link MyProductsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MyProductsFragment extends BaseFragment {

    public MyProductsFragment() {
    }

    public static MyProductsFragment newInstance() {
        MyProductsFragment fragment = new MyProductsFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_my_products, container, false);
    }

}
