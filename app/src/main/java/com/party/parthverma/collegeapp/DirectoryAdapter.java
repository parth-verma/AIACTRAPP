package com.party.parthverma.collegeapp;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class DirectoryAdapter extends BaseAdapter {

    private Context context;
    private LayoutInflater inflater;
    private ArrayList<Direct> data_src;

    public DirectoryAdapter(Context context, ArrayList<Direct> items) {
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
        ViewHolder holder;
        if (convertView == null) {

            // 2
            convertView = inflater.inflate(R.layout.directory_layout, parent, false);

            // 3
            holder = new ViewHolder();
            holder.name = (TextView) convertView.findViewById(R.id.directory_name);
            holder.room_number = (TextView) convertView.findViewById(R.id.room_number);
            holder.floor = (TextView) convertView.findViewById(R.id.floor);

            // 4
            convertView.setTag(holder);
        } else {
            // 5
            holder = (ViewHolder) convertView.getTag();
        }
        TextView name = holder.name;
        TextView room_number = holder.room_number;
        TextView floor = holder.floor;

        Direct directory = (Direct) getItem(position);
        name.setText(directory.name);
        room_number.setText(directory.room_number);
        floor.setText(directory.floor);

        return convertView;

    }

    private static class ViewHolder {
        public TextView name;
        public TextView room_number;
        public TextView floor;
    }


}


class Direct {
    String name, room_number, floor, block;

    public Direct(String name, String room_number, String floor, String block) {
        this.name = name;
        this.room_number = room_number;
        this.floor = floor;
        this.block = block;

    }

    static private String loadJSONFromAsset(Context context) {
        String json = null;
        try {

            InputStream is = context.getAssets().open("directory.json");

            int size = is.available();

            byte[] buffer = new byte[size];

            is.read(buffer);

            is.close();

            json = new String(buffer, "UTF-8");


        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
        return json;

    }

    public static ArrayList<Direct> getDirectory(Context context) {
        JSONObject obj;
        try {
            obj = new JSONObject(loadJSONFromAsset(context));
        } catch (JSONException ex) {
            ex.printStackTrace();
            return null;
        }
        JSONArray directory;
        try {


            directory = obj.getJSONArray("directory");
        } catch (JSONException ex) {
            ex.printStackTrace();
            return null;
        }
        ArrayList<Direct> directories = new ArrayList<Direct>();

        for (int i = 0; i < directory.length(); i++) {
            Direct x;
            try {
                JSONObject jo = directory.getJSONObject(i);
                x = new Direct(jo.getString("name"), jo.getString("room_number"), jo.getString("floor"), jo.getString("block"));
            } catch (JSONException ex) {
                ex.printStackTrace();
                return null;
            }
            directories.add(x);
        }

        return directories;
    }
}