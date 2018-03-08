package com.neildg.mobidev_handsonrepo.exam_downloader;

import android.content.Intent;
import android.graphics.Movie;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import com.neildg.mobidev_handsonrepo.R;
import com.neildg.mobidev_handsonrepo.exam_downloader.listeners.MovieDownloadPackage;
import com.neildg.mobidev_handsonrepo.exam_downloader.models.MovieRepository;
import com.neildg.mobidev_handsonrepo.exam_downloader.views.DownloadingMovieAdapter;
import com.neildg.mobidev_handsonrepo.exam_downloader.views.FinishedMovieAdapter;
import com.neildg.mobidev_handsonrepo.exam_downloader.models.MovieModel;

import java.util.ArrayList;

public class DownloaderActivity extends AppCompatActivity {
    private final static String TAG = "DownloaderActivity";

    private RecyclerView downloadingView;
    private DownloadingMovieAdapter downloadingMovieAdapter;

    private RecyclerView finishedView;
    private FinishedMovieAdapter finishedMovieAdapter;

    private MovieModel[] downloadingList;
    private MovieModel[] finishedList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_downloader);

        this.setupDownloadingList();
        this.setupFinishedList();
        this.setupBtns();
    }

    @Override
    protected void onResume() {
        super.onResume();
        this.refreshLists();
    }

    private void setupBtns() {
        Button downloadListBtn = this.findViewById(R.id.download_btn);
        downloadListBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(DownloaderActivity.this, MovieListActivity.class);
                startActivity(i);
            }
        });
    }

    private void setupDownloadingList() {
        this.downloadingList = MovieRepository.getInstance().getDownloadingMovies();
        this.downloadingView = this.findViewById(R.id.ongoing_view);
        this.downloadingMovieAdapter = new DownloadingMovieAdapter(this.downloadingList);
        RecyclerView.LayoutManager recylerLayoutManager = new LinearLayoutManager(this);
        this.downloadingView.setLayoutManager(recylerLayoutManager);
        this.downloadingView.setItemAnimator(new DefaultItemAnimator());
        this.downloadingView.setAdapter(this.downloadingMovieAdapter);
    }

    private void setupFinishedList() {
        this.finishedList = MovieRepository.getInstance().getFinishedMovies();
        this.finishedView = this.findViewById(R.id.finished_view);
        this.finishedMovieAdapter = new FinishedMovieAdapter(this.finishedList);
        RecyclerView.LayoutManager recylerLayoutManager = new LinearLayoutManager(this);
        this.finishedView.setLayoutManager(recylerLayoutManager);
        this.finishedView.setItemAnimator(new DefaultItemAnimator());
        this.finishedView.setAdapter(this.finishedMovieAdapter);
    }

    private void refreshLists() {
        this.downloadingList = MovieRepository.getInstance().getDownloadingMovies();
        this.downloadingMovieAdapter = new DownloadingMovieAdapter(this.downloadingList);
        this.downloadingView.setAdapter(this.downloadingMovieAdapter);

        this.finishedList = MovieRepository.getInstance().getFinishedMovies();
        this.finishedMovieAdapter = new FinishedMovieAdapter(this.finishedList);
        this.finishedView.setAdapter(this.finishedMovieAdapter);
    }

}
