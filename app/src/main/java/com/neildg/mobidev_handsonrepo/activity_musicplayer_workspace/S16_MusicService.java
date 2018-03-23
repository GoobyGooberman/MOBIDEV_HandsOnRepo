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

public class S16_MusicService extends Service implements MediaPlayer.OnPreparedListener, MediaPlayer.OnErrorListener, MediaPlayer.OnCompletionListener {
    private final static String TAG = "S16_MusicService";

    private MediaPlayer musicPlayer;
    private S16_MusicBinder musicBinder;
    private ArrayList<S16_SongModel> playList;
    private int currentSongIndex = 0;
    private IPlaySongListener songListener;

    public void setPlayList(ArrayList<S16_SongModel> playList, IPlaySongListener songListener) {
        this.playList = playList;
        this.songListener = songListener;
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
            this.songListener.onSongUpdated(this.currentSongIndex);
        } catch (IOException e) {
            e.printStackTrace();
        }
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
        Log.d(TAG, "Music player prepared!");
        mp.start();
    }

    public int getCurrentSongPosition(){
        if (this.musicPlayer != null){
            return this.musicPlayer.getCurrentPosition();
        }
        return 0;
    }

    public int getCurrentSongDuration(){
        if (this.musicPlayer != null){
            return this.musicPlayer.getDuration();
        }
        return 0;
    }

    public void resume(){
        if(this.musicPlayer != null) {
            this.musicPlayer.start();
        }
    }

    public void pause(){
        if(this.musicPlayer != null) {
            this.musicPlayer.pause();
        }
    }

    public void seek(int newSec){
        if(this.musicPlayer != null) {
            this.musicPlayer.seekTo(newSec);
        }
    }

    public boolean isPlaying(){
        if(this.musicPlayer != null) {
            return this.musicPlayer.isPlaying();
        }
        return false;
    }
}
