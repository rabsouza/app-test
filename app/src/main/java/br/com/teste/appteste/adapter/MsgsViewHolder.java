package br.com.teste.appteste.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import br.com.teste.appteste.R;

/**
 * Created by rabsouza on 19/06/16.
 */

public class MsgsViewHolder extends RecyclerView.ViewHolder {

    private TextView notification;
    private TextView txtShape;
    private ImageView imgImage;
    private TextView txtTitle;

    public MsgsViewHolder(View view) {
        super(view);

        txtShape = (TextView) view.findViewById(R.id.recycler_view_msgs_shape);
        notification = (TextView) view.findViewById(R.id.recycler_view_msgs_notifications);
        imgImage = (ImageView) view.findViewById(R.id.recycler_view_msgs_img);
        txtTitle = (TextView) view.findViewById(R.id.recycler_view_msgs_title);
    }

    public TextView getTxtShape() {
        return txtShape;
    }

    public ImageView getImgImage() {
        return imgImage;
    }

    public TextView getTxtTitle() {
        return txtTitle;
    }

    public TextView getNotification() {
        return notification;
    }
}
