package com.example.priteshpatel.mylist;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class CustomAdapter extends  ArrayAdapter<String>{
    public CustomAdapter(Context context, String[] activities) {
        super(context,R.layout.custom_row ,activities);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater psInflater=LayoutInflater.from(getContext());
        View myview=psInflater.inflate(R.layout.custom_row,parent,false);
        String acti_name=getItem(position);

        TextView myText=(TextView)myview.findViewById(R.id.psText);
        ImageView psImage=(ImageView)myview.findViewById(R.id.myImage);
        myText.setText(acti_name);
        psImage.setImageResource(R.mipmap.pritesh);
        return myview;

    }
}
