package com.neildg.mobidev_handsonrepo.activity_musicplayer_workspace;

import android.widget.MediaController;

import com.neildg.mobidev_handsonrepo.activity_musicplayer.MusicPlayerActivity;

/**
 * Created by Administrator on 3/23/2018.
 */

public class S14_MusicPlayerControl implements MediaController.MediaPlayerControl{
    private S14_MusicPlayerActivity player;
    private S14_MusicService service;

    public S14_MusicPlayerControl(S14_MusicPlayerActivity player, S14_MusicService service) {
        this.player = player;
        this.service = service;
    }

    @Override
    public void start() {
      /*  if(this.service != null){
            this.service.resume();
        }*/
    }

    @Override
    public void pause() {
        /*if(this.service != null){
            this.service.pause();
        }*/

    }

    @Override
    public int getDuration() {
        /*if(this.service != null && this.player.isMusicBound() && this.service.isPlaying())
            return this.service.getCurrentSongDuration();
        else
            return 0;*/
        return 0;
    }

    @Override
    public int getCurrentPosition() {
        return 0;
    }

    @Override
    public void seekTo(int pos) {

    }

    @Override
    public boolean isPlaying() {
        return false;
    }

    @Override
    public int getBufferPercentage() {
        return 0;
    }

    @Override
    public boolean canPause() {
        return false;
    }

    @Override
    public boolean canSeekBackward() {
        return false;
    }

    @Override
    public boolean canSeekForward() {
        return false;
    }

    @Override
    public int getAudioSessionId() {
        return 0;
    }
}
