package com.neildg.mobidev_handsonrepo.exam_downloader.views;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.neildg.mobidev_handsonrepo.R;

import java.util.List;

/**
 * Created by delgallegon on 07/03/2018.
 */

public class MovieViewAdapter extends RecyclerView.Adapter<MovieViewHolder> {
    private final static String TAG = "MovieViewAdapter";

    private List<MovieModel> moviesList;

    public MovieViewAdapter(List<MovieModel> moviesList) {
        this.moviesList = moviesList;
    }


    @Override
    public MovieViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View viewInstance = LayoutInflater.from(parent.getContext()).inflate(R.layout.downloadable_item, parent, false);
        return new MovieViewHolder(viewInstance);
    }

    @Override
    public void onBindViewHolder(MovieViewHolder holder, int position) {
        MovieModel movieModel = this.moviesList.get(position);
        holder.getMovieTitleTxt().setText(movieModel.getName());
        holder.getDescText().setText(movieModel.getDescription());
    }

    @Override
    public int getItemCount() {
        return this.moviesList.size();
    }
}
