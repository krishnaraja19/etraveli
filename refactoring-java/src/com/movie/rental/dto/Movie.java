package com.movie.rental.dto;
public class Movie {
	private Long id;
    private String name;
    private String type;
    private String genre;
    
    public Movie() {
    	
    }

    public Movie(Long id,String name, String type,String genre) {
    	this.id = id;
    	this.name = name;
        this.type = type;
        this.genre = genre;
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

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}
    
   
}
