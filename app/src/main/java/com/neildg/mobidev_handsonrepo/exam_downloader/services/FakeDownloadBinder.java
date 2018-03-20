package com.neildg.mobidev_handsonrepo.exam_downloader.services;

import android.os.Binder;
import android.os.IBinder;

/**
 * Created by NeilDG on 3/20/2018.
 */

public class FakeDownloadBinder extends Binder {
    private final static String TAG = "FakeDownloadBinder";

    private FakeDownloadService service;

    public FakeDownloadBinder(FakeDownloadService service) {
        this.service = service;
    }

    public FakeDownloadService getService() {
        return this.service;
    }
}
