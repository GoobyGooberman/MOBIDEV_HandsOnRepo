package com.neildg.mobidev_handsonrepo.exam_downloader.views;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.neildg.mobidev_handsonrepo.R;

/**
 * Created by delgallegon on 07/03/2018.
 */

public class MovieViewHolder extends RecyclerView.ViewHolder {
    private final static String TAG = "MovieViewHolder";

    private TextView movieTitleTxt;
    private TextView descText;
    private Button downloadBtn;

    public MovieViewHolder(View view) {
        super(view);

        this.movieTitleTxt = view.findViewById(R.id.movie_title_txt);
        this.descText = view.findViewById(R.id.desc_txt);
        this.downloadBtn = view.findViewById(R.id.download_btn);
    }

    public TextView getMovieTitleTxt() {
        return this.movieTitleTxt;
    }

    public TextView getDescText() {
        return this.descText;
    }
}
