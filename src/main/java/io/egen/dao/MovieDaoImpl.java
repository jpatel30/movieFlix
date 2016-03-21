package io.egen.dao;

import io.egen.entity.Movie;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;


@Repository
@Transactional
public class MovieDaoImpl implements MovieDao {
	@PersistenceContext
	private EntityManager em;

	@Override
	public List<Movie> findAll() {
		String qlString = "SELECT m FROM Movie m ORDER BY m.id ASC";
		List<Movie> movies = em.createQuery(qlString, Movie.class)
				.getResultList();
		return movies;
	}

	@Override
	public Movie findById(String Id) {
		Movie movie= em.find(Movie.class, Id);
		return movie;
	}

	@Override
	public Movie create(Movie movie) {
		 em.persist(movie);
		return movie;
	}

	@Override
	public Movie update(Movie movie) {
		return em.merge(movie);
	}

	@Override
	public void delete(Movie movie) {
		em.remove(movie);
	}

	@Override
	public void insertAllMovie(List<Movie> movies) {
		for(Movie mv:movies){
			em.persist(mv);
		}
	}

}
