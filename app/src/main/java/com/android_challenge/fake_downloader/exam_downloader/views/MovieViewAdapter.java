package com.android_challenge.fake_downloader.exam_downloader.views;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.android_challenge.fake_downloader.exam_downloader.listeners.IDownloadListener;
import com.android_challenge.fake_downloader.exam_downloader.models.MovieModel;
import com.neildg.mobidev_handsonrepo.R;

/**
 * Created by delgallegon on 07/03/2018.
 */

public class MovieViewAdapter extends RecyclerView.Adapter<MovieViewHolder> {
    private final static String TAG = "MovieViewAdapter";

    private MovieModel[] moviesList;
    private IDownloadListener downloadListener;

    public MovieViewAdapter(MovieModel[] moviesList, IDownloadListener downloadListener) {
        this.moviesList = moviesList;
        this.downloadListener = downloadListener;
    }


    @Override
    public MovieViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View viewInstance = LayoutInflater.from(parent.getContext()).inflate(R.layout.downloadable_item, parent, false);
        return new MovieViewHolder(viewInstance, this.downloadListener);
    }

    @Override
    public void onBindViewHolder(MovieViewHolder holder, int position) {
        MovieModel movieModel = this.moviesList[position];
        movieModel.setViewPosition(position);
        holder.getMovieTitleTxt().setText(movieModel.getName());
        holder.getDescText().setText(movieModel.getDescription());
    }

    @Override
    public int getItemCount() {
        return this.moviesList.length;
    }
}
