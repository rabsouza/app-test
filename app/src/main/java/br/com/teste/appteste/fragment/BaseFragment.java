package br.com.teste.appteste.fragment;

import android.support.v4.app.Fragment;
import android.widget.Toast;

public class BaseFragment extends Fragment{

    protected void toast(String msg) {
        Toast.makeText(getContext(), msg, Toast.LENGTH_SHORT).show();
    }

    protected void toast(int msg) {
        Toast.makeText(getContext(), msg, Toast.LENGTH_SHORT).show();
    }
}
