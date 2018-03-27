package com.android_challenge.fake_downloader.exam_downloader;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.android_challenge.fake_downloader.exam_downloader.listeners.IFinishedListener;
import com.android_challenge.fake_downloader.exam_downloader.models.MovieModel;
import com.android_challenge.fake_downloader.exam_downloader.models.MovieRepository;
import com.android_challenge.fake_downloader.exam_downloader.services.FakeDownloadService;
import com.android_challenge.fake_downloader.exam_downloader.views.DownloadingMovieAdapter;
import com.android_challenge.fake_downloader.exam_downloader.views.FinishedMovieAdapter;
import com.neildg.mobidev_handsonrepo.R;


public class DownloaderActivity extends AppCompatActivity implements IFinishedListener {
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
    protected void onDestroy() {
        this.destroyService();
        super.onDestroy();
    }

    @Override
    protected void onResume() {
        super.onResume();
        this.refreshLists();
        this.handleDownloads();
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

    private void destroyService() {
        //fill this up with method calls related to destroying and unbinding of services
        Log.d(TAG, "Services destroyed!");
    }

    private void setupDownloadingList() {
       //setup the downloading recycler view
    }

    private void setupFinishedList() {
        //setup the finished recycler view
    }

    private void refreshLists() {
        this.downloadingMovieAdapter = null;
        this.finishedMovieAdapter = null;

        //re-initializes your downloading and finished adapter, with the updated list of movies.
    }

    private void handleDownloads() {
        final MovieModel movieModel = MovieRepository.getInstance().getLatestDownloadableMovie();
        if(movieModel != null) {
           //creates a service connection, starts and binds the service intent. automatically starts the service.
        }
    }

    @Override
    public void onDownloadFinished(MovieModel movieModel, FakeDownloadService service) {
        //marks a given movie as "finished", updates your UI, and displays a notification to the user.
    }
}
