package com.neildg.mobidev_handsonrepo.activity_musicplayer;

import android.os.Binder;

import com.neildg.mobidev_handsonrepo.activity_musicplayer_workspace.S16_MusicService;

/**
 * Created by Administrator on 3/2/2018.
 */

public class S16_MusicBinder extends Binder {
    private final static String TAG = "S16_MusicBinder";

    private S16_MusicService musicService;

    public S16_MusicBinder(S16_MusicService service) {
        this.musicService = service;
    }

    public S16_MusicService getMusicService() {
        return this.musicService;
    }
}
