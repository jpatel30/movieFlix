package io.egen.service;

import io.egen.dao.MovieDao;
import io.egen.entity.Movie;
import io.egen.exception.MovieAlreadyExitsException;
import io.egen.exception.MovieNotFoundException;

import java.util.List;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class MovieServiceImpl implements MovieService {

	@Autowired
	private MovieDao dao;

	@Override
	public List<Movie> findAll() {
		return dao.findAll();
	}

	@Override
	public Movie findById(String Id) throws MovieNotFoundException {
		Movie movie=dao.findById(Id);
		if(movie==null){
			throw new MovieNotFoundException() ;
		}else{
		return movie;
		}
	}

	@Override
	public Movie create(Movie movie) throws MovieAlreadyExitsException {
		Movie existing =  dao.findById(movie.getImdbID());
		if(existing == null) {
			return dao.create(movie);
		}
		else {
			throw new MovieAlreadyExitsException();
		}
		
	}

	@Override
	public Movie update(String Id, Movie movie) throws MovieNotFoundException {
		Movie existing =  dao.findById(Id);
		if(existing == null) {
			throw new MovieNotFoundException();
		}
		else {
			return dao.update(movie);
		}
	}

	@Override
	public void delete(String Id) throws MovieNotFoundException {
		Movie existing =  dao.findById(Id);
		if(existing == null) {
			throw new MovieNotFoundException();
		}
		else {
			dao.delete(existing);
		}
	}

	@Override
	public void insertAllMovie(List<Movie> movies) {
		dao.insertAllMovie(movies);
		
	}
}
