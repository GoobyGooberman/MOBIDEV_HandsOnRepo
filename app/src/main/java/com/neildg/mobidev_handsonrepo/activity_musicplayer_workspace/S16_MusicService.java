package com.neildg.mobidev_handsonrepo.activity_musicplayer_workspace;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.os.PowerManager;

import com.neildg.mobidev_handsonrepo.activity_musicplayer.S16_MusicBinder;

import java.util.ArrayList;

public class S16_MusicService extends Service implements MediaPlayer.OnPreparedListener, MediaPlayer.OnErrorListener, MediaPlayer.OnCompletionListener {
    private final static String TAG = "S16_MusicService";

    private MediaPlayer musicPlayer;
    private S16_MusicBinder musicBinder;
    private ArrayList<S16_SongModel> playList;
    private int currentSongIndex = 0;

    public void setPlayList(ArrayList<S16_SongModel> playList) {
        this.playList = playList;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        this.currentSongIndex = 0;
        this.musicPlayer = new MediaPlayer();
        this.musicPlayer.setWakeMode(this.getApplicationContext(), PowerManager.PARTIAL_WAKE_LOCK);
        this.musicPlayer.setOnPreparedListener(this);
        this.musicPlayer.setOnErrorListener(this);
        this.musicPlayer.setOnCompletionListener(this);

        this.musicBinder = new S16_MusicBinder(this);

    }

    @Override
    public IBinder onBind(Intent intent) {
        return this.musicBinder;
    }

    @Override
    public boolean onUnbind(Intent intent) {
        this.musicPlayer.stop();
        this.musicPlayer.release();
        this.musicPlayer = null;
        return super.onUnbind(intent);
    }

    @Override
    public void onCompletion(MediaPlayer mp) {

    }

    @Override
    public boolean onError(MediaPlayer mp, int what, int extra) {
        return false;
    }

    @Override
    public void onPrepared(MediaPlayer mp) {

    }
}
