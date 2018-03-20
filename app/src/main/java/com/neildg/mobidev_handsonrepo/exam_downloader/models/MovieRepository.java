package com.neildg.mobidev_handsonrepo.exam_downloader.models;

import java.util.ArrayList;

/**
 * Holds the repository of movies and its current status
 * Created by NeilDG on 3/8/2018.
 */

public class MovieRepository {
    private final static String TAG = "MovieRepository";
    private static MovieRepository sharedInstance = null;

    public static  MovieRepository getInstance() {
        if(sharedInstance == null) {
            sharedInstance = new MovieRepository();
            sharedInstance.initialize();
        }

        return sharedInstance;
    }

    private ArrayList<MovieModel> availableMovies = new ArrayList<>();
    private ArrayList<MovieModel> downloadingMovies = new ArrayList<>();
    private ArrayList<MovieModel> finishedMovies = new ArrayList<>();

    private MovieModel queuedMovie = null; //the latest queued movie to download in the service.

    private void initialize() {
        this.availableMovies.add(new MovieModel("Black Panther", "De king will now have de strength of de black pantha stripped eweii"));
        this.availableMovies.add(new MovieModel("Thor: Ragnarok", "Marvel Studios"));
        this.availableMovies.add(new MovieModel("Avengers: Infinity War", "Marvel Studios"));
        this.availableMovies.add(new MovieModel("Harry Potter and the Deathly Hallows Part 2", "It All Ends"));
    }

    /*
     * Returns the list of downloadable movies
     */
    public MovieModel[] getAvailableMovies() {
        MovieModel[] downloadables = this.availableMovies.toArray(new MovieModel[this.availableMovies.size()]);
        return downloadables;
    }

    /*
     * Returns the list of currently downloading movies
     */
    public MovieModel[] getDownloadingMovies() {
        MovieModel[] downloading = this.downloadingMovies.toArray(new MovieModel[this.downloadingMovies.size()]);
        return downloading;
    }

    /*
     * Returns the list of finished movies
     */
    public MovieModel[] getFinishedMovies() {
        MovieModel[] finished = this.finishedMovies.toArray(new MovieModel[this.finishedMovies.size()]);
        return finished;
    }

    /*
     * Moves a movie to the downloadable list, by specifying its index.
     */
    public void markMovieForDownload(int index) {
        MovieModel movie = this.availableMovies.remove(index);
        this.downloadingMovies.add(movie);
        this.queuedMovie = movie;
    }

    /*
     * Returns the latest movie queued for download. This is called by a downloader service.
     */
    public MovieModel getLatestDownloadableMovie() {
        return this.queuedMovie;
    }

    /*
     * Marks a movie in the downloading list as finished. by specifying its index.
     */
    public void markMovieFinished(int index) {
        MovieModel movie = this.downloadingMovies.remove(index);
        this.finishedMovies.add(movie);
    }

    /*
     * Resets this repository
     */
    public void reset() {
        this.downloadingMovies.clear();
        this.finishedMovies.clear();
        this.availableMovies.clear();
        this.initialize();
    }
}
