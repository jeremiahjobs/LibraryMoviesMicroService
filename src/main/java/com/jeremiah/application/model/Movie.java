package com.jeremiah.application.model;

import org.springframework.stereotype.Component;

/**
 * Movie class, which contains basic information about a movie
 * @author Jeremiah 
 *
 */
@Component
public class Movie {

	private String movieId;
	private String title;
	private String description;
	private String releaseYear;
	private String directedBy;
	private String imdbRating;
	private String runtime;
	private String starring;
	
	
	public Movie() {	
	}
	
	public Movie(String movieId, String title, String description, String releaseYear, String directedBy, 
			String imdbRating, String runtime, String starring) {
		
		this.movieId = movieId;
		this.title = title;
		this.description = description;
		this.releaseYear = releaseYear;
		this.directedBy = directedBy;
		this.imdbRating = imdbRating;
		this.runtime = runtime;
		this.starring = starring;

	}

	
	public String getMovieId() {
		return movieId;
	}

	public void setMovieId(String movieId) {
		this.movieId = movieId;
	}
	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getReleaseYear() {
		return releaseYear;
	}

	public void setReleaseYear(String releaseYear) {
		this.releaseYear = releaseYear;
	}

	public String getDirectedBy() {
		return directedBy;
	}

	public void setDirectedBy(String directedBy) {
		this.directedBy = directedBy;
	}

	public String getImdbRating() {
		return imdbRating;
	}

	public void setImdbRating(String imdbRating) {
		this.imdbRating = imdbRating;
	}

	public String getRuntime() {
		return runtime;
	}

	public void setRuntime(String runtime) {
		this.runtime = runtime;
	}

	public String getStarring() {
		return starring;
	}

	public void setStarring(String starring) {
		this.starring = starring;
	}
	
	
	
	
}
