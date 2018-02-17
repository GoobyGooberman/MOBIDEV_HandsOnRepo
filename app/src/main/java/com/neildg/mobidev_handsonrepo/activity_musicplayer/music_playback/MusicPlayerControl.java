package com.neildg.mobidev_handsonrepo.activity_musicplayer.music_playback;

import android.widget.MediaController;

import com.neildg.mobidev_handsonrepo.activity_musicplayer.MusicPlayerActivity;

/**
 * Handles the music playback control
 * Created by NeilDG on 2/17/2018.
 */

public class MusicPlayerControl implements MediaController.MediaPlayerControl {

    private MusicPlayerActivity  musicPlayerActivity;

    public MusicPlayerControl(MusicPlayerActivity musicPlayerActivity) {
        this.musicPlayerActivity = musicPlayerActivity;
    }
    @Override
    public void start() {

    }

    @Override
    public void pause() {

    }

    @Override
    public int getDuration() {
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
