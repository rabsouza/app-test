package br.com.teste.appteste.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import br.com.teste.appteste.R;

/**
 * Created by rabsouza on 19/06/16.
 */

public class MsgsViewHolder extends RecyclerView.ViewHolder{

    private TextView txtTitle;
    private TextView txtResume;
    private TextView txtValue;

    public MsgsViewHolder(View view) {
        super(view);

        txtTitle = (TextView) view.findViewById(R.id.card_view_my_sales_title);
        txtResume = (TextView) view.findViewById(R.id.card_view_my_sales_resume);
        txtValue = (TextView) view.findViewById(R.id.card_view_my_sales_value);
    }

    public TextView getTxtTitle() {
        return txtTitle;
    }

    public TextView getTxtResume() {
        return txtResume;
    }

    public TextView getTxtValue() {
        return txtValue;
    }


}
