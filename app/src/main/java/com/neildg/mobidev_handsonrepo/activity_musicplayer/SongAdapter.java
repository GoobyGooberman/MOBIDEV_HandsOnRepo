package com.neildg.mobidev_handsonrepo.activity_musicplayer;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.neildg.mobidev_handsonrepo.R;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by NeilDG on 2/17/2018.
 */

public class SongAdapter extends RecyclerView.Adapter<SongViewHolder> {
    private final static String TAG = "SongAdapter";

    private List<SongModel> songModelList;
    private IPlaySongListener songListener;

    public SongAdapter(ArrayList<SongModel> modelList, IPlaySongListener songListener) {
        this.songModelList = modelList;
        this.songListener = songListener;
    }

    @Override
    public SongViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View viewInstance = LayoutInflater.from(parent.getContext()).inflate(R.layout.song_item_layout, parent, false);
        return new SongViewHolder(viewInstance,this.songListener);
    }

    @Override
    public void onBindViewHolder(SongViewHolder holder, int position) {
        SongModel model = this.songModelList.get(position);
        holder.getSongTxtView().setText(model.getSongName());
        holder.getArtistTxtView().setText(model.getArtist());
    }

    @Override
    public int getItemCount() {
        return this.songModelList.size();
    }
}
