package com.example.hasine.tinderr;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class CustomAdapter extends BaseAdapter{

    String [] result;
    Context context;
    int [] imageId;
    public static String[] friendDetails;
    public static String[] friendNames;
    public static int[] friendImages2 = {R.drawable.hasinegroot, R.drawable.wallagroot, R.drawable.harpreetgroot,
            R.drawable.amandeepgroot, R.drawable.yektagroot, R.drawable.nataliegroot};
    private static LayoutInflater inflater=null;
    public CustomAdapter(MainActivityTinder mainActivity, String[] friendNames, int[] friendImages) {
        // TODO Auto-generated constructor stub
        result=friendNames;
        context=mainActivity;
        imageId=friendImages;
        inflater = ( LayoutInflater )context.
                getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return result.length;
    }

    @Override
    public Object getItem(int position) {
        // TODO Auto-generated method stub
        return position;
    }

    @Override
    public long getItemId(int position) {
        // TODO Auto-generated method stub
        return position;
    }

    public class Holder
    {
        TextView tv;
        ImageView img;
    }
    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        // TODO Auto-generated method stub
        Holder holder=new Holder();
        View rowView;

        rowView = inflater.inflate(R.layout.friendlist, null);
        holder.tv=(TextView) rowView.findViewById(R.id.textView1);
        holder.img=(ImageView) rowView.findViewById(R.id.imageView1);

        holder.tv.setText(result[position]);
        holder.img.setImageResource(imageId[position]);

        rowView.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {

                //      get info from string friend_details and store them into new string
                friendDetails = context.getResources().getStringArray(R.array.friend_details);
                friendNames = context.getResources().getStringArray(R.array.friend_names);

                String detail = new String();
                int image = 0;
                switch (result[position]) {
                    case "Hasine":
                        detail = friendDetails[0];
                        image = friendImages2[0];
                        break;
                    case "Walla":
                        detail = friendDetails[1];
                        image = friendImages2[1];
                        break;
                    case "Harpreet":
                        detail = friendDetails[2];
                        image = friendImages2[2];
                        break;
                    case "Amandeep":
                        detail = friendDetails[3];
                        image = friendImages2[3];
                        break;
                    case "Yekta":
                        detail = friendDetails[4];
                        image = friendImages2[4];
                        break;
                    case "Natalie":
                        detail = friendDetails[5];
                        image = friendImages2[5];
                        break;
                }

                // passing data(image,name,detail) to second activity
                Intent intent = new Intent(context, SecondActivity.class);
                Bundle b = new Bundle();
                b.putString("name", result[position]);
                b.putString("detail", detail);
                b.putInt("image", image);
                intent.putExtras(b);
                context.startActivity(intent);
            }
        });

        return rowView;
    }
}