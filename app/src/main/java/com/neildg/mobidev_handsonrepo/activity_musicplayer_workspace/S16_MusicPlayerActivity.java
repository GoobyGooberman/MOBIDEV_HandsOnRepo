package com.neildg.mobidev_handsonrepo.activity_musicplayer_workspace;

import android.Manifest;
import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.os.IBinder;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.neildg.mobidev_handsonrepo.R;
import com.neildg.mobidev_handsonrepo.activity_musicplayer.S16_MusicBinder;
import com.neildg.mobidev_handsonrepo.activity_musicplayer.music_playback.SongAdapter;

import java.util.ArrayList;
import java.util.List;

public class S16_MusicPlayerActivity extends AppCompatActivity {
    private final static String TAG = "MusicPlayerActivity";

    private final static int EXTERNAL_STORAGE_REQUEST_CODE = 1;

    private ArrayList<S16_SongModel> songList = new ArrayList<>();
    private RecyclerView recyclerView;
    private SongAdapter songAdapter;

    private ServiceConnection musicConnection;
    private S16_MusicService musicService;
    private Intent musicIntent;

    private boolean musicBound = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_s16_music_player);

        this.requestPermissions();
        recyclerView = (RecyclerView)findViewById(R.id.S16MusicRecyclerView);

        songAdapter= new SongAdapter(songList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(songAdapter);

        this.setupMusicService();
        this.startMusicService();

    }

    @Override
    protected void onDestroy() {
        this.stopService(this.musicIntent);
        this.unbindService(this.musicConnection);
        super.onDestroy();
    }

    private void requestPermissions() {
        String[] permissions = new String[1];
        permissions[0] = Manifest.permission.READ_EXTERNAL_STORAGE;
        ActivityCompat.requestPermissions(this, permissions,EXTERNAL_STORAGE_REQUEST_CODE);
    }

    private void loadSongsFromStorage() {
        ContentResolver musicResolver = this.getContentResolver();
        Uri musicUri = android.provider.MediaStore.Audio.Media.EXTERNAL_CONTENT_URI;
        Cursor musicCursor = musicResolver.query(musicUri, null, null, null, null);

        if(musicCursor!=null && musicCursor.moveToFirst()){
            //get columns
            int titleColumn = musicCursor.getColumnIndex
                    (android.provider.MediaStore.Audio.Media.TITLE);
            int idColumn = musicCursor.getColumnIndex
                    (android.provider.MediaStore.Audio.Media._ID);
            int artistColumn = musicCursor.getColumnIndex
                    (android.provider.MediaStore.Audio.Media.ARTIST);

            //add songs to list
            do {
                long thisId = musicCursor.getLong(idColumn);
                String title = musicCursor.getString(titleColumn);
                String artist = musicCursor.getString(artistColumn);
                songList.add(new S16_SongModel(artist,title,thisId));

                Log.d(TAG, "ID: " +thisId+ " S16_SongModel: " +title+ " Arist: " +artist);
            }
            while (musicCursor.moveToNext());
            this.songAdapter.notifyDataSetChanged();

        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        if(requestCode == EXTERNAL_STORAGE_REQUEST_CODE) {
            if(grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                //yes granted!
                Log.d(TAG,"Access granted! Welcome!");

                //LOAD NG MUSIC!
                this.loadSongsFromStorage();
            }
            else {
                this.finish();
            }
        }
    }

    private void setupMusicService() {
        Log.d(TAG, "Setup music service!");
        this.musicConnection = new ServiceConnection() {
            @Override
            public void onServiceConnected(ComponentName name, IBinder service) {
                S16_MusicBinder musicBinder = (S16_MusicBinder) service;
                musicService = musicBinder.getMusicService();
                musicService.setPlayList(songList);
                musicBound = true;
                Log.d(TAG, "Music service connected!");
            }

            @Override
            public void onServiceDisconnected(ComponentName name) {
                musicBound = false;
            }
        };
    }

    private void startMusicService() {
        if(musicIntent == null) {
            this.musicIntent = new Intent(this, S16_MusicService.class);
            this.bindService(this.musicIntent, this.musicConnection, Context.BIND_AUTO_CREATE);
            this.startService(this.musicIntent);
            Log.d(TAG, "Successfully started music service!");
        }
    }
}
