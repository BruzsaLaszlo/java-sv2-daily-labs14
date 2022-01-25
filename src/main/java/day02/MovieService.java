package day02;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;

public class MovieService {

    private List<Movie> movies = new ArrayList<>();

    public void addMovie(Movie movie) {
        movies.add(movie);
    }

    public List<Movie> getMoviesWithActor(String nameOfActor) {
        return movies.stream()
                .filter(movie -> movie.actors().contains(nameOfActor))
                .toList();
    }

    public Movie getLongestMovie() {
        return movies.stream()
                .max(Comparator.comparing(Movie::length))
                .orElseThrow(NoSuchElementException::new);
    }
}
