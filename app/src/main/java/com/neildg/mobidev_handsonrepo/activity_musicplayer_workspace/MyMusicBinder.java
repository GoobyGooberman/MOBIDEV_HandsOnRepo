package com.neildg.mobidev_handsonrepo.activity_musicplayer_workspace;

import android.os.Binder;

/**
 * Created by Administrator on 3/9/2018.
 */

public class MyMusicBinder extends Binder {
    private MyMusicService musicService;

    public MyMusicBinder(MyMusicService myMusicService) {
        this.musicService = myMusicService;
    }

    public MyMusicService getMusicService() {
        return this.musicService;
    }
}
