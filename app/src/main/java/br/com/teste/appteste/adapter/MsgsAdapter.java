package br.com.teste.appteste.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import br.com.teste.appteste.R;
import br.com.teste.appteste.domain.Message;
import br.com.teste.appteste.util.AndroidUtils;

/**
 * Created by rabsouza on 19/06/16.
 */

public class MsgsAdapter extends RecyclerView.Adapter<MsgsViewHolder> {
    private static final String TAG = MsgsAdapter.class.getSimpleName();

    private Context context;
    private List<Message> messages;

    public MsgsAdapter(Context context, List<Message> messages) {
        this.context = context;
        this.messages = messages;
    }

    @Override
    public MsgsViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.adapter_msgs, viewGroup, false);
        return new MsgsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MsgsViewHolder holder, int position) {
        if (messages != null && !messages.isEmpty()) {
            final Message message = messages.get(position);
            Log.i(TAG, String.format(
                    "onBindViewHolder: Fill to row position: %S with %s.", position, message));

            holder.getTxtTitle().setText(message.getFromContact());
            if (message.getUrlPhoto() != null) {
                Picasso.with(context)
                        .load(message.getUrlPhoto()).fit().into(holder.getImgImage());
                holder.getImgImage().setVisibility(View.VISIBLE);
                holder.getTxtShape().setVisibility(View.INVISIBLE);
            } else {
                holder.getImgImage().setVisibility(View.INVISIBLE);
                TextView txtShape = holder.getTxtShape();
                txtShape.setVisibility(View.VISIBLE);
                txtShape.setBackgroundResource(message.getColorIdRes());
                txtShape.setText(message.getFromContact().substring(0, 1));
            }

            if (message.getNotification()) {
                holder.getNotification().setVisibility(View.VISIBLE);
            } else {
                holder.getNotification().setVisibility(View.INVISIBLE);
            }
            final View itemView = holder.itemView;
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    AndroidUtils.toast(itemView.getContext(), R.string.toast_blank_fragment);
                }
            });
        } else {
            Log.w(TAG, "onBindViewHolder: No content to holder!");
        }

    }

    @Override
    public int getItemCount() {
        return messages != null ? messages.size() : 0;
    }
}
