package day05;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import static java.util.stream.Collectors.*;

public class Streets {


    public Map<String, List<Integer>> getSoldHousesByStreets(Path path) {
        var map = getFromFile(path);
        map.entrySet().forEach(entry -> entry.setValue(getTranformedList(entry.getValue())));
        return map;
    }

    private List<Integer> getTranformedList(List<Integer> value) {
        int[] zeroOne = new int[2];
        return value.stream()
                .map(integer -> integer == 0 ? ++zeroOne[0] * 2 : ++zeroOne[1] * 2 - 1)
                .toList();
    }

    private Map<String, List<Integer>> getFromFile(Path path) {
        try {
            return Files.readAllLines(path)
                    .stream()
                    .map(line -> line.split(" "))
                    .collect(groupingBy(
                            data -> data[0],
                            TreeMap::new,
                            mapping(data -> Integer.parseInt(data[1]),
                                    toList())
                    ));
        } catch (IOException e) {
            throw new IllegalArgumentException("file not found " + path);
        }
    }

}
