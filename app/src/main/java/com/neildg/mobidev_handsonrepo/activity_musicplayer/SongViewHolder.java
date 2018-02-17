package com.neildg.mobidev_handsonrepo.activity_musicplayer;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.neildg.mobidev_handsonrepo.R;

/**
 * Created by NeilDG on 2/17/2018.
 */

public class SongViewHolder extends RecyclerView.ViewHolder {

    private TextView songTxtView;
    private TextView artistTxtView;

    public SongViewHolder(View itemView) {
        super(itemView);

        this.songTxtView = itemView.findViewById(R.id.song_title_txt);
        this.artistTxtView = itemView.findViewById(R.id.artist_name_txt);
    }


    public TextView getSongTxtView() {
        return this.songTxtView;
    }

    public TextView getArtistTxtView() {
        return this.artistTxtView;
    }
}
