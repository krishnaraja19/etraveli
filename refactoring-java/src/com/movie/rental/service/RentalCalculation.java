package com.movie.rental.service;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.apache.commons.lang3.StringUtils;

import com.movie.rental.constants.MovieRentalConstants;
import com.movie.rental.dto.CustomerDetails;
import com.movie.rental.dto.Movie;
import com.movie.rental.dto.MovieRentalDetails;

public class RentalCalculation {
  //This is starting receipt write method
  //we are checking customerMoviesRental object is null or not. If not null we are moving to write rental receipt.
  // Loading required properties for writing rental receipt content
  // variable declaration part and it is using write a border
  public String receiptWrite(CustomerDetails customerMoviesRental) {
	  
 String receiptStatus="";
	 
	 Properties properties = null;
	 if(customerMoviesRental!=null) {
	
	 try(FileReader reader=new FileReader("config.properties")) {
		  
		properties=new Properties();  
		properties.load(reader); 
	 }catch(IOException io) {
	 io.printStackTrace();
	 }
	
	String line = new String(new char[48]).replace('\0', '-');
	String headLine = new String(new char[48]).replace('\0', '=');


   //Receipt header part creation
   receiptHeader(customerMoviesRental,line,headLine,properties);
   
   //Receipt body part creation
   double[] result = receiptBody(customerMoviesRental,properties);
   if(null == result ) {
    throw new NullPointerException("Total amount is empty and frequenct point is empty");
   }
   //Receipt tail part creation
   receiptTail(line,result[0],result[1],properties);
   
   receiptStatus = "receipt generated";
 }else {

 throw new NullPointerException("No movies selected by customer");
 }

return receiptStatus;

  }
 
  //Receipt header part implementation, It will print the Title, Customer Id and Customer Name
  public void receiptHeader(CustomerDetails customerMoviesRental,String line,String headLine,Properties prop){
   if(customerMoviesRental.getCustomer()!=null) {
	   System.out.println(line);
	   System.out.printf("|%s|%n",
	           StringUtils.center(prop.getProperty("receipt.title"), 46)
	          );
	   System.out.println(headLine);
	   System.out.printf("|%s|%s|%n",
	           StringUtils.center(prop.getProperty("custId.label")+customerMoviesRental.getCustomer().getId(), 16),
	           StringUtils.center(prop.getProperty("custName.label")+customerMoviesRental.getCustomer().getName(), 29));
	   System.out.println(line);
	   System.out.printf("|%s|%s|%n",
	           StringUtils.center(prop.getProperty("movie.label"), 29),
	           StringUtils.center(prop.getProperty("movieAmount.label"), 16));
	   System.out.println(line);
   }else {
	   throw new NullPointerException("Customer details can not empty. Please provide customer details");
   }
   
  }
 
