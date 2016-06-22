package br.com.teste.appteste.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import br.com.teste.appteste.MainApplication;
import br.com.teste.appteste.R;
import br.com.teste.appteste.adapter.MsgsAdapter;
import br.com.teste.appteste.adapter.MySalesAdapter;
import br.com.teste.appteste.domain.Message;
import br.com.teste.appteste.domain.Profile;
import br.com.teste.appteste.domain.Sale;
import br.com.teste.appteste.service.MessageService;
import br.com.teste.appteste.service.SaleService;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link MyProfileFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MyProfileFragment extends BaseFragment {

    private static final String TAG = MyProfileFragment.class.getSimpleName();

    private List<Message> messages;
    private MessageService messageService = new MessageService();
    private RecyclerView recyclerViewMessages;

    private List<Sale> sales;
    private SaleService saleService = new SaleService();
    private RecyclerView recyclerViewSales;

    private TextView txtCounterMessage;
    private TextView txtCurrentAccountBalance;

    public MyProfileFragment() {
    }

    public static MyProfileFragment newInstance() {
        MyProfileFragment fragment = new MyProfileFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_my_profile, container, false);

        recyclerViewSales = (RecyclerView) view.findViewById(R.id.recycler_view_my_profile_my_sales);
        recyclerViewSales.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerViewSales.setItemAnimator(new DefaultItemAnimator());
        recyclerViewSales.setHasFixedSize(true);

        recyclerViewMessages = (RecyclerView) view.findViewById(R.id.recycler_view_my_profile_msgs);
        recyclerViewMessages.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false));
        recyclerViewMessages.setItemAnimator(new DefaultItemAnimator());
        recyclerViewMessages.setHasFixedSize(true);


        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        loadSales();
        loadMessages();
        loadProfileData();
    }

    private void loadProfileData() {
        Profile profile = new Profile().sales(sales).messages(this.messages);
        txtCounterMessage = (TextView) getActivity().findViewById(R.id.my_profile_counter_messages);
        txtCounterMessage.setText(profile.getFormattedCounterMessages());

        txtCurrentAccountBalance = (TextView) getActivity()
                .findViewById(R.id.my_profile_current_account_balance);
        txtCurrentAccountBalance.setText(profile.getFormattedCurrentAccountBalance());
    }

    public void loadSales() {
        Log.i(TAG, "loadSales: Load all sales by user!");
        String user = MainApplication.getInstance().getUser();
        sales = saleService.findSalesByUser(user);

        recyclerViewSales.setAdapter(new MySalesAdapter(getContext(), sales));
    }

    public void loadMessages() {
        Log.i(TAG, "loadMessages: Load all messages by user!");
        String user = MainApplication.getInstance().getUser();
        messages = messageService.findAllMessageByContact(user);

        recyclerViewMessages.setAdapter(new MsgsAdapter(getContext(), messages));
    }

}
