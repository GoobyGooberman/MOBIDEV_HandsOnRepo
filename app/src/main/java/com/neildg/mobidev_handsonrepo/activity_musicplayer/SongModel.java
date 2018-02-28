package com.neildg.mobidev_handsonrepo.activity_musicplayer;

/**
 * Represents the song model
 * Created by NeilDG on 2/16/2018.
 */

public class SongModel {
    private final static String TAG = "S14_SongModel";

    private long songID;
    private String songName;
    private String artist;

    public SongModel(long songID, String songName, String artist) {
        this.songID = songID;
        this.songName = songName;
        this.artist = artist;
    }


    public long getSongID() {
        return songID;
    }

    public String getSongName() {
        return songName;
    }

    public String getArtist() {
        return artist;
    }
}
