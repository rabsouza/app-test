package br.com.teste.appteste.fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import br.com.teste.appteste.R;


/**
 * A simple {@link BaseFragment} subclass.
 * Use the {@link NotificationsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class NotificationsFragment extends BaseFragment {

    private static final String TAG = NotificationsFragment.class.getSimpleName();

    public NotificationsFragment() {
    }

    public static NotificationsFragment newInstance() {
        NotificationsFragment fragment = new NotificationsFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Log.d(TAG, "onCreateView: Create new fragment Notifications!");

        return inflater.inflate(R.layout.fragment_notifications, container, false);
    }

}
