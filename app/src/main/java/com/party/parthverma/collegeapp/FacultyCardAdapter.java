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
import org.w3c.dom.Text;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class FacultyCardAdapter extends BaseAdapter{


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
        View rowView = inflater.inflate(R.layout.faculty_layout, parent, false);
        TextView name = (TextView) rowView.findViewById(R.id.fac_name);
        TextView desg = (TextView) rowView.findViewById(R.id.fac_desg);
        TextView desc = (TextView) rowView.findViewById(R.id.faculty_desc);
        TextView qual = (TextView) rowView.findViewById(R.id.faculty_qual);
        TextView mail = (TextView) rowView.findViewById(R.id.faculty_mail);
        TextView phone = (TextView) rowView.findViewById(R.id.faculty_phone);
        ImageView logo = (ImageView) rowView.findViewById(R.id.club_image);

        Faculty faculty = (Faculty) getItem(position);
        name.setText(faculty.name);
        desg.setText(faculty.desg);
        Picasso.with(context).load(faculty.image_loc).placeholder(R.drawable.output).into(logo);

        return rowView;

    }
}





class Faculty {
    String name, desg, desc, qual, mail, phone,image_loc;

    public Faculty(String name,String desg,String desc, String qual, String mail, String phone, String image_loc)
    {
        this.name = name;
        this.desg = desg;
        this.desc = desc;
        this.qual = qual;
        this.mail = mail;
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
        JSONArray facul;
        try {


            facul = obj.getJSONArray("faculty");
        }catch (JSONException ex)
        {
            ex.printStackTrace();
            return null;
        }
        ArrayList<Faculty> faculties = new ArrayList<Faculty>();

        for (int i=0;i< facul.length() ;i++)
        {
            Faculty x;
            try {
                JSONObject jo = facul.getJSONObject(i);
                x = new Faculty(jo.getString("name"), jo.getString("designation"), jo.getString("description"), jo.getString("qualification"), jo.getString("mail"), jo.getString("phone"), jo.getString("url"));
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
