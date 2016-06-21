package br.com.teste.appteste.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import br.com.teste.appteste.MainApplication;
import br.com.teste.appteste.R;
import br.com.teste.appteste.adapter.MsgsAdapter;
import br.com.teste.appteste.domain.Message;
import br.com.teste.appteste.service.MessageService;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link MsgsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MsgsFragment extends BaseFragment {

    private static final String TAG = MsgsFragment.class.getSimpleName();

    private List<Message> messages;
    private MessageService messageService = new MessageService();
    private RecyclerView recyclerView;

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
        View view = inflater.inflate(R.layout.fragment_msgs, container, false);

        recyclerView = (RecyclerView) view.findViewById(R.id.recycler_view_msgs);
        recyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 4));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setHasFixedSize(true);

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        loadMessages();
    }

    public void loadMessages() {
        Log.i(TAG, "loadMessages: Load all messages by user!");
        String user = MainApplication.getInstance().getUser();
        messages = messageService.findAllMessageByContact(user);

        recyclerView.setAdapter(new MsgsAdapter(getContext(), messages));
    }
}
