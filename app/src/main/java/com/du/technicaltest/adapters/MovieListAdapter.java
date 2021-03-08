package com.du.technicaltest.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.du.technicaltest.R;
import com.du.technicaltest.model.MovieModel;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MovieListAdapter extends RecyclerView.Adapter<MovieListAdapter.MyViewHolder> {
    Context context;
    List<MovieModel> movieList;
    String imageBasePath = "https://image.tmdb.org/t/p/w500";

    public MovieListAdapter(Context context, List<MovieModel> movieList) {
        this.context = context;
        this.movieList = movieList;
    }

    public void setMovieList(List<MovieModel> movieList)
    {
        this.movieList = movieList;
        notifyDataSetChanged();
    }


    @NonNull
    @Override
    public MovieListAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.recycler_row, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MovieListAdapter.MyViewHolder holder, int position) {
        holder.movieTitle.setText(this.movieList.get(position).getTitle());
        Glide.with(context)
                .load(imageBasePath + this.movieList.get(position).getPosterPath())
                .apply(RequestOptions.centerCropTransform())
                .into(holder.moviePoster);
    }

    @Override
    public int getItemCount() {
        if(this.movieList != null)
        {
            return this.movieList.size();
        }
        return 0;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        ImageView moviePoster;
        TextView movieTitle;
        public MyViewHolder(View itemView){
            super(itemView);
            moviePoster = (ImageView) itemView.findViewById(R.id.img_moviePoster);
            movieTitle = (TextView) itemView.findViewById(R.id.tv_movieTitle);

        }
    }
}
