package com.example.divya.notepal.Adapter;



import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.divya.notepal.Model.SpecialDaysModel;
import com.example.divya.notepal.R;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by Divya on 23-02-2017.
 */

public class SpecialDaysAdapter extends RecyclerView.Adapter<SpecialDaysAdapter.MyViewHolder> {
    private Context mContext;
    private List<SpecialDaysModel> specialDaysList;

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.row, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        SpecialDaysModel specialDay = specialDaysList.get(position);
        holder.title.setText(specialDay.getSpecialDayTitle());
        holder.date.setText(specialDay.getSpacialDayDate());

    }

    @Override
    public int getItemCount() {
        return specialDaysList.size();
    }

    public SpecialDaysAdapter(Context mContext, List<SpecialDaysModel> specialDaysList) {
        this.mContext = mContext;
        this.specialDaysList = specialDaysList;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView title,date;
        public MyViewHolder(View itemView) {
            super(itemView);
            title = (TextView) itemView.findViewById(R.id.title);
            date = (TextView) itemView.findViewById(R.id.date);
        }
    }
}
