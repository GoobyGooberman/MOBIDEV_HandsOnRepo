package com.neildg.mobidev_handsonrepo.exam_downloader;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.neildg.mobidev_handsonrepo.R;
import com.neildg.mobidev_handsonrepo.exam_downloader.views.DownloadingMovieAdapter;
import com.neildg.mobidev_handsonrepo.exam_downloader.views.MovieModel;
import com.neildg.mobidev_handsonrepo.exam_downloader.views.MovieViewAdapter;

import java.util.ArrayList;
import java.util.List;

public class MovieListActivity extends AppCompatActivity {
    private final static String TAG = "MovieListActivity";

    private ArrayList<MovieModel> moviesList = new ArrayList<>();

    private RecyclerView moviesView;
    private MovieViewAdapter movieAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_list);

        this.generateDefaultData();
        this.setupDownloadingList();
    }

    private void generateDefaultData() {
        this.moviesList.add(new MovieModel("Black Panther", "De king will now have de strength of de black pantha stripped eweii"));
        this.moviesList.add(new MovieModel("Thor: Ragnarok", "Marvel Studios"));
        this.moviesList.add(new MovieModel("Avengers: Infinity War", "Marvel Studios"));
        this.moviesList.add(new MovieModel("Harry Potter and the Deathly Hallows Part 2", "It All Ends"));
    }

    private void setupDownloadingList() {
        this.moviesView = this.findViewById(R.id.available_movies_view);
        this.movieAdapter = new MovieViewAdapter(this.moviesList);
        RecyclerView.LayoutManager recylerLayoutManager = new LinearLayoutManager(this);
        this.moviesView.setLayoutManager(recylerLayoutManager);
        this.moviesView.setItemAnimator(new DefaultItemAnimator());
        this.moviesView.setAdapter(this.movieAdapter);
    }
}
