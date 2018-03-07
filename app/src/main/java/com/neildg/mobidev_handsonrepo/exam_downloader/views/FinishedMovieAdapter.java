package com.neildg.mobidev_handsonrepo.exam_downloader.views;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.neildg.mobidev_handsonrepo.R;

import java.util.List;

/**
 * Created by NeilDG on 3/5/2018.
 */

public class FinishedMovieAdapter extends RecyclerView.Adapter<FinishedMovieViewHolder>{
    private final static String TAG = "FinishedMovieAdapter";

    private List<MovieModel> finishedList;

    public FinishedMovieAdapter(List<MovieModel> finishedList) {
        this.finishedList = finishedList;
    }

    @Override
    public FinishedMovieViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View viewInstance = LayoutInflater.from(parent.getContext()).inflate(R.layout.finished_download_item, parent, false);
        return new FinishedMovieViewHolder(viewInstance);
    }

    @Override
    public void onBindViewHolder(FinishedMovieViewHolder holder, int position) {
        MovieModel movieModel = this.finishedList.get(position);
        holder.getMovieTitleTxt().setText(movieModel.getName());
        holder.getDescText().setText(movieModel.getDescription());
    }

    @Override
    public int getItemCount() {
        return this.finishedList.size();
    }
}
