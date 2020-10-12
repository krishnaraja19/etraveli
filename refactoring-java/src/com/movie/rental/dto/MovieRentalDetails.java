package com.movie.rental.dto;
public class MovieRentalDetails {
	private Movie movie;
	private int days;
    private double amount;
    private int frequencyPoint;
    
    public MovieRentalDetails() {
    	
    }
    public MovieRentalDetails(Movie movie,int days,double amount,int frequencyPoint) {
        this.movie = movie;
        this.days = days;
        this.amount = amount;
        this.frequencyPoint = frequencyPoint;
    }

	public Movie getMovie() {
		return movie;
	}

	public void setMovie(Movie movie) {
		this.movie = movie;
	}

	public int getDays() {
		return days;
	}

	public void setDays(int days) {
		this.days = days;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public int getFrequencyPoint() {
		return frequencyPoint;
	}

	public void setFrequencyPoint(int frequencyPoint) {
		this.frequencyPoint = frequencyPoint;
	}

   
}
