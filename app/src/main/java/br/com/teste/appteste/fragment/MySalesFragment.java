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

import java.util.List;

import br.com.teste.appteste.MainApplication;
import br.com.teste.appteste.R;
import br.com.teste.appteste.adapter.MySalesAdapter;
import br.com.teste.appteste.domain.Sale;
import br.com.teste.appteste.service.SaleService;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link MySalesFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MySalesFragment extends BaseFragment {

    private static final String TAG = MySalesFragment.class.getSimpleName();

    private List<Sale> sales;
    private SaleService saleService = new SaleService();
    private RecyclerView recyclerView;

    public MySalesFragment() {
    }

    public static MySalesFragment newInstance() {
        MySalesFragment fragment = new MySalesFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_my_sales, container, false);

        recyclerView = (RecyclerView) view.findViewById(R.id.recycler_view_my_sales);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setHasFixedSize(true);

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        loadSales();
    }

    public void loadSales() {
        Log.i(TAG, "loadSales: Load all sales by user!");
        String user = MainApplication.getInstance().getUser();
        sales = saleService.findSalesByUser(user);

        recyclerView.setAdapter(new MySalesAdapter(getContext(), sales));
    }

}
