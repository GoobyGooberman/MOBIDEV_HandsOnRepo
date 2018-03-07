package com.neildg.mobidev_handsonrepo.exam_downloader;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import com.neildg.mobidev_handsonrepo.R;
import com.neildg.mobidev_handsonrepo.activity_restaurant.RestaurantAdapter;
import com.neildg.mobidev_handsonrepo.activity_restaurant.RestaurantModel;
import com.neildg.mobidev_handsonrepo.exam_downloader.views.DownloadingMovieAdapter;
import com.neildg.mobidev_handsonrepo.exam_downloader.views.FinishedMovieAdapter;
import com.neildg.mobidev_handsonrepo.exam_downloader.views.MovieModel;

import java.util.ArrayList;

public class DownloaderActivity extends AppCompatActivity {

    private ArrayList<MovieModel> downloadingList = new ArrayList<MovieModel>();
    private ArrayList<MovieModel> finishedList = new ArrayList<>();

    private RecyclerView downloadingView;
    private DownloadingMovieAdapter downloadingMovieAdapter;

    private RecyclerView finishedView;
    private FinishedMovieAdapter finishedMovieAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_downloader);

        this.generateDefaultData();
        this.setupDownloadingList();
        this.setupFinishedList();
        this.setupBtns();
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

    private void generateDefaultData() {
        this.downloadingList.add(new MovieModel("Black Panther", "De king will now have de strength of de black pantha stripped eweii"));
        this.downloadingList.add(new MovieModel("Thor: Ragnarok", "Marvel Studios"));
        this.downloadingList.add(new MovieModel("Avengers: Infinity War", "Marvel Studios"));
        this.downloadingList.add(new MovieModel("Harry Potter and the Deathly Hallows Part 2", "It All Ends"));
    }

    private void setupDownloadingList() {
        this.downloadingView = this.findViewById(R.id.ongoing_view);
        this.downloadingMovieAdapter = new DownloadingMovieAdapter(this.downloadingList);
        RecyclerView.LayoutManager recylerLayoutManager = new LinearLayoutManager(this);
        this.downloadingView.setLayoutManager(recylerLayoutManager);
        this.downloadingView.setItemAnimator(new DefaultItemAnimator());
        this.downloadingView.setAdapter(this.downloadingMovieAdapter);
    }

    private void setupFinishedList() {
        this.finishedView = this.findViewById(R.id.finished_view);
        this.finishedMovieAdapter = new FinishedMovieAdapter(this.downloadingList); //QQQQ replace with finishedList
        RecyclerView.LayoutManager recylerLayoutManager = new LinearLayoutManager(this);
        this.finishedView.setLayoutManager(recylerLayoutManager);
        this.finishedView.setItemAnimator(new DefaultItemAnimator());
        this.finishedView.setAdapter(this.finishedMovieAdapter);

    }
}
