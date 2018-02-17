package com.neildg.mobidev_handsonrepo.activity_musicplayer;

import android.Manifest;
import android.content.ContentResolver;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.neildg.mobidev_handsonrepo.R;
import com.neildg.mobidev_handsonrepo.activity_restaurant.RestaurantAdapter;

import java.util.ArrayList;

public class MusicPlayerActivity extends AppCompatActivity {
    private final static String TAG = "MusicPlayerActivity";

    private final static int PERMISSION_READ_EXTERNAL_STORAGE = 1;

    private ArrayList<SongModel> songList = new ArrayList<>();
    private RecyclerView songView;
    private SongAdapter songAdapter;

    private TextView titleView;
    private TextView artistView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music_player);

        this.requestPermissions();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.music_player_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId() == R.id.item_stop) {
            this.finish();
        }
        return super.onOptionsItemSelected(item);
    }

    private void requestPermissions() {
        ActivityCompat.requestPermissions(this,
                new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},
                PERMISSION_READ_EXTERNAL_STORAGE);
    }

    private void loadSongsFromStorage() {
        ContentResolver musicResolver = this.getContentResolver();
        Uri musicUri = android.provider.MediaStore.Audio.Media.EXTERNAL_CONTENT_URI;
        Cursor musicCursor = musicResolver.query(musicUri, null, null, null, "title ASC");

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
                songList.add(new SongModel(thisId, thisTitle, thisArtist));
            }
            while (musicCursor.moveToNext());
        }

        this.checkSongs();
    }

    private void checkSongs() {
        for(int i = 0; i < this.songList.size(); i++) {
            SongModel song = this.songList.get(i);
            Log.d(TAG, "Song #" +i+ ": Title - " +song.getSongName()+ "  Artist - " +song.getArtist());
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        if(requestCode == PERMISSION_READ_EXTERNAL_STORAGE) {
            if (grantResults.length > 0
                    && grantResults[0] == PackageManager.PERMISSION_GRANTED) {

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
        this.titleView = this.findViewById(R.id.song_title_txt);
        this.artistView = this.findViewById(R.id.artist_txt);

        this.titleView.setText("Select a song");
        this.artistView.setText("");

        this.songView = this.findViewById(R.id.music_view);
        this.songAdapter = new SongAdapter(this.songList);
        RecyclerView.LayoutManager recylerLayoutManager = new LinearLayoutManager(this);
        this.songView.setLayoutManager(recylerLayoutManager);
        this.songView.setItemAnimator(new DefaultItemAnimator());
        this.songView.setAdapter(this.songAdapter);
    }
}
