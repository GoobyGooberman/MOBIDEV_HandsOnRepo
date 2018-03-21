package com.neildg.mobidev_handsonrepo.exam_downloader.listeners;

import com.neildg.mobidev_handsonrepo.exam_downloader.models.MovieModel;
import com.neildg.mobidev_handsonrepo.exam_downloader.services.FakeDownloadService;

/**
 * Holds list of listeners to be used for triggered events.
 * Created by NeilDG on 3/8/2018.
 */

public class MovieDownloadPackage {
    public interface IDownloadListener {
        void onDownloadInitiated(int index);
    }

    public interface IFinishedListener {
        void onDownloadFinished(MovieModel movieModel, FakeDownloadService service);
    }
}
