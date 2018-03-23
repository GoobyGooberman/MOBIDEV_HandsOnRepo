package com.neildg.mobidev_handsonrepo.activity_musicplayer_workspace;

import android.content.Context;
import android.widget.MediaController;

/**
 * Created by Administrator on 3/21/2018.
 */

public class S16_MusicPlayerControl implements MediaController.MediaPlayerControl {

    private S16_MusicPlayerActivity activity;
    private S16_MusicService musicService;

    public S16_MusicPlayerControl(S16_MusicPlayerActivity activity, S16_MusicService musicService) {
        this.activity = activity;
        this.musicService = musicService;
    }

    @Override
    public void start() {
        if(this.musicService != null) {
            this.musicService.resume();
        }
    }

    @Override
    public void pause() {
        if(this.musicService != null) {
            this.musicService.pause();
        }
    }

    @Override
    public int getDuration() {
        if(this.musicService != null && this.activity.isMusicBound() && this.musicService.isPlaying()){
            return this.musicService.getCurrentSongDuration();
        }
        return 0;
    }

    @Override
    public int getCurrentPosition() {
        if(this.musicService != null && this.activity.isMusicBound() && this.musicService.isPlaying()){
            return this.musicService.getCurrentSongPosition();
        }
        return 0;
    }

    @Override
    public void seekTo(int pos) {
        if(this.musicService != null){
            this.musicService.seek(pos);
        }
    }

    @Override
    public boolean isPlaying() {
        if(this.musicService != null){
            return this.musicService.isPlaying();
        }
        return false;
    }

    @Override
    public int getBufferPercentage() {
        return 0;
    }

    @Override
    public boolean canPause() {
        return true;
    }

    @Override
    public boolean canSeekBackward() {
        return true;
    }

    @Override
    public boolean canSeekForward() {
        return true;
    }

    @Override
    public int getAudioSessionId() {
        return 0;
    }
}
