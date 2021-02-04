package com.example.movielist.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.movielist.R;
import com.example.movielist.models.Result;

import java.util.List;

public class MoviesAdapter extends RecyclerView.Adapter<MoviesAdapter.MovieHolder> {

    private List<Result> mMovieList;
    private Context mContext;

    public MoviesAdapter(List<Result> movieList, Context context){
        this.mMovieList = movieList;
        this.mContext = context;
    }


    @NonNull
    @Override
    public MovieHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       View v = LayoutInflater.from(mContext).inflate(R.layout.row_movies, parent, false);
       MovieHolder mh = new MovieHolder(v);
        return mh;
    }

    @Override
    public void onBindViewHolder(@NonNull MovieHolder holder, int position) {

        holder.mTvTitle.setText(mMovieList.get(position).getTitle());
        holder.mTvOverview.setText(mMovieList.get(position).getOverview());
        holder.mTvReleaseDate.setText(mMovieList.get(position).getReleaseDate());
        Glide.with(mContext).load("https://image.tmdb.org/t/p/w500/"+mMovieList.get(position).getPosterPath()).into(holder.mIvMoVie);

    }

    @Override
    public int getItemCount() {
        return mMovieList.size();
    }

    public class MovieHolder extends RecyclerView.ViewHolder {

        private TextView mTvTitle, mTvOverview, mTvReleaseDate;
        private ImageView mIvMoVie;

        public MovieHolder(@NonNull View v) {
            super(v);
            mTvTitle = (TextView)v.findViewById(R.id.tv_Title);
            mTvOverview = (TextView)v.findViewById(R.id.tv_OverView);
            mTvReleaseDate = (TextView)v.findViewById(R.id.tv_ReleaseDate);
            mIvMoVie = (ImageView)v.findViewById(R.id.iv_Movie);
        }
    }
}
