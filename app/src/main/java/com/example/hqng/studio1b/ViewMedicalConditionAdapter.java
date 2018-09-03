package com.example.hqng.studio1b;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class ViewMedicalConditionAdapter extends RecyclerView.Adapter<ViewMedicalConditionAdapter.ViewMedicalConditionViewHolder> {

    private Context context;
    private ArrayList<MedicalCondition> list;

    public ViewMedicalConditionAdapter(Context context, ArrayList<MedicalCondition> list){
        this.context = context;
        this.list = list;
    }

    @Override
    public ViewMedicalConditionAdapter.ViewMedicalConditionViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(this.context);
        View view = inflater.inflate(R.layout.recycler_view_medical_condition, null);
        return new ViewMedicalConditionViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewMedicalConditionViewHolder holder, int position) {
        MedicalCondition condition = list.get(position);
        holder.viewConditionName.setText(condition.getConditionTitle());
        holder.viewConditionDesc.setText(condition.getConditionDescription());
    }

    @Override
    public int getItemCount() {
        return this.list.size();
    }

    class ViewMedicalConditionViewHolder extends RecyclerView.ViewHolder {
        TextView viewConditionName, viewConditionDesc;

        public ViewMedicalConditionViewHolder(View view) {
            super(view);
            viewConditionName = (TextView) view.findViewById(R.id.conditionName);
            viewConditionDesc = (TextView) view.findViewById(R.id.conditionDesc);
        }

    }

}
