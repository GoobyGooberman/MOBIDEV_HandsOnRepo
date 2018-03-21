package com.neildg.mobidev_handsonrepo.exam_downloader.views;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.neildg.mobidev_handsonrepo.R;
import com.neildg.mobidev_handsonrepo.exam_downloader.MovieViewActivity;

/**
 * Created by NeilDG on 3/5/2018.
 */

public class FinishedMovieViewHolder extends RecyclerView.ViewHolder {
    private final static String TAG = "FinishedMovieViewHolder";

    private TextView movieTitleTxt;
    private TextView descText;
    private Button openBtn;

    public FinishedMovieViewHolder(final View view) {
        super(view);

        this.movieTitleTxt = view.findViewById(R.id.movie_title_txt);
        this.descText = view.findViewById(R.id.desc_txt);
        this.openBtn = view.findViewById(R.id.open_btn);
        this.openBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(view.getContext(), MovieViewActivity.class);
                i.putExtra(MovieViewActivity.MOVIE_TITLE_KEY, movieTitleTxt.getText());
                view.getContext().startActivity(i);
            }
        });
    }


    public TextView getMovieTitleTxt() {
        return movieTitleTxt;
    }

    public TextView getDescText() {
        return descText;
    }
}
