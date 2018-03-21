package com.neildg.mobidev_handsonrepo.exam_downloader;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.neildg.mobidev_handsonrepo.R;

public class MovieViewActivity extends AppCompatActivity {

    public final static String MOVIE_TITLE_KEY = "MOVIE_TITLE_KEY";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_view);
        this.setMovieTitle();
    }

    private void setMovieTitle() {
        Intent intent = this.getIntent();
        TextView movieTextView = this.findViewById(R.id.movie_title_txt);
        movieTextView.setText(intent.getStringExtra(MOVIE_TITLE_KEY));
    }
}
