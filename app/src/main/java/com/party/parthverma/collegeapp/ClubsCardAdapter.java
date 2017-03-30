package com.party.parthverma.collegeapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;


public class ClubsCardAdapter extends BaseAdapter {

    private Context context;
    private LayoutInflater inflater;
    private ArrayList<Club> data_src;

    public ClubsCardAdapter(Context context, ArrayList<Club> items) {
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
            convertView = inflater.inflate(R.layout.club_card_layout, parent, false);

            // 3
            holder = new ViewHolder();
            holder.clubImage = (ImageView) convertView.findViewById(R.id.club_image);
            holder.name = (TextView) convertView.findViewById(R.id.club_name);
            holder.type = (TextView) convertView.findViewById(R.id.club_type);

            // 4
            convertView.setTag(holder);
        } else {
            // 5
            holder = (ViewHolder) convertView.getTag();
        }
        TextView name = holder.name;
        TextView type = holder.type;
        ImageView logo = holder.clubImage;

        Club club = (Club) getItem(position);
        name.setText(club.name);
        type.setText(club.type);
        Picasso.with(context).load(club.image_loc).into(logo);

        return convertView;

    }

    private static class ViewHolder {
        public TextView name;
        public TextView type;
        public ImageView clubImage;
    }


}


class Club {
    String name, type, desc, image_loc;

    public Club(String name, String type, String desc, String image_loc) {
        this.name = name;
        this.type = type;
        this.desc = desc;
        this.image_loc = image_loc;

    }

    static private String loadJSONFromAsset(Context context) {
        String json = null;
        try {

            InputStream is = context.getAssets().open("clubs.json");

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

    public static ArrayList<Club> getClubs(Context context) {
        JSONObject obj;
        try {
            obj = new JSONObject(loadJSONFromAsset(context));
        } catch (JSONException ex) {
            ex.printStackTrace();
            return null;
        }
        JSONArray club;
        try {


            club = obj.getJSONArray("clubs");
        } catch (JSONException ex) {
            ex.printStackTrace();
            return null;
        }
        ArrayList<Club> clubs = new ArrayList<Club>();

        for (int i = 0; i < club.length(); i++) {
            Club x;
            try {
                JSONObject jo = club.getJSONObject(i);
                x = new Club(jo.getString("name"), jo.getString("type"), jo.getString("desc"), jo.getString("main_image_url"));
            } catch (JSONException ex) {
                ex.printStackTrace();
                return null;
            }
            clubs.add(x);
        }

        return clubs;
    }
}
