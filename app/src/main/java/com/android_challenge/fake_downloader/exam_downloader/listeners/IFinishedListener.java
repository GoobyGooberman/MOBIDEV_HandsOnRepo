package com.android_challenge.fake_downloader.exam_downloader.listeners;

import com.android_challenge.fake_downloader.exam_downloader.models.MovieModel;
import com.android_challenge.fake_downloader.exam_downloader.services.FakeDownloadService;

/**
 *
 * Created by delgallegon on 26/03/2018.
 */

public interface IFinishedListener {
    // handled by your downloader activity.
    void onDownloadFinished(MovieModel movieModel, FakeDownloadService service);
}