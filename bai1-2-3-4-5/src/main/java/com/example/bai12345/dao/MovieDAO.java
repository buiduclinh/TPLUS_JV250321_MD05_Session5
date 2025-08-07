package com.example.bai12345.dao;

import com.example.bai12345.model.Movie;

import java.util.List;

public interface MovieDAO {
    List<Movie> getMovies();

    Movie getMovie(int id);

    boolean addMovie(Movie movie);

    boolean updateMovie(Movie movie);

    boolean deleteMovie(int id);

    Movie getMovie(String title);
}
