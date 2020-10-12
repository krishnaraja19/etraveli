package com.movie.rental.dao;

import java.util.ArrayList;


import com.movie.rental.constants.MovieRentalConstants;
import com.movie.rental.dto.Movie;

public class GetAllMoivesImplementation implements GetAllMovies{
	
	
	public ArrayList<Movie> loadAllMovies() {
		ArrayList<Movie> moviesList = new ArrayList<Movie>();
		moviesList.add(new Movie((long) 1,"You've Got Mail",MovieRentalConstants.TWOD,  MovieRentalConstants.THRILLER));
		moviesList.add(new Movie((long) 2,"Matrix",MovieRentalConstants.TWOD, MovieRentalConstants.SCIFI_ACTION));
		moviesList.add(new Movie((long) 3,"Cars",MovieRentalConstants.THREED,  MovieRentalConstants.ANIMATION));
		moviesList.add(new Movie((long) 4,"Fast & Furious X", MovieRentalConstants.TWOD, MovieRentalConstants.ACTION));
		moviesList.add(new Movie((long) 5,"Tangled",MovieRentalConstants.THREED,  MovieRentalConstants.ANIMATION));
		moviesList.add(new Movie((long) 6,"Obilivon",MovieRentalConstants.TWOD, MovieRentalConstants.SCIFI_ACTION));
		moviesList.add(new Movie((long) 7,"Jurassic Park",MovieRentalConstants.TWOD,  MovieRentalConstants.THRILLER));
		moviesList.add(new Movie((long) 8,"Croods",MovieRentalConstants.THREED,  MovieRentalConstants.ANIMATION));
		return moviesList;
	}
}
