package com.movie.rental;



import com.movie.rental.constants.MovieRentalConstants;
import com.movie.rental.dto.Customer;
import com.movie.rental.service.RentalReceipt;


public class Main {

  public static void main(String[] args) {
	//Test case object  creation
	  try {
			RentalReceipt receipt = new RentalReceipt();
			
			Customer customer = new Customer((long)1,"Krishna Raja",true,"krishnaraja19@gmail.com","+46 764498115");
			
			System.out.println("Test Case1");
			//First Testcase , Need to give movie Id,customer object, rental days,Rental Amount and frequency Point
			receipt.toGetRental((long) 1,customer,4,10,1);
			
			System.out.println("\nTest Case2");
			//second Testcase , Need to give movie name,customer object, rental days,Rental Amount and frequency Point
			receipt.toGetRental("Cars",customer,6,12,1);
			
			System.out.println("\nTest Case3");
			//third Testcase , Need to give movie genre,customer object, rental days,Rental Amount and frequency Point
			receipt.toGetRentalByGenre(MovieRentalConstants.ANIMATION,customer,6,12,1);
			
			System.out.println("\nTest Case4");
			//fourth Testcase, List of movie's id selected by user, So here we can pass movies list and rental details
			
			
			 receipt.toGetBulkRental( new long[] {1,3,4,5,7,8}, customer, new int[]
			{6,4,10,8,12,8}, new double[]
			 {10,15,12,20,30,10}, new int[] {1,1,2,3,1,1} );
			
			
			System.out.println("Thank you for the oppurtinity");
	  }catch(Exception e) {
		  System.out.println(e.getMessage());
		  e.printStackTrace();
	  }
	  }
}