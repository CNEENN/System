package main.java.com.movie.service;

import main.java.com.movie.domain.Movie;
import main.java.com.movie.idao.DAOFactory;
import main.java.com.movie.idao.IMovieDAO;

import java.util.List;
public class MovieService {
    private IMovieDAO movieDAO = DAOFactory.creatMovieDAO();

    public int add(Movie movie) {
        return movieDAO.insert(movie);
    }

    public int delete(Movie movie) {
        return movieDAO.delete(movie.getId());
    }

    public int modify(Movie movie) {
        return movieDAO.update(movie);
    }

    public Movie findByTitle(String title) {
        return movieDAO.select(title);
    }

    public List<Movie> findByDirector(String director) {
        return movieDAO.findByDirector(director);
    }

    public List<Movie> findAll() {
        return movieDAO.findAll();
    }
}
