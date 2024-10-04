package com.example.movieapii3.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.movieapii3.entity.Movie;
import com.example.movieapii3.service.MovieService;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000") // Allow requests from the React frontend
public class MovieController {

    @Autowired
    private MovieService movieService;

    // Simple GET endpoint to test if the server is running
    @GetMapping("/hello")
    public String sayHello() {
        return "Welcome to the Movie API!";
    }

    // POST request to add a movie using the Movie entity
    @PostMapping("/movies")
    public String createMovie(@RequestBody Movie movie) {
        movieService.saveMovie(movie); // Call the service to save the movie
        return "Movie added successfully!";
    }

    // GET request to fetch the list of all movies
    @GetMapping("/movies")
    public List<Movie> getAllMovies() {
        return movieService.getAllMovies(); // Call the service to fetch all movies
    }

    // Optional: GET request to fetch a specific movie by its ID
    @GetMapping("/movies/{id}")
    public Movie getMovieById(@PathVariable Long id) {
        return movieService.getMovieById(id); // Fetch the movie by its ID
    }

    
}