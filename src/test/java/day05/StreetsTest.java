package day05;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Path;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class StreetsTest {

    Streets streets = new Streets();
    Path path = Path.of("src/test/resources/streets.txt");

    @Test
    void getSoldHouses() throws IOException {

        var expected = Map.of(
                "Kossuth", List.of(2,4,1,3,5,7),
                "Petofi", List.of(1,2,4,3,6)
        );

        assertEquals(expected, streets.getSoldHouses(path));

    }
}