package com.movie.rental.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import com.movie.rental.dao.GetAllMoivesImplementation;
import com.movie.rental.dto.Customer;
import com.movie.rental.dto.CustomerDetails;
import com.movie.rental.dto.Movie;
import com.movie.rental.dto.MovieRentalDetails;

public class RentalReceipt {
	ArrayList<Movie> allMovies;
	SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
	ExceptionHelper excepHelper = new ExceptionHelper();
	public RentalReceipt(){
		allMovies= new GetAllMoivesImplementation().loadAllMovies();
	}
	
	public void toGetRental(Long movieId,Customer customer,int rentalDays,double rentalAmount,int frequencyPoint){
		Movie movie=null;
		MovieRentalDetails movierental=null;
		try {
		movie = allMovies
	    	    .stream()
	    	    .filter(m-> m.getId().equals(movieId))
	    	    .collect(Collectors.toList()).get(0);
	    }catch(IndexOutOfBoundsException ex) {
	    	throw new IndexOutOfBoundsException("Movie id is invalid");
	    }
	    if(movie!=null)
	    	movierental = new MovieRentalDetails(movie,rentalDays,rentalAmount,frequencyPoint);
	    else 
	    	throw new NullPointerException("Movie object is empty");
	    if(excepHelper.daysCheck(rentalDays) ||  excepHelper.amountCheck(rentalAmount) || excepHelper.frequenctPointCheck(frequencyPoint))
	    {
	    	System.out.println("Invalid input");
	    }else {
	    	 List<MovieRentalDetails> movieList = new ArrayList<MovieRentalDetails>();
	 	    movieList.add(movierental);
	 	    if(!movieList.isEmpty()) {
	 	    CustomerDetails custSelectedMovie = new CustomerDetails(
	 	    		customer,movieList, formatter.format(new Date()),001);
	 	    
	 	    String result = new RentalCalculation()
	 	    		.receiptWrite(custSelectedMovie);
	 	    
	 	    System.out.println(result);
	 	    }else {
	 			System.out.println("Sorry Currently we don't have any movie in this movie name: "+movie.getName());
	 		}
	    }
	   
	}
public void toGetRental(String movieName,Customer customer,int rentalDays,double rentalAmount,int frequencyPoint) {
	 	 Movie movie = null;
	 	 MovieRentalDetails movierental=null;
		 List<MovieRentalDetails> movieList = new ArrayList<MovieRentalDetails>();
		 try {
		 movie = allMovies
		    	    .stream()
		    	    .filter(m-> m.getName().equals(movieName))
		    	    .collect(Collectors.toList()).get(0);
			
		   
		 }catch(IndexOutOfBoundsException ex) {
		    	throw new IndexOutOfBoundsException("Movie name is invalid");
	    }
		  if(excepHelper.daysCheck(rentalDays) ||  excepHelper.amountCheck(rentalAmount) || excepHelper.frequenctPointCheck(frequencyPoint))
		    {
		    	System.out.println("Invalid input");
		    }else {
		 if(movie!=null)
			 movierental = new MovieRentalDetails(movie,rentalDays,rentalAmount,frequencyPoint);
		 else 
			 throw new NullPointerException("Movie object is empty");
		 movieList.add(movierental);
		if(!movieList.isEmpty()) {
		    CustomerDetails custSelectedMovie = new CustomerDetails(
		    		customer,movieList, formatter.format(new Date()),001);
		    
		    String result = new RentalCalculation()
		    		.receiptWrite(custSelectedMovie);
		    
		    System.out.println(result);
		}else {
			System.out.println("Sorry Currently we don't have any movie in this movie name: "+movieName);
		}
		    }
	    
	}
public void toGetRentalByGenre(String genre,Customer customer,int rentalDays,double rentalAmount,int frequencyPoint) {
	 if(!genre.isEmpty()) {
		 List<MovieRentalDetails> movieList = new ArrayList<MovieRentalDetails>();
		 allMovies.forEach(movie->{
			 if(movie.getGenre().equalsIgnoreCase(genre)) {
				 movieList.add(new MovieRentalDetails(movie,rentalDays,rentalAmount,frequencyPoint));
			 }
		 });
		  if(excepHelper.daysCheck(rentalDays) ||  excepHelper.amountCheck(rentalAmount) || excepHelper.frequenctPointCheck(frequencyPoint))
		    {
		    	System.out.println("Invalid input");
		    }else {
				 if(!movieList.isEmpty()) {
					 CustomerDetails custSelectedMovie = new CustomerDetails(
					    		customer,movieList, formatter.format(new Date()),001);
				    String result = new RentalCalculation()
				    		.receiptWrite(custSelectedMovie);
				    System.out.println(result);
				 }else {
					 System.out.println("Sorry Currently we don't have any movie in this genre: "+genre);
				 }
		    }
	 }else {
		 throw new NullPointerException("Please provide the correct genre");
	 }
	 
    
}
	
public void toGetBulkRental(long[] movieId,Customer customer,int[] days,double[] amount,int[] fequencyPoint) {
	ArrayList<Movie> selectedMovies=null;
	List<MovieRentalDetails> movieList = new ArrayList<MovieRentalDetails>();
	  if(excepHelper.daysCheck(days) ||  excepHelper.amountCheck(amount) || excepHelper.frequenctPointCheck(fequencyPoint))
	    {
	    	System.out.println("Invalid input");
	    }else {
			if(movieId.length!=0)
				selectedMovies=  (ArrayList<Movie>) allMovies
				    .stream()
				    .filter(m-> Arrays.stream(movieId).anyMatch(id-> id==m.getId()))
				    .collect(Collectors.toList());
			else
				throw new NullPointerException("MovieId's list is empty");
			int i=0;
			if(!selectedMovies.isEmpty())
				for(Movie movie:selectedMovies) {
					movieList.add( new MovieRentalDetails(movie,days[i],amount[i],fequencyPoint[i]));
					i++;
				}
			else
				throw new NullPointerException("MovieId's is not valid");
			
					if(!movieList.isEmpty()) {
							CustomerDetails custSelectedMovie = new
							CustomerDetails(customer,movieList, formatter.format(new
							Date()),001);
							
							String result = new RentalCalculation().receiptWrite(custSelectedMovie);
							
							System.out.println(result);
					}else {
						System.out.println("Sorry Currently we don't have any movie in this List ");
					}
			
			}
	}  
	 
}
