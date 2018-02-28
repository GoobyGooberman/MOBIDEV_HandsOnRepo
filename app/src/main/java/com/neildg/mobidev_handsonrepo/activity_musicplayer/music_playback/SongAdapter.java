package com.neildg.mobidev_handsonrepo.activity_musicplayer.music_playback;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.neildg.mobidev_handsonrepo.R;

import java.util.List;

/**
 * Created by Administrator on 2/28/2018.
 */

public class SongAdapter extends RecyclerView.Adapter<SongAdapter.myViewHolder> {
    private List<Song> songlist;

    public class myViewHolder extends RecyclerView.ViewHolder{

        public TextView artist;
        public TextView title;

        public myViewHolder(View view){
            super(view);
            title = (TextView)view.findViewById(R.id.title);
            artist = (TextView)view.findViewById(R.id.artist);
        }
    }
    public SongAdapter(List<Song> songlist){
        this.songlist=songlist;
    }

    @Override
    public SongAdapter.myViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.s16_music_item, parent, false);

        return new myViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(SongAdapter.myViewHolder holder, int position){
        Song song = songlist.get(position);
        holder.artist.setText(song.getArtist());
        holder.title.setText(song.getTitle());

        if(position % 2 == 1) {
            holder.itemView.setBackgroundResource(R.drawable.border2);
        }
        else {
            holder.itemView.setBackgroundResource(R.drawable.border);
        }
    }

    @Override
    public int getItemCount (){
        return songlist.size();
    }


}
