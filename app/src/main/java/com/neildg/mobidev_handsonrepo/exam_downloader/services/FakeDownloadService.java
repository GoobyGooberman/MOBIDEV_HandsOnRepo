package com.neildg.mobidev_handsonrepo.exam_downloader.services;

import android.app.Activity;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

import com.neildg.mobidev_handsonrepo.exam_downloader.DownloaderActivity;
import com.neildg.mobidev_handsonrepo.exam_downloader.models.MovieModel;
import com.neildg.mobidev_handsonrepo.exam_downloader.views.OngoingMovieViewHolder;

import static android.content.ContentValues.TAG;

public class FakeDownloadService extends Service {
    private final static String TAG = "FakeDownloadService";

    private FakeDownloadBinder binder;
    private MovieModel movieModel;
    private OngoingMovieViewHolder movieViewHolder;

    public FakeDownloadService() {

    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        return this.binder;
    }

    @Override
    public void onCreate() {
        super.onCreate();

        this.binder = new FakeDownloadBinder(this);
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public boolean onUnbind(Intent intent) {
        this.binder = null;
        return super.onUnbind(intent);
    }

    public void setMovieToDownload(MovieModel movieModel, final OngoingMovieViewHolder movieViewHolder) {
        this.movieModel = movieModel;
        this.movieViewHolder = movieViewHolder;

        Log.d(TAG, "SETTING: Fake download service started for the movie: " +this.movieModel.getName());
        Log.d(TAG, "SETTING: Movie model position: " +movieModel.getViewPosition());

        try {
            movieViewHolder.initializeBar(0, 100);

            for(int currentProgress = 0; currentProgress <= 100; currentProgress+=5) {
                Thread.sleep(50);
                movieViewHolder.updateProgress(currentProgress);
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
