package com.neildg.mobidev_handsonrepo.activity_musicplayer_workspace;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.neildg.mobidev_handsonrepo.R;

/**
 * Created by Administrator on 2/28/2018.
 */

public class S14_MusicViewHolder extends RecyclerView.ViewHolder {
    private TextView songName;
    private TextView artistName;

    public S14_MusicViewHolder(View itemView) {
        super(itemView);

        this.songName = itemView.findViewById(R.id.song_title_text);
        this.artistName = itemView.findViewById(R.id.artist_name_text);
    }

    public TextView getSongName() {
        return songName;
    }

    public TextView getArtistName() {
        return artistName;
    }
}
