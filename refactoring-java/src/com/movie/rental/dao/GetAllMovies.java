package com.movie.rental.dao;

import java.util.ArrayList;

import com.movie.rental.dto.Movie;

public interface GetAllMovies {
	ArrayList<Movie> loadAllMovies();
}
