package com.jeremiah.application.controller;
import java.util.List;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jeremiah.application.data.MovieLibraryDAO;
import com.jeremiah.application.model.Movie;

/**
 * RESTController, which contains basic CRUD operation methods in order to access the MovieLibraryDOA class
 * @author Jeremiah 
 *
 */
@RestController
public class RESTController implements ErrorController{

	private MovieLibraryDAO movieLibrary = new MovieLibraryDAO();
	private static final String PATH = "/error";
	
	
	public RESTController() {
		movieLibrary.movieSetUp();
	}
	
	/**
	 * GET operation to get all movies inside the library for http://localhost:8080/movies.
	 * If we add a year to http://localhost:8080/movies?year=" " we get all movies corresponding to that year
	 * @return returns a list with all existing movie objects 
	 */
	@GetMapping(value = "/movies")
	public List<Movie> getAllMovies(@RequestParam( value ="year", required = false) String year){
		if(year != null) {
			return movieLibrary.getAllMoviesByYear(year);	
		}
		return movieLibrary.getAllMovies();
	}
	
	/**
	 * GET operation to get a specific movie depending on the movieId for http://localhost:8080/movies/{movieId}
	 * @param movieId
	 * @return returns movie object for the specific id in the URL
	 */
	@GetMapping(value = "/movies/{movieId}")
	public Movie getAllMovies(@PathVariable(value = "movieId") String movieId){
		return movieLibrary.getMovie(movieId);
	}
	
	/**
	 * PUT operation for http://localhost:8080/movies
	 * @param movie
	 * @return returns the movie object just updated
	 */
	@PutMapping(value = "/movies")
	public Movie updateMovie(@RequestBody Movie movie) {
		return movieLibrary.updateMovie(movie);
		
	}
	
	/**
	 * POST operation http://localhost:8080/movies
	 * @param movie
	 * @return returns the movie object just added
	 */
	@PostMapping(value = "/movies")
    public Movie addMovie(@RequestBody Movie movie) {
		return movieLibrary.addMovie(movie);
	}
	
	/**
	 * DELETE operation for specific movie for http://localhost:8080/movies/{movieId}
	 * @param movieId
	 */
	@DeleteMapping(value = "/movies/{movieId}")
	public void deleteMovie(@PathVariable("movieId") String movieId) {
		movieLibrary.deleteMovie(movieId);	
	}
	
	/**
	 * Return is shown in case of an error
	 * @return String = "Error Handling"
	 */
	@RequestMapping(value = PATH)
	public String error(){
		return "Error Handling - URL not found";
	}
	
	/**
	 * abstract method in order to use ErrorController interface
	 * @return returns the error path 
	 */
	public String getErrorPath() {
		return PATH;
	}
	
}
