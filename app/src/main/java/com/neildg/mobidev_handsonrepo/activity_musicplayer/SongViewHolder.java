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

    private IPlaySongListener songListener;

    public SongViewHolder(View itemView, final IPlaySongListener songListener) {
        super(itemView);

        this.songTxtView = itemView.findViewById(R.id.song_title_txt);
        this.artistTxtView = itemView.findViewById(R.id.artist_name_txt);
        this.songListener = songListener;

        this.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                songListener.onPlayRequested(SongViewHolder.this.getAdapterPosition());
            }
        });
    }


    public TextView getSongTxtView() {
        return this.songTxtView;
    }

    public TextView getArtistTxtView() {
        return this.artistTxtView;
    }
}
