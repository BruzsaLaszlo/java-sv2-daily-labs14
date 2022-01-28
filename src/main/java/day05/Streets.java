package day05;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Streets {


    public Map<String, List<Integer>> getSoldHouses(Path path) {
        var map = getFromFile(path);
        map.entrySet()
                .forEach(entry -> entry.setValue(getNumbersList(entry.getValue())));
        return map;
    }

    private List<Integer> getNumbersList(List<Integer> value) {
        List<Integer> result = new ArrayList<>();
        int zero = 0;
        int one = 0;
        for (Integer integer : value) {
            result.add(integer == 0 ? ++zero * 2 : ++one * 2 - 1);
        }
        return result;
    }

    private Map<String, List<Integer>> getFromFile(Path path) {
        try {
            Map<String, List<Integer>> map = new TreeMap<>();
            Files.readAllLines(path)
                    .forEach(line -> {
                        var data = line.split(" ");
                        int num = Integer.parseInt(data[1]);
                        map.computeIfAbsent(data[0], s -> new ArrayList<>())
                                .add(num);
                    });
            return map;
        } catch (IOException e) {
            throw new IllegalArgumentException("file not found " + path);
        }
    }

}
