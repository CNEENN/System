package main.java.com.movie.idao;

import main.java.com.movie.domain.Movie;
import java.util.List;
public interface IMovieDAO {
    public int insert(Movie movie);
    public int update(Movie movie);
    public int delete(int id);
    public Movie select(String title);
    public List<Movie> findByDirector(String director);
    public List<Movie> findAll();
}
