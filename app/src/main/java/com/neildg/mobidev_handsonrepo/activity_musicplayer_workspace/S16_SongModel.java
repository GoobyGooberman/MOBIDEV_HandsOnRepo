package com.neildg.mobidev_handsonrepo.activity_musicplayer_workspace;

/**
 * Created by Administrator on 2/28/2018.
 */

public class S16_SongModel {
    private String artist;
    private String title;
    private long id;

    public S16_SongModel(String artist, String title, long id){
        this.artist = artist;
        this.title = title;
        this.id = id;

    }

    public String getArtist() {
        return artist;
    }

    public String getTitle() {
        return title;
    }

    public long getId() {
        return id;
    }
}
