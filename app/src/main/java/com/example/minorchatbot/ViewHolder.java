package com.example.minorchatbot;

import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;


public class ViewHolder extends RecyclerView.ViewHolder {


    TextView listItemNumberView;


    public ViewHolder(View itemView) {
        super(itemView);
        listItemNumberView = (TextView) itemView.findViewById(R.id.msgs);
    }

}
