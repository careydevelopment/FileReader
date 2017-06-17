package com.careydevelopment.filereader;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class ReadFileBufferedReader {

    private static final String INPUT_FILE = "./input/lures.txt";
    
    public static void main(String[] args) {
        try (BufferedReader br = Files.newBufferedReader(Paths.get(INPUT_FILE))) {    
            Stream<String> stream = br.lines();
            
            stream.forEach(line -> {
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
