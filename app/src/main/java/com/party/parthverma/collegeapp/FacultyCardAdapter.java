package com.party.parthverma.collegeapp;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.w3c.dom.Text;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class FacultyCardAdapter extends BaseAdapter {


    private Context context;
    private LayoutInflater inflater;
    private ArrayList<Faculty> data_src;

    public FacultyCardAdapter(Context context, ArrayList<Faculty> items) {
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
        Log.d("Parth","Inside getView");
        ViewHolder holder;
        if(convertView == null) {

            // 2
            convertView = inflater.inflate(R.layout.faculty_layout, parent, false);

            // 3
            holder = new ViewHolder();
            holder.facultyImage = (ImageView) convertView.findViewById(R.id.faculty_image);
            holder.name= (TextView) convertView.findViewById(R.id.fac_name);
            holder.designation = (TextView) convertView.findViewById(R.id.fac_desg);

            // 4
            convertView.setTag(holder);
        }
        else{
            // 5
            holder = (ViewHolder) convertView.getTag();
        }

        TextView name = holder.name;
        TextView desg = holder.designation;
        ImageView logo = holder.facultyImage;

        Faculty faculty = (Faculty) getItem(position);
        name.setText(faculty.name);
        desg.setText(faculty.designation);
        Picasso.with(context).load(faculty.image_loc).into(logo);

        return convertView;

    }
    private static class ViewHolder {
        public TextView name;
        public TextView designation;
        public ImageView facultyImage;
    }
    public void measureItems(int columnWidth) {
        Log.d("Parth","Inside measureItems");
        // Obtain system inflater
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        // Inflate temp layout object for measuring
        GridViewItemLayout itemView = (GridViewItemLayout)inflater.inflate(R.layout.faculty_layout, null);

        // Create measuring specs
        int widthMeasureSpec = View.MeasureSpec.makeMeasureSpec(columnWidth, View.MeasureSpec.EXACTLY);
        int heightMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED);

        // Loop through each data object
        for(int index = 0; index < data_src.size(); index++) {
            Faculty item = data_src.get(index);

            // Set position and data
            itemView.setPosition(index);
            itemView.updateItemDisplay(item);

            // Force measuring
            itemView.requestLayout();
            itemView.measure(widthMeasureSpec, heightMeasureSpec);
        }
    }

}





class Faculty {
    String name, designation, description, qualification, email, phone,image_loc;

    public Faculty(String name,String designation,String description, String qualification, String email, String phone, String image_loc)
    {
        this.name = name;
        this.designation = designation;
        this.description = description;
        this.qualification = qualification;
        this.email = email;
        this.phone = phone;
        this.image_loc = image_loc;

    }
    static private String loadJSONFromAsset(Context context) {
        String json = null;
        try {

            InputStream is = context.getAssets().open("faculty.json");

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

    public static ArrayList<Faculty> getFaculties(Context context)
    {
        JSONObject obj;
        try {
            obj = new JSONObject(loadJSONFromAsset(context));
        }catch (JSONException ex){
            ex.printStackTrace();
            return null;
        }
        JSONArray faculty;
        try {


            faculty = obj.getJSONArray("faculty");
        }catch (JSONException ex)
        {
            ex.printStackTrace();
            return null;
        }
        ArrayList<Faculty> faculties = new ArrayList<Faculty>();

        for (int i=0;i< faculty.length() ;i++)
        {
            Faculty x;
            try {
                JSONObject jo = faculty.getJSONObject(i);
                x = new Faculty(jo.getString("name"), jo.getString("designation"), jo.getString("description"), jo.getString("qualification"), jo.getString("mail"), jo.getString("phone"), jo.getString("image_url"));
            }catch (JSONException ex)
            {
                ex.printStackTrace();
                return null;
            }
            faculties.add(x);
        }

        return faculties;
    }
}
