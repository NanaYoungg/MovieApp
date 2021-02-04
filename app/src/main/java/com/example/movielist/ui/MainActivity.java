package com.example.movielist.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.example.movielist.R;
import com.example.movielist.adapters.MoviesAdapter;
import com.example.movielist.models.MovieResponse;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements MainPresenterInterface {

    @BindView(R.id.rv_Movies)
    private RecyclerView mRvMovies;

    private String TAG = "MainActivity";
    private RecyclerView.Adapter mAdapter;
    private MainPresenter mMainPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //ButterKnife
        ButterKnife.bind(this);

        setupMVP();
        setupViews();
        getMovieList();

    }

    private void getMovieList() {
        mMainPresenter.getMovies();
    }

    private void setupViews() {
        mRvMovies.setLayoutManager(new LinearLayoutManager(this));
    }

    private void setupMVP() {
        mMainPresenter = new MainPresenter(this);
    }


    public void showToast(String str){
        Toast.makeText(MainActivity.this, str, Toast.LENGTH_SHORT).show();
    }

    public void displayMovies(MovieResponse movieResponse){
        if(movieResponse != null){
            Log.d(TAG, movieResponse.getResults().get(1).getTitle());
            mAdapter = new MoviesAdapter(movieResponse.getResults(), MainActivity.this);
            mRvMovies.setAdapter(mAdapter);

        }else{

            Log.d(TAG,"movieResponse null");
        }
    }

    public void displayError(String e){
        showToast(e);
    }

}