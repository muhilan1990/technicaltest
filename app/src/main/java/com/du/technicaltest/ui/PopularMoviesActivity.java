package com.du.technicaltest.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.du.technicaltest.R;
import com.du.technicaltest.adapters.MovieListAdapter;
import com.du.technicaltest.model.MovieModel;
import com.du.technicaltest.model.MoviesResponse;
import com.du.technicaltest.viewmodel.MovieListViewModel;

import java.util.List;

public class PopularMoviesActivity extends AppCompatActivity {

    private List<MovieModel> movieModelList;
    private MovieListAdapter adapter;
    private MovieListViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_popular_movies);

        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        LinearLayoutManager linearLayoutManager = new GridLayoutManager(this, 2);
        recyclerView.setLayoutManager(linearLayoutManager);
        adapter = new MovieListAdapter(this, movieModelList);
        recyclerView.setAdapter(adapter);

        TextView noResult = (TextView) findViewById(R.id.tv_noResult);

        viewModel = ViewModelProviders.of(this).get(MovieListViewModel.class);
        viewModel.getMovieListObserver().observe(this, new Observer<MoviesResponse>() {

            @Override
            public void onChanged(MoviesResponse movieModels) {
                if (movieModels != null) {
                    movieModelList = movieModels.getResults();
                    adapter.setMovieList(movieModelList);
                    noResult.setVisibility(View.GONE);
                } else {
                    noResult.setVisibility(View.VISIBLE);
                }
            }
        });

        viewModel.apiServiceCall();
    }

    @Override
    public void onBackPressed() {
        startActivity(new Intent(this, LoginActivity.class));
        finish();
    }
}