package com.movie.rental.dto;

import java.util.List;

public class CustomerDetails {
	private Customer customer;
	private List<MovieRentalDetails> movieRentalList;
	private String invoiceDate;
	private int invoiceNumber;
	
	public CustomerDetails() {
		
	}
	public CustomerDetails(Customer customer,List<MovieRentalDetails> movieRentalList,String invoiceDate,int invoiceNumber) {
		this.customer = customer;
		this.movieRentalList = movieRentalList;
		this.invoiceDate = invoiceDate;
		this.invoiceNumber = invoiceNumber;
	}
		
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public List<MovieRentalDetails> getMovieRentalList() {
		return movieRentalList;
	}
	public void setMovieRentalList(List<MovieRentalDetails> movieRentalList) {
		this.movieRentalList = movieRentalList;
	}
	public String getInvoiceDate() {
		return invoiceDate;
	}
	public void setInvoiceDate(String invoiceDate) {
		this.invoiceDate = invoiceDate;
	}
	public int getInvoiceNumber() {
		return invoiceNumber;
	}
	public void setInvoiceNumber(int invoiceNumber) {
		this.invoiceNumber = invoiceNumber;
	}
	
	
}
