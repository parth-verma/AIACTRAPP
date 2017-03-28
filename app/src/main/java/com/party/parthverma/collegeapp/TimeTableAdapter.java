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
import java.util.PriorityQueue;


public class TimeTableAdapter extends BaseAdapter {

    private Context context;
    private LayoutInflater inflater;
    private ArrayList<TimeTableCse> data_src;

    public TimeTableAdapter(Context context, ArrayList<TimeTableCse> items) {
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
        if(convertView == null) {

            // 2
            convertView = inflater.inflate(R.layout.timetable_layout, parent, false);

            // 3
            holder = new ViewHolder();
            holder.name= (TextView) convertView.findViewById(R.id.branch_name);
            holder.semester = (TextView) convertView.findViewById(R.id.branch_year);

            // 4
            convertView.setTag(holder);
        }
        else{
            // 5
            holder = (ViewHolder) convertView.getTag();
        }
        TextView name = holder.name;
        TextView branch = holder.semester;


        TimeTableCse timeTableCse = (TimeTableCse) getItem(position);
        name.setText(timeTableCse.name);
        branch.setText(timeTableCse.semester);

        return convertView;

    }

    private static class ViewHolder {
        public TextView name;
        public TextView semester;
    }


}


class TimeTableCse {
    String name, semester, image_loc;

    public TimeTableCse(String name, String semester, String image_loc)
    {
        this.name=name;
        this.semester=semester;
        this.image_loc = image_loc;

    }
    static private String loadJSONFromAsset(Context context) {
        String json = null;
        try {

            InputStream is = context.getAssets().open("timetable.json");

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

    public static ArrayList<TimeTableCse> getTimeTableCse(Context context)
    {
        JSONObject obj;
        try {
            obj = new JSONObject(loadJSONFromAsset(context));
        }catch (JSONException ex){
            ex.printStackTrace();
            return null;
        }
        JSONArray timetablecse;
        try {


            timetablecse = obj.getJSONArray("cse");
        }catch (JSONException ex)
        {
            ex.printStackTrace();
            return null;
        }
        ArrayList<TimeTableCse> cse = new ArrayList<TimeTableCse>();

        for (int i=0;i< timetablecse.length() ;i++)
        {
            TimeTableCse x;
            try {
                JSONObject jo = timetablecse.getJSONObject(i);
                x = new TimeTableCse(jo.getString("name"), jo.getString("semester"),jo.getString("image_url"));
            }catch (JSONException ex)
            {
                ex.printStackTrace();
                return null;
            }
            cse.add(x);
        }

        return cse;
    }
}
