package com.neildg.mobidev_handsonrepo.activity_musicplayer_workspace;

import android.os.Binder;

/**
 * Created by Administrator on 3/2/2018.
 */

public class S14_MusicBinder extends Binder {
    private final static String TAG = "S14_MusicBinder";

    private S14_MusicService musicService;

    public S14_MusicBinder(S14_MusicService musicService) {
        this.musicService = musicService;
    }

    public S14_MusicService getMusicService() {
        return this.musicService;
    }
}
