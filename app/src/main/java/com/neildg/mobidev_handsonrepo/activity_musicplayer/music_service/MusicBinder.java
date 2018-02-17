package com.neildg.mobidev_handsonrepo.activity_musicplayer.music_service;

import android.os.Binder;

/**
 * Created by NeilDG on 2/17/2018.
 */

public class MusicBinder extends Binder {

    private MusicService musicService;
    public MusicBinder(MusicService musicService) {
        this.musicService = musicService;
    }

    public MusicService getService() {
        return this.musicService;
    }
}
