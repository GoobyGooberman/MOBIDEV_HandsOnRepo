package com.neildg.mobidev_handsonrepo.activity_musicplayer_workspace;

import android.app.Service;
import android.content.ContentUris;
import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.IBinder;
import android.os.PowerManager;
import android.util.Log;

import com.neildg.mobidev_handsonrepo.activity_musicplayer.SongModel;

import java.io.IOException;
import java.util.ArrayList;

public class S14_MusicService extends Service implements
        MediaPlayer.OnPreparedListener, MediaPlayer.OnErrorListener, MediaPlayer.OnCompletionListener{
    private final static String TAG = "S14_MusicService";

    private ArrayList<S14_SongModel> playList;
    private int currentSongIndex = 0;

    private MediaPlayer musicPlayer;
    private S14_MusicBinder musicBinder;

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

        this.musicBinder = new S14_MusicBinder(this);
    }

    @Override
    public IBinder onBind(Intent intent) {
        return this.musicBinder;
    }

    public void playSong() {
        this.musicPlayer.reset();
        S14_SongModel song = this.playList.get(this.currentSongIndex);
        long songID = song.getSongID();
        Log.d(TAG, "Song id: " +songID);

        //set uri
        Uri trackUri = ContentUris.withAppendedId(
                android.provider.MediaStore.Audio.Media.EXTERNAL_CONTENT_URI,
                songID);

        try {
            this.musicPlayer.setDataSource(this.getApplicationContext(), trackUri);
            this.musicPlayer.prepareAsync();
            //this.songListener.onSongUpdated(this.currentSongIndex);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void setSong(int index) {
        this.currentSongIndex = index;
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
        Log.d(TAG," On prepared MediaPlayer");
        mp.start();
    }


    @Override
    public void onCompletion(MediaPlayer mp) {

    }

    @Override
    public boolean onError(MediaPlayer mp, int what, int extra) {
        return false;
    }


}