  //Receipt body part implementation
  public double[] receiptBody(CustomerDetails customerMoviesRental,Properties properties)
  {
		double[] result = new double[2];
		double totalAmount = 0;
		int frequentEnterPoints = 0;
		double thisAmount = 0;
		for (MovieRentalDetails mrd : customerMoviesRental.getMovieRentalList()) {
		
		// determine amount for each movie
		// Thriller movie amount calculation
		if (mrd.getMovie().getGenre().equals(MovieRentalConstants.THRILLER)) {
		thisAmount = thrillerMovieCalculation(mrd.getAmount(), mrd.getDays(),properties) + thisAmount;
		}
		// Sci-fi Action movie amount calculation
		if (mrd.getMovie().getGenre().equals(MovieRentalConstants.SCIFI_ACTION)) {
		thisAmount = scifiActionMovieCalculation(mrd.getAmount(), mrd.getDays(),properties) + thisAmount;
		}
		// Animation movie amount calculation
		if (mrd.getMovie().getGenre().equals(MovieRentalConstants.ANIMATION)) {
		thisAmount = animationMovieCalculation(mrd.getAmount(), mrd.getDays(),properties) + thisAmount;
		
		}
		// Action movie amount calculation
		if (mrd.getMovie().getGenre().equals(MovieRentalConstants.ACTION)) {
		thisAmount = actionMovieCalculation(mrd.getAmount(), mrd.getDays(),properties) + thisAmount;
		}
		// add frequent bonus points
		
		frequentEnterPoints=frequentEnterPoints+mrd.getFrequencyPoint();
		frequentEnterPoints = fequentBonusPointCalculation(mrd.getMovie().getGenre(),mrd.getDays(),frequentEnterPoints,properties);
		
		
		
		System.out.printf("|%s|%s|%n", StringUtils.center(mrd.getMovie().getName(), 29),
		StringUtils.center("" + thisAmount, 16));
		
		totalAmount = totalAmount + thisAmount;
		thisAmount = 0;
		
		
		}
		result[0] = totalAmount;
		result[1] = frequentEnterPoints;

		return result;
  }
 
//Receipt tail part implementation
  public void receiptTail(String line,double totalAmount,double frequentEnterPoints,Properties prop) {
	   System.out.println(line);
	   // add footer lines
	   System.out.printf("|%s|%s|%n",
	           StringUtils.center(prop.getProperty("totalAmount.label"), 29),
	           StringUtils.center(""+totalAmount, 16));
	   System.out.println(line);
	   System.out.printf("|%s|%s|%n",
	           StringUtils.center(prop.getProperty("ferquencyPoint.label"), 31),
	           StringUtils.center(""+(int)frequentEnterPoints, 14));
	   System.out.println(line);
  }
 

 
  //Thriller movie amount calculation
  public double thrillerMovieCalculation(double thisAmount,int days,Properties properties) {
	  return days > Integer.parseInt(properties.getProperty("thriller.moviledaySlap")) ? ((days - Integer.parseInt(properties.getProperty("thriller.moviledaySlap"))) * thisAmount) : thisAmount;
  }
 //Sci-Fi Action movie amount calculation
  public double scifiActionMovieCalculation(double thisAmount,int days,Properties properties) {
	  return days > Integer.parseInt(properties.getProperty("scifi.moviledaySlap")) ? ((days - Integer.parseInt(properties.getProperty("scifi.moviledaySlap"))) * thisAmount) : thisAmount;
  }
 //Animation movie amount calculation
  public double animationMovieCalculation(double thisAmount,int days,Properties properties) {
	  return days > Integer.parseInt(properties.getProperty("animation.moviledaySlap")) ? ((days - Integer.parseInt(properties.getProperty("animation.moviledaySlap"))) * thisAmount) : thisAmount;
  }
 //Action movie amount calculation
  public double actionMovieCalculation(double thisAmount,int days,Properties properties) {
	  return days > Integer.parseInt(properties.getProperty("action.moviledaySlap")) ? ((days - Integer.parseInt(properties.getProperty("action.moviledaySlap"))) * thisAmount) : thisAmount;
  }
 
  //Extra frequenct point calculation for particular genre
  public int fequentBonusPointCalculation(String movieGenre,int days,int frequentEnterPoints,Properties properties) {

	  // add bonus for a two day new release rental movie
	 if (movieGenre.equals(MovieRentalConstants.THRILLER) && days > Integer.parseInt(properties.getProperty("thriller.bonusDays"))) {
	 frequentEnterPoints++;
	 }
	 
	//  if (movieGenre.equals("Sci-fi Action") && days > Integer.parseInt(properties.getProperty("scifi.bonusDays")))
	// frequentEnterPoints++;
	//  if (movieGenre.equals("Animation") && days > Integer.parseInt(properties.getProperty("animation.bonusDays")))
	//  frequentEnterPoints++;
	//  if (movieGenre.equals("Action") && days > Integer.parseInt(properties.getProperty("action.bonusDays")))
	// frequentEnterPoints++;
	 return frequentEnterPoints;
  }
 
}