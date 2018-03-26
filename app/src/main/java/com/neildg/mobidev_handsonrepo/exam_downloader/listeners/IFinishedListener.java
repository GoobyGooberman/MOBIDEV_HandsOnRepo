package com.neildg.mobidev_handsonrepo.exam_downloader.listeners;

import com.neildg.mobidev_handsonrepo.exam_downloader.models.MovieModel;
import com.neildg.mobidev_handsonrepo.exam_downloader.services.FakeDownloadService;

/**
 *
 * Created by delgallegon on 26/03/2018.
 */

public interface IFinishedListener {
    // handled by your downloader activity.
    void onDownloadFinished(MovieModel movieModel, FakeDownloadService service);
}