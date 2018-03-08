package com.neildg.mobidev_handsonrepo.exam_downloader.models;

/**
 * Represents the movie model
 * Created by delgallegon on 05/03/2018.
 */

public class MovieModel {
    private final static String TAG = "MovieModel";

    private String name, description;

    public MovieModel(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return this.name;
    }

    public String getDescription() {
        return this.description;
    }
}
