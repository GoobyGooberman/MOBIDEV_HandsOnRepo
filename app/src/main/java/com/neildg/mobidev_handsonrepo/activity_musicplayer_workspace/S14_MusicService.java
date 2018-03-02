package com.neildg.mobidev_handsonrepo.activity_musicplayer_workspace;

import android.app.Service;
import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.os.PowerManager;

import com.neildg.mobidev_handsonrepo.activity_musicplayer.SongModel;

import java.util.ArrayList;

public class S14_MusicService extends Service implements
        MediaPlayer.OnPreparedListener, MediaPlayer.OnErrorListener, MediaPlayer.OnCompletionListener{
    private final static String TAG = "S14_MusicService";

    private ArrayList<S14_SongModel> playList;
    private int currentSongIndex = 0;

    private MediaPlayer musicPlayer;

    //BAWAL DAW!!!
    /*public S14_MusicService(ArrayList<S14_SongModel> playList) {
        this.playList = playList;
    }*/

    public void setPlayList(ArrayList<S14_SongModel> playList) {
        this.playList = playList;
    }

    @Override
    public void onCreate() {
        super.onCreate();

        this.currentSongIndex = 0;
        this.musicPlayer = new MediaPlayer();
        this.musicPlayer.setWakeMode(getApplicationContext(), PowerManager.PARTIAL_WAKE_LOCK);
        this.musicPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
        this.musicPlayer.setOnPreparedListener(this);
        this.musicPlayer.setOnErrorListener(this);
        this.musicPlayer.setOnCompletionListener(this);
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        return null;
    }

    @Override
    public boolean onUnbind(Intent intent) {
        this.musicPlayer.stop();
        this.musicPlayer.release();
        this.musicPlayer = null;
        return super.onUnbind(intent);
    }

    @Override
    public void onPrepared(MediaPlayer mp) {

    }


    @Override
    public void onCompletion(MediaPlayer mp) {

    }

    @Override
    public boolean onError(MediaPlayer mp, int what, int extra) {
        return false;
    }


}
