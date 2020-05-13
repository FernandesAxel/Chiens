package com.example.chiens.Model;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.chiens.R;

import java.util.List;

public class ListChiotsAdapter extends RecyclerView.Adapter<ListChiotsAdapter.ViewHolder> {

    private List<Chiots> values;
    private Context context;
    private ImageView imageView;


    class ViewHolder extends RecyclerView.ViewHolder {

        TextView race;

        View layout;

        ViewHolder(View v) {
            super(v);
            layout = v;
            race = v.findViewById(R.id.race);
            imageView = v.findViewById(R.id.imageView);


        }
    }


    public ListChiotsAdapter(List<Chiots> Test, Context context) {
        values = Test;
        this.context = context;
    }


    @NonNull
    @Override
    public ListChiotsAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View v = inflater.inflate(R.layout.row_layout, parent, false);

        return new ViewHolder(v);
    }


    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {

        final Chiots currentChiots = values.get(position);
        holder.race.setText(currentChiots.getRace());
        Glide.with(context).load(values.get(position).getUrl()).fitCenter().into(imageView);


    }


    @Override
    public int getItemCount() {

        return values.size();
    }
}