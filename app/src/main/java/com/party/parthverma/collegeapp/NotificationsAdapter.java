package com.party.parthverma.collegeapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by parthverma on 26/03/17.
 */

public class NotificationsAdapter extends BaseAdapter {
    private Context context;
    private LayoutInflater inflater;
    private ArrayList<Notification> data_src;

    public NotificationsAdapter(Context context, ArrayList<Notification> items) {
        this.context = context;
        data_src = items;
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }
    @Override
    public int getCount() {
        return data_src.size();
    }

    @Override
    public Object getItem(int position) {
        return data_src.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        NotificationsAdapter.ViewHolder holder;
        if(convertView == null) {

            // 2
            convertView = inflater.inflate(R.layout.notifications_layout, parent, false);

            // 3
            holder = new ViewHolder();

            holder.title= (TextView) convertView.findViewById(R.id.notif_title);
            holder.desc = (TextView) convertView.findViewById(R.id.notif_text);

            // 4
            convertView.setTag(holder);
        }
        else{
            // 5
            holder = (NotificationsAdapter.ViewHolder) convertView.getTag();
        }
        TextView name = holder.title;
        TextView type = holder.desc;

        Notification notif = (Notification) getItem(position);
        name.setText(notif.title);
        type.setText(notif.message);

        return convertView;

    }

    private static class ViewHolder {
        public TextView title;
        public TextView desc;
    }
}
