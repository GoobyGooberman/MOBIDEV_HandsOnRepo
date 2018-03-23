package com.neildg.mobidev_handsonrepo.activity_musicplayer_workspace;

import android.content.Context;
import android.widget.MediaController;

/**
 * Created by Administrator on 3/23/2018.
 */

public class S14_MusicControllerUI extends MediaController {
    public boolean forCleaning = false;

    public S14_MusicControllerUI(Context context) {
        super(context);
    }

    public void markForCleaning(boolean flag){
        this.forCleaning = flag;
    }

    public void hide(){
        if(this.forCleaning){
            super.hide();
        }
    }
}
