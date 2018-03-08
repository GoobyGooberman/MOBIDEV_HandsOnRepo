package com.neildg.mobidev_handsonrepo.exam_downloader.listeners;

/**
 * Holds list of listeners to be used for triggered events.
 * Created by NeilDG on 3/8/2018.
 */

public class MovieDownloadPackage {
    public interface IDownloadListener {
        void onDownloadInitiated(int index);
    }
}
