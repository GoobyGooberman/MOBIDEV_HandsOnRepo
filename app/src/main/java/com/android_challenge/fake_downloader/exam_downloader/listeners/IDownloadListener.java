package com.android_challenge.fake_downloader.exam_downloader.listeners;

/**
 * Called by a view holder that has a download button.
 * Created by delgallegon on 26/03/2018.
 */
public interface IDownloadListener {

    //calls this function wherein a movie in the movie list will be downloaded, specified by its index.
    void onDownloadInitiated(int index);
}
