package com.example.chiens.Model;


import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.chiens.Controller.GalleryActivity;
import com.example.chiens.R;

import java.util.ArrayList;



public class ChienMignonAdapter extends RecyclerView.Adapter<ChienMignonAdapter.ViewHolder>{

    private ArrayList<String> mImages = new ArrayList<>();
    private ArrayList<String> mText = new ArrayList<>();
    private Context mContext;

    public ChienMignonAdapter(Context mContext, ArrayList<String> mImages, ArrayList<String> mText ) {
        this.mImages = mImages;
        this.mText = mText;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_listitem,parent,false);
        ViewHolder holder = new ViewHolder(v);
        return  holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {

        Glide.with(mContext).asBitmap().load(mImages.get(position)).into(holder.image);
        holder.textView.setText(mText.get(position));

        holder.layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(mContext,GalleryActivity.class);
                i.putExtra("image_url",mImages.get(position));
                i.putExtra("text",mText.get(position));
                mContext.startActivity(i);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mText.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView image;
        TextView textView;
        RelativeLayout layout;

        public ViewHolder( View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.imageView_chien_mignon);
            textView = itemView.findViewById(R.id.race_chien_mignon);
            layout = itemView.findViewById(R.id.parent_layout);


        }
    }
}
