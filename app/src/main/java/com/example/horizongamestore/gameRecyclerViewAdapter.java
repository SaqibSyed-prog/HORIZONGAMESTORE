package com.example.horizongamestore;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

public class gameRecyclerViewAdapter extends RecyclerView.Adapter<gameRecyclerViewAdapter.ViewHolder> {

    List<Game> gameList;
    Context context;

    public gameRecyclerViewAdapter(Context context, List<Game> gameList) {
        this.gameList = gameList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.title.setText(gameList.get(position).getTitle());
        Glide.with(context)
                .load(gameList.get(position).getThumbnail())
                .into(holder.thumbnailUrl);
    }

    @Override
    public int getItemCount() {
        return gameList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView title;
        ImageView thumbnailUrl;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            thumbnailUrl = itemView.findViewById(R.id.thumbnail);
//            url = itemView.findViewById(R.id.floatingActionButtonUrl);
            title = itemView.findViewById(R.id.title);

        }
    }
}

