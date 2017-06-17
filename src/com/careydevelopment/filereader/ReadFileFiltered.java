package com.careydevelopment.filereader;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class ReadFileFiltered {

    private static final String INPUT_FILE = "./input/lures.txt";
    
    public static void main(String[] args) {
        try (Stream<String> stream = Files.lines(Paths.get(INPUT_FILE))) {
                
            stream.filter(line -> line.indexOf("Inshore") > -1)
                .forEach(line -> {
                    String[] parts = line.split(";");
                    String lureName = parts[0];
                    String lureType = parts[1];
                    String lurePrice = parts[2];

                    System.out.println("Found: " + lureName + " (" + lureType + ") $" + lurePrice );
                });
        } catch (IOException e) {
            System.err.println("Problem reading file " + e.getMessage());
            e.printStackTrace();
        }
    }
}
