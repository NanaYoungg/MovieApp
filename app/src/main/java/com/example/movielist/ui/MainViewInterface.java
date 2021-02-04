package com.example.movielist.ui;

import com.example.movielist.models.MovieResponse;

public interface MainViewInterface {
    void showToast(String s);
    void displayMovies(MovieResponse movieResponse);
    void displayError(String s);
}
