package com.movie.rental.dto;

public class Customer {
	private Long id;
    private String name;
    private boolean isActive;
    private String mailId;
    private String mobileNumber;

    public Customer() {
    	
    }
    public Customer(Long id,String name,boolean isActive,String mailId,String moblileNumber) {
    	this.id = id;
        this.name = name;
        this.isActive = isActive;
        this.mailId = mailId;
        this.mobileNumber = moblileNumber;
    }


	public String getMobileNumber() {
		return mobileNumber;
	}


	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	public String getMailId() {
		return mailId;
	}

	public void setMailId(String mailId) {
		this.mailId = mailId;
	}

	
    
}
