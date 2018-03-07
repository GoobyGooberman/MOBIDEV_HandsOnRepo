package com.neildg.mobidev_handsonrepo.activity_musicplayer_workspace;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.neildg.mobidev_handsonrepo.R;
import com.neildg.mobidev_handsonrepo.activity_musicplayer.IPlaySongListener;

import java.util.List;

/**
 * Created by Administrator on 2/28/2018.
 */

public class S16_SongAdapter extends RecyclerView.Adapter<S16_SongAdapter.S16_MusicViewHolder> {
    private List<S16_SongModel> songlist;
    private IPlaySongListener songListener;

    public S16_SongAdapter(List<S16_SongModel> songlist, IPlaySongListener songListener){
        this.songlist=songlist;
        this.songListener = songListener;
    }

    @Override
    public S16_MusicViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.s16_music_item, parent, false);

        return new S16_MusicViewHolder(itemView, this.songListener);
    }

    @Override
    public void onBindViewHolder(S16_MusicViewHolder holder, int position){
        S16_SongModel song = songlist.get(position);
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

    public class S16_MusicViewHolder extends RecyclerView.ViewHolder{

        public TextView artist;
        public TextView title;

        public S16_MusicViewHolder(View view, final IPlaySongListener songListener){
            super(view);
            title = (TextView)view.findViewById(R.id.title);
            artist = (TextView)view.findViewById(R.id.artist);

            this.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //request to play a song
                    songListener.onPlayRequested(getAdapterPosition());
                }
            });
        }
    }

}
