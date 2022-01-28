package day05;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import static java.util.stream.Collectors.*;

public class Streets {

    public Map<String, List<Integer>> getSoldHouses(Path path) throws IOException {
        return Files.readAllLines(path)
                .stream()
                .map(line -> line.split(" "))
                .collect(groupingBy(
                        data -> data[0],
                        TreeMap::new,
                        collectingAndThen(
                                mapping(data -> Integer.parseInt(data[1]),
                                        toList()),
                                list -> {
                                    int[] zeroOne = new int[2];
                                    return list.stream()
                                            .map(integer -> integer == 0 ? ++zeroOne[0] * 2 : ++zeroOne[1] * 2 - 1)
                                            .toList();
                                }
                        )));
    }

}
