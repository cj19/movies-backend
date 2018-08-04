package com.darvasr.movies.resource;

import com.darvasr.movies.dto.MovieDTO;
import com.darvasr.movies.entity.Movie;
import com.darvasr.movies.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/movie")
public class MovieResource {

    private final MovieService movieService;

    @Autowired
    public MovieResource(MovieService movieService) {
        this.movieService = movieService;
    }

    @PreAuthorize("hasRole('USER')")
    @RequestMapping(method = RequestMethod.POST, consumes = "application/json")
    public ResponseEntity<Movie> createMovie(@RequestBody MovieDTO movieDTO) {
        Movie movie = movieService.createMovie(movieDTO);
        return ResponseEntity.ok(movie);
    }

    @PreAuthorize("hasRole('USER')")
    @RequestMapping(value = "{id}" ,method = RequestMethod.GET)
    public ResponseEntity<Movie> getMovieById(@PathVariable("id") Long id) {
        Movie movie = movieService.getMovieById(id);
        return ResponseEntity.ok(movie);
    }

    @PreAuthorize("hasRole('USER')")
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Movie>> getAllMovies(){
        List<Movie> movies = movieService.getAllMovies();
        return ResponseEntity.ok(movies);
    }
}
