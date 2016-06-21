package br.com.teste.appteste.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import br.com.teste.appteste.R;
import br.com.teste.appteste.domain.Sale;
import br.com.teste.appteste.util.AndroidUtils;

/**
 * Created by rabsouza on 19/06/16.
 */

public class MySalesAdapter extends RecyclerView.Adapter<MySalesViewHolder> {
    private static final String TAG = MySalesAdapter.class.getSimpleName();

    private Context context;
    private List<Sale> sales;

    public MySalesAdapter(Context context, List<Sale> sales) {

        this.context = context;
        this.sales = sales;
    }

    @Override
    public MySalesViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.adapter_my_sales, viewGroup, false);
        return new MySalesViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MySalesViewHolder holder, int position) {
        if (sales != null && !sales.isEmpty()) {
            final Sale sale = sales.get(position);
            Log.i(TAG, String.format(
                    "onBindViewHolder: Fill to row position: %S with %s.", position, sale));

            holder.getTxtTitle().setText(sale.getFormattedTitle());
            holder.getTxtResume().setText(sale.getResume());
            holder.getTxtValue().setText(sale.getFormattedValue());

            final View itemView = holder.itemView;
            if (position % 2 == 0) {
                itemView.setBackgroundResource(R.color.white);
            } else {
                itemView.setBackgroundResource(R.color.gray);
            }

            if (sale.getNotification()) {
                holder.getNotification().setVisibility(View.VISIBLE);
            } else {
                holder.getNotification().setVisibility(View.INVISIBLE);
            }

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    AndroidUtils.toast(itemView.getContext(), sale.getResume());
                }
            });
        } else {
            Log.w(TAG, "onBindViewHolder: No content to holder!");
        }

    }

    @Override
    public int getItemCount() {
        return sales != null ? sales.size() : 0;
    }
}
