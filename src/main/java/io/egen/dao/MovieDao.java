package io.egen.dao;

import io.egen.entity.Movie;

import java.util.List;


public interface MovieDao {
	
	public List<Movie> findAll();
	public Movie findById(String Id);
	public Movie create(Movie movie);
	public Movie update(Movie movie);
	public void delete(Movie movie);
	public void insertAllMovie(List<Movie> movies);
}
