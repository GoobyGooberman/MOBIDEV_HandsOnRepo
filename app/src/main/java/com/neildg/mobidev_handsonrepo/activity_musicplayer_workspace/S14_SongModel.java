package com.neildg.mobidev_handsonrepo.activity_musicplayer_workspace;

/**
 * Created by Administrator on 2/28/2018.
 */

public class S14_SongModel {
    private String songName;
    private String artistName;

    public S14_SongModel(String songName, String artistName) {
        this.songName = songName;
        this.artistName = artistName;
    }

    public String getSongName() {
        return this.songName;
    }

    public String getArtistName() {
        return this.artistName;
    }
}
