package day02;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MovieServiceTest {

    MovieService ms = new MovieService();
    Movie suicideSquad = new Movie("The Suicide Squad",132, List.of("Margot Robbie", "Margot Robbie"));
    Movie jungleCruise = new Movie("Jungle Cruise", 127, List.of("Dwayne Johnson", "Emily Blunt"));
    Movie redNotice = new Movie("Red Notice", 118, List.of("Dwayne Johnson", "Ryan Reynolds", "Gal Gadot"));

    @BeforeEach
    void setUp() {
        ms.addMovie(suicideSquad);
        ms.addMovie(jungleCruise);
        ms.addMovie(redNotice);
    }


    @Test
    void getMoviesWithActor() {
        var actual = ms.getMoviesWithActor("Dwayne Johnson");
        assertEquals(2, actual.size());
    }

    @Test
    void getLongestMovie() {
        Movie actual = ms.getLongestMovie();
        assertEquals(132,actual.length());
    }
}