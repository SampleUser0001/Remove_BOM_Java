package sample.rejectbom.controller;

import org.apache.commons.io.input.BOMInputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Collectors;
import java.util.List;

import java.io.IOException;

public class UsualCsvReader {
    
    public static List<String> read(String filepath) throws IOException {
        return Files.lines(Paths.get(filepath))
                    .map(Object::toString)
                    .collect(Collectors.toList());
    }
}