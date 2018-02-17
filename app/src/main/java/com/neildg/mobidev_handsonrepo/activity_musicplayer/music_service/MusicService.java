package com.neildg.mobidev_handsonrepo.activity_musicplayer.music_service;

import android.app.Service;
import android.content.ContentUris;
import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.IBinder;
import android.os.PowerManager;

import com.neildg.mobidev_handsonrepo.activity_musicplayer.SongModel;

import java.io.IOException;
import java.util.ArrayList;

public class MusicService extends Service implements MediaPlayer.OnPreparedListener, MediaPlayer.OnErrorListener, MediaPlayer.OnCompletionListener {

    private MediaPlayer mediaPlayer;
    private MusicBinder musicBinder;
    private ArrayList<SongModel> playlist;

    private int currentSongIndex = 0;

    public MusicService() {

    }

    public void setPlaylist(ArrayList<SongModel> playlist) {
        this.playlist = playlist;
    }

    public void playSong() {
        this.mediaPlayer.reset();
        SongModel song = this.playlist.get(this.currentSongIndex);
        long songID = song.getSongID();

        //set uri
        Uri trackUri = ContentUris.withAppendedId(
                android.provider.MediaStore.Audio.Media.EXTERNAL_CONTENT_URI,
                songID);

        try {
            this.mediaPlayer.setDataSource(this.getApplicationContext(), trackUri);
            this.mediaPlayer.prepareAsync();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void setSong(int index) {
        this.currentSongIndex = index;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        this.currentSongIndex = 0;
        this.mediaPlayer = new MediaPlayer();

        this.mediaPlayer.setWakeMode(getApplicationContext(),
                PowerManager.PARTIAL_WAKE_LOCK);
        this.mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
        this.mediaPlayer.setOnPreparedListener(this);
        this.mediaPlayer.setOnCompletionListener(this);
        this.mediaPlayer.setOnErrorListener(this);

        this.musicBinder = new MusicBinder(this);
    }

    @Override
    public IBinder onBind(Intent intent) {
        return this.musicBinder;
    }

    @Override
    public boolean onUnbind(Intent intent) {
        this.mediaPlayer.stop();
        this.mediaPlayer.release();
        return super.onUnbind(intent);
    }

    @Override
    public void onPrepared(MediaPlayer mp) {
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
