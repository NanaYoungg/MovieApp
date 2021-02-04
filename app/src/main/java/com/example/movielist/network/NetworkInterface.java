package com.example.movielist.network;

import com.example.movielist.models.MovieResponse;

import java.util.Observable;

import retrofit2.http.GET;
import retrofit2.http.Query;

public interface NetworkInterface {

    @GET("discover/movie")
    Observable<MovieResponse> getMovies(@Query("api_key") String api_key);
}
