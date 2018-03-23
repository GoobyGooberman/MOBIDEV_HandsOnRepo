package com.neildg.mobidev_handsonrepo.activity_musicplayer_workspace;

import android.content.Context;
import android.widget.MediaController;

/**
 * Created by Administrator on 3/21/2018.
 */

public class S16_MusicControllerUI extends MediaController {
    public boolean forCleaning = false;

    public S16_MusicControllerUI(Context context) {
        super(context);
    }

    public void markforCleaning(boolean flag){
        this.forCleaning=flag;
    }

    @Override
    public void hide() {
        if(this.forCleaning){
            super.hide();
        }
    }
}
