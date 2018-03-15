package com.example.application.AnsarAlsunaDonations;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

/**
 * Created by Yaseen on 31/12/2016.
 */

public class CustomAdapter extends ArrayAdapter<String>{
  public CustomAdapter(@NonNull Context context, String [] ISPs) {
        super(context,R.layout.custom_row, ISPs);

    }
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater myInflater = LayoutInflater.from(getContext());
        View CustomView = myInflater.inflate(R.layout.custom_row, parent, false);

        String singlefruitItem =getItem(position);
        TextView myText=(TextView) CustomView.findViewById(R.id.myText);
        myText.setText(singlefruitItem);

        return CustomView;
    }
}
