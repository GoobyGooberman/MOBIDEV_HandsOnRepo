package com.neildg.mobidev_handsonrepo.activity_musicplayer_workspace;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.neildg.mobidev_handsonrepo.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2/28/2018.
 */

public class S14_MusicAdapter extends RecyclerView.Adapter<S14_MusicViewHolder> {
    private List<S14_SongModel> songList;

    public S14_MusicAdapter(ArrayList<S14_SongModel> songList) {
        this.songList = songList;
    }

    @Override
    public S14_MusicViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.s14_song_item_layout, parent, false);
        return new S14_MusicViewHolder(view);
    }

    @Override
    public void onBindViewHolder(S14_MusicViewHolder holder, int index) {
        S14_SongModel modeList = this.songList.get(index);
        holder.getSongName().setText(modeList.getSongName());
        holder.getArtistName().setText(modeList.getArtistName());
    }

    @Override
    public int getItemCount() {
        return this.songList.size();
    }
}
