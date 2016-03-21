package io.egen.service;

import io.egen.entity.Movie;
import io.egen.exception.MovieAlreadyExitsException;
import io.egen.exception.MovieNotFoundException;

import java.util.List;

public interface MovieService {

	List<Movie> findAll();

	Movie findById(String Id) throws MovieNotFoundException;

	Movie create(Movie movie) throws MovieAlreadyExitsException;

	Movie update(String Id, Movie movie) throws MovieNotFoundException;

	void delete(String Id) throws MovieNotFoundException;

	void insertAllMovie(List<Movie> movies);

}
