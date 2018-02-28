package com.neildg.mobidev_handsonrepo.activity_musicplayer_workspace;

import android.Manifest;
import android.content.ContentResolver;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.TextView;

import com.neildg.mobidev_handsonrepo.R;
import com.neildg.mobidev_handsonrepo.activity_musicplayer.SongModel;

import java.util.ArrayList;

public class S14_MusicPlayerActivity extends AppCompatActivity {
    private final static String TAG = "MusicPlayerActivity";
    private final static int PERMISSION_READ_EXTERNAL_STORAGE = 1;

    private TextView songtitle;
    private TextView artist;
    private ArrayList<S14_SongModel> songList = new ArrayList<>();
    private RecyclerView recyclerView;
    private S14_MusicAdapter musicAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_s14_music_player);

        this.requestPermissions();
    }

    private void requestPermissions() {
        ActivityCompat.requestPermissions(this,
                new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},
                PERMISSION_READ_EXTERNAL_STORAGE);
    }

    private void loadSongsFromStorage() {
        ContentResolver musicResolver = this.getContentResolver();
        Uri musicUri = MediaStore.Audio.Media.EXTERNAL_CONTENT_URI;
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
                String thisTitle = musicCursor.getString(titleColumn);
                String thisArtist = musicCursor.getString(artistColumn);
                songList.add(new S14_SongModel(thisTitle, thisArtist));
                Log.d(TAG, "Name: " +thisTitle+ " Artist: " +thisArtist);
            }
            while (musicCursor.moveToNext());
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        if(requestCode == PERMISSION_READ_EXTERNAL_STORAGE) {
            if (grantResults.length > 0
                    && grantResults[0] == PackageManager.PERMISSION_GRANTED) {

                Log.d(TAG, "Permission granted!");
                // permission was granted, yay!
                this.loadSongsFromStorage();
                this.setupUI();

            } else {
                // permission denied, boo!
                this.finish();
            }
        }
    }

    private void setupUI() {
        this.songtitle = this.findViewById(R.id.song_title_text);
        this.artist = this.findViewById(R.id.artist_name_text);

        this.recyclerView = this.findViewById(R.id.music_recycler_view);
        this.musicAdapter = new S14_MusicAdapter(this.songList);
        RecyclerView.LayoutManager recyclerLayout = new LinearLayoutManager(this);
        this.recyclerView.setLayoutManager(recyclerLayout);
        this.recyclerView.setItemAnimator(new DefaultItemAnimator());
        this.recyclerView.setAdapter(this.musicAdapter);

    }
}
