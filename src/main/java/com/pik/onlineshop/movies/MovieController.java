package com.pik.onlineshop.movies;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Michael J. Simons
 */
@RestController
@RequestMapping("/")
public class MovieController {

	private final MovieService movieService;

	public MovieController(MovieService movieService) {
		this.movieService = movieService;
	}

	@GetMapping("/test")
	public String test() {
		return movieService.test();
	}

	@GetMapping("/test2")
	public String test2() {
		return "test";
	}

	@GetMapping("/test3")
	public List<MovieResultDto> test3() {
		return movieService.searchMoviesByTitle("");
	}

}