package com.android_challenge.fake_downloader.exam_downloader.listeners;

/**
 * Attach this to your view holder that has a progress bar.
 * Created by delgallegon on 26/03/2018.
 */

public interface IOngoingMovieViewHolder {
    //initializes your progress bar
    void initializeBar(int currentValue, int maxValue);
    //updates the progress bar value
    void updateProgress(int value);
}
