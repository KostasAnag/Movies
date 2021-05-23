package com.example.movies;


import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MovieAdapter extends RecyclerView.Adapter {

    private Context context;
    private ArrayList<Movie> movies;

    public MovieAdapter(Context context, ArrayList<Movie> movies) {
        this.context = context;
        this.movies = movies;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View row = inflater.inflate(R.layout.movie_row, parent, false);
        MyViewHolder holder = new MyViewHolder(row);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ((MyViewHolder)holder).txtVw_title.setText(movies.get(position).getTitle());
        //((MyViewHolder)holder).txtVw_notes.setText(movies.get(position).getNotes());
       // ((MyViewHolder)holder).txtVw_category.setText(movies.get(position).getCategory());
       // ((MyViewHolder)holder).txtVw_ratings.setText(String.valueOf(movies.get(position).getRatings()));

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, MovieActivity.class);
                intent.putExtra("movie_id", movies.get(position).getId());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return this.movies.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        TextView txtVw_title;
        //TextView txtVw_notes;
        //TextView txtVw_category;
        //TextView txtVw_ratings;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            txtVw_title = itemView.findViewById(R.id.txtVw_title);
           // txtVw_notes = itemView.findViewById(R.id.txtVw_notes);
           // txtVw_category = itemView.findViewById(R.id.txtVw_category);
           // txtVw_ratings = itemView.findViewById(R.id.txtVw_ratings);
        }
    }
}
