package com.movie.rental.service;

import com.movie.rental.exception.InvalidAmountException;
import com.movie.rental.exception.InvalidDateException;
import com.movie.rental.exception.InvalidFrequencyPointException;

public class ExceptionHelper {
	ExceptionHelper(){
		
	}
	public boolean daysCheck(int days){
		boolean flag = false;
		if(days<=0) {
			try {
				throw new InvalidDateException("Date is not valid");
			} catch (InvalidDateException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			flag=true;
		}
		return flag;
	}
	public boolean amountCheck(double amount)  {
		boolean flag = false;
		if(amount<=0) {
			try {
				throw new InvalidAmountException("Amount is not valid");
			} catch (InvalidAmountException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			flag=true;
		}
		return flag;
	}
	public boolean frequenctPointCheck(int freqPoint)  {
		boolean flag = false;
		if(freqPoint<=0) {
			try {
				throw new InvalidFrequencyPointException("Frequent point is not valid");
			} catch (InvalidFrequencyPointException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			flag=true;
		}
		return flag;
	}
	public boolean daysCheck(int[] days) {
		boolean flag = false;
		if(days.length == 0) {
			try {
				throw new InvalidDateException("Date list is empty");
			} catch (InvalidDateException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			flag=true;
		}
		return flag;
	}
	
	public boolean amountCheck(double[] amount) {
		boolean flag = false;
		if(amount.length == 0) {
			try {
				throw new InvalidAmountException("Amount list is empty");
			} catch (InvalidAmountException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			flag=true;
		}
		return flag;
	}
	public boolean frequenctPointCheck(int[] freqPoint)  {
		boolean flag = false;
		if(freqPoint.length ==0) {
			try {
				throw new InvalidFrequencyPointException("Frequent point list is not valid");
			} catch (InvalidFrequencyPointException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			flag=true;
		}
		return flag;
	}
}
