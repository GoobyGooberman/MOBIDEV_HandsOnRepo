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

public class DownloadingMovieAdapter extends RecyclerView.Adapter<MovieViewHolder> {
    private final static String TAG = "MovieAdapter";

    private List<MovieModel> downloadingList;

    public DownloadingMovieAdapter(List<MovieModel> downloadingList) {
        this.downloadingList = downloadingList;
    }

    @Override
    public MovieViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View viewInstance = LayoutInflater.from(parent.getContext()).inflate(R.layout.ongoing_download_item, parent, false);
        return new MovieViewHolder(viewInstance);
    }

    @Override
    public void onBindViewHolder(MovieViewHolder holder, int position) {
        MovieModel movieModel = this.downloadingList.get(position);
        holder.getMovieTitleTxt().setText(movieModel.getName());
        holder.getDescText().setText(movieModel.getDescription());
    }

    @Override
    public int getItemCount() {
        return this.downloadingList.size();
    }
}
