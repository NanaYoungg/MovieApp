package com.example.movielist.ui;

import com.example.movielist.models.MovieResponse;
import com.example.movielist.network.NetworkClient;

import java.net.NetworkInterface;
import java.util.Observable;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class MainPresenter implements MainPresenterInterface{

    private MainViewInterface mvi;
    private String TAG = "MainPresenter";

    public MainPresenter(MainViewInterface mvi){
        this.mvi = mvi;
    }

    public void getMovies(){
        getObservable().subscribeWith(getObserver());
    }

    public Observable<MovieResponse> getObserver(){
        return NetworkClient.getRetrofit().create(NetworkInterface.class)
                .getMovies("303e211d88ac47c43075a15cd3bbaf2e")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }
}
