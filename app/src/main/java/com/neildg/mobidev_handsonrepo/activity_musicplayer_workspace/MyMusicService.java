package com.neildg.mobidev_handsonrepo.activity_musicplayer_workspace;

import android.app.Service;
import android.content.ContentUris;
import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.IBinder;
import android.os.PowerManager;
import android.util.Log;

import com.neildg.mobidev_handsonrepo.activity_musicplayer.IPlaySongListener;

import java.io.IOException;
import java.util.ArrayList;

public class MyMusicService extends Service implements MediaPlayer.OnCompletionListener, MediaPlayer.OnErrorListener, MediaPlayer.OnPreparedListener {
    private final static String TAG = "MyMusicService";

    private ArrayList<S16_SongModel> playList;
    private int currentSongIndex = 0;

    private MyMusicBinder musicBinder;
    private MediaPlayer musicPlayer;

    private IPlaySongListener listener;

    public void setPlayList(ArrayList<S16_SongModel> playList, IPlaySongListener listener) {
        this.playList = playList;
        this.listener = listener;
    }

    @Override
    public void onCreate() {
        super.onCreate();

        this.musicBinder = new MyMusicBinder(this);
        this.musicPlayer = new MediaPlayer();
        this.musicPlayer.setOnCompletionListener(this);
        this.musicPlayer.setOnErrorListener(this);
        this.musicPlayer.setOnPreparedListener(this);
        this.musicPlayer.setWakeMode(this.getApplicationContext(), PowerManager.PARTIAL_WAKE_LOCK);

        Log.d(TAG, "Music service created.");
    }

    public void setSong(int index) {
        this.currentSongIndex = index;
    }

    public void playSong() {
        this.musicPlayer.reset();
        S16_SongModel song = this.playList.get(this.currentSongIndex);
        long songID = song.getId();
        Log.d(TAG, "Song id: " +songID);

        //set uri
        Uri trackUri = ContentUris.withAppendedId(
                android.provider.MediaStore.Audio.Media.EXTERNAL_CONTENT_URI,
                songID);

        try {
            this.musicPlayer.setDataSource(this.getApplicationContext(), trackUri);
            this.musicPlayer.prepareAsync();

            this.listener.onSongUpdated(this.currentSongIndex);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public IBinder onBind(Intent intent) {
        return this.musicBinder;
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
        mp.start();
    }
}
