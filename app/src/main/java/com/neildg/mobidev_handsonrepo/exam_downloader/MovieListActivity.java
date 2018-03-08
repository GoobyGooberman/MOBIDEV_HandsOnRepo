package com.neildg.mobidev_handsonrepo.exam_downloader;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.neildg.mobidev_handsonrepo.R;
import com.neildg.mobidev_handsonrepo.exam_downloader.listeners.MovieDownloadPackage;
import com.neildg.mobidev_handsonrepo.exam_downloader.models.MovieModel;
import com.neildg.mobidev_handsonrepo.exam_downloader.models.MovieRepository;
import com.neildg.mobidev_handsonrepo.exam_downloader.views.MovieViewAdapter;

import java.util.ArrayList;

public class MovieListActivity extends AppCompatActivity implements MovieDownloadPackage.IDownloadListener {
    private final static String TAG = "MovieListActivity";

    private MovieModel[] moviesList;

    private RecyclerView moviesView;
    private MovieViewAdapter movieAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_list);

        this.setupMoviesList();
    }

    private void setupMoviesList() {
        this.moviesList = MovieRepository.getInstance().getAvailableMovies();
        this.moviesView = this.findViewById(R.id.available_movies_view);
        this.movieAdapter = new MovieViewAdapter(this.moviesList, this);
        RecyclerView.LayoutManager recylerLayoutManager = new LinearLayoutManager(this);
        this.moviesView.setLayoutManager(recylerLayoutManager);
        this.moviesView.setItemAnimator(new DefaultItemAnimator());
        this.moviesView.setAdapter(this.movieAdapter);
    }

    @Override
    public void onDownloadInitiated(int index) {
        MovieRepository.getInstance().markMovieForDownload(index);
        this.finish();
    }
}
