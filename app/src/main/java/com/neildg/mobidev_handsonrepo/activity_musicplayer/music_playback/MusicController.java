package com.neildg.mobidev_handsonrepo.activity_musicplayer.music_playback;

import android.content.Context;
import android.widget.MediaController;

/**
 * Created by NeilDG on 2/17/2018.
 */

public class MusicController extends MediaController {

    public boolean forCleaning = false;
    public MusicController(Context context) {
        super(context);
    }

    public void markForCleaning(boolean flag) {
        this.forCleaning = flag;
    }
    @Override
    public void hide() {
        if(this.forCleaning) {
            super.hide();
        }

    }
}
