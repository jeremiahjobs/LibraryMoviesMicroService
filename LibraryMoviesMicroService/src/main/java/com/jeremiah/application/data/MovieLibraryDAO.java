package com.jeremiah.application.data;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.jeremiah.application.model.Movie;

/**
 * 
 * @author Jeremiah 
 *
 */
@Repository
public class MovieLibraryDAO {
	
	
	private Map<String, Movie> movieMap = new HashMap<String, Movie>();
	
	
	public MovieLibraryDAO() {
		
	}
	
	/**
	 * gets a movie according to its ID from the movieMap
	 * @param movieId
	 * @return the movie represented by the movieID
	 * @throws NullPointerException
	 */
	public Movie getMovie(String movieId) throws NullPointerException {
		
		return movieMap.get(movieId);	
	}	
	
	/**
	 * sets three movies so the application will not be empty
	 */
	public void movieSetUp() {
		
		Movie movie1 = new Movie("M1", "Star Wars VI", "A very good movie" , "1980" , "George Lucas", 
				"10.0", "120 min", "Mark Hamilton");
		Movie movie2 = new Movie("M2", "Star Wars V", "A very good movie" , "1978" , "George Lucas", 
				"10.0", "98 min", "Carrie Fisher");
		Movie movie3 = new Movie("M3", "Star Wars IV", "A very good movie" , "1982" , "George Lucas", 
				"10.0", "120 min", "Chewbacca");
		
		movieMap.put(movie1.getMovieId(), movie1);
		movieMap.put(movie2.getMovieId(), movie2);
		movieMap.put(movie3.getMovieId(), movie3);
		
	}	
	
	/**
	 * adds a movie to the movieMap
	 * @param movie
	 */
	public Movie addMovie(Movie movie) {
		
		movieMap.put(movie.getMovieId(), movie);
		return movie;
	}
		
	/**
	 * updates a existing movie as long as the ID remains the same
	 * @param movie
	 * @return updated movie
	 */
	public Movie updateMovie(Movie movie) {
		
		movieMap.put(movie.getMovieId(), movie);
		return movie;
	}
		
	/**
	 * deletes a movie represente by the movieID
	 * @param movieId
	 * @throws NullPointerException
	 */
	public void deleteMovie(String movieId) throws NullPointerException {
		
		movieMap.remove(movieId);
	}
		
	/**
	 * gets all movies from the movie hashmap, puts them into a list and returns this list
	 * @return movie list
	 */
	public List<Movie> getAllMovies(){
		
		Collection<Movie> c = movieMap.values();
		List<Movie> movieList = new ArrayList<Movie>();
		movieList.addAll(c);
		return movieList;
	}
	
	
	public List<Movie> getAllMoviesByYear(String year){
		
		List<Movie> moviesByYearList = new ArrayList<Movie>();
		for(Movie movie : movieMap.values()) {
			if(year.equals(movie.getReleaseYear())) {
				moviesByYearList.add(movie);
			}
		}
		return moviesByYearList;
		
	}
	
}
